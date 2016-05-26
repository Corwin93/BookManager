package org.lance.bookmanager.repository;

import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.entity.User;

import java.util.List;

/**
 * Created by Corwin on 10.04.2016.
 */

public interface BookRepository {
    void addBook(Book book);
    List listAllBooks();
    List listAllBooksByPurchases(Integer number);
    Book getBookById(Integer bookId);
    void removeBook(Integer id);
    void addUser(User user);
    List listAllUsers();
    User getUserByNickName(String nickName);
    void removeUser(String nickName);
}
