package ru.bookstore;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;
import ru.bookstore.pojo.Book;
import ru.bookstore.service.BookService;

import static org.junit.Assert.assertTrue;


public class BookServiceIT {
    @Test
    public void shouldCheckNumberIsMOCK() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("Learning JavaEE", 1000F, "Interesting book");

        assertTrue(book.getNumber().startsWith("MOCK"));
    }
}
