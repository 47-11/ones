package de.fourtyseveneleven.ones.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static java.util.Objects.isNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
abstract class AbstractRestControllerTestIT {

   protected MockMvc mvc = null;

   @Autowired
   WebApplicationContext webApplicationContext;

   @Autowired
   ObjectMapper objectMapper;

   @BeforeEach
   void setup() {

      if (isNull(mvc)) {
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
      }
   }

   protected String serializeJson(Object obj) throws JsonProcessingException {

      return objectMapper.writeValueAsString(obj);
   }

   protected <T> T deserializeJson(String json, Class<T> clazz) throws JsonProcessingException {

      return objectMapper.readValue(json, clazz);
   }
}