package com.quickstart.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author andaicheng
 */
public class StringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringTest.class);

    @Test
    public void test001() {
        System.out.print(StringUtils.defaultIfBlank(" ", "25"));
    }

    @Test
    public void testLog() {
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
