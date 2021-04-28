package de.fourtyseveneleven.ones.rider.service;

import de.fourtyseveneleven.ones.rider.model.dto.RiderDto;

import java.util.Optional;

public interface RiderService {

    Optional<RiderDto> findOneById(long id);

    Optional<RiderDto> findOneByEmailAddress(String emailAddress);
}
