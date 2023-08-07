package com.bankapp.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LoggingAspect {
	private Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);

	//transfer, withdraw, deposit any method of service : wildcard
	
//	@Around("execution(public void transfer(..))")
	@Around("execution( * com.bankapp.service.*.*(..))")
	public Object around(ProceedingJoinPoint pjp)throws Throwable {
		long start =System.currentTimeMillis();
		
		Object value=pjp.proceed();
		
		long end  =System.currentTimeMillis();
		
		logger.info("time taken to exeuction method: "+pjp.getSignature().getName()+" is " +(end-start)+" ms");
		
		return value;
	}
	
	
	
	
	
	
	
	
//	@Pointcut("execution(public void transfer(..))")
//	public void loggingPointCut() {}
//	
//	//u use something called wildcard
//	
//	@Around("loggingPointCut()")
//	public Object around(ProceedingJoinPoint pjp)throws Throwable {
//		long start =System.currentTimeMillis();
//		
//		Object value=pjp.proceed();
//		
//		long end  =System.currentTimeMillis();
//		
//		logger.info("time taken to transfer method: "+(end-start)+" ms");
//		
//		return value;
//	}
	
	
}












