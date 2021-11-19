package de.fourtyseveneleven.ones.horse.service;

import de.fourtyseveneleven.ones.horse.model.FullHorseDto;

import java.util.List;
import java.util.UUID;

public interface HorseService {

    List<FullHorseDto> getMyHorses();

    void createHorseForCurrentUser(FullHorseDto horse);

    void update(UUID horseUuid, FullHorseDto horseDto);
}
