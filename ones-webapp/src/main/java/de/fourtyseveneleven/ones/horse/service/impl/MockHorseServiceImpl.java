package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.horse.model.HorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static de.fourtyseveneleven.ones.horse.model.Gender.FEMALE;
import static de.fourtyseveneleven.ones.horse.model.Gender.MALE;

@Service
public class MockHorseServiceImpl implements HorseService {

    private final List<HorseDto> mockHorses = buildMockHorses();

    @Override
    public List<HorseDto> getMyHorses() {

        return new ArrayList<>(mockHorses);
    }

    private List<HorseDto> buildMockHorses() {

        return List.of(
                new HorseDto(UUID.randomUUID(), "123456789", "987654321", "Shadowfax", MALE, "Mearas", "Weiß", (short) 153, (short) 1234, null, null),
                new HorseDto(UUID.randomUUID(), "248163264128", "361854162", "Jolly Jumper", FEMALE, "Pferd", "Braun", (short) 125, (short) 2013, null, null)
        );
    }
}
