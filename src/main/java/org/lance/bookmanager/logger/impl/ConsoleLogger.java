package org.lance.bookmanager.logger.impl;

import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.logger.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * Created by Corwin on 11.04.2016.
 */
public class ConsoleLogger implements Logger {
    @Override
    public void logBookObserved(Book book) throws IOException {
        String currentTime = new Date().toString();
        String message = currentTime
                + ": The book "
                + book.getId().toString()
                + "/\"" + book.getTitle() + "\""
                + " was observed\n";
        System.out.println(message);
    }

    @Override
    public void log(String message) throws IOException {
        System.out.println(message);
    }
}
