package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.common.model.dto.PageDto;
import de.fourtyseveneleven.ones.common.model.dto.PageRequest;



import java.util.Optional;

public interface SimpleEventService {

    Optional<SimpleEventDto> findOneByUuid(String eventUuid);

    PageDto<SimpleEventDto> findAll(EventFilterDto filter, PageRequest pageRequest);
}
