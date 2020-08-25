package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
	public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	/**
	 * This method uses Around advice which ensures that an advice can run before
	 * and after the method execution and log the execution time of the method
	 * This advice will be be applied to all the method which are annotated with the
	 * annotation @LogExecutionTime @see com.example.demo.LogExecutionTime
	 * 
	 * Any method where execution times need to be measured and logged, annotate the method with @LogExecutionTime
	 * example 
	 * @LogExecutionTime
	 * public void m1();
	 * 
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(com.example.demo.LogExecutionTime)")
	public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		// Measure method execution time
		StopWatch stopWatch = new StopWatch(className + "->" + methodName);
		stopWatch.start(methodName);
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();
		// Log method execution time
		if (logger.isInfoEnabled()) {
			logger.info(stopWatch.prettyPrint());
		}
		return result;
	}
}
