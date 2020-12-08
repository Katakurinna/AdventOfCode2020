package me.cerratolabs.adventofcode2020.day4;

import me.cerratolabs.adventofcode2020.utils.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D4P2 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\main\\resources\\day4.txt"));
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
        long count = passports.stream().filter(D4P2::isValidPassport).count();
        System.out.println(count);
    }

    private static boolean isValidPassport(String passport) {
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
            boolean c = false;
            String value = ps.split(":")[1].trim();
            try {
                String methodName = "is" + ps.split(":")[0].trim();
                c = (boolean) D4P2.class.getDeclaredMethod(methodName, String.class).invoke(D4P2.class, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (c) {
                data.remove(ps.split(":")[0].trim());
            }
        }
        data.remove("cid");
        return data.isEmpty();
    }

    private static boolean isbyr(String value) {
        int intValue = Integer.parseInt(value);
        return intValue >= 1920 && intValue <= 2002;
    }

    private static boolean isiyr(String value) {
        int intValue = Integer.parseInt(value);
        return intValue >= 2010 && intValue <= 2020;
    }

    private static boolean iseyr(String value) {
        int intValue = Integer.parseInt(value);
        return intValue >= 2020 && intValue <= 2030;
    }

    private static boolean ishgt(String value) {
        if (value.contains("cm")) {
            int intValue = Integer.parseInt(value.replace(" ", "").substring(0, value.indexOf("c")));
            return intValue >= 150 && intValue <= 193;
        }
        if (value.contains("in")) {
            int intValue = Integer.parseInt(value.replace(" ", "").substring(0, value.indexOf("i")));
            return intValue >= 59 && intValue <= 76;
        }
        return false;
    }

    private static boolean ishcl(String value) {
        if (value.charAt(0) != '#') return false;
        value = value.substring(1);
        if (value.length() != 6) return false;
        for (String c : value.split("")) {
            try {
                Integer intValue = Integer.parseInt(c);
                if (intValue < 0 || intValue > 9) {
                    return false;
                }
            } catch (NumberFormatException e) {
                char letter = c.charAt(0);
                if (letter < 97 || letter > 102) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isecl(String value) {
        List<String> list = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        return list.contains(value);
    }

    private static boolean ispid(String value) {
        return value.length() == 9 && StringUtils.isInteger(value);
    }

    private static boolean iscid(String value) {
        return true;
    }

}