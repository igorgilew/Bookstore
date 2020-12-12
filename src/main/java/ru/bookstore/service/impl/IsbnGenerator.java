package ru.bookstore.service.impl;

import ru.bookstore.annotation.interceptor.binding.Loggable;
import ru.bookstore.annotation.qualifier.ThirteenDigits;
import ru.bookstore.service.NumberGenerator;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    Logger logger;

    @Loggable // для реализации сквозной функциональности и активации перехватчика
    public String generateNumber() {
        String isbn = "13-84356-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован ISBN : " + isbn);
        return isbn;
    }
}
