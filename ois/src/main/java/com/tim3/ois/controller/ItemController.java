package com.tim3.ois.controller;


import com.tim3.ois.model.Item;
import com.tim3.ois.model.User;
import com.tim3.ois.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;

//    @GetMapping("/items")
//    public ModelAndView getRegistration() {
//        ModelAndView modelAndView = new ModelAndView();
//        Item item= new Item();
//        modelAndView.addObject("item", item);
//        modelAndView.setViewName("items");
//        return modelAndView;
//    }
    @GetMapping("/items")
    public String getItem(){
        return "testing items";
    }

//    @PostMapping(value = "/items",produces = MediaType.APPLICATION_JSON_VALUE)
//    public boolean createNewItem(
//            @Valid
//            @RequestBody
//                    Item item, BindingResult bindingResult) {
//        Item itemExists = itemService.findItemByName(item.getName());
//        if (itemExists != null) {
//            bindingResult.rejectValue("item", "There is already an item registered with the name provided");
//            return false;
//        }
//        itemService.saveItem(item);
//        return true;
//    }
    @PostMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createNewUser(
            @Valid
            @RequestBody
                    Item item, BindingResult bindingResult) {
        Item itemExists= itemService.findItemByName(item.getName());
        if (itemExists != null) {
            //bindingResult.rejectValue("item", "There is already an item registered with the name provided");
            return false;
        }
        itemService.saveItem(item);
        return true;
    }
    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable(value = "id") int itemId,
                           @Valid @RequestBody Item itemNow) {
        Item item = itemService.findItemById(itemId);
        item.setQuantity(itemNow.getQuantity());
        item.setDescription(itemNow.getDescription());
        item.setPrice(itemNow.getPrice());
        item.setName(itemNow.getName());
        Item updatedItem = itemService.saveItem(item);
        return updatedItem;
    }

    @DeleteMapping("/items/{id}")
    public Boolean deleteUser(@PathVariable(value = "id")int itemId){
        Item item = itemService.findItemById(itemId);
        itemService.deleteItem(item);
        return true;
    }

}
