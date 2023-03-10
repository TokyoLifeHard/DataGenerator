package org.datagen.generator;

import org.datagen.enitiy.Passport;
import org.datagen.enitiy.Snils;
import org.datagen.enitiy.User;
import org.datagen.io.Reader;

import java.util.ArrayList;
import java.util.Random;

public class UserGenerator {
    SnilsGenerator snilsGenerator;
    InnGenerator innGenerator;
    PassportGenerator passportGenerator;

    public User generateUser(){

        return new User();
    }
    private Snils generateSnils(){
        return this.snilsGenerator.generate();
    }
    private Passport generatePassport(){
        return new Passport();
    }


}
