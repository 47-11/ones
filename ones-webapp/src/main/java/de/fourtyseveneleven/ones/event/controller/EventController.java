package de.fourtyseveneleven.ones.event.controller;

import de.fourtyseveneleven.ones.event.model.dto.ContestDto;
import de.fourtyseveneleven.ones.event.model.dto.EventDetailDto;
import de.fourtyseveneleven.ones.event.model.dto.EventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.service.ContestService;
import de.fourtyseveneleven.ones.event.service.EventDetailService;
import de.fourtyseveneleven.ones.event.service.EventService;
import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@AuthenticatedApiController
@RequestMapping("/api/v1/event")
public class EventController {

    private final EventService eventService;
    private final EventDetailService eventDetailService;
    private final ContestService contestService;

    public EventController(EventService eventService, EventDetailService eventDetailService, ContestService contestService) {
        this.eventService = eventService;
        this.eventDetailService = eventDetailService;
        this.contestService = contestService;
    }

    @GetMapping("")
    public List<EventDto> findAll(@RequestParam(required = false) String titleContains,
                                  @RequestParam(required = false) String descriptionContains,
                                  @RequestParam(required = false) LocalDateTime startsBefore,
                                  @RequestParam(required = false) LocalDateTime startsAfter,
                                  @RequestParam(required = false) LocalDateTime endsBefore,
                                  @RequestParam(required = false) LocalDateTime endsAfter,
                                  @RequestParam(required = false) Long organizerId) {

        final var filter = new EventFilterDto(titleContains, descriptionContains, startsBefore, startsAfter,
                endsBefore, endsAfter, organizerId);

        return eventService.findAll(filter);
    }

    @GetMapping("/{uuid}")
    public EventDetailDto getDetails(@PathVariable String uuid) {

        return eventDetailService.findOneByEventUuid(uuid)
                .orElse(null);
    }

    @GetMapping("/{eventUuid}/contests")
    public List<ContestDto> getContests(@PathVariable String eventUuid) {

        return contestService.getContestsForEvent(eventUuid);
    }
}
