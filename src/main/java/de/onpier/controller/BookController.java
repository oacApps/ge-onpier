package de.onpier.controller;

import de.onpier.dto.Book;
import de.onpier.service.BookSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookSvc bookSvc;

    @GetMapping("/available")
    public List<Book> availableBooks()
    {
        return bookSvc.availableBooks();
    }
}
