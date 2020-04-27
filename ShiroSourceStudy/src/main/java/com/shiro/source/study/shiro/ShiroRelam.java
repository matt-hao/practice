package com.shiro.source.study.shiro;

import com.shiro.source.study.domain.*;
import com.shiro.source.study.service.IAdminService;
import com.shiro.source.study.service.IStudentService;
import com.shiro.source.study.service.ITeacherService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.stream.Collectors;

/**
 * Created by Mario on 2016/7/6.
 */
@Component
public class ShiroRelam extends AuthorizingRealm {

    @Autowired
    private ITeacherService teacherService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IAdminService adminService;

    @Value(value = "${shiro.applicationSalt}")
    private String applicationSalt;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null)
            throw new AuthorizationException("principals为空,请检查");
        ShiroUser curUser = (ShiroUser) principals.getPrimaryPrincipal();
        if (curUser == null)
            throw new AuthorizationException("currentUser不存在,请检查");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (User.HOST.TEACHER.equals(curUser.getHost())) {
            Teacher teacher = teacherService.findWithPermission(curUser.getId());
            checkUserExisted(teacher);
            setAuthorizationInfoDetails(teacher, info);
            return info;
        } else if (User.HOST.STUDENT.equals(curUser.getHost())) {
            Student student = studentService.findWithPermission(curUser.getId());
            checkUserExisted(student);
            setAuthorizationInfoDetails(student, info);
            return info;
        } else if (User.HOST.ADMIN.equals(curUser.getHost())) {
            Admin admin = adminService.findWithPermission(curUser.getId());
            checkUserExisted(admin);
            setAuthorizationInfoDetails(admin, info);
            return info;
        }
        throw new AuthorizationException("没有权限");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if (token == null)
            throw new AuthenticationException("token is empty");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        if (usernamePasswordToken.getHost().equals(User.HOST.TEACHER.name())) {
            Teacher teacher = teacherService.findByAccount((String) token.getPrincipal());
            checkUserExisted(teacher);
            return new SimpleAuthenticationInfo(new ShiroUser(teacher, User.HOST.TEACHER), teacher.getPassword(),
                    contactSalt(teacher), getName());
        } else if (usernamePasswordToken.getHost().equals(User.HOST.STUDENT.name())) {
            Student student = studentService.findByAccount((String) token.getPrincipal());
            checkUserExisted(student);
            return new SimpleAuthenticationInfo(new ShiroUser(student, User.HOST.STUDENT), student.getPassword(),
                    contactSalt(student), getName());
        } else if (usernamePasswordToken.getHost().equals(User.HOST.ADMIN.name())) {
            Admin admin = adminService.findByAccount((String) token.getPrincipal());
            checkUserExisted(admin);
            return new SimpleAuthenticationInfo(new ShiroUser(admin, User.HOST.ADMIN), admin.getPassword(),
                    contactSalt(admin), getName());
        }
        throw new AuthenticationException("用户角色不合法");
    }

    private ByteSource contactSalt(User user) {
        return ByteSource.Util.bytes(applicationSalt.concat(":").concat(user.getSalt()));
    }

    private void checkUserExisted(User user) {
        if (user == null)
            throw new AuthenticationException("用户不存在");
    }

    private void setAuthorizationInfoDetails(User user, SimpleAuthorizationInfo info) {
        info.setRoles(user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toSet()));
        info.setStringPermissions(user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getPermission).distinct().collect(Collectors.toSet()));
    }

    public static class ShiroUser implements Serializable {
        private static final long serialVersionUID = 1541632199769821808L;

        private Long id;
        private String name;
        private String account;
        private User.HOST host;

        public ShiroUser(User user, User.HOST host) {
            this(user.getId(), user.getName(), user.getAccount(), host);
        }

        public ShiroUser(Long id, String name, String account, User.HOST host) {
            this.id = id;
            this.name = name;
            this.account = account;
            this.host = host;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAccount() {
            return account;
        }

        User.HOST getHost() {
            return host;
        }

        @Override
        public String toString() {
            return "ShiroUser{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", account='" + account + '\'' +
                    ", host=" + host.name() +
                    '}';
        }
    }
}
