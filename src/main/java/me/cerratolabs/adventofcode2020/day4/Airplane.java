package me.cerratolabs.adventofcode2020.day4;

public class Airplane {

    private final Integer firstSeat;
    private final Integer lastSeat;

    public Airplane(Integer firstSeat, Integer lastSeat) {
        this.firstSeat = firstSeat;
        this.lastSeat = lastSeat;
    }

    public Airplane getFirstHalf() {
        return new Airplane(firstSeat, (lastSeat + firstSeat) / 2);
    }

    public Airplane getSecondHalf() {
        return new Airplane((lastSeat + firstSeat) / 2 + 1, lastSeat);
    }

    public Integer getFirstSeat() {
        return firstSeat;
    }

    public Integer getLastSeat() {
        return lastSeat;
    }

    public static Airplane getLengthAirplane() {
        return new Airplane(0, 127);
    }

    public static Airplane getHeightAirplane() {
        return new Airplane(0, 7);
    }


}
