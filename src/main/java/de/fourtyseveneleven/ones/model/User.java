package de.fourtyseveneleven.ones.model;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Table(name = "user")
public class User extends AbstractBaseEntity {

    @Serial
    private static final long serialVersionUID = 4695286136876273732L;

    private String emailAddress;
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
