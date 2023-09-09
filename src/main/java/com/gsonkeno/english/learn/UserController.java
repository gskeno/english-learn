package com.gsonkeno.english.learn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user")
    public String user(String name){
        System.out.println(name);
        return name;
    }
}
