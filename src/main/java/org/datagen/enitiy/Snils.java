package org.datagen.enitiy;

import java.util.Objects;

public class Snils {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snils snils = (Snils) o;
        return number.equals(snils.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Snils{" +
                "number='" + number + '\'' +
                '}';
    }
}

