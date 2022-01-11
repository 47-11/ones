package de.fourtyseveneleven.ones.horse.service.impl;

import de.fourtyseveneleven.ones.ecm.exception.EcmApiException;
import de.fourtyseveneleven.ones.ecm.generated.ApiException;
import de.fourtyseveneleven.ones.ecm.generated.api.MasterdataPropertyControllerApi;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataProperty;
import de.fourtyseveneleven.ones.ecm.generated.model.MasterdataPropertyCharacteristic;
import de.fourtyseveneleven.ones.horse.service.HorsePropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HorsePropertyServiceImpl implements HorsePropertyService {

    private final MasterdataPropertyControllerApi masterdataPropertyControllerApi;

    public HorsePropertyServiceImpl(MasterdataPropertyControllerApi masterdataPropertyControllerApi) {
        this.masterdataPropertyControllerApi = masterdataPropertyControllerApi;
    }

    @Override
    public List<String> getAllBreeds() {

        return getOptionsForProperty("HORSE_BREED");

    }

    @Override
    public List<String> getAllColors() {

        return getOptionsForProperty("HORSE_COLOR");
    }

    private List<String> getOptionsForProperty(String propertyName) {

        return getProperties(propertyName).stream()
                .map(MasterdataProperty::getItems)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .map(MasterdataPropertyCharacteristic::getDisplay)
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<MasterdataProperty> getProperties(String propertyName) {

        try {
            return masterdataPropertyControllerApi.getPropertyItems(propertyName);
        } catch (ApiException e) {
            throw new EcmApiException(e);
        }
    }
}
