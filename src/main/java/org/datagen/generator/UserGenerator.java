package org.datagen.generator;

import org.datagen.enitiy.Inn;
import org.datagen.enitiy.Passport;
import org.datagen.enitiy.Snils;
import org.datagen.enitiy.User;
import org.datagen.io.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class UserGenerator {
    private static final SnilsGenerator snilsGenerator;
    private static final InnGenerator innGenerator;
    private static final PassportGenerator passportGenerator;

    static {
        snilsGenerator = new SnilsGenerator();
        innGenerator = new InnGenerator();
        passportGenerator = new PassportGenerator();
    }

    public User generateUser() throws IOException {
        return new User(generatePassport(),generateSnils(),generateInn());
    }
    private Snils generateSnils(){
        return snilsGenerator.generate();
    }
    private Passport generatePassport() throws IOException {
        return passportGenerator.generate();
    }
    private Inn generateInn(){
        return innGenerator.generate();
    }

}
