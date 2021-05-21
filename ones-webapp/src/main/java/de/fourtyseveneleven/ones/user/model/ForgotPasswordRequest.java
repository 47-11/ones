package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractBaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity
@Table(name = "forgot_password_request")
public class ForgotPasswordRequest extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = -8703414370421191689L;

    private User user;
    private String confirmationCode;
    private LocalDateTime validUntil;

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
