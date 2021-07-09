package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.mapper.CommonMapper;
import de.fourtyseveneleven.ones.common.mapper.DateTimeFormatMapper;
import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetition;
import de.fourtyseveneleven.ones.event.model.dto.FullContestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {
                CommonMapper.class,
                DateTimeFormatMapper.class
        })
public interface FullContestMapper {

    @Mapping(source = "kind", target = "category")
    @Mapping(source = "raiseLength", target = "distance")
    @Mapping(source = "beginning", target = "start")
    @Mapping(source = "vddQualificationLevel", target = "qualificationLevel")
    @Mapping(source = "isCARD", target = "isMap")
    @Mapping(source = "stages", target = "numberOfStages", qualifiedByName = "size")
    @Mapping(source = "horseAgeMin", target = "minimumHorseAge")
    @Mapping(source = "horseAgeMax", target = "maximumHorseAge")
    @Mapping(source = "contestantAgeMin", target = "minimumParticipantAge")
    @Mapping(source = "contestantAgeMax", target = "maximumParticipantAge")
    @Mapping(source = "contestantQuantityMin", target = "minimumParticipants")
    @Mapping(source = "contestantQuantityMax", target = "maximumParticipants")
    @Mapping(source = "isMARKED", target = "markings")
    @Mapping(source = "displayRegistertHorses", target = "signedUpHorses")
    FullContestDto fromEcmDto(EventContestCompetition eventContestCompetition);
}
