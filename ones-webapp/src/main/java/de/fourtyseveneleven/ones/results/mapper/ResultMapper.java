package de.fourtyseveneleven.ones.results.mapper;

import de.fourtyseveneleven.ones.ecm.generated.model.EventContestCompetitionResult;
import de.fourtyseveneleven.ones.results.model.ResultDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultMapper {

    /*
     * TODO
     */
    ResultDto fromEcmDto(EventContestCompetitionResult eventContestCompetitionResult);
}
