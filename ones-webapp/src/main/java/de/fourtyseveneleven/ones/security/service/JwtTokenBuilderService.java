package de.fourtyseveneleven.ones.security.service;

import de.fourtyseveneleven.ones.user.model.User;

public interface JwtTokenBuilderService {

    String buildToken(User user);
}
