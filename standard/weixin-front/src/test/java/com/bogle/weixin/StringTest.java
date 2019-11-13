package com.bogle.weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Bogle on 2015/12/23.
 */
public class StringTest {

    private final static Logger log = LoggerFactory.getLogger(StringTest.class);

//    @Test
    public void testBoolean() {
        log.info(Boolean.parseBoolean(null) + "");
    }
}
