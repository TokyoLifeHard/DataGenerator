package org.datagen;


import org.datagen.enitiy.User;
import org.datagen.generator.UserGenerator;

public class Main {

    public static void main(String[] args) throws Exception {
        UserGenerator userGenerator = new UserGenerator();
        User user = userGenerator.generateUser();
        System.out.println(user.toString());
    }
}
