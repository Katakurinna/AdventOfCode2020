package me.cerratolabs.adventofcode2020.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class D1P1 {

    public static List<String> input;

    public static void main(String[] args) throws IOException {
        input = Files.readAllLines(Paths.get("src\\main\\resources\\day1.txt"));
        for (String integer : input) {
            int intg = Integer.parseInt(integer);
            for (int i = 0; i < input.size(); i++) {
                if (intg + g(i) == 2020) {
                    System.out.println((intg * g(i)) + "");
                    return;
                }
            }
        }
    }
    private static Integer g(int index) {
        return Integer.parseInt(input.get(index));
    }
}