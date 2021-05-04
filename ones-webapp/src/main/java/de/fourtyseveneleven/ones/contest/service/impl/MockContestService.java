package de.fourtyseveneleven.ones.contest.service.impl;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MockContestService implements ContestService {

    private final Map<Long, ContestDto> mockContests;

    public MockContestService() {
        mockContests = createMockContests();
    }

    @Override
    public Optional<ContestDto> findOneById(long id) {

        return Optional.ofNullable(mockContests.get(id));
    }

    @Override
    public List<ContestDto> findAll(ContestFilterDto filter) {

        return new ArrayList<>(mockContests.values());
    }

    private Map<Long, ContestDto> createMockContests() {

        final Map<Long, ContestDto> result = new HashMap<>();
        for (long i = 1; i < 20; i++) {
            result.put(i, createMockContest(i));
        }

        return result;
    }

    private ContestDto createMockContest(long id) {

        final var contestDto = new ContestDto();
        contestDto.setId(id);
        contestDto.setVersion(1);
        contestDto.setCreated(LocalDateTime.now().minusDays(14));
        contestDto.setLastModified(LocalDateTime.now());

        final char contestLetter = (char)(65 + id);
        contestDto.setTitle("Wettbewerb " + contestLetter);
        contestDto.setDescription(MessageFormat.format("Dies ist die Beschreibung für Wettbewerb {0}. Lorem Ipsum etc.", contestLetter));

        final LocalDateTime now = LocalDateTime.now();
        contestDto.setStart(now.plusDays(id));
        contestDto.setEnd(now.plusDays(id + 2));

        return contestDto;
    }
}
