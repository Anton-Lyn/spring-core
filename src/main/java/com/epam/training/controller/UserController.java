package com.epam.training.controller;

import com.epam.training.facade.BookingFacade;
import com.epam.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Integer id, Model model) {
        User user = bookingFacade.getUserById(id);
        model.addAttribute("user", user);
        throw new RuntimeException("privet");

//        return "user";
    }

    @GetMapping("/createUser")
    public String newUser(Model model) {
        model.addAttribute("defaultUser", new User());

        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("defaultUser") User user) {
        bookingFacade.createUser(user);

        return "redirect:/";
    }


}
