package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.EventContestPlain;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SimpleEventMapperTestIT {

    @Autowired
    private SimpleEventMapper simpleEventMapper;

    @Test
    void testFromEcmDto() {

        final EventContestPlain eventContestPlain = buildEventContestPlain();
        final SimpleEventDto simpleEventDto = simpleEventMapper.eventContestPlainToSimpleEventDto(eventContestPlain);

        assertThat(simpleEventDto).isNotNull();
        assertThat(simpleEventDto.getUuid()).isEqualTo(eventContestPlain.getUuid());
        assertThat(simpleEventDto.getStart()).isEqualTo(LocalDateTime.from(eventContestPlain.getBeginning()));
        assertThat(simpleEventDto.getEnd()).isEqualTo(LocalDateTime.from(eventContestPlain.getEnding()));
        assertThat(simpleEventDto.getAddress().getLocationName()).isEqualTo(eventContestPlain.getLocationDesciption());
        assertThat(simpleEventDto.getAddress().getRegion()).isEqualTo(eventContestPlain.getCountryRegion());
        assertThat(simpleEventDto.getAddress().getCountry()).isEqualTo(eventContestPlain.getCountry());
        assertThat(simpleEventDto.getIsNationalChampionship()).isEqualTo(eventContestPlain.getIsCountryChampionship());
        assertThat(simpleEventDto.getIsInternational()).isEqualTo(eventContestPlain.getIsCei());
    }

    private EventContestPlain buildEventContestPlain() {

        final EventContestPlain eventContestPlain = new EventContestPlain();
        eventContestPlain.setUuid("the uuid");
        eventContestPlain.setTitle("the title");
        eventContestPlain.setBeginning(OffsetDateTime.now());
        eventContestPlain.setEnding(OffsetDateTime.now().plusDays(2));
        eventContestPlain.setLocationDesciption("the location");
        eventContestPlain.setCountryRegion("the region");
        eventContestPlain.setCountry("the country");
        eventContestPlain.setIsCountryChampionship(true);
        eventContestPlain.setIsCard(true);
        eventContestPlain.setIsCei(false);

        return eventContestPlain;
    }
}