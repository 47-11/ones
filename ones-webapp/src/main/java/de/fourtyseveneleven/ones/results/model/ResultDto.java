package de.fourtyseveneleven.ones.results.model;

import de.fourtyseveneleven.ones.event.model.dto.SimpleContestDto;
import de.fourtyseveneleven.ones.horse.model.HorseDto;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ResultDto {

    private SimpleContestDto contest;
    private List<HorseDto> horses = new LinkedList<>();
    private int placement;
    /**
     *  In km/h
     */
    private BigDecimal averageSpeed;

    public SimpleContestDto getContest() {
        return contest;
    }

    public void setContest(SimpleContestDto contest) {
        this.contest = contest;
    }

    public List<HorseDto> getHorses() {
        return horses;
    }

    public void setHorses(List<HorseDto> horses) {
        this.horses = horses;
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
