package org.lance.bookmanager.controller;

import org.lance.bookmanager.annotation.BookValidation;
import org.lance.bookmanager.annotation.MySqlBookRepo;
import org.lance.bookmanager.annotation.UserValidation;
import org.lance.bookmanager.entity.Book;
import org.lance.bookmanager.entity.User;
import org.lance.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Corwin on 07.02.2016.
 */

@Controller
public class BookController {
    @Autowired
    @MySqlBookRepo
    private BookRepository bookRepository;

    @Autowired
    @BookValidation
    private Validator bookValidator;

    @Autowired
    @UserValidation
    private Validator userValidator;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String indexPage(Model model) {
        List books = bookRepository.listAllBooksByPurchases(4);
        model.addAttribute("books", books);
        model.addAttribute("login", new User());
        return "index";
    }

    @RequestMapping(value = {"/listBooks", "/listbooks"}, method = RequestMethod.GET)
    public String listBooks(Model model) {
        List<Book> books = bookRepository.listAllBooks();
        model.addAttribute("books", books);
        return "listBooks";
    }

    @RequestMapping(value = {"/listUsers", "/listusers"}, method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<User> users = bookRepository.listAllUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public String productPage(@PathVariable Integer bookId, Model model) {
        model.addAttribute("book", bookRepository.getBookById(bookId));
        return "productPage";
    }

    @RequestMapping(value = {"/addBook", "/addbook"}, method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "addBook";
    }

    @RequestMapping(value = {"/addBook", "/addbook"}, method = RequestMethod.POST)
    public String addBook(@ModelAttribute("newBook") Book book, BindingResult result) {
        bookValidator.validate(book, result);
        if(result.hasErrors()) return "addBook";
        bookRepository.addBook(book);
        return "redirect:/listBooks";
    }

    @RequestMapping(value = {"/deleteBook/{id}", "/deletebook/{id}"}, method = RequestMethod.GET)
    public String deleteBook(@PathVariable Integer id) {
        bookRepository.removeBook(id);
        return "redirect:/listBooks";
    }

    @RequestMapping(value = {"/deleteUser/{nickName}", "/deleteuser/{nickName}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String nickName) {
        bookRepository.removeUser(nickName);
        return "redirect:/listUsers";
    }

    @RequestMapping(value = {"/addUser", "/adduser"}, method=RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("newUser", new User());
        return "addUser";
    }

    @RequestMapping(value = {"/addUser", "/adduser"}, method = RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser") User user, BindingResult errors) {
        userValidator.validate(user, errors);
        if(errors.hasErrors()) {
            return "addUser";
        }
            bookRepository.addUser(user);
            return "redirect:/listUsers";
    }

    @RequestMapping(value = "/register", method=RequestMethod.GET)
    public String registerUser(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser
            (@ModelAttribute("newUser") User newUser, BindingResult errors, Model model) {
        userValidator.validate(newUser, errors);
        if(errors.hasErrors()) {
            return "register";
        }
        bookRepository.addUser(newUser);
        return "redirect:/index";
    }

    //TODO Check ip address for admin pages
    public Boolean checkIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        if("77.47.237.30" == ipAddress || "127.0.0.1" == ipAddress)
            return true;
        else
            return false;
    }
}
