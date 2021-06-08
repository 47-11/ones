package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.common.model.dto.PageDto;
import de.fourtyseveneleven.ones.ecm.generated.model.ResponcePageContestsPlain;
import de.fourtyseveneleven.ones.event.model.dto.SimpleEventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = SimpleEventMapper.class
)
public interface EventPageMapper {

    @Mapping(source = "data", target = "elements")
    PageDto<SimpleEventDto> map(ResponcePageContestsPlain responcePageContestsPlain);
}
