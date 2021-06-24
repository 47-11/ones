package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockHorseServiceImpl implements HorseService {

    private final List<HorseDto> mockHorses = buildMockHorses();

    @Override
    public List<HorseDto> getMyHorses() {

        return new ArrayList<>(mockHorses);
    }

    private List<HorseDto> buildMockHorses() {

        return List.of(
                new HorseDto("uuid_1", "Shadowfax", "123456789"),
                new HorseDto("uuid_2", "Jolly Jumper", "987654321")
        );
    }
}
