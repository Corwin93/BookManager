package org.lance.bookmanager.domain;

import org.lance.bookmanager.enumerator.Genre;
import org.lance.bookmanager.enumerator.Language;

import javax.persistence.*;

/**
 * Created by Corwin on 07.02.2016.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "annotation")
    private String annotation;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "language")
    private Language language;
    @Column(name = "genre")
    private Genre genre;
    @Column(name = "number_of_pages")
    private int numberOfPages;
    @Column(name = "publish_year")
    private int publishYear;
    @Column(name = "price")
    private int price;
    @Column(name = "purchases")
    private int purchases;

    public Book() {
    }

    public Book(String title, String author, String isbn, Language language, Genre genre, Integer id, int numberOfPages, int publishYear, int price, int purchases, String annotation, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.annotation = annotation;
        this.publisher = publisher;
        this.language = language;
        this.genre = genre;
        this.id = id;
        this.numberOfPages = numberOfPages;
        this.publishYear = publishYear;
        this.price = price;
        this.purchases = purchases;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public String getLanguage() {
        return language.getValue();
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre.getValue();
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
