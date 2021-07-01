package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.ApplicationAccountControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterAccount4Member;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterContact;
import de.fourtyseveneleven.ones.ecm.generated.model.RegisterResponce;
import de.fourtyseveneleven.ones.user.exception.RegistrationException;
import de.fourtyseveneleven.ones.user.mapper.PersonalDataDtoMapper;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.model.dto.PersonalDataDto;
import de.fourtyseveneleven.ones.user.service.EcmRegistrationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class EcmRegistrationServiceImpl implements EcmRegistrationService {

    private final ApplicationAccountControllerApi applicationAccountControllerApi;
    private final PersonalDataDtoMapper personalDataDtoMapper;

    public EcmRegistrationServiceImpl(ApplicationAccountControllerApi applicationAccountControllerApi, PersonalDataDtoMapper personalDataDtoMapper) {
        this.applicationAccountControllerApi = applicationAccountControllerApi;
        this.personalDataDtoMapper = personalDataDtoMapper;
    }

    @Override
    public UUID registerExistingMember(User user, int vddMemberNumber) {

        final RegisterAccount4Member registerAccount4MemberRequest = new RegisterAccount4Member();
        registerAccount4MemberRequest.setLoginIdentification(user.getEmailAddress());
        registerAccount4MemberRequest.setEmail(user.getEmailAddress());
        registerAccount4MemberRequest.setVddMemberNumber(vddMemberNumber);

        return doRegisterExistingMember(registerAccount4MemberRequest, user);
    }

    private UUID doRegisterExistingMember(RegisterAccount4Member registerAccount4Member, User user) {

        final RegisterResponce registerResponce = tryPostRegisterAccount4Member(registerAccount4Member);
        return handleResponse(registerResponce, user);
    }

    private RegisterResponce tryPostRegisterAccount4Member(RegisterAccount4Member registerAccount4Member) {

        try {
            return applicationAccountControllerApi.postRegisterAccount4Member(registerAccount4Member);
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }

    @Override
    public UUID registerNewMember(User user, PersonalDataDto personalData) {

        final RegisterAccount registerAccountRequest = buildRegisterAccountRequest(user, personalData);
        final RegisterResponce registerResponce = tryPostRegisterAccount(registerAccountRequest);
        return handleResponse(registerResponce, user);
    }

    private RegisterAccount buildRegisterAccountRequest(User user, PersonalDataDto personalDataDto) {

        final RegisterContact registerContact = personalDataDtoMapper.personalDataDtoToRegisterContact(personalDataDto);
        registerContact.setEmail(user.getEmailAddress());

        final RegisterAccount registerAccountRequest = new RegisterAccount();
        registerAccountRequest.setUser(registerContact);
        registerAccountRequest.setLoginIdentification(user.getEmailAddress());
        return registerAccountRequest;
    }

    private RegisterResponce tryPostRegisterAccount(RegisterAccount registerAccountRequest) {

        try {
            return applicationAccountControllerApi.postRegisterAccount(registerAccountRequest);
        } catch (ApiException e) {
            throw new EcmApiException(getExceptionMessage("ecm.api-exception"), e);
        }
    }

    private UUID handleResponse(RegisterResponce registerResponce, User user) {

        if (isRegistrationSuccessful(registerResponce)) {
            return handleSuccessfulRegistration(registerResponce, user);
        } else {
            throw new RegistrationException(getExceptionMessage("registration.ecm-registration-failed"));
        }
    }

    private boolean isRegistrationSuccessful(RegisterResponce registerResponce) {

        final Integer reasonCode = registerResponce.getReasonCode();
        final boolean successfulReasonCode = isNull(reasonCode) || reasonCode == 0;
        final boolean successfulState = "CREATED".equalsIgnoreCase(registerResponce.getState());
        return successfulReasonCode && successfulState;
    }

    private UUID handleSuccessfulRegistration(RegisterResponce registerResponce, User user) {

        final String uuid = registerResponce.getRegisterObjectUuid();
        if (isBlank(uuid)) {
            final String exceptionMessage = format("Successful registration response without uuid. User: {0} / Response: {1}", user, registerResponce);
            throw new IllegalStateException(exceptionMessage);
        } else {
            return UUID.fromString(uuid);
        }
    }
}
