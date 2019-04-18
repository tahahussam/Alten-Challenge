package com.altenchallenge.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.altenchallenge.controller.*.*(..))")
	public void controllerMethods() {
	}
}