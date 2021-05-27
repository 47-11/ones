package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;

import java.util.List;

public interface FullContestService {

    List<FullContestDto> getContestsForEvent(String eventUuid);
}
