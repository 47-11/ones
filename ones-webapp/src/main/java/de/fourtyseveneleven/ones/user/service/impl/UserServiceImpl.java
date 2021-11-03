package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataContactControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataContact;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
import de.fourtyseveneleven.ones.user.mapper.UserDtoMapper;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import de.fourtyseveneleven.ones.user.service.EcmRegistrationService;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static de.fourtyseveneleven.ones.security.util.UserUtils.getAuthenticatedUser;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MasterdataContactControllerApi masterdataContactControllerApi;
    private final UserDtoMapper userDtoMapper;
    private final EcmRegistrationService ecmRegistrationService;

    public UserServiceImpl(UserRepository userRepository, MasterdataContactControllerApi masterdataContactControllerApi, ApplicationAccountControllerApi applicationAccountControllerApi, UserDtoMapper userDtoMapper, EcmRegistrationService ecmRegistrationService) {
        this.userRepository = userRepository;
        this.masterdataContactControllerApi = masterdataContactControllerApi;
        this.userDtoMapper = userDtoMapper;
        this.ecmRegistrationService = ecmRegistrationService;
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

    @Override
    public UserDto getCurrentUser() {

        final User currentUser = getAuthenticatedUser();
        final UUID uuid = currentUser.getUuid();
        if (isNull(uuid)) {
            return new UserDto(currentUser.getEmailAddress());
        } else {
            return getUserFromEcm(uuid);
        }
    }

    private UserDto getUserFromEcm(UUID userUuid) {

        try {
            return tryGetUserFromEcm(userUuid);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private UserDto tryGetUserFromEcm(UUID userUuid) throws ApiException {

        final MasterdataContact masterdataContact = masterdataContactControllerApi.getContactByUuid(userUuid.toString());
        return userDtoMapper.masterdataContactToUserDto(masterdataContact);
    }

    @Override
    public void setPersonalDataForCurrentUser(UserDto personalData) {

        final User currentUser = getAuthenticatedUser();
        if (isNull(currentUser.getUuid())) {
            setPersonalData(currentUser, personalData);
        } else {
            updatePersonalData(currentUser, personalData);
        }
    }

    private void setPersonalData(User user, UserDto personalData) {

        final UUID uuid = ecmRegistrationService.registerNewMember(user, personalData);
        user.setUuid(uuid);
        updateUser(user);
    }

    private void updatePersonalData(User user, UserDto personalData) {

        // TODO: Update personal data in ECM
    }

    @Override
    @Transactional
    public void deleteSelf() {

        final User toDelete = getAuthenticatedUser();
        userRepository.delete(toDelete);
    }
}
