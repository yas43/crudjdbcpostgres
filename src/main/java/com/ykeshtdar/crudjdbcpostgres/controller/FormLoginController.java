package com.ykeshtdar.crudjdbcpostgres.controller;

import com.ykeshtdar.crudjdbcpostgres.dao.*;
import com.ykeshtdar.crudjdbcpostgres.model.*;
import com.ykeshtdar.crudjdbcpostgres.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("admin")
public class FormLoginController {
    private final FormLoginService formLoginService;

    public FormLoginController(FormLoginService formLoginService) {

        this.formLoginService = formLoginService;
    }

    @PostMapping("/add")
    public FormLogin addUser(@RequestBody FormLogin formLogin){
        return formLoginService.addUser(formLogin);
    }

    @GetMapping("/{id}")
    public FormLogin displayUser(@PathVariable("id")Integer id){
        return formLoginService.displayUserById(id);
    }

    @PutMapping("/update")
    public FormLogin updateUser(@RequestBody FormLogin formLogin){
        return formLoginService.updateUser(formLogin);
    }

    @GetMapping("/display")
    public List<FormLogin> displayAllUser(){
        return formLoginService.displayAllUser();
    }

    @PostMapping("/{id}")
    public boolean isUserExist(@PathVariable("id")Integer id){
        return formLoginService.isUserExist(id);
    }
}
