package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataPropertyControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataProperty;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataPropertyCharacteristic;
import de.fourtyseveneleven.ones.event.model.dto.ContestCategory;
import de.fourtyseveneleven.ones.event.service.EventPropertyService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class EventPropertyServiceImpl implements EventPropertyService {

    private final MasterdataPropertyControllerApi masterdataPropertyControllerApi;

    public EventPropertyServiceImpl(MasterdataPropertyControllerApi masterdataPropertyControllerApi) {
        this.masterdataPropertyControllerApi = masterdataPropertyControllerApi;
    }

    @Override
    @Cacheable(cacheNames = "allCategories", cacheManager = "propertyCacheManager")
    public List<ContestCategory> getAllCategories() {

        return getOptionsForProperty("CONTEST_KIND").stream()
                .map(property -> new ContestCategory(property.getAcronym(), property.getDisplay()))
                .toList();
    }

    @Override
    @Cacheable(cacheNames = "allRegions", cacheManager = "propertyCacheManager")
    public List<String> getAllRegions() {

        return getOptionsForProperty("REGION_NAT").stream()
                .map(MasterdataPropertyCharacteristic::getDisplay)
                .filter(Objects::nonNull)
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    private List<MasterdataPropertyCharacteristic> getOptionsForProperty(String propertyName) {

        return getProperties(propertyName).stream()
                .map(MasterdataProperty::getItems)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .toList();
    }

    private List<MasterdataProperty> getProperties(String propertyName) {

        try {
            return masterdataPropertyControllerApi.getPropertyItems(propertyName);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }
}
