package com.shiro.source.study.shiro;

import com.shiro.source.study.domain.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by Mario on 2016/3/15.
 */
@Component
public class EncryptUser<T extends User> {

    @Value(value = "${shiro.applicationSalt}")
    private String applicationSalt;

    @Value(value = "${shiro.hashAlgorithmName}")
    private String algorithmName;

    @Value(value = "${shiro.hashIterations}")
    private Integer hasIterations;

    @Autowired
    private SecureRandomNumberGenerator secureRandomNumberGenerator;

    public T encrypt(T user) {
        Objects.requireNonNull(user);
        user.setSalt(getSalt());
        user.setPassword(encodePasswordString(user.getPassword(), user.getSalt()));
        return user;
    }

    private String getSalt() {
        return secureRandomNumberGenerator.nextBytes().toBase64();
    }

    private String getCombineSalt(String salt) {
        return applicationSalt.concat(":").concat(salt);
    }

    private String encodePasswordString(String rawPassword, String salt) {
        return new SimpleHash(algorithmName, rawPassword, getCombineSalt(salt), hasIterations).toBase64();
    }

}
