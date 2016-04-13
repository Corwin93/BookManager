package org.lance.bookmanager;

import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.logger.impl.FileLogger;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Corwin on 11.04.2016.
 */
public class Test {
    private static FileLogger logger = new FileLogger();
    public static void main(String[] args) {
        logger.setFilePath(Paths.get("E:\\serverLog.log"));
        try {
            logger.logBookObserved(new Book("retre"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
