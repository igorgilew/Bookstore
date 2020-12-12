package ru.bookstore.service;

import ru.bookstore.annotation.interceptor.binding.Loggable;
import ru.bookstore.pojo.Book;
import ru.bookstore.annotation.qualifier.ThirteenDigits;

import javax.inject.Inject;

@Loggable //связка с перехватчиком
public class BookService {

    @Inject @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }


}
