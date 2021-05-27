package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;

import java.util.List;
import java.util.Optional;

public interface SimpleEventService {

    Optional<SimpleEventDto> findOneByUuid(String eventUuid);

    List<SimpleEventDto> findAll(EventFilterDto filter);
}
