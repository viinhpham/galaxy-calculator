package com.interview.galaxy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 14:18
 */
public class Application {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("Welcome to merchant galaxy");
        List<String> input = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()));
    }
}
