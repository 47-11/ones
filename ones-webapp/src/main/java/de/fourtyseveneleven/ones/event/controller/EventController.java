package de.fourtyseveneleven.ones.event.controller;

import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.service.FullContestService;
import de.fourtyseveneleven.ones.event.service.FullEventService;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
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

    private final SimpleEventService simpleEventService;
    private final FullEventService fullEventService;
    private final FullContestService fullContestService;

    public EventController(SimpleEventService simpleEventService, FullEventService fullEventService,
                           FullContestService fullContestService) {

        this.simpleEventService = simpleEventService;
        this.fullEventService = fullEventService;
        this.fullContestService = fullContestService;
    }

    @GetMapping("")
    public List<SimpleEventDto> findAll(@RequestParam(required = false) String titleContains,
                                        @RequestParam(required = false) String descriptionContains,
                                        @RequestParam(required = false) LocalDateTime startsBefore,
                                        @RequestParam(required = false) LocalDateTime startsAfter,
                                        @RequestParam(required = false) LocalDateTime endsBefore,
                                        @RequestParam(required = false) LocalDateTime endsAfter,
                                        @RequestParam(required = false) Long organizerId) {

        final var filter = new EventFilterDto(titleContains, descriptionContains, startsBefore, startsAfter,
                endsBefore, endsAfter, organizerId);

        return simpleEventService.findAll(filter);
    }

    @GetMapping("/{uuid}")
    public FullEventDto getFullEvent(@PathVariable String uuid) {

        return fullEventService.findOneByUuid(uuid)
                .orElse(null);
    }

    @GetMapping("/{eventUuid}/contests")
    public List<FullContestDto> getFullContests(@PathVariable String eventUuid) {

        return fullContestService.getContestsForEvent(eventUuid);
    }
}
