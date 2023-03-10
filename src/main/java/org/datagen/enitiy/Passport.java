package org.datagen.enitiy;

import java.util.Objects;

public class Passport {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateIssued;
    private String whomIssued;
    private String placeLiving;
    private String seria;
    private String number;
    private String birthDate;

    public Passport() {
    }


    public static class Builder{
        private final Passport passport;

        public Builder() {
            this.passport = new Passport();
        }

        public  Builder firstName(String firstName){
            this.passport.firstName = firstName;
            return this;
        }

        public  Builder secoundName(String lastName){
            this.passport.lastName = lastName;
            return this;
        }

        public Builder patronymic(String patronymic){
            this.passport.patronymic = patronymic;
            return this;
        }

        public Builder dateIssued(String dateIssued){
            this.passport.dateIssued =  dateIssued;
            return this;
        }

        public Builder whomIssued(String whomIssued){
            this.passport.whomIssued = whomIssued;
            return this;
        }

        public Builder placeLiving(String placeLiving){
            this.passport.placeLiving = placeLiving;
            return this;
        }

        public Builder seria(String seria){
            this.passport.seria= seria;
            return this;
        }

        public Builder number(String number){
            this.passport.number = number;
            return this;
        }

        public Builder birthDate(String birthDate){
            this.passport.birthDate = birthDate;
            return this;
        }
        public Passport build(){
            return this.passport;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (!Objects.equals(dateIssued, passport.dateIssued)) return false;
        if (!Objects.equals(whomIssued, passport.whomIssued)) return false;
        if (!Objects.equals(placeLiving, passport.placeLiving))
            return false;
        if (!Objects.equals(seria, passport.seria)) return false;
        return Objects.equals(number, passport.number);
    }

    @Override
    public int hashCode() {
        int result = dateIssued != null ? dateIssued.hashCode() : 0;
        result = 31 * result + (whomIssued != null ? whomIssued.hashCode() : 0);
        result = 31 * result + (placeLiving != null ? placeLiving.hashCode() : 0);
        result = 31 * result + (seria != null ? seria.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateIssued='" + dateIssued + '\'' +
                ", whomIssued='" + whomIssued + '\'' +
                ", placeLiving='" + placeLiving + '\'' +
                ", seria='" + seria + '\'' +
                ", number='" + number + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
