package org.datagen.io;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;


public class ConfigReader {
    private static final Yaml YAML;

    static {
        YAML = new Yaml();
    }

    public static LinkedHashMap<String, String> readCfg() throws FileNotFoundException {
        Object load = null;

        if (Files.exists(Path.of(System.getProperty("user.dir")+"\\config.yml"))) {
            load = YAML.load(new FileInputStream(new File("config.yml")));
            System.out.println(load.toString());
            return (LinkedHashMap<String, String>) load;
        }

        return (LinkedHashMap<String, String>) load;
    }

}
