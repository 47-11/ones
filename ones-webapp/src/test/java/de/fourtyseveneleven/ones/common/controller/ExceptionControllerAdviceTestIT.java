package de.fourtyseveneleven.ones.common.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.common.exception.OnesException;
import de.fourtyseveneleven.ones.common.model.dto.ErrorDto;
import de.fourtyseveneleven.ones.user.exception.RegistrationIncompleteException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.Serial;
import java.io.UnsupportedEncodingException;

import static de.fourtyseveneleven.ones.message.MessageUtils.getExceptionMessage;
import static org.assertj.core.api.Assertions.assertThat;


class ExceptionControllerAdviceTestIT extends AbstractRestControllerTestIT {

    @Autowired
    private ExceptionThrowingController exceptionThrowingController;

    @Test
    void testUnknownException() throws Exception {

        exceptionThrowingController.throwNext(TestException::new);

        final var expectedErrorDto = new ErrorDto(getExceptionMessage("common.internal-error"),
                TestException.MESSAGE, TestException.class.getSimpleName());
        assertResponse(HttpStatus.INTERNAL_SERVER_ERROR, expectedErrorDto);
    }

    @Test
    void testElementNotFoundException() throws Exception {

        exceptionThrowingController.throwNext(ElementNotFoundException::new);

        final var expectedErrorDto = new ErrorDto(null,
                null, ElementNotFoundException.class.getSimpleName());
        assertResponse(HttpStatus.NOT_FOUND, expectedErrorDto);
    }

    @Test
    void testOnesException() throws Exception {

        final String message = "testOnesException()";

        exceptionThrowingController.throwNext(() -> new OnesException(message));

        final var expectedErrorDto = new ErrorDto(message,
                message, OnesException.class.getSimpleName());
        assertResponse(HttpStatus.BAD_REQUEST, expectedErrorDto);
    }

    @Test
    void testOnesExceptionWithCause() throws Exception {

        final String message = "testOnesExceptionWithCause()";
        final String causeMessage = "cause message";

        exceptionThrowingController.throwNext(() -> new OnesException(message, new ArrayIndexOutOfBoundsException(causeMessage)));

        final var expectedErrorDto = new ErrorDto(message,
                causeMessage, ArrayIndexOutOfBoundsException.class.getSimpleName());
        assertResponse(HttpStatus.BAD_REQUEST, expectedErrorDto);
    }

    @Test
    void testOnesExceptionWithDescendant() throws Exception {

        exceptionThrowingController.throwNext(TestOnesException::new);

        final var expectedErrorDto = new ErrorDto(TestOnesException.MESSAGE,
                TestOnesException.MESSAGE, TestOnesException.class.getSimpleName());
        assertResponse(HttpStatus.BAD_REQUEST, expectedErrorDto);
    }

    @Test
    void testAuthenticationException() throws Exception {

        final String message = "testAuthenticationException()";

        exceptionThrowingController.throwNext(() -> new RegistrationIncompleteException(message));

        final var expectedErrorDto = new ErrorDto(message, message, RegistrationIncompleteException.class.getSimpleName());
        assertResponse(HttpStatus.FORBIDDEN, expectedErrorDto);
    }

    private void assertResponse( HttpStatus expectedStatus, ErrorDto expectedErrorDto) throws Exception {

        final MockHttpServletResponse response = get();
        assertThat(response.getStatus()).isEqualTo(expectedStatus.value());
        assertErrorDto(response, expectedErrorDto);
    }

    private void assertErrorDto(MockHttpServletResponse response, ErrorDto expectedErrorDto) throws UnsupportedEncodingException, JsonProcessingException {

        final ErrorDto errorDto = deserializeJson(response.getContentAsString(), ErrorDto.class);
        assertThat(errorDto.getUserMessage()).isEqualTo(expectedErrorDto.getUserMessage());
        assertThat(errorDto.getExceptionMessage()).isEqualTo(expectedErrorDto.getExceptionMessage());
        assertThat(errorDto.getExceptionType()).isEqualTo(expectedErrorDto.getExceptionType());
        assertThat(errorDto).isEqualTo(expectedErrorDto);
    }

    private MockHttpServletResponse get() throws Exception {

        return getMvc().perform(MockMvcRequestBuilders.get(ExceptionThrowingController.EXCEPTION_URL)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn().getResponse();
    }

    private static class TestException extends Exception {

        @Serial
        private static final long serialVersionUID = -2899237976068867772L;

        private static final String MESSAGE = "some test exception message";

        private TestException() {
            super(MESSAGE);
        }
    }

    private static class TestOnesException extends OnesException {

        @Serial
        private static final long serialVersionUID = -6325877056103163286L;

        private static final String MESSAGE = "test exception that is a descendant of OnesException";

        private TestOnesException() {
            super(MESSAGE);
        }
    }
}
