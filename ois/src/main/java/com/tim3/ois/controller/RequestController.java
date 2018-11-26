package com.tim3.ois.controller;

import com.tim3.ois.model.Item;
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
    @PostMapping(value = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createNewRequest(
            @Valid
            @RequestBody
                    Request request, BindingResult bindingResult) {
//        Request requestExists= requestService.findRequestById(request.getId());
//        if (requestExists != null) {
//            //bindingResult.rejectValue("request", "There is already a request registered with the name provided");
//            return false;
//        }
        requestService.saveRequest(request);
        return true;
    }
//



}
