package com.example.frequency_api.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

@RestController
public class exampleController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(exampleController.class);
    @GetMapping("/echo/{text}")
    public Callable<String> echo(@PathVariable("text") String text){    //Callable<> makes async rendering
//        LOGGER.info("echo({})" + text);
        return () -> text;
    }
}
