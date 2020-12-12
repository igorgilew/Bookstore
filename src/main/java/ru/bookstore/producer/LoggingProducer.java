package ru.bookstore.producer;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Поскольку Logger входит в состав JDK, он не является бином,
 * который можно вставить в точку внедрения (rt.jar не содержит beans.xml),
 * поэтому нужно произвести внедряемый Logger, который можно инжектить.
 */
public class LoggingProducer {
    @Produces
    public Logger produceLogger (InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
