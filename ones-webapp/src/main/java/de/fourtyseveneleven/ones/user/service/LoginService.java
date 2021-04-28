package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.dto.LoginDto;

public interface LoginService {

    String login(LoginDto loginDto);
}
