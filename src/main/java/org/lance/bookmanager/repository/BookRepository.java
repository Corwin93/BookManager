package org.lance.bookmanager.repository;

import org.lance.bookmanager.entity.Book;

import java.util.List;

/**
 * Created by Corwin on 10.04.2016.
 */

public interface BookRepository {
    void addBook(Book book);
    List listAll();
    List listAllByPurchases(Integer number);
    Book getById(Integer bookId);
    void removeBook(Integer id);
}
