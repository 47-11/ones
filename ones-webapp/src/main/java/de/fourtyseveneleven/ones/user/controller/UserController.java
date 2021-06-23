package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
