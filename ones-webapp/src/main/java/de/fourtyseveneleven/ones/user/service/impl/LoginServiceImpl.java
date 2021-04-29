package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.LoginDto;
import de.fourtyseveneleven.ones.user.exception.RegistrationIncompleteException;
import de.fourtyseveneleven.ones.security.service.JwtTokenBuilderService;
import de.fourtyseveneleven.ones.user.service.LoginService;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;

@Service
public class LoginServiceImpl implements LoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtTokenBuilderService jwtTokenBuilderService;

    public LoginServiceImpl(PasswordEncoder passwordEncoder, UserService userService, JwtTokenBuilderService jwtTokenBuilderService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtTokenBuilderService = jwtTokenBuilderService;
    }

    @Override
    public String login(LoginDto loginDto) {

        final User user = userService.findOneByEmailAddress(loginDto.getEmailAddress())
                .orElseThrow(() -> new BadCredentialsException(getExceptionMessage("authentication.login.bad-credentials")));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(getExceptionMessage("authentication.login.bad-credentials"));
        }

        if (!user.isRegistrationConfirmed()) {
            throw new RegistrationIncompleteException(getExceptionMessage("authentication.login.registration-incomplete"));
        }

        return jwtTokenBuilderService.buildToken(user);
    }
}
