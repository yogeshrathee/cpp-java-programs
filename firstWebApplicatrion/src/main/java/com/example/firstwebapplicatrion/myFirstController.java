package com.example.firstwebapplicatrion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class myFirstController {
    @RequestMapping("/First")
    public String returnValue() {
        return "Hello Yogesh  ====>>>  GOOD MORNING, HAVE A NICE DAY!!! ";
    }
    @RequestMapping("/Link")
    public String link()
    {
        return " THANK YOU";
    }
}
