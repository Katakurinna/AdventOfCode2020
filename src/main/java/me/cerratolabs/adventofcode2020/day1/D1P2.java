package me.cerratolabs.adventofcode2020.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class D1P2 {
    public static List<String> input;
    public static void main(String[] args) throws IOException {
        input = Files.readAllLines(Paths.get("src\\main\\resources\\day1.txt"));
        for (String integer : input) {
            int i = Integer.parseInt(integer);
            Integer num = null;
            for (int n1 = 0; n1 < input.size(); n1++) {
                for (int n2 = 0; n2 < input.size(); n2++) {
                    if (i + g(n1) + g(n2) == 2020) {
                        System.out.println((i * g(n1) * g(n2)) + "");
                        return;
                    }
                }
            }
        }
    }
    private static Integer g(int index) {
        return Integer.parseInt(input.get(index));
    }
}