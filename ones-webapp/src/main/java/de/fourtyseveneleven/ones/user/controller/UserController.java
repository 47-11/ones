package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@AuthenticatedApiController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserDto getCurrentUser() {

        return userService.getCurrentUser();
    }

    @PatchMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPersonalData(@RequestBody UserDto personalData) {

        userService.setPersonalDataForCurrentUser(personalData);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSelf() {
        userService.deleteSelf();
    }
}
