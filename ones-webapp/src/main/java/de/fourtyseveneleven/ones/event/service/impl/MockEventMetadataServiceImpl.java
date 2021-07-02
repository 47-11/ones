package de.fourtyseveneleven.ones.event.service.impl;

import de.fourtyseveneleven.ones.event.model.dto.ContestCategory;
import de.fourtyseveneleven.ones.event.service.EventMetadataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockEventMetadataServiceImpl implements EventMetadataService {

    @Override
    public List<ContestCategory> getAllCategories() {
        
        return List.of(new ContestCategory("EFR", "Einführungsritt"), new ContestCategory("EFF", "Einführungsfahrt"),
                new ContestCategory("KDR", "Kurzdistanzritt"), new ContestCategory("MDR", "Mitteldistanzritt"),
                new ContestCategory("LDR", "Langdistanzritt"));
    }
}
