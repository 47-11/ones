package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.user.model.dto.EmailPasswordDto;
import de.fourtyseveneleven.ones.user.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("")
    public String login(@RequestBody EmailPasswordDto emailPasswordDto) {

        return loginService.login(emailPasswordDto);
    }
}
