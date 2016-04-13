package org.lance.bookmanager.logger;

import org.lance.bookmanager.entity.Book;

import java.io.IOException;

/**
 * Created by Corwin on 10.04.2016.
 */
public interface Logger {
    void logBookObserved(Book book) throws IOException;
    void log(String message) throws IOException;
}
