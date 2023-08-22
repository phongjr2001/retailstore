package com.rs.retailstore.controller;

import com.rs.retailstore.model.Greeting;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1")
@Scope("prototype")
public class CustomerGreetingController {


    private static final String greetingTemplate="Hello,%s %s";
    private final AtomicLong counter=new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "gender",defaultValue = "0")boolean gender,
                             @RequestParam(value = "customerName",defaultValue = "Customer")String customerName){
       return Greeting.builder()
               .id(counter.incrementAndGet())
               .content(String.format(greetingTemplate,gender ?"Mr.":"MS.",customerName))
               .build();
    }
}
