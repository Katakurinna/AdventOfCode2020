package me.cerratolabs.adventofcode2020.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class D2P2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\main\\resources\\day2.txt"));
        long correctPassword = input.stream().filter(D2P2::isValidPassword).count();
        System.out.println(correctPassword + "");
    }

    private static boolean isValidPassword(String line) {
        String pattern = line.split(": ")[0];
        String password = line.split(": ")[1];
        int first = Integer.parseInt(pattern.split("-")[0])-1;
        String maxL = pattern.split("-")[1];
        int second = Integer.parseInt(maxL.split(" ")[0])-1;
        char letter = maxL.split(" ")[1].charAt(0);
        if (password.charAt(first) == letter && password.charAt(second) != letter) {
            return true;
        }
        if (password.charAt(first) != letter && password.charAt(second) == letter) {
            return true;
        }
        return false;
    }
}