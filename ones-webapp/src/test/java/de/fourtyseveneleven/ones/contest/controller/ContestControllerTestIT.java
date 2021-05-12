package de.fourtyseveneleven.ones.contest.controller;

import de.fourtyseveneleven.ones.common.controller.AbstractRestControllerTestIT;
import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;

import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ContestControllerTestIT extends AbstractRestControllerTestIT {

    @Autowired
    private ContestService contestService;

    public ContestControllerTestIT() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindOneById() throws Exception {

        final long testId = 1L;

        final MockHttpServletResponse response = getMvc()
                .perform(MockMvcRequestBuilders.get("/api/v1/contest/" + testId)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        final ContestDto contestDto = deserializeJson(response, ContestDto.class);
        assertThat(contestDto.getId()).isEqualTo(testId);
    }

    @Test
    void testFindOneByIdUnknownId() throws Exception {

        final MockHttpServletResponse response = getMvc()
                .perform(MockMvcRequestBuilders.get("/api/v1/contest/" + 9824L)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void testFindAll() throws Exception {

        final MockHttpServletResponse response = getMvc()
                .perform(MockMvcRequestBuilders.get("/api/v1/contest")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        final List<Object> contests = new ArrayList<Object>(deserializeJson(response, List.class));
        assertThat(contests).hasSameSizeAs(contestService.findAll(new ContestFilterDto()));
    }
}
