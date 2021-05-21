package de.fourtyseveneleven.ones.user.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementAlreadyPresentException;
import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.user.model.User;
import de.fourtyseveneleven.ones.user.repository.UserRepository;
import de.fourtyseveneleven.ones.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserServiceImplTest {

    @Mock
    private UserRepository mockUserRepository;

    private final UserService userService;

    UserServiceImplTest() {

        openMocks(this);
        userService = new UserServiceImpl(mockUserRepository);
    }

    @Test
    void testFindOneByEmailAddress() {

        final String testEmailAddress = "testFindOneByEmailAddress@foo.bar";

        testWithUsers(testEmailAddress);
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final Optional<User> foundUser = userService.findOneByEmailAddress(testEmailAddress);
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmailAddress()).isEqualTo(testEmailAddress);
        assertThat(saveCalledWithArguments).isEmpty();
    }

    @Test
    void testFindOneByEmailAddressNotFound() {

        final String testEmailAddress = "testFindOneByEmailAddress@foo.bar";

        testWithUsers();
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final Optional<User> foundUser = userService.findOneByEmailAddress(testEmailAddress);
        assertThat(foundUser).isEmpty();
        assertThat(saveCalledWithArguments).isEmpty();
    }

    @Test
    void testFindOneByIncompleteRegistration() {

        final String registrationConfirmationCode = "testFindOneByIncompleteRegistration";

        final User testUser = buildUser("testFindOneByIncompleteRegistration@foo.bar", 238479L);
        testUser.setRegistrationConfirmationCode(registrationConfirmationCode);
        testUser.setRegistrationConfirmed(false);

        testWithUsers(Collections.singletonList(testUser));
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final Optional<User> foundUser = userService.findByIncompleteRegistration(registrationConfirmationCode);
        assertThat(foundUser).isPresent();
        assertThat(foundUser).hasValue(testUser);
        assertThat(saveCalledWithArguments).isEmpty();
    }

    @Test
    void testFindOneByIncompleteRegistrationAlreadyConfirmed() {

        final String registrationConfirmationCode = "testFindOneByIncompleteRegistrationAlreadyConfirmed";

        final User testUser = buildUser("testFindOneByIncompleteRegistrationAlreadyConfirmed@foo.bar", 238479L);
        testUser.setRegistrationConfirmationCode(registrationConfirmationCode);
        testUser.setRegistrationConfirmed(true);

        testWithUsers(Collections.singletonList(testUser));
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final Optional<User> foundUser = userService.findByIncompleteRegistration(registrationConfirmationCode);
        assertThat(foundUser).isEmpty();
        assertThat(saveCalledWithArguments).isEmpty();
    }

    @Test
    void testFindOneByIncompleteRegistrationUnknownConfirmationCode() {

        testWithUsers("testFindOneByIncompleteRegistrationUnknownConfirmationCode@foo.bar");
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final Optional<User> foundUser = userService.findByIncompleteRegistration("testFindOneByIncompleteRegistrationUnknownConfirmationCode");
        assertThat(foundUser).isEmpty();
        assertThat(saveCalledWithArguments).isEmpty();
    }

    @Test
    void testCreateNewUser() {

        testWithUsers();
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final User userToCreate = buildUser("testCreateNewUser@foo.bar", 8349L);
        final User createdUser = userService.createNewUser(userToCreate);
        assertThat(createdUser).isEqualTo(userToCreate);
        assertThat(saveCalledWithArguments).containsExactly(userToCreate);
    }

    @Test
    void testCreateNewUserExistingMailAddress() {

        final String testEmailAddress = "testCreateNewUserExistingMailAddress@foo.bar";

        testWithUsers(testEmailAddress);
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final User userToCreate = buildUser(testEmailAddress, 23487L);
        assertThatExceptionOfType(ElementAlreadyPresentException.class)
                .isThrownBy(() -> userService.createNewUser(userToCreate));
        assertThat(saveCalledWithArguments).isEmpty();
    }

    @Test
    void testUpdateUser() {

        final String testEmailAddress = "testUpdateUser@foo.bar";
        final long testId = 2134686L;

        final User existingUser = buildUser(testEmailAddress, testId);
        existingUser.setRegistrationConfirmationCode("testUpdateUser");
        testWithUsers(Collections.singletonList(existingUser));
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final User userToUpdate = buildUser(testEmailAddress, testId);
        userToUpdate.setRegistrationConfirmationCode(null);
        final User updatedUser = userService.updateUser(userToUpdate);

        assertThat(saveCalledWithArguments).containsExactly(updatedUser);
        assertThat(updatedUser.getRegistrationConfirmationCode()).isNull();
    }

    @Test
    void testUpdateUserUnknownUser() {

        final String testEmailAddress = "testUpdateUser@foo.bar";
        final long testId = 2134686L;

        final User existingUser = buildUser(testEmailAddress, testId);
        existingUser.setRegistrationConfirmationCode("testUpdateUser");
        testWithUsers(Collections.singletonList(existingUser));
        final List<User> saveCalledWithArguments = watchSaveCalledArguments();

        final User userToUpdate = buildUser(testEmailAddress, 1L);
        assertThatExceptionOfType(ElementNotFoundException.class)
                .isThrownBy(() -> userService.updateUser(userToUpdate));

        assertThat(saveCalledWithArguments).isEmpty();
    }

    private void testWithUsers(String... emailAddresses) {

        final AtomicLong id = new AtomicLong(1);
        final List<User> users = Arrays.stream(emailAddresses)
                .map(emailAddress -> buildUser(emailAddress, id.getAndAdd(1)))
                .collect(Collectors.toList());

        testWithUsers(users);
    }

    private User buildUser(String emailAddress, long id) {

        final var user = new User();
        user.setId(id);
        user.setEmailAddress(emailAddress);

        return user;
    }

    private void testWithUsers(List<User> users) {

        when(mockUserRepository.findOneById(anyLong()))
                .thenAnswer(invocation -> {

                    final long id = invocation.getArgument(0);
                    return users.stream()
                            .filter(u -> id == u.getId())
                            .findAny();
                });

        when(mockUserRepository.findOneByEmailAddress(anyString()))
                .thenAnswer(invocation -> {

                    final String emailAddress = invocation.getArgument(0);
                    return users.stream()
                            .filter(u -> emailAddress.equals(u.getEmailAddress()))
                            .findAny();
                });

        when(mockUserRepository.findOneByRegistrationConfirmationCodeAndRegistrationConfirmedIsFalse(anyString()))
                .thenAnswer(invocation -> {

                    final String registrationConfirmationCode = invocation.getArgument(0);
                    return users.stream()
                            .filter(u -> !u.isRegistrationConfirmed())
                            .filter(u -> registrationConfirmationCode.equals(u.getRegistrationConfirmationCode()))
                            .findAny();
                });
    }

    private List<User> watchSaveCalledArguments() {

        final List<User> calls = new LinkedList<>();

        when(mockUserRepository.save(any()))
                .thenAnswer(invocation -> {

                    final User user = invocation.getArgument(0);
                    calls.add(user);
                    return user;
                });

        return calls;
    }
}
