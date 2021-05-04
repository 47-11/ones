package de.fourtyseveneleven.ones.user.controller;

import de.fourtyseveneleven.ones.user.model.dto.RegistrationDto;
import de.fourtyseveneleven.ones.user.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createRegistration(@RequestBody RegistrationDto registration) {

        registrationService.createRegistration(registration);
    }

    @PostMapping("/confirm")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void confirmRegistration(@RequestParam(name = "code") String registrationConfirmationCode) {

        registrationService.confirmRegistration(registrationConfirmationCode);
    }
}
