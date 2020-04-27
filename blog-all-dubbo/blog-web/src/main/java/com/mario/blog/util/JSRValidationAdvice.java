package com.mario.blog.util;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.validator.constraints.NotBlank;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.constraints.NotNull;

/**
 * Created by Mario on 2015/9/16.
 */
public class JSRValidationAdvice {
    private static final Logger logger = Logger.getLogger(JSRValidationAdvice.class);


    private boolean isMissingParamsError(String code) {
        if (code.equals(NotNull.class.getSimpleName()) || code.equals(NotBlank.class.getSimpleName()) || code.equals(NotEmpty.class.getSimpleName())) {
            return true;
        } else {
            return false;
        }
    }


    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        BindingResult bindingResult = null;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length != 0) {
            for (Object obj : args) {
                if (obj instanceof BindingResult) {
                    bindingResult = (BindingResult) obj;
                    break;
                }
            }
        }
        if (bindingResult != null && bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String targetName = joinPoint.getTarget().getClass().getSimpleName();
            String method = joinPoint.getSignature().getName();
            logger.error("������:" + targetName + ",����:" + method + ",����:" + fieldError.getObjectName() + ",����:" + fieldError.getField() + ",code:" + fieldError.getCode() + "������Ϣ:" + new String(fieldError.getDefaultMessage().getBytes("gbk"), "utf-8"));
            return "other/error";
        }
        return joinPoint.proceed();
    }

}
