package de.fourtyseveneleven.ones.controller;

import de.fourtyseveneleven.ones.model.dto.RegistrationDto;
import de.fourtyseveneleven.ones.service.RegistrationService;
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
    public void createRegistration(@RequestParam(name = "code") String registrationConfirmationCode) {

        registrationService.confirmRegistration(registrationConfirmationCode);
    }
}
