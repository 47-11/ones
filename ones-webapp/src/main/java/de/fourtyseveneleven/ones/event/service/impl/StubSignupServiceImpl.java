package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.event.model.dto.SignupDto;
import de.fourtyseveneleven.ones.event.service.SignupService;
import org.springframework.stereotype.Service;

@Service
public class StubSignupServiceImpl implements SignupService {

    @Override
    public void signup(SignupDto signup) {

        // No-Op in this implementation
    }

}
