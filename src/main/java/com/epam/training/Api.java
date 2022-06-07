package com.epam.training;

import com.epam.training.facade.impl.BookingFacadeImpl;
import com.epam.training.model.Event;
import com.epam.training.model.Ticket;
import com.epam.training.model.User;
import com.epam.training.utils.FileParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class Api {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        BookingFacadeImpl bookingFacade = context.getBean("bookingFacade", BookingFacadeImpl.class);
        System.out.println(bookingFacade.getEventById(1));
        System.out.println(bookingFacade.getUserById(1));
    }
}
