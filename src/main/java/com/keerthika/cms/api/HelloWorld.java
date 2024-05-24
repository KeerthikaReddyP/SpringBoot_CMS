package com.keerthika.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

//    @RequestMapping(value="/hello")
    @GetMapping
    public String sayHello(){
        return "Helloo world!";
    }
}
