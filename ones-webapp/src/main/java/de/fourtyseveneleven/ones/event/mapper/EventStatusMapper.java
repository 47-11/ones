package de.fourtyseveneleven.ones.event.mapper;

import de.fourtyseveneleven.ones.event.model.EventStatus;
import org.mapstruct.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mapper(componentModel = "spring")
public class EventStatusMapper {

    private static final Logger LOG = LoggerFactory.getLogger(EventStatusMapper.class);

    public EventStatus fromEcmState(String state) {

        switch (state) {
            case "Termin abgesagt":
                return EventStatus.CANCELLED;
            case "Termin vorrüber":
                return EventStatus.DATE_PASSED;
            case "Termin vorläufig":
                return EventStatus.DATE_PRELIMINARY;
            case "Termin fix":
                return EventStatus.DATE_FIX;
            case "Auschreibung aktualisiert":
                return EventStatus.UPDATED;
            default:
                LOG.error("Unknown event state {}", state);
                return EventStatus.UNKNOWN;
        }
    }
}
