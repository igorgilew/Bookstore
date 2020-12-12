package ru.bookstore;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import ru.bookstore.pojo.Book;
import ru.bookstore.service.BookService;

/**
 * Класс для запуска.
 * Создает CDI контейнер (в специфике Weld) и вызывает метод компонента
 */
public class App {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();//создаем контейнер
        //получаем внедренный и сконструированный компонент
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("Изучаем JavaEE7", 12.5f, "Интересная и полезная книга");
        System.out.println(book);
        weld.shutdown();
    }
}
