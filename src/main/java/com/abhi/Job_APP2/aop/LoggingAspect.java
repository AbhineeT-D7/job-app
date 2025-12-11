package com.abhi.Job_APP2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.subho.Job_APP2.Service.jobservice.*(..))")
	public void beforeMethodCall(JoinPoint jp) {
        LOGGER.info("Method called: {}", jp.getSignature().getName());
	}

	@After("execution(* com.subho.Job_APP2.Service.jobservice.*(..))")
	public void afterMethodCall(JoinPoint jp) {
        LOGGER.info("Method executed: {}", jp.getSignature().getName());
	}

	@AfterThrowing("execution(* com.subho.Job_APP2.Service.jobservice.*(..))")
	public void afterException(JoinPoint jp) {
        LOGGER.error("Exception occurred in method: {}", jp.getSignature().getName());
	}

	@AfterReturning("execution(* com.subho.Job_APP2.Service.jobservice.*(..))")
	public void afterSuccessfulReturn(JoinPoint jp) {
        LOGGER.info("Method executed successfully: {}", jp.getSignature().getName());
	}
}
