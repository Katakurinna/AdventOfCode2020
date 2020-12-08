package me.cerratolabs.adventofcode2020.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class D3P2 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\main\\resources\\day3.txt"));
        int trees = 1;
        trees = trees * getTrees(input, 1,1);
        trees = trees * getTrees(input, 3,1);
        trees = trees * getTrees(input, 5,1);
        trees = trees * getTrees(input, 7,1);
        trees = trees * getTrees(input, 1,2);
        System.out.println(trees);
    }

    private static int getTrees(List<String> input, int right, int down) {
        int numbers = 0;
        int trees = 0;
        for (int i = down; i < input.size(); i = i + down) {
            numbers = numbers + right;
            int aux = numbers;
            while (aux >= input.get(i).length()) {
                aux = aux - input.get(i).length();
            }
            if (input.get(i).charAt(aux) == '#') {
                trees++;
            }
        }
        return trees;
    }
}