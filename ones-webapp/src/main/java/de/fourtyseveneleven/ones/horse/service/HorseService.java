package de.fourtyseveneleven.ones.horse.service;

import de.fourtyseveneleven.ones.horse.model.FullHorseDto;

import java.util.List;

public interface HorseService {

    List<FullHorseDto> getMyHorses();

    void createHorseForCurrentUser(FullHorseDto horse);

}
