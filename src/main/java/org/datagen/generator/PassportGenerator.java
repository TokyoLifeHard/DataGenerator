package org.datagen.generator;

import org.datagen.enitiy.Passport;
import org.datagen.io.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Random;

public class PassportGenerator {
    private static final Reader READER = new Reader();
    private static final String FEMALE_LAST_NAME = "src/main/resources/femaleLastName.txt";
    private static final String FEMALE_NAME = "src/main/resources/femaleNames.txt";
    private static final String FEMALE_PATRONYMIC = "src/main/resources/patronymicFemale.txt";
    private static final String MALE_LAST_NAME = "src/main/resources/malelastName.txt";
    private static final String MALE_NAME = "src/main/resources/maleNames.txt";
    private static final String MALE_PATRONYMIC = "src/main/resources/patronymicMale.txt";
    private static final String OKATO = "src/main/resources/Okato.txt";


    public Passport generate() throws IOException {
        char sex = generateSex();
        if (sex == 'm'){
           return generateMale();
        }else {
            return genearteFemale();
        }
    }

    private Passport genearteFemale() throws IOException {
        String birthDate = generateBirthDate();
        return new Passport.Builder()
                .firstName(READER.getRandomFio(Path.of(FEMALE_NAME)))
                .secoundName(READER.getRandomFio(Path.of(FEMALE_LAST_NAME)))
                .patronymic(READER.getRandomFio(Path.of(FEMALE_PATRONYMIC)))
                .birthDate(birthDate)
                .whomIssued(whomIssued())
                .dateIssued(caluclateDateIssued(birthDate))
                .placeLiving("Москва")
                .seria(generateSeria(birthDate,genearteOkatoNum()))
                .number(generateNumber())
                .build();

    }

    private Passport generateMale() throws IOException {
        String birthDate = generateBirthDate();
        return new Passport.Builder()
                .firstName(READER.getRandomFio(Path.of(MALE_NAME)))
                .secoundName(READER.getRandomFio(Path.of(MALE_LAST_NAME)))
                .patronymic(READER.getRandomFio(Path.of(MALE_PATRONYMIC)))
                .birthDate(birthDate)
                .dateIssued(caluclateDateIssued(birthDate))
                .placeLiving("Москва")
                .seria(generateSeria(birthDate,genearteOkatoNum()))
                .number(generateNumber())
                .build();

    }

    private String caluclateDateIssued(String birthDate){

        StringBuilder dateIssued = new StringBuilder();

        int dayOfTheMonth = Integer.parseInt(birthDate.split("-")[2]);
        int monthNumber = Integer.parseInt(birthDate.split("-")[1]);

        if(monthNumber == 2){

        }

        dayOfTheMonth += RandomUtils.radmonInts(1,5);
        monthNumber += RandomUtils.radmonInts(1,3);

        if (isUpper14andYounger20(birthDate)){
           dateIssued.append(caclulateYearIssued(birthDate,14)) ;
        }else if (isUpper20(birthDate) && !isUpper45(birthDate)){
            dateIssued.append(caclulateYearIssued(birthDate,20));
        } else if (isUpper45(birthDate)) {
            dateIssued.append(caclulateYearIssued(birthDate,45));
        }
        return dateIssued.append("-").append(monthNumber).append("-").append(dayOfTheMonth).toString();
    }
    private int caclulateYearIssued(String birthDate,int ageIssued){
        String birthYear = birthDate.split("-")[0];
        System.out.println(birthYear);
        int years = LocalDate.now().getYear() - Integer.parseInt(birthYear);
        return LocalDate.now().getYear() - Math.abs(years - ageIssued);
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
        System.out.println(yearBirth);
        int last2DigestOfYearBirth = Integer.parseInt(yearBirth.substring(2));
        System.out.println(last2DigestOfYearBirth);
        String okatoNum = okatoData.split(",")[0];
        return new StringBuilder()
                .append(okatoNum)
                .append(last2DigestOfYearBirth)
                .toString();
    }

    private String generateNumber(){
        StringBuilder passportNumber = new StringBuilder();
        for (int i = 0; i<6;i++){
            passportNumber.append(RandomUtils.radmonInts(0,9));
        }
        return passportNumber.toString();
    }
    private String genearteOkatoNum() throws IOException {
        return READER.getRandomLine(Path.of(OKATO))[0];
    }

    private String whomIssued() throws IOException{
        StringBuilder whomIssued = new StringBuilder();
        String[] okato = READER.getRandomLine(Path.of(OKATO));
        return  whomIssued.append("УФМС России по гор ").append(okato[2]).append(" ").append(okato[1]).toString();
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

    public static void main(String[] args) throws IOException {
        PassportGenerator passportGenerator = new PassportGenerator();
        Passport passport = passportGenerator.generate();
        System.out.println(passport.toString());

    }
}
