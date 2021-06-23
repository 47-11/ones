package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;

@Entity
public class User extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -2934189468164010417L;

    private String emailAddress;
    private String password;
    private boolean registrationConfirmed;
    private String registrationConfirmationCode;

    @NotBlank(message = "{user.email-address.not-blank}")
    @Email(message = "{user.email-address.email}")
    @Size(max = 255, message = "{user.email-address.size}")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @NotBlank(message = "{user.password.not-blank}")
    @Size(min = 60, max = 60, message = "{user.password.size}")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistrationConfirmed() {
        return registrationConfirmed;
    }

    public void setRegistrationConfirmed(boolean registrationConfirmed) {
        this.registrationConfirmed = registrationConfirmed;
    }

    @Size(min=255, max = 255, message = "{user.registration-confirmation-code.size}")
    public String getRegistrationConfirmationCode() {
        return registrationConfirmationCode;
    }

    public void setRegistrationConfirmationCode(String registrationConfirmationCode) {
        this.registrationConfirmationCode = registrationConfirmationCode;
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof User;
    }

    @Override
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq_generator")
    @SequenceGenerator(
            name = "user_seq_generator",
            sequenceName = "user_seq",
            allocationSize = 1)
    public long getId() {
        return doGetId();
    }
}
