package org.lance.bookmanager.repository.impl;

import org.hibernate.SessionFactory;
import org.lance.bookmanager.annotation.MySqlBookRepo;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.entity.User;
import org.lance.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Corwin on 07.02.2016.
 */
@Repository
@MySqlBookRepo
@Transactional
public class MySqlBookRepository implements BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    public List listAllBooks() {
        return sessionFactory.getCurrentSession()
                                  .createQuery("from Book").list();
    }

    public List listAllBooksByPurchases(Integer number) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Book order by purchases desc").setMaxResults(number).list();
    }

    public Book getBookById(Integer bookId) {
        return (Book)sessionFactory.getCurrentSession()
                .createQuery("from Book where id=" + bookId).uniqueResult();
    }

    public void removeBook(Integer id) {
        Book book = (Book) this.sessionFactory.getCurrentSession().load(Book.class, id);
        if(null != book) {
            sessionFactory.getCurrentSession().delete(book);
        }
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List listAllUsers() {
        return sessionFactory.getCurrentSession()
                .createQuery("from User ").list();
    }

    @Override
    public User getUserByNickName(String nickName) {
        return (User)sessionFactory.getCurrentSession()
                .createQuery("from User where nickName=" + nickName).uniqueResult();
    }

    @Override
    public void removeUser(String nickName) {
        User user = (User) this.sessionFactory.getCurrentSession().load(User.class, nickName);
        if(null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
