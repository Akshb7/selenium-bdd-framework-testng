package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {

    private static final Logger log = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        log.info("This is an INFO log!");
        log.warn("This is a WARN log!");
        log.error("This is an ERROR log!");
    }
}