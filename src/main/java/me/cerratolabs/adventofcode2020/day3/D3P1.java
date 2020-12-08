package me.cerratolabs.adventofcode2020.day3;

import me.cerratolabs.adventofcode2020.day2.D2P2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class D3P1 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\main\\resources\\day3.txt"));
        int numbers = 0;
        int trees = 0;
        input.remove(0);
        for (String s : input) {
            numbers = numbers + 3;
            int aux = numbers;
            while (aux >= s.length()) {
                aux = aux - s.length();
            }
            if (s.charAt(aux) == '#') {
                trees++;
            }
        }
        System.out.println(trees);
    }
}