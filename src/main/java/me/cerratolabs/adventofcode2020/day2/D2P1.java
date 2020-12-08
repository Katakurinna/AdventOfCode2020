package me.cerratolabs.adventofcode2020.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class D2P1 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\main\\resources\\day2.txt"));
        long correctPassword = input.stream().filter(D2P1::isValidPassword).count();
        System.out.println(correctPassword + "");
    }

    private static boolean isValidPassword(String line) {
        String[] aux = line.split(":");
        String pattern = aux[0];
        String password = aux[1].substring(1);
        int min = Integer.parseInt(pattern.split("-")[0]);
        String maxL = pattern.split("-")[1];
        int max = Integer.parseInt(maxL.substring(0, maxL.indexOf(" ")));
        char letter = maxL.substring(maxL.indexOf(" ") + 1).charAt(0);
        int times = password.length() - password.replace(letter + "", "").length();
        if (times >= min && times <= max) {
            return true;
        }
        return false;
    }
}