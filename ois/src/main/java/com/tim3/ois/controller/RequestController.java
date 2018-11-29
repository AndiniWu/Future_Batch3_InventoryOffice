package com.tim3.ois.controller;

import com.tim3.ois.model.Request;
import com.tim3.ois.model.User;
import com.tim3.ois.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping("/request")
    public List<Request> getAllLends(){
        return requestService.findAll();
    }

//



}
