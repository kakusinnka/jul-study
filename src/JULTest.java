import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

public class JULTest {

    /*
     * 输出方式
     */
    @Test
    public void test001() {
        Logger logger = Logger.getLogger("JULTest");

        logger.info("Hello JUL!!!");

        logger.log(Level.INFO, "Hellow JUL 002!!!");

        String name = "zhangsan";
        int age = 28;
        logger.log(Level.INFO, "学生的姓名：{0}，年龄：{1}。", new Object[] { name, age });

    }

    /*
     * 日志级别
     */
    @Test
    public void test002() {
        Logger logger = Logger.getLogger("JULTest");

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /*
     * 指定Hander, Formatter
     */
    @Test
    public void test003() {
        Logger logger = Logger.getLogger("JULTest");
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);

        logger.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    /*
     * 指定Hander, Formatter
     */
    @Test
    public void test004() throws SecurityException, IOException {
        Logger logger = Logger.getLogger("JULTest");
        logger.setUseParentHandlers(false);
        FileHandler handler = new FileHandler("D:/workSpace/src/project/jul-study/log/log.txt");
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        logger.addHandler(handler);

        logger.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}
