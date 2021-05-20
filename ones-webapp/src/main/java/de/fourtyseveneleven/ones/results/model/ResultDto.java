package de.fourtyseveneleven.ones.results.model;

import de.fourtyseveneleven.ones.event.model.dto.ContestDto;
import de.fourtyseveneleven.ones.horse.model.HorseDto;

import java.math.BigDecimal;

public class ResultDto {

    private ContestDto contest;
    private HorseDto horse;

    private int placement;
    /**
     *  In km/h
     */
    private BigDecimal averageSpeed;

    public ContestDto getContest() {
        return contest;
    }

    public void setContest(ContestDto contest) {
        this.contest = contest;
    }

    public HorseDto getHorse() {
        return horse;
    }

    public void setHorse(HorseDto horse) {
        this.horse = horse;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public BigDecimal getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}
