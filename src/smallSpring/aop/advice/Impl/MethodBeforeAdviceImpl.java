package smallSpring.aop.advice.Impl;

import smallSpring.aop.advice.Interface.MethodAdvice;
import smallSpring.aop.advice.Interface.MethodBeforeAdvice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

    @Override
    public void Before(Method method, Object[] args, Object target) {
        System.out.println("i am the advice for proxy");

    }
}
