package de.fourtyseveneleven.ones.user.repository;

import de.fourtyseveneleven.ones.common.repository.AbstractRepositoryTestIT;
import de.fourtyseveneleven.ones.user.model.ForgotPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

class ForgotPasswordRepositoryTestIT extends AbstractRepositoryTestIT<ForgotPasswordRequest> {

    @Autowired
    private ForgotPasswordRequestRepository forgotPasswordRequestRepository;

    @Override
    protected JpaRepository<ForgotPasswordRequest, Long> getRepository() {
        return forgotPasswordRequestRepository;
    }

    @Override
    protected ForgotPasswordRequest getTestEntity() {
        return new ForgotPasswordRequest();
    }
}
