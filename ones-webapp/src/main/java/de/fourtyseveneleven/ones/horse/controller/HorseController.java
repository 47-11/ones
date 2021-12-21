package de.fourtyseveneleven.ones.horse.controller;

import de.fourtyseveneleven.ones.horse.model.FullHorseDto;
import de.fourtyseveneleven.ones.horse.service.HorsePropertyService;
import de.fourtyseveneleven.ones.horse.service.HorseService;
import de.fourtyseveneleven.ones.openapi.AuthenticatedApiController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AuthenticatedApiController
@RequestMapping("/api/v1/horse")
public class HorseController {

    private final HorseService horseService;
    private final HorsePropertyService horsePropertyService;

    public HorseController(HorseService horseService, HorsePropertyService horsePropertyService) {
        this.horseService = horseService;
        this.horsePropertyService = horsePropertyService;
    }

    @GetMapping("/my")
    public List<FullHorseDto> getMyHorses() {

        return horseService.getMyHorses();
    }

    @PostMapping("/my")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createHorse(@RequestBody FullHorseDto horse) {

        horseService.createHorseForCurrentUser(horse);
    }

    @PatchMapping("/{horseUuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHorse(@PathVariable UUID horseUuid,@RequestBody FullHorseDto horseDto) {

        horseService.update(horseUuid, horseDto);
    }

    @GetMapping("/breeds")
    public List<String> getAllBreeds() {

        return horsePropertyService.getAllBreeds();
    }

    @GetMapping("/colors")
    public List<String> getAllColors() {

        return horsePropertyService.getAllColors();
    }

}
