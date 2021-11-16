package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.horse.model.FullHorseDto;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static de.fourtyseveneleven.ones.horse.model.Gender.*;

@Service
public class MockHorseServiceImpl implements HorseService {

    private final List<FullHorseDto> mockHorses = buildMockHorses();

    @Override
    public List<FullHorseDto> getMyHorses() {

        return new ArrayList<>(mockHorses);
    }

    private List<FullHorseDto> buildMockHorses() {

        return List.of(
                new FullHorseDto(UUID.randomUUID(), "123456789", "987654321", "Shadowfax", STALLION, "Mearas", "Weiß", (short) 153, (short) 1234, null, null),
                new FullHorseDto(UUID.randomUUID(), "248163264128", "361854162", "Jolly Jumper", MARE, "Pferd", "Braun", (short) 125, (short) 2013, null, null)
        );
    }

    @Override
    public void createHorseForCurrentUser(FullHorseDto fullHorseDto) {
        // No-Op
    }

    @Override
    public void update(UUID horseUuid, HorseDto horseDto) {

        // NO-OP
    }
}
