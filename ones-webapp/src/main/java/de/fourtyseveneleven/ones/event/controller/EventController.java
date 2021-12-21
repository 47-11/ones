package de.fourtyseveneleven.ones.event.controller;

import de.fourtyseveneleven.ones.common.model.SortDirection;
import de.fourtyseveneleven.ones.common.model.dto.PageDto;
import de.fourtyseveneleven.ones.common.model.dto.PageRequest;
import de.fourtyseveneleven.ones.common.model.dto.SortRequest;
import de.fourtyseveneleven.ones.event.model.dto.ContestCategory;
import de.fourtyseveneleven.ones.event.model.dto.EventFilterDto;
import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import de.fourtyseveneleven.ones.event.model.dto.SignupDto;
import de.fourtyseveneleven.ones.event.model.dto.SignupRequestDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.service.EventPropertyService;
import de.fourtyseveneleven.ones.event.service.FullContestService;
import de.fourtyseveneleven.ones.event.service.FullEventService;
import de.fourtyseveneleven.ones.event.service.SignupService;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AuthenticatedApiController
@RequestMapping("/api/v1/event")
public class EventController {

    private final SimpleEventService simpleEventService;
    private final FullEventService fullEventService;
    private final FullContestService fullContestService;
    private final SignupService signupService;
    private final EventPropertyService eventPropertyService;

    public EventController(SimpleEventService simpleEventService, FullEventService fullEventService,
                           FullContestService fullContestService, SignupService signupService, EventPropertyService eventPropertyService) {

        this.simpleEventService = simpleEventService;
        this.fullEventService = fullEventService;
        this.fullContestService = fullContestService;
        this.signupService = signupService;
        this.eventPropertyService = eventPropertyService;
    }

    @GetMapping
    public PageDto<SimpleEventDto> findAll(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                           @RequestParam(required = false)  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate until,
                                           @RequestParam(required = false) List<String> regions,
                                           @RequestParam(required = false) List<String> categories,
                                           @RequestParam(required = false) Boolean isMap,
                                           @RequestParam(required = false) Boolean isCountryChampionship,
                                           @RequestParam(required = false) Boolean isInternational,
                                           @RequestParam(required = false) Boolean alreadySignedUp,
                                           @RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "10") int pageSize,
                                           @RequestParam(required = false, defaultValue = "start") String sortBy,
                                           @RequestParam(required = false, defaultValue = "ASCENDING") SortDirection sortDirection) {

        final var filter = new EventFilterDto(from, until, regions, categories, isMap, isCountryChampionship, isInternational, alreadySignedUp);
        final var pageRequest = new PageRequest(page, pageSize);
        final var sortRequest = new SortRequest(sortBy, sortDirection);
        return simpleEventService.findAll(filter, pageRequest, sortRequest);
    }

    @GetMapping("/categories")
    public List<ContestCategory> getAllCategories() {

        return eventPropertyService.getAllCategories();
    }

    @GetMapping("/regions")
    public List<String> getAllRegions() {

        return eventPropertyService.getAllRegions();
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

    @PostMapping("/contest/{contestUuid}/signup")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void signUp(@PathVariable String contestUuid,
                       @RequestBody SignupRequestDto request) {

        final SignupDto signupDto = new SignupDto(contestUuid, request);
        signupService.signup(signupDto);
    }

    @GetMapping("/contest/{contestUuid}/my-horses")
    public List<FullContestDto> getSignedUpHorsesForContest(@PathVariable UUID contestUuid) {

        return Collections.emptyList();
    }
}
