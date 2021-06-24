package de.fourtyseveneleven.ones.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/connection-test")
public class ConnectionTestController {

    @GetMapping("")
    public ConnectionTestResult testConnection() {

        return new ConnectionTestResult(LocalDateTime.now());
    }

    public record ConnectionTestResult(LocalDateTime timestamp) {
    }
}
