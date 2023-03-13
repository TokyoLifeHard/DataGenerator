package org.datagen;


import org.datagen.generator.UserDatapoolGenerator;
import org.datagen.generator.UserGenerator;
import org.datagen.io.Writer;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDatapoolGenerator userDatapoolGenerator = new UserDatapoolGenerator(new UserGenerator(), new Writer());
        userDatapoolGenerator.generateUsers(10);
    }
}
