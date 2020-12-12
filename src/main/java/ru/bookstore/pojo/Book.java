package ru.bookstore.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private String title;
    private Float price;
    private String description;
    private String number;

    public Book(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
