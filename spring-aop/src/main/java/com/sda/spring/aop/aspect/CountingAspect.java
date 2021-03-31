package com.sda.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CountingAspect {

    private static final Logger log = LoggerFactory.getLogger(CountingAspect.class);

    private static Map<String, Integer> countMap = new HashMap<>();

    // define pointcut
    @Pointcut("@annotation(Countable)") // pointcut expression
    public void executeCounting() {
        // pointcut signature
    }

    @Before("executeCounting()")
    public void incrementCount(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getDeclaringType() +
                "." + joinPoint.getSignature().getName();

        // if key is present, increment value
        if (countMap.containsKey(methodName)) {
            // get value and increment
            Integer currentCount = countMap.get(methodName);
            currentCount++;
            countMap.put(methodName, currentCount);
        } else {
            // if key not found > then add key with value 1
            countMap.put(methodName, 1);
        }

        StringBuilder message = new StringBuilder("Method count: |");
        // concatenate key - value to message
        countMap.forEach((key, value) ->
                message.append(key + ":" + value + " | "));

        log.info(message.toString());
    }
}
