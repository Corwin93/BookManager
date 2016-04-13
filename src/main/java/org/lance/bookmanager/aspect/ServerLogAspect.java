package org.lance.bookmanager.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.lance.bookmanager.annotation.FileLog;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Created by Corwin on 10.04.2016.
 */

@Aspect
public class ServerLogAspect {
    @Autowired
    @FileLog
    Logger logger;

    @Pointcut("execution(* org.lance.bookmanager.repository.BookRepository.getById(Integer))" +
            "&& args(bookId)")
    public void bookObserved(Integer bookId) {}

    @Around(value = "bookObserved(bookId)", argNames = "jp, bookId")
    public Book aroundBookObserved(ProceedingJoinPoint jp, Integer bookId) {
        Book bookObserved = null;
        try {
            bookObserved = (Book)jp.proceed();
            logger.logBookObserved(bookObserved);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return bookObserved;
    }
}
