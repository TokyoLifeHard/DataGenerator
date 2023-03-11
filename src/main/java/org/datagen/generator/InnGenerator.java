package org.datagen.generator;

import org.datagen.enitiy.Inn;
import org.datagen.io.Reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class InnGenerator {
    private static final String REGION_CODE_INN = "D:\\DataGenerator\\src\\main\\resources\\regionCodeInn.txt";
    private static final Reader READER = new Reader();
    private static List<Integer> list1 = List.of(7,2,4,10,3,5,9,4,6,8);
    private static List<Integer> list2 = List.of(3,7,2,4,10,3,5,9,4,6,8);

    public Inn generate(){

        try {
            return new Inn(generateInnWithControllSum());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String generateRegionCode() throws IOException {
        return READER.getRandomLine(Path.of(REGION_CODE_INN))[0];
    }

    private String generateDigests(Random random,int count){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(randomDigest(random));
        }
        return sb.toString();
    }

    private String generateInnWithControllSum() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(generateRegionCode());
        sb.append(generateDigests(new Random(),1));
        sb.append(generateDigests(new Random(),1));
        sb.append(generateDigests(new Random(),6));
        sb.append(calc11Digest(sb.toString().toCharArray()));
        sb.append(calc12Digest(sb.toString().toCharArray()));
        return sb.toString();
    }

    private int randomDigest(Random random){
        return random.ints(0,9)
                .findFirst()
                .getAsInt();
    }
    
    private int calc11Digest(char[] innDigests){
        int digest = 0;
        for (int i = 0; i < list1.size(); i++) {
            digest += list1.get(i) * Character.getNumericValue(innDigests[i]);
        }
        return digest % 11 % 10;
    }

    private int calc12Digest(char[] innDigests){
        int digest = 0;

        for (int i = 0; i < list2.size(); i++) {
            digest += list2.get(i) * Character.getNumericValue(innDigests[i]);
        }
        return digest % 11 % 10;
    }

}
