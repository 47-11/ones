package de.fourtyseveneleven.ones.contest.service.impl;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MockContestService implements ContestService {

    private final Map<String, ContestDto> mockContests;

    public MockContestService() {
        mockContests = createMockContests();
    }

    @Override
    public Optional<ContestDto> findOneByUuid(String contestUuid) {
        return Optional.empty();
    }

    @Override
    public List<ContestDto> findAll(ContestFilterDto filter) {

        return new ArrayList<>(mockContests.values());
    }

    private Map<String, ContestDto> createMockContests() {

        final Map<String, ContestDto> result = new HashMap<>();
        for (long i = 1; i < 20; i++) {
            final ContestDto contest = createMockContest(i);
            result.put(contest.getUuid(), contest);
        }

        return result;
    }

    private ContestDto createMockContest(long id) {

        final var contestDto = new ContestDto();
        contestDto.setUuid("UUID " + id);

        final char contestLetter = (char)(65 + id);
        contestDto.setTitle("Wettbewerb " + contestLetter);

        final LocalDateTime now = LocalDateTime.now();
        contestDto.setStart(now.plusDays(id));
        contestDto.setEnd(now.plusDays(id + 2));

        contestDto.setDistance(BigDecimal.valueOf(Math.random() * 100));

        return contestDto;
    }
}
