package de.fourtyseveneleven.ones.rider.service.impl;

import de.fourtyseveneleven.ones.rider.model.dto.RiderDto;
import de.fourtyseveneleven.ones.rider.service.RiderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MockRiderService implements RiderService {

    private final Map<Long, RiderDto> mockRiders;

    public MockRiderService() {
        mockRiders = createMockRiders();
    }

    @Override
    public Optional<RiderDto> findOneById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<RiderDto> findOneByEmailAddress(String emailAddress) {
        return Optional.empty();
    }

    private Map<Long, RiderDto> createMockRiders() {

        final Map<Long, RiderDto> result = new HashMap<>();
        final RiderDto firstRider = createFirstMockRider();
        result.put(firstRider.getId(), firstRider);
        final RiderDto secondRider = createSecondMockRider();
        result.put(secondRider.getId(), secondRider);
        return result;
    }

    private RiderDto createFirstMockRider() {

        final var result = new RiderDto();
        result.setId(1L);
        result.setVersion(2);
        result.setCreated(LocalDateTime.now());
        result.setLastModified(LocalDateTime.now());

        result.setEmailAddress("max.mustermann@gmx.de");
        result.setFirstName("Max");
        result.setLastName("Mustermann");

        result.setInitialDataSetupCompleted(true);
        result.setAllNecessaryDataPresent(true);

        return result;
    }

    private RiderDto createSecondMockRider() {

        final var result = new RiderDto();
        result.setId(2L);
        result.setVersion(1);
        result.setCreated(LocalDateTime.now());
        result.setLastModified(LocalDateTime.now());

        result.setEmailAddress("testy.mctesticles@aol.com");
        result.setFirstName("Testy");
        result.setLastName("McTesticles");

        result.setInitialDataSetupCompleted(false);
        result.setAllNecessaryDataPresent(false);

        return result;
    }
}
