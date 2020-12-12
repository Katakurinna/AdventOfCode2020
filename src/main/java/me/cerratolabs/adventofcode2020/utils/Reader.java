package me.cerratolabs.adventofcode2020.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Reader {

    public static List<String> readLines(String day) throws IOException {
        return Files.readAllLines(Paths.get("src\\main\\resources\\" + day + ".txt"));
    }

}
