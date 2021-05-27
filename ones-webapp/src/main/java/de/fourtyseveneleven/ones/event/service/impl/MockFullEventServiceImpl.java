package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.common.model.dto.PersonDto;
import de.fourtyseveneleven.ones.event.model.dto.AccommodationDto;
import de.fourtyseveneleven.ones.event.model.dto.FullEventDto;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import de.fourtyseveneleven.ones.event.service.FullEventService;
import de.fourtyseveneleven.ones.event.service.SimpleEventService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MockFullEventServiceImpl implements FullEventService {

    private final SimpleEventService simpleEventService;

    public MockFullEventServiceImpl(SimpleEventService simpleEventService) {
        this.simpleEventService = simpleEventService;
    }

    @Override
    public Optional<FullEventDto> findOneByUuid(String eventUuid) {

        return simpleEventService.findOneByUuid(eventUuid)
                .map(this::fullEventFromSimpleEvent);
    }

    private FullEventDto fullEventFromSimpleEvent(SimpleEventDto simpleEventDto) {

        final var fullEvent = new FullEventDto();
        BeanUtils.copyProperties(simpleEventDto, fullEvent);

        fullEvent.setEventHost(buildPerson());
        fullEvent.setEventOrganizer(fullEvent.getEventHost());
        fullEvent.setContactPerson(fullEvent.getEventHost());
        fullEvent.setParticipationApplicationDeadline(fullEvent.getStart().minusDays(1));
        fullEvent.setParticipationApplicationDeadlineMissedFee(BigDecimal.TEN);
        fullEvent.setIsVaccinationMandatory(true);
        fullEvent.setIsHelmetMandatory(false);
        fullEvent.setAvailableAccommodations(buildAccommodations());
        fullEvent.setAdditionalComments(List.of("Lorem", "Ipsum", "etc."));

        return fullEvent;
    }

    private PersonDto buildPerson() {

        final var person = new PersonDto();
        person.setName("John Doe");
        person.setEmailAddress("test@example.com");
        person.setPhoneNumber("+49 00000 0000000");
        person.setAddress(buildAddress());

        return person;
    }

    private AddressDto buildAddress() {

        final var address = new AddressDto();
        address.setStreet("Straße");
        address.setCity("Stadt");
        address.setZipCode("123456");
        address.setRegion("NRW");
        address.setCountry("DE");

        return address;
    }

    private List<AccommodationDto> buildAccommodations() {

        final var accommodation = new AccommodationDto();
        accommodation.setType("Weide");
        accommodation.setFee(BigDecimal.ZERO);
        accommodation.setPledgeFee(BigDecimal.TEN);

        return List.of(accommodation);
    }
}
