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
public class UserSvc {
    private List<User> userList = new ArrayList<>();
    private List<BorrowedBook> borrowedBook = new ArrayList<>();

    private UserSvc(){
        DataLoader dataLoader = DataLoader.getInstance();
        if(this.userList.isEmpty()){
            this.userList = dataLoader.getUserList();
        }
        if(this.borrowedBook.isEmpty()) {
            this.borrowedBook = dataLoader.getBorrowedBook();
        }
    }

    public List<User> borrowed(){
        List<User> users = this.userList
                .stream()
                .filter(usr ->
                        this.borrowedBook.stream()
                        .anyMatch(bbook ->
                                bbook.getBorrower().equalsIgnoreCase(usr.getName()+"," +usr.getFirstName())
                        )
                ).collect(Collectors.toList());
        return users;
    }

    public List<User> nonTerminatedUser(){
        List<User> users = this.userList
                .stream()
                .filter(usr ->
                        this.borrowedBook.stream().noneMatch(bbook ->
                                        bbook.getBorrower().equalsIgnoreCase(usr.getName()+"," +usr.getFirstName())
                                )
                ).collect(Collectors.toList());

        return users;
    }
}
