package org.datagen.enitiy;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID uuid;


    private Passport passport;
    private Snils snils;
    private String sex;
    public User() {
    }

    public User(Passport passport, Snils snils, String sex) {
        this.passport = passport;
        this.snils = snils;
        this.sex = sex;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Snils getSnils() {
        return snils;
    }

    public void setSnils(Snils snils) {
        this.snils = snils;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid) &&
                Objects.equals(passport, user.passport) &&
                Objects.equals(snils, user.snils);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, passport, snils);
    }
}
