package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.event.model.dto.EventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MockEventServiceImpl implements EventService {

    private final Map<String, EventDto> mockEvents;

    public MockEventServiceImpl() {
        mockEvents = createMockEvents();
    }

    @Override
    public Optional<EventDto> findOneByUuid(String eventUuid) {
        return Optional.ofNullable(mockEvents.get(eventUuid));
    }

    @Override
    public List<EventDto> findAll(EventFilterDto filter) {

        return new ArrayList<>(mockEvents.values());
    }

    private Map<String, EventDto> createMockEvents() {

        final Map<String, EventDto> result = new HashMap<>();
        for (int i = 1; i < 20; i++) {
            final EventDto event = createMockEvent(i);
            result.put(event.getUuid(), event);
        }

        return result;
    }

    private EventDto createMockEvent(int id) {

        final var event = new EventDto();
        event.setUuid("UUID " + id);

        event.setTitle("Veranstaltung " + id);

        final LocalDateTime now = LocalDateTime.now();
        event.setStart(now.plusDays(id));
        event.setEnd(now.plusDays(id + 2));

        return event;
    }
}
