package de.fourtyseveneleven.ones.user.service;

import de.fourtyseveneleven.ones.user.model.dto.EmailPasswordDto;

public interface LoginService {

    String login(EmailPasswordDto emailPasswordDto);
}
