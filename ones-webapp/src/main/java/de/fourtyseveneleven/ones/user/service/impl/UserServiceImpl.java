package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findOneByEmailAddress(String emailAddress) {

        return userRepository.findOneByEmailAddress(emailAddress);
    }

    @Override
    public Optional<User> findByIncompleteRegistration(String registrationConfirmationCode) {

        return userRepository.findOneByRegistrationConfirmationCodeAndRegistrationConfirmedIsFalse(registrationConfirmationCode);
    }

    @Override
    @Transactional
    public User createNewUser(User newUser) {

        requireNewUser(newUser);
        return userRepository.save(newUser);
    }

    private void requireNewUser(User newUser) {

        final Optional<User> existingUser = findOneByEmailAddress(newUser.getEmailAddress());
        if (existingUser.isPresent()) {
            throw new ElementAlreadyPresentException();
        }
    }

    @Override
    @Transactional
    public User updateUser(User updatedUser) {

        final User toUpdate = userRepository.findOneById(updatedUser.getId()).orElseThrow(ElementNotFoundException::new);
        BeanUtils.copyProperties(updatedUser, toUpdate);
        return userRepository.save(toUpdate);
    }
}
