package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.user.model.dto.SetPersonalDataRequest;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setPersonalData(@RequestBody SetPersonalDataRequest request) {

        userService.setPersonalData(request);
    }

    @PatchMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePersonalData(@RequestBody UserDto personalData) {

        userService.updatePersonalData(personalData);
    }

    @DeleteMapping("/me")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSelf() {
        userService.deleteSelf();
    }
}
