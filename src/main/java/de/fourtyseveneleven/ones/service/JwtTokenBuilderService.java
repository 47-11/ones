package de.fourtyseveneleven.ones.service;

import de.fourtyseveneleven.ones.model.User;

public interface JwtTokenBuilderService {

    String buildToken(User user);
}
