package com.demoqa.shop.util;


import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ATFAssert {
   static Logger log = LoggerFactory.getLogger(ATFAssert.class);

    public static void assertTrue(String message, boolean condition, String expectedMessage) {

        log.info("assert that " + expectedMessage + " is true");
        Assert.assertTrue(message, condition);
    }

    public static void assertFalse(String message, boolean condition, String expectedMessage) {
        log.info("assert that " + expectedMessage + " is true");
        Assert.assertFalse(message, condition);
    }

    public static void assertEquals(Object expected, Object actual, String message, String expectedMessage) {
        log.info("assert that " + expectedMessage);
        Assert.assertEquals(message, expected, actual);
    }

    public static void assertNotNull(Object condition, String message, String expectedMessage) {
        log.info("assert that " + expectedMessage + " is not null");
        Assert.assertNotNull (message, condition);
    }
}
