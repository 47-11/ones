package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.EventDetailDto;

import java.util.Optional;

public interface EventDetailService {

    Optional<EventDetailDto> findOneByEventUuid(String eventUuid);
}
