package org.datagen.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class Reader {

    public String getRandomFio(Path path) throws IOException {
        String[] randomLine = getRandomLine(path);
        return randomLine[randomNum(randomLine.length-1)];
    }
    public String[] getRandomLine(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        String line = lines.get(randomNum(lines.size()-1));
        return line.split(",");
    }

    private int randomNum(int size){
        return new Random()
                .ints(0,size)
                .findFirst()
                .getAsInt();
    }


}
