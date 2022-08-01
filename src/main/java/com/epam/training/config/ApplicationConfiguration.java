package com.epam.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class ApplicationConfiguration {
    //text2

    @Bean
    HandlerExceptionResolver errorHandler () {
        return (request, response, handler, ex) -> {
            ModelAndView model = new ModelAndView("errorPage");
            model.addObject("exceptionType", ex);
            model.addObject("handlerMethod", handler);
            return model;
        };
    }

}
