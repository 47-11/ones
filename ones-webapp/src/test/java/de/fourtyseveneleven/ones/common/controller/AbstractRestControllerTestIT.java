package de.fourtyseveneleven.ones.common.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.isNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public abstract class AbstractRestControllerTestIT {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mvc;

    protected MockMvc getMvc() {

        return mvc;
    }

    @BeforeEach
    void setUpOnce() {

        if (isNull(mvc)) {
            this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        }
    }

    protected String serializeJson(Object obj) throws JsonProcessingException {

        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected <T> T deserializeJson(MockHttpServletResponse response, Class<T> clazz) {

        try {
            return deserializeJson(response.getContentAsString(), clazz);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    protected <T> T deserializeJson(String json, Class<T> clazz) {

        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
