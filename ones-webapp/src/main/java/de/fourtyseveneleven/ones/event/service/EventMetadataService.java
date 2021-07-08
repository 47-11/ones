package de.fourtyseveneleven.ones.event.service;

import de.fourtyseveneleven.ones.event.model.dto.ContestCategory;

import java.util.List;

public interface EventMetadataService {

    List<ContestCategory> getAllCategories();

    List<String> getAllRegions();
}
