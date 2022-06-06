package com.epam.training;

import com.epam.training.facade.impl.BookingFacadeImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Api {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BookingFacadeImpl bookingFacade = context.getBean("bookingFacade", BookingFacadeImpl.class);
        System.out.println(bookingFacade);
    }
}
