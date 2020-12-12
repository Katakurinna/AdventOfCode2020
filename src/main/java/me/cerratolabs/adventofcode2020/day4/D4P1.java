package me.cerratolabs.adventofcode2020.day4;

import me.cerratolabs.adventofcode2020.utils.Reader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4P1 {

    public static void main(String[] args) throws IOException {
        List<String> input = Reader.readLines("day4");
        List<String> passports = new ArrayList<>();
        passports.add("");
        for (String line : input) {
            if (line.length() <= 1) {
                passports.add("");
            } else {
                String passport = passports.remove(passports.size() - 1);
                passport += " " + line;
                passports.add(passport);
            }
        }
        D4P1 d4P1 = new D4P1();
        long count = passports.stream().filter(d4P1::isValidPassport).count();
        System.out.println(count);
    }

    private boolean isValidPassport(String passport) {
        String[] passportStrings = passport.trim().split(" ");
        List<String> data = new ArrayList<>();
        data.addAll(Arrays.asList("byr",
            "iyr",
            "eyr",
            "hgt",
            "hcl",
            "ecl",
            "pid",
            "cid"));
        for (String ps : passportStrings) {
                data.remove(ps.split(":")[0].trim());
        }
        data.remove("cid");
        return data.isEmpty();
    }

}