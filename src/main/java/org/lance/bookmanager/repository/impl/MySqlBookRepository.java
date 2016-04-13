package org.lance.bookmanager.repository.impl;

import org.hibernate.SessionFactory;
import org.lance.bookmanager.annotation.MySqlRepo;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Corwin on 07.02.2016.
 */
@Repository
@MySqlRepo
@Transactional
public class MySqlBookRepository implements BookRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    public List listAll() {
        return sessionFactory.getCurrentSession()
                                  .createQuery("from Book").list();
    }

    public List listAllByPurchases(Integer number) {
        return sessionFactory.getCurrentSession().createQuery("from Book order by purchases desc").setMaxResults(number).list();
    }

    public Book getById(Integer bookId) {
        return (Book)sessionFactory.getCurrentSession().createQuery("from Book where id=" + bookId).uniqueResult();
    }

    public void removeBook(Integer id) {
        Book book = (Book) this.sessionFactory.getCurrentSession().load(Book.class, id);
        if(null != book) {
            sessionFactory.getCurrentSession().delete(book);
        }
    }
}
