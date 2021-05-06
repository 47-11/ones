package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.user.model.dto.ChangePasswordDto;
import de.fourtyseveneleven.ones.user.service.PasswordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@AuthenticatedApiController
@RequestMapping("/api/v1/change-password")
public class ChangePasswordController {

    private final PasswordService passwordService;

    public ChangePasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changePassword(@RequestBody ChangePasswordDto changePasswordDto) {

        passwordService.changePassword(changePasswordDto.getOldPassword(), changePasswordDto.getNewPassword());
    }
}
