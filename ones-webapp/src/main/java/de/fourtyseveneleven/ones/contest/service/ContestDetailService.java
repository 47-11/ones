package de.fourtyseveneleven.ones.contest.service;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDetailDto;

import java.util.Optional;

public interface ContestDetailService {

    Optional<ContestDetailDto> findOneByContestUuid(String contestUuid);
}
