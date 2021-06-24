package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.service.FullContestService;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MockFullContestServiceImpl implements FullContestService {

    private final SimpleEventService simpleEventService;

    public MockFullContestServiceImpl(SimpleEventService simpleEventService) {
        this.simpleEventService = simpleEventService;
    }

    @Override
    public List<FullContestDto> getContestsForEvent(String eventUuid) {

        return simpleEventService.findOneByUuid(eventUuid)
                .map(SimpleEventDto::getContests)
                .stream()
                .flatMap(List::stream)
                .map(this::fullContestFromSimpleContest)
                .collect(toList());
    }

    private FullContestDto fullContestFromSimpleContest(SimpleContestDto simpleContest) {

        final var fullContest = new FullContestDto();
        BeanUtils.copyProperties(simpleContest, fullContest);

        fullContest.setStart(LocalDateTime.now());
        fullContest.setCanStartLater(true);
        fullContest.setAltitudeDifference(BigDecimal.TEN);
        fullContest.setQualificationLevel(1);
        fullContest.setSignupFee(BigDecimal.TEN);
        fullContest.setStartFee(BigDecimal.TEN);
        fullContest.setMaximumDuration("T8");
        fullContest.setMinimumHorseAge(6);
        fullContest.setMinimumParticipantAge(16);
        fullContest.setCurrentParticipants(8);
        fullContest.setMaximumParticipants(20);

        return fullContest;
    }
}
