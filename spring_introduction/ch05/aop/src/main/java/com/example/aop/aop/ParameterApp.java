package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterApp {

    //pointCut 은 인터넷에 서치 후 더 알아보고 사용
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    // 룰 설정 =>com.example.aop.controller라는 패키지 하위에 있는 모든 메소드를 다 aop로 보겠다고 설정하는 문구
    private void cut(){
    }

    // 메소드가 실행되기 전에 arguments 확인
    @Before("cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // get method 출력
        System.out.println(method.getName());
        Object[] args = joinPoint.getArgs();
        for(Object obj:args){
            System.out.println("type : "+obj.getClass().getSimpleName());
            System.out.println("value : "+obj);
        }
    }

    //  메소드가 실행되고 어떻게 return 될 것인지 확인
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj){
        System.out.println("return obj");
        System.out.println(returnObj);
    }

}
