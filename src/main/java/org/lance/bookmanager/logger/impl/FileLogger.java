package org.lance.bookmanager.logger.impl;

import org.lance.bookmanager.annotation.*;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * Created by Corwin on 10.04.2016.
 */

@Component
@FileLog
public class FileLogger implements Logger {
    Path filePath;

    @Override
    public void logBookObserved(Book book) throws IOException {
        String currentTime = new Date().toString();
        String message = currentTime
                + ": The book "
                + book.getId().toString()
                + "/\"" + book.getTitle() + "\""
                + " was observed\n";
        Files.write(filePath, message.getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public void log(String message) throws IOException {
        Files.write(filePath, message.getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public void logAdminPageRequested(String ip, String Uri, Boolean accessed) throws IOException {
        String currentTime = new Date().toString();
        String response = accessed ? "allowed" : "denied";
        String message = currentTime
                + ": Client "
                + ip
                + " tried to access "
                + Uri
                + ". Access: "
                + response
                + "\n";
        Files.write(filePath, message.getBytes(), StandardOpenOption.APPEND);
    }

    @Autowired
    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }
}
