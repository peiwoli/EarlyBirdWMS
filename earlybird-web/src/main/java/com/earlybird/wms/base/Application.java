package com.earlybird.wms.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.earlybird.wms.base.service.MyService;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@RestController
public class Application {

    private final MyService myService;
    
    public Application(MyService myService) {
        this.myService = myService;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }





    @GetMapping("/")
    public String home() {
        return myService.message();
    }
  
}
