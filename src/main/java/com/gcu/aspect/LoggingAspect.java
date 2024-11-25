package com.gcu.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

	// Log method entry for all methods in controller, business, and data packages
	@Before("execution(* com.gcu.controller.*.*(..)) || execution(* com.gcu.business.*.*(..)) || execution(* com.gcu.data.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		logger.info("Entering {}.{}()", className, methodName);
	}

	// Log method exit for all methods in controller, business, and data packages
	@After("execution(* com.gcu.controller.*.*(..)) || execution(* com.gcu.business.*.*(..)) || execution(* com.gcu.data.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		logger.info("Exiting {}.{}()", className, methodName);
	}

	// Log exceptions for all methods in controller, business, and data packages
	@AfterThrowing(pointcut = "execution(* com.gcu.controller.*.*(..)) || execution(* com.gcu.business.*.*(..)) || execution(* com.gcu.data.*.*(..))", throwing = "ex")
	public void logException(JoinPoint joinPoint, Throwable ex) {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		logger.error("Exception in {}.{}(): {}", className, methodName, ex.getMessage(), ex);
	}
}
