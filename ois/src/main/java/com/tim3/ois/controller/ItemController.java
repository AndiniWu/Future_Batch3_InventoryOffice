package com.tim3.ois.controller;


import com.tim3.ois.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.tim3.ois.model.User;
import org.springframework.web.servlet.ModelAndView;

import com.tim3.ois.repository.UserRepository;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class ItemController {

}
