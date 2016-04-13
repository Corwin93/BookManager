package org.lance.bookmanager.controller;

import org.lance.bookmanager.annotation.BookValidation;
import org.lance.bookmanager.annotation.MySqlRepo;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Corwin on 07.02.2016.
 */

@Controller
public class BookController {
    @Autowired
    @MySqlRepo
    private BookRepository bookRepository;

    @Autowired
    @BookValidation
    private Validator bookValidator;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String indexPage(Model model) {
        List books = bookRepository.listAllByPurchases(4);
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = {"/listBooks", "/list"}, method = RequestMethod.GET)
    public String listBooks(Model model) {
        List<Book> books = bookRepository.listAll();
        model.addAttribute("books", books);
        return "listBooks";
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public String productPage(@PathVariable Integer bookId, Model model) {
        model.addAttribute("book", bookRepository.getById(bookId));
        return "productPage";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "addBook";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("newBook") Book book, BindingResult result) {
        bookValidator.validate(book, result);
        if(result.hasErrors()) return "addBook";
        bookRepository.addBook(book);
        return "redirect:/listBooks";
    }

    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id) {
        bookRepository.removeBook(id);
        return "redirect:/listBooks";
    }
}
