package de.onpier.service;

import de.onpier.dto.Book;
import de.onpier.dto.BorrowedBook;
import de.onpier.dto.User;
import de.onpier.utills.DataLoader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookSvc {

    private List<Book> bookList = new ArrayList<>();
    private List<BorrowedBook> borrowedBook = new ArrayList<>();

    private BookSvc(){
        DataLoader dataLoader = DataLoader.getInstance();
        if(this.bookList.isEmpty()){
            this.bookList = dataLoader.getBookList();
        }
        if(this.borrowedBook.isEmpty()) {
            this.borrowedBook = dataLoader.getBorrowedBook();
        }
    }
    public List<Book> availableBooks(){

        List<Book> books = this.bookList.stream()
                .filter(book -> this.borrowedBook.stream().anyMatch(
                        bbook -> bbook.getBook().equalsIgnoreCase(book.getTitle())
                )).collect(Collectors.toList());

        return books;
    }
}
