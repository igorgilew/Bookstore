package ru.bookstore.service;

import ru.bookstore.annotation.interceptor.binding.Loggable;
import ru.bookstore.annotation.qualifier.ThirteenDigits;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@Alternative // альтернативная реализация тринадцатизначного генератора для тестов
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Сгенерирован Mock : " + mock);
        return mock;
    }
}
