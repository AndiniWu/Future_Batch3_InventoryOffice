package com.tim3.ois.controller;


import com.tim3.ois.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.tim3.ois.model.User;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/registration")
    public ModelAndView getRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createNewUser(
            @Valid
            @RequestBody
                    User user, BindingResult bindingResult){
        User userExists = userService.findUserByEmail(user.getEmail());
        if(userExists!=null){
            bindingResult.rejectValue("email","There is already a user registered with the email provided");
            return false;
        }
        userService.saveUser(user);
        return true;
        }
    }


//    @PostMapping(value = "/registration", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ModelAndView createNewUser(
//            @Valid
//            @RequestBody
//                    User user, BindingResult bindingResult){
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByEmail(user.getEmail());
//        if(userExists!=null){
//            bindingResult.rejectValue("email","There is already a user registered with the email provided");
//        }
//        if(bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            userService.saveUser(user);
//            modelAndView.setViewName("registration");
//            modelAndView.addObject("user",new User());
//        }
//        return modelAndView;
//    }


