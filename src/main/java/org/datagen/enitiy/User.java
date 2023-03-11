package org.datagen.enitiy;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID uuid;
    private Passport passport;
    private Snils snils;
    private Inn inn;
    public User() {
    }

    public User(Passport passport, Snils snils,Inn inn) {
        this.uuid = UUID.randomUUID();
        this.passport = passport;
        this.snils = snils;
        this.inn = inn;
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

    public Inn getInn() {
        return inn;
    }

    public void setInn(Inn inn) {
        this.inn = inn;
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

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", passport=" + passport +
                ", snils=" + snils +
                ", inn=" + inn +
                '}';
    }
}
