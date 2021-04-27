package de.fourtyseveneleven.ones.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleControllerTestIT extends AbstractRestControllerTestIT {

    private static final String BASE_URL = "/api/v1/example";

    @Test
    public void testHelloWithDefaultValue() throws Exception {
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/hello")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(HttpStatus.OK.value());

        final String response = mvcResult.getResponse().getContentAsString();
        assertThat(response).isEqualTo("Hello, world!");
    }

    @Test
    public void testHello() throws Exception {
        final MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/hello?name=Testy")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(HttpStatus.OK.value());

        final String response = mvcResult.getResponse().getContentAsString();
        assertThat(response).isEqualTo("Hello, Testy!");
    }
}
