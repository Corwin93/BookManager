package org.lance.bookmanager.controller;

import org.lance.bookmanager.domain.Book;
import org.lance.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Corwin on 07.02.2016.
 */
@Controller
@RequestMapping("index")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = bookRepository.listAll();
        model.addAttribute("books", books);
        return "index";
    }
}
