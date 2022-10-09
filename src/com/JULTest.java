package com;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.junit.Test;

public class JULTest {
    /*
     * “父子”关系
     * logger02使用了logger01的handler。
     * “setUseParentHandlers”
     * 指定此记录器是否应将其输出发送到其父记录器。
     */
    @Test
    public void test001() {
        Logger logger01 = Logger.getLogger("com");
        Logger logger02 = Logger.getLogger("com.JULTest");
        logger01.setUseParentHandlers(false);
        logger02.setUseParentHandlers(true);
        ConsoleHandler handler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger01.addHandler(handler);

        logger01.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);

        logger01.fine("logger01 fine");
        logger02.fine("logger02 fine");
    }

}
