package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContactNatural;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterMembership;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterResponce;
import de.fourtyseveneleven.ones.user.mapper.UserMapper;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.UserDto;
import de.fourtyseveneleven.ones.user.service.EcmRegistrationService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@Service
public class EcmRegistrationServiceImpl implements EcmRegistrationService {

    private final ApplicationAccountControllerApi applicationAccountControllerApi;
    private final UserMapper userMapper;

    public EcmRegistrationServiceImpl(ApplicationAccountControllerApi applicationAccountControllerApi, UserMapper userMapper) {
        this.applicationAccountControllerApi = applicationAccountControllerApi;
        this.userMapper = userMapper;
    }

    @Override
    public UUID registerNewMemberByVddNumber(User user, int vddMemberNumber) {

        final RegisterResponce registerResponce = tryRegisterMemberByVddNumber(user.getEmailAddress(), vddMemberNumber);
        return getUserUuidFromEcmRegistrationResponse(registerResponce);
    }

    private RegisterResponce tryRegisterMemberByVddNumber(String emailAddress, int vddMemberNumber) {

        final RegisterAccount registerAccount = buildRegisterMemberByVddMemberNumberRequest(emailAddress, vddMemberNumber);

        try {
            return applicationAccountControllerApi.postRegisterAccount(registerAccount);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private RegisterAccount buildRegisterMemberByVddMemberNumberRequest(String emailAddress, int vddMemberNumber) {

        final RegisterAccount registerAccount = new RegisterAccount();
        registerAccount.setLoginIdentification(emailAddress);

        final RegisterContactNatural registerContactNatural = new RegisterContactNatural();
        registerContactNatural.setEmail(emailAddress);
        registerAccount.setUser(registerContactNatural);

        final RegisterMembership registerMembership = new RegisterMembership();
        registerMembership.setVddMemberId(Integer.toString(vddMemberNumber));
        registerAccount.setMemberships(registerMembership);

        return registerAccount;
    }

    @Override
    public UUID registerNewMember(User user, UserDto personalData) {

        final RegisterResponce registerResponce = tryRegisterNewMember(user.getEmailAddress(), personalData);
        return getUserUuidFromEcmRegistrationResponse(registerResponce);
    }

    private RegisterResponce tryRegisterNewMember(String emailAddress, UserDto personalData) {

        final RegisterAccount registerAccount = buildRegisterNewMemberRequest(emailAddress, personalData);

        try {
            return applicationAccountControllerApi.postRegisterAccount(registerAccount);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }

    private RegisterAccount buildRegisterNewMemberRequest(String emailAddress, UserDto personalData) {

        final RegisterAccount registerAccountRequest = userMapper.userDtoToRegisterAccount(personalData);
        registerAccountRequest.setLoginIdentification(emailAddress);

        final RegisterContactNatural registerContactNatural = requireNonNull(registerAccountRequest.getUser());
        registerContactNatural.setEmail(emailAddress);

        return registerAccountRequest;
    }

    private UUID getUserUuidFromEcmRegistrationResponse(RegisterResponce ecmRegistrationResponse) {

        final String uuid = ecmRegistrationResponse.getRegisterObjectUuid();
        return Optional.ofNullable(uuid)
                .map(UUID::fromString)
                .orElseThrow(() -> new IllegalStateException("registerObjectUuid should not be null"));
    }
}
