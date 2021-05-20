package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.ContestDto;

import java.util.List;

public interface ContestService {

    List<ContestDto> getContestsForEvent(String eventUuid);
}
