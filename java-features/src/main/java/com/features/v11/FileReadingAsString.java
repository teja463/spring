package com.features.v11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadingAsString {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/sample.txt");
        System.out.println(path.toUri());
        String s = Files.readString(path);
        System.out.println(s);
    }
}
