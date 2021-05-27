package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;

import java.util.Optional;

public interface FullEventService {

    Optional<FullEventDto> findOneByUuid(String eventUuid);
}
