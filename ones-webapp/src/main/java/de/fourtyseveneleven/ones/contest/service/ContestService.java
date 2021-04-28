package de.fourtyseveneleven.ones.contest.service;

import de.fourtyseveneleven.ones.contest.model.dto.ContestDto;
import de.fourtyseveneleven.ones.contest.model.dto.ContestFilterDto;

import java.util.List;
import java.util.Optional;

public interface ContestService {

    Optional<ContestDto> findOneById(long id);

    List<ContestDto> findAll(ContestFilterDto filter);
}
