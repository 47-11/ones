package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractBaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity
public class ForgotPasswordRequest extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -8703414370421191689L;

    private User user;
    private String confirmationCode;
    private LocalDateTime validUntil;

    @ManyToOne
    @NotNull(message = "{forgot-password-request.user.not-null}")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NotBlank(message = "{forgot-password-request.confirmation-code.not-blank}")
    @Size(min = 255, max = 255, message = "{forgot-password-request.confirmation-code.size}")
    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    protected boolean canEqual(Object other) {
        return other instanceof ForgotPasswordRequest;
    }

    @Override
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "forgot_password_request_seq_generator")
    @SequenceGenerator(
            name = "forgot_password_request_seq_generator",
            sequenceName = "forgot_password_request_seq",
            allocationSize = 1)
    public long getId() {
        return doGetId();
    }
}
