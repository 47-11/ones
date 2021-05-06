package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.user.model.dto.ForgotPasswordDto;
import de.fourtyseveneleven.ones.user.model.dto.ForgotPasswordSetNewPasswordDto;
import de.fourtyseveneleven.ones.user.service.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/forgot-password")
public class ForgotPasswordController {

    private final PasswordService passwordService;

    public ForgotPasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void forgotPassword(@RequestBody ForgotPasswordDto forgotPasswordDto) {

        passwordService.forgotPassword(forgotPasswordDto.getEmailAddress());
    }

    @PostMapping("/change-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void forgotPasswordSetNewPassword(@RequestBody ForgotPasswordSetNewPasswordDto forgotPasswordSetNewPasswordDto) {

        passwordService.forgotPasswordSetNewPassword(forgotPasswordSetNewPasswordDto.getCode(),
                forgotPasswordSetNewPasswordDto.getNewPassword());
    }
}
