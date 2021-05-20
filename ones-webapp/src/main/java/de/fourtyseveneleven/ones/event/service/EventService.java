package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.EventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;

import java.util.List;
import java.util.Optional;

public interface EventService {

    Optional<EventDto> findOneByUuid(String eventUuid);

    List<EventDto> findAll(EventFilterDto filter);
}
