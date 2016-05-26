package org.lance.bookmanager.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.lance.bookmanager.annotation.FileLog;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Corwin on 10.04.2016.
 */

@Aspect
public class ServerLogAspect {
    @Autowired
    @FileLog
    Logger logger;

    @Pointcut("execution(* org.lance.bookmanager.repository.BookRepository.getBookById(Integer))" +
            "&& args(bookId)")
    public void bookObserved(Integer bookId) {}

    @Pointcut("execution" +
            "(* org.lance.bookmanager.controller.BookController.checkIp(javax.servlet.http.HttpServletRequest))" +
            "&& args(request)")
    public void adminPageRequested(HttpServletRequest request) {}

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

    @Around(value = "adminPageRequested(request)", argNames = "jp, request")
    public Boolean aroundAdminPageRequested(ProceedingJoinPoint jp, HttpServletRequest request) {
        Boolean result = null;
        try {
            result = (Boolean)jp.proceed();
            logger.logAdminPageRequested(request.getRemoteAddr(), request.getRequestURI(), result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
