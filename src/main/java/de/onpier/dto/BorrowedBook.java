package de.onpier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BorrowedBook {
    private String borrower;
    private String book;
    private String borrowedFrom;
    private String borrowedTo;
}
