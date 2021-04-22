package de.fourtyseveneleven.ones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping("/api/v1/example")
public class ExampleController {

    @GetMapping("hello")
    public String hello(@RequestParam(required = false, defaultValue = "world") String name) {

        return MessageFormat.format("Hello, {0}!", name);
    }
}
