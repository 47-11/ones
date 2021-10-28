package de.fourtyseveneleven.ones.horse.controller;

import de.fourtyseveneleven.ones.horse.model.FullHorseDto;
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
import java.util.UUID;

@AuthenticatedApiController
@RequestMapping("/api/v1/horse")
public class HorseController {

    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
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
    public void updateHorse(@PathVariable UUID horseUuid, HorseDto horseDto) {

        horseService.update(horseUuid, horseDto);
    }
}
