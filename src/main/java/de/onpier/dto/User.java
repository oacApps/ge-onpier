package de.onpier.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String firstName;
    private String MemberSince;
    private String memberTill;
    private String gender;
}
