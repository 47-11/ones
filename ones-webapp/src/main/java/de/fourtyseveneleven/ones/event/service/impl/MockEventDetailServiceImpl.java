package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.common.model.dto.AddressDto;
import de.fourtyseveneleven.ones.event.model.RideType;
import de.fourtyseveneleven.ones.event.model.dto.EventDetailDto;
import de.fourtyseveneleven.ones.event.model.dto.EventDto;
import de.fourtyseveneleven.ones.event.service.EventDetailService;
import de.fourtyseveneleven.ones.event.service.EventService;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.Optional;

import static de.fourtyseveneleven.ones.event.model.RideType.DISTANCE_DRIVE;
import static de.fourtyseveneleven.ones.event.model.RideType.DISTANCE_RIDE;
import static java.util.stream.Collectors.toMap;

@Service
public class MockEventDetailServiceImpl implements EventDetailService {

    private final EventService eventService;

    public MockEventDetailServiceImpl(MockEventServiceImpl eventService) {
        this.eventService = eventService;

    }

    @Override
    public Optional<EventDetailDto> findOneByEventUuid(String eventUuid) {

        return eventService.findOneByUuid(eventUuid)
                .map(this::buildEventDetails);
    }

    private EventDetailDto buildEventDetails(EventDto event) {

        final var eventDetail = new EventDetailDto();
        eventDetail.setEvent(event);
        eventDetail.setAddress(buildEventAddress());

        eventDetail.setParticipationDocumentUrl("example.com");
        eventDetail.setTenderDocumentUrl("example.com");

        eventDetail.setMdr("62");
        eventDetail.setLdr("82, 100, 120");
        eventDetail.setMtr("124 (62/62), 164 (82/82)");
        eventDetail.setRideTypes(EnumSet.of(DISTANCE_RIDE, DISTANCE_DRIVE));
        eventDetail.setAdditionalRideInformation("Lorem ipsum");


        final String organizerName = "buildOrganizerAddress";
        final AddressDto organizerAddress = buildOrganizerAddress();
        eventDetail.setEventInitiatorName(organizerName);
        eventDetail.setEventInitiatorAddress(organizerAddress);
        eventDetail.setOrganizerName(organizerName);
        eventDetail.setOrganizerAddress(organizerAddress);
        eventDetail.setContactPersonName(organizerName);
        eventDetail.setContactPersonAddress(organizerAddress);
        eventDetail.setContactPhoneNumber("+49 151 14773681");
        eventDetail.setContactEmailAddress("wiebke.angelbeck@gmx.de");

        return eventDetail;
    }

    private AddressDto buildEventAddress() {

        final var address = new AddressDto();
        address.setLocationName("Ortsausgang Stuck");
        address.setStreet("Lenzenerstraße");
        address.setZipCode("19294");
        address.setCity("Stuck");
        address.setRegion("Mecklenburg-Vorpommern");
        address.setCountry("DE");

        return address;
    }

    private AddressDto buildOrganizerAddress() {

        final var address = new AddressDto();
        address.setLocationName("buildOrganizerAddress");
        address.setStreet("Eldena Straße 6");
        address.setZipCode("19294");
        address.setCity("Stuck");
        address.setRegion("Mecklenburg-Vorpommern");
        address.setCountry("DE");

        return address;
    }
}
