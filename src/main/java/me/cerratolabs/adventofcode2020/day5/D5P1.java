package me.cerratolabs.adventofcode2020.day5;

import me.cerratolabs.adventofcode2020.utils.Reader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class D5P1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Reader.readLines("day5");
        List<Integer> collect = input.stream().map(D5P1::getSeatId).sorted().collect(Collectors.toList());
        System.out.println("Highest ticket: " + collect.get(collect.size() - 1));
        for (int i = 0; i < 934; i++) {
            if (!collect.contains(i)) {
                // one is my ticket. (PART 2)
                System.out.println(i);
            }
        }
    }

    public static Integer getSeatId(String position) {
        Airplane airplane = Airplane.getLengthAirplane();
        for (int i = 0; i < 7; i++) {
            if (position.charAt(i) == 'F') {
                airplane = airplane.getFirstHalf();
            } else {
                airplane = airplane.getSecondHalf();
            }
        }
        Integer row = airplane.getFirstSeat();
        airplane = Airplane.getHeightAirplane();
        for (int i = 7; i < 10; i++) {
            if (position.charAt(i) == 'L') {
                airplane = airplane.getFirstHalf();
            } else {
                airplane = airplane.getSecondHalf();
            }
        }
        Integer column = airplane.getLastSeat();
        return row * 8 + column;
    }

}
