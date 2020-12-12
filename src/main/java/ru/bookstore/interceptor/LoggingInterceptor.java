package ru.bookstore.interceptor;

import ru.bookstore.annotation.interceptor.binding.Loggable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke // вместо вызова перехваченного метода компонента
    public Object logMethod(InvocationContext invocationContext) throws Exception {
        logger.entering(invocationContext.getTarget().getClass().getName(),
                invocationContext.getMethod().getName());
        try {
            return invocationContext.proceed(); // выполнение метода компонента
        } finally {
            logger.exiting(invocationContext.getTarget().getClass().getName(),
                    invocationContext.getMethod().getName());
        }
    }

}
