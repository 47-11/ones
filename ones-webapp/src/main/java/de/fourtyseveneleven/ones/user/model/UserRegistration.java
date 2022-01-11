package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractBaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.util.UUID;

@Entity
public class UserRegistration extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = 8146278498169507338L;

    private String emailAddress;
    private String password;
    private String confirmationCode;

    @NotBlank(message = "{user-registration.email-address.not-blank}")
    @Email(message = "{user-registration.email-address.email}")
    @Size(max = 255, message = "{user-registration.email-address.size}")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @NotBlank(message = "{user-registration.password.not-blank}")
    @Size(min = 60, max = 60, message = "{user-registration.password.size}")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank(message = "")
    @Size(min=255, max = 255, message = "{user-registration.confirmation-code.size}")
    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String registrationConfirmationCode) {
        this.confirmationCode = registrationConfirmationCode;
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof UserRegistration;
    }

    @Override
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_registration_seq_generator")
    @SequenceGenerator(
            name = "user_registration_seq_generator",
            sequenceName = "user_registration_seq",
            allocationSize = 1)
    public long getId() {
        return doGetId();
    }
}
