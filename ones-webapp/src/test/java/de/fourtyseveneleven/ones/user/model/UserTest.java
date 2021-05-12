package de.fourtyseveneleven.ones.user.model;

import de.fourtyseveneleven.ones.common.model.AbstractEntityTest;

public class UserTest extends AbstractEntityTest<User> {

    @Override
    protected User buildEntity() {
        return new User();
    }
}
