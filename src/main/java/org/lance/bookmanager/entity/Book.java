package org.lance.bookmanager.entity;


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
    private String language;
    @Column(name = "genre")
    private String genre;
    @Column(name = "number_of_pages")
    private Integer numberOfPages;
    @Column(name = "publish_year")
    private Integer publishYear;
    @Column(name = "price")
    private Integer price;
    @Column(name = "purchases")
    private Integer purchases;

    public Book() {
    }

    public Book(String title, String author, String isbn, String language, String genre, Integer numberOfPages, Integer publishYear, Integer price, Integer purchases, String annotation, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.annotation = annotation;
        this.publisher = publisher;
        this.language = language;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.publishYear = publishYear;
        this.price = price;
        this.purchases = purchases;
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
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

    public Integer getPurchases() {
        return purchases;
    }

    public void setPurchases(Integer purchases) {
        this.purchases = purchases;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
