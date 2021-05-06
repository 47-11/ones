package de.fourtyseveneleven.ones.contest.service.impl;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDetailDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.service.ContestDetailService;
import de.fourtyseveneleven.ones.contest.service.ContestService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContestDetailServiceImpl implements ContestDetailService {

    private final ContestService contestService;

    public ContestDetailServiceImpl(ContestService contestService) {
        this.contestService = contestService;
    }

    @Override
    public Optional<ContestDetailDto> findOneByContestUuid(String contestUuid) {

        return contestService.findOneByUuid(contestUuid)
                .map(this::buildDetails);
    }

    private ContestDetailDto buildDetails(ContestDto contest) {

        final var contestDetail = new ContestDetailDto();
        contestDetail.setContest(contest);
        contestDetail.setDescription("Dies ist die Beschreibung für " + contest.getTitle());
        contestDetail.setOrganizerName("Testy McTesticles");
        contestDetail.setContactInformation("t.mctesticles@aol.com");

        return contestDetail;
    }
}
