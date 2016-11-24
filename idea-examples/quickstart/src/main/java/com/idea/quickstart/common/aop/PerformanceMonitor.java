package com.idea.quickstart.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PerformanceMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitor.class);

    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        long start = System.nanoTime();
        Object ret = point.proceed();
        long end = System.nanoTime();

        LOGGER.info("{}: {}ms", point.getTarget().getClass() + "." + point.getSignature().getName(),
                (end - start) / 1000000);
        return ret;
    }
}
