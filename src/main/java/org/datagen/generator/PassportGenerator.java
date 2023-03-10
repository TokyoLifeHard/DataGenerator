package org.datagen.generator;

import org.datagen.enitiy.Passport;
import org.datagen.io.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Random;

public class PassportGenerator {
    private static final Reader READER = new Reader();
    private static final String FEMALE_LAST_NAME = "";
    private static final String FEMALE_NAME = "";
    private static final String FEMALE_PATRONYMIC = "";
    private static final String MALE_LAST_NAME = "";
    private static final String MALE_NAME = "";
    private static final String MALE_PATRONYMIC = "";

    public Passport generate(){
        char sex = generateSex();


        return null;
    }

    private Passport genearteFemale() throws IOException {
        String birthDate = generateBirthDate();
        String dateIssued = caluclateDateIssued(birthDate);
        return new Passport.Builder()
                .firstName(READER.getRandomFio(Path.of(FEMALE_NAME)))
                .secoundName(READER.getRandomFio(Path.of(FEMALE_LAST_NAME)))
                .patronymic(READER.getRandomFio(Path.of(FEMALE_PATRONYMIC)))
                .birthDate(birthDate)
                .dateIssued(caluclateDateIssued(birthDate))
                .placeLiving("")
                .seria("")
                .number("")
                .build();

    }

    private Passport generateMale() throws IOException {
        String birthDate = generateBirthDate();
        String dateIssued = caluclateDateIssued(birthDate);
        return new Passport.Builder()
                .firstName(READER.getRandomFio(Path.of(MALE_NAME)))
                .secoundName(READER.getRandomFio(Path.of(MALE_LAST_NAME)))
                .patronymic(READER.getRandomFio(Path.of(MALE_PATRONYMIC)))
                .birthDate(birthDate)
                .dateIssued(caluclateDateIssued(birthDate))
                .placeLiving("")
                .seria("")
                .number("")
                .build();

    }

    private String caluclateDateIssued(String birthDate){
        LocalDate dateBirthdate = LocalDate.parse(birthDate);

        StringBuilder dateIssued = new StringBuilder();
        int dayOfTheMonth = Integer.parseInt(birthDate.split("-")[0]);
        int monthNumber = Integer.parseInt(birthDate.split("-")[1]);

        RandomUtils.radmonInts(1,2);
        if (isUpper14andYounger20(birthDate)){
           dateIssued.append(caclulateYearIssued(birthDate,14)) ;
        }else if (isUpper20(birthDate) && !isUpper45(birthDate)){
            dateIssued.append(caclulateYearIssued(birthDate,20));
        } else if (isUpper45(birthDate)) {
            dateIssued.append(caclulateYearIssued(birthDate,45));
        }
        return dateIssued.toString();
    }
    private int caclulateYearIssued(String birthDate,int ageIssued){
        String birthYear = birthDate.split("-")[2];
        int years = LocalDate.now().getYear() - Integer.parseInt(birthDate);
        return LocalDate.now().getYear() - (years - ageIssued);
    }
    public String generateBirthDate(){
        Random random = new Random();
        int minDay = (int) LocalDate.of((LocalDate.now().getYear()-60), 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(LocalDate.now().getYear(), 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay).toString();
    }

    private String generateSeria(String birthDate, String okatoData){
        String yearBirth = birthDate.split("-")[0];
        int last2DigestOfYearBirth = Integer.parseInt(yearBirth.substring(3,4));
        String okatoNum = okatoData.split(",")[0];
        return new StringBuilder()
                .append(okatoNum)
                .append(last2DigestOfYearBirth)
                .toString();
    }

    private boolean isUpper20(String birthDate){

        boolean isFullYearsMore20 = LocalDate.now().getYear() - Integer.parseInt(birthDate.split("-")[2]) > 20;
        boolean isCurrentMonthMoreBirthdate = LocalDate.now().getMonth().getValue() <= Integer.parseInt(birthDate.split("-")[1]);
        boolean isCurrentDayMoreBirthdate = LocalDate.now().getDayOfMonth() <= Integer.parseInt(birthDate.split("-")[0]);

        return isFullYearsMore20 && isCurrentMonthMoreBirthdate && isCurrentDayMoreBirthdate;
    }

    private boolean isUpper14(String birthDate){

        boolean isFullYearsMore14 = LocalDate.now().getYear() - Integer.parseInt(birthDate.split("-")[2]) > 14;
        boolean isCurrentMonthMoreBirthdate = LocalDate.now().getMonth().getValue() <= Integer.parseInt(birthDate.split("-")[1]);
        boolean isCurrentDayMoreBirthdate = LocalDate.now().getDayOfMonth() <= Integer.parseInt(birthDate.split("-")[0]);

        return isFullYearsMore14 && isCurrentMonthMoreBirthdate && isCurrentDayMoreBirthdate;
    }
    private boolean isUpper14andYounger20(String birthDate){
        return isUpper14(birthDate) && !isUpper20(birthDate);
    }
    private boolean isUpper45(String birthDate){

        boolean isFullYearsMore45 = LocalDate.now().getYear() - Integer.parseInt(birthDate.split("-")[2]) > 45;
        boolean isCurrentMonthMoreBirthdate = LocalDate.now().getMonth().getValue() <= Integer.parseInt(birthDate.split("-")[1]);
        boolean isCurrentDayMoreBirthdate = LocalDate.now().getDayOfMonth() <= Integer.parseInt(birthDate.split("-")[0]);

        return isFullYearsMore45 && isCurrentMonthMoreBirthdate && isCurrentDayMoreBirthdate;
    }

    private char generateSex(){
        Random random = new Random();
        int sex = random.nextInt(2);
        if (sex == 0){
            return 'm';
        }else {
            return 'f';
        }
    }

    public static void main(String[] args) {


    }
}
