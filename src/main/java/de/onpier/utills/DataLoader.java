package de.onpier.utills;

import de.onpier.dto.Book;
import de.onpier.dto.BorrowedBook;
import de.onpier.dto.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataLoader {
    @Autowired
    private BooksDataLoader booksDataLoader = new BooksDataLoader();
    @Autowired
    private BorrowedDataLoader borrowedDataLoader = new BorrowedDataLoader();
    @Autowired
    private UsersDataLoader usersDataLoader = new UsersDataLoader();

    private static DataLoader dataLoader_instance = null;

    private List<Book> bookList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<BorrowedBook> borrowedBook = new ArrayList<>();

    private DataLoader(){
        if(this.bookList.isEmpty()){
            this.bookList = booksDataLoader.init("src/main/resources/csv/books.csv");
        }
        if(this.userList.isEmpty()){
            this.userList = usersDataLoader.init("src/main/resources/csv/user.csv");
        }
        if(this.borrowedBook.isEmpty())
            this.borrowedBook = borrowedDataLoader.init("src/main/resources/csv/borrowed.csv");
    }

    public static DataLoader getInstance()
    {
        if (dataLoader_instance == null)
            dataLoader_instance = new DataLoader();
        return dataLoader_instance;
    }


}
