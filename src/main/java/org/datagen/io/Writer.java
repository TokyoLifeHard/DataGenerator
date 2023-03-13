package org.datagen.io;

import org.datagen.enitiy.User;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Writer {
    private static Path path = Path.of(System.getProperty("user.dir")+"\\"+"users.txt");
    public void writeUser(User user) throws IOException {
        if (!Files.exists(path)){
            Files.createFile(path);
        }
        Files.writeString(path, user.toString()+"\n", StandardOpenOption.APPEND);

    }

}
