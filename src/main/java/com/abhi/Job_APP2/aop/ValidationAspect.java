package com.abhi.Job_APP2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

	public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

	@Around("execution(* com.subho.Job_APP2.Service.jobservice.getonejob(..)) && args(postId)")
	public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
		if (postId < 0) {
			LOGGER.info("PostId is negative, converting to positive...");
			postId = -postId;
            LOGGER.info("New PostId: {}", postId);
		}
		return jp.proceed(new Object[]{postId});
	}
}
