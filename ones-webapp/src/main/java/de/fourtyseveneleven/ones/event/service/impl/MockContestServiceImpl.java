package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.common.exception.ElementNotFoundException;
import de.fourtyseveneleven.ones.event.model.dto.ContestDto;
import de.fourtyseveneleven.ones.event.model.dto.EventDto;
import de.fourtyseveneleven.ones.event.service.ContestService;
import de.fourtyseveneleven.ones.event.service.EventService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import static de.fourtyseveneleven.ones.event.model.ContestType.EFR;
import static de.fourtyseveneleven.ones.event.model.ContestType.MDR;

@Service
public class MockContestServiceImpl implements ContestService {

    private final EventService eventService;

    public MockContestServiceImpl(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public List<ContestDto> getContestsForEvent(String eventUuid) {

        final EventDto event = eventService.findOneByUuid(eventUuid)
                .orElseThrow(ElementNotFoundException::new);

        return List.of(buildEfrContest(event), buildMdrContest(event));
    }

    private ContestDto buildEfrContest(EventDto event) {

        final var contest = new ContestDto();
        contest.setContestType(EFR);
        contest.setDistance(BigDecimal.valueOf(40));
        contest.setDate(event.getStart().toLocalDate());
        contest.setQualificationLevel(1);
        contest.setAltitudeDifference(BigDecimal.valueOf(60));
        contest.setParticipationPrice(BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP));
        contest.setStartPrice(contest.getParticipationPrice());
        contest.setMaximumDuration("T8");
        contest.setMinimumHorseAge(5);
        contest.setMinimumParticipantAge(16);
        contest.setCurrentParticipants(12);
        contest.setMaximumParticipants(50);

        return contest;
    }

    private ContestDto buildMdrContest(EventDto event) {

        final var contest = new ContestDto();
        contest.setContestType(MDR);
        contest.setDistance(BigDecimal.valueOf(82));
        contest.setDate(event.getEnd().toLocalDate());
        contest.setQualificationLevel(2);
        contest.setAltitudeDifference(BigDecimal.valueOf(80));
        contest.setParticipationPrice(BigDecimal.valueOf(30).setScale(2, RoundingMode.HALF_UP));
        contest.setStartPrice(contest.getParticipationPrice());
        contest.setMaximumDuration("T8");
        contest.setMinimumHorseAge(7);
        contest.setMinimumParticipantAge(18);
        contest.setCurrentParticipants(9);
        contest.setMaximumParticipants(30);

        return contest;
    }
}
