package com.tim3.ois.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.tim3.ois.model.User;


@Controller
public class RegistrationController {

    @GetMapping(value="/registration")
    public String getRegistration(){
        return "registration";
    }

    @ResponseBody
    @PostMapping(value = "/api/registration", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean authenticate(@RequestBody User user) {

        // this logic should be moved inside service implementation
        if(user.getName()!= ""){
            return true;
        }
        return false;
    }

}
