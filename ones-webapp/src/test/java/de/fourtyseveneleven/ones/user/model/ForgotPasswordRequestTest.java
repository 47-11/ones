package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractEntityTest;

class ForgotPasswordRequestTest extends AbstractEntityTest<ForgotPasswordRequest> {

    @Override
    protected ForgotPasswordRequest buildEntity() {
        return new ForgotPasswordRequest();
    }
}
