package org.lance.bookmanager.repository;

import org.hibernate.SessionFactory;
import org.lance.bookmanager.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Corwin on 07.02.2016.
 */
@Repository
@Transactional
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addBook(Book book) {
        this.sessionFactory.getCurrentSession().save(book);
    }

    public List<Book> listAll() {
        return this.sessionFactory.getCurrentSession()
                                  .createQuery("from Book").list();
    }

    public List<Book> listAllByPurchases(Integer number) {
        return this.sessionFactory.getCurrentSession().createQuery("from Book order by purchases desc").setMaxResults(number).list();
    }

    public void removeBook(Integer id) {
        Book book = (Book) this.sessionFactory.getCurrentSession().load(Book.class, id);
        if(null != book) {
            this.sessionFactory.getCurrentSession().delete(book);
        }
    }
}
