package org.datagen.generator;

import org.datagen.enitiy.Snils;

import java.util.ArrayList;
import java.util.Random;


public class SnilsGenerator {
    public Snils  generate(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<3; i++){
            for (int j = 0;j<3;j++){
                sb.append(randomDigest(random));
            }
            sb.append("-");
        }
        int controllSum = calculateControllSum(sb);
        sb.append(checkControllSum(controllSum));
        Snils snils = new Snils();
        snils.setNumber(sb.toString());
        return snils;
    }


    private int calculateControllSum(StringBuilder sb){
        String[] nums = sb.toString().split("-");
        ArrayList<Integer> digests = new ArrayList<>(9);
        int controllSum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int num = Integer.parseInt(nums[i]);
            digests.add(num / 100);
            digests.add(num / 10 % 10);
            digests.add(num % 10 % 10);
        }
        for (int i = 0; i < digests.size(); i++) {
            controllSum += digests.get(i) * (digests.size()- i - 1);
        }
        return controllSum;
    }
    private String checkControllSum(int controllSum){
        if (controllSum < 100){
            return String.valueOf(controllSum);
        }
        else if (controllSum > 101) {
            return String.valueOf((controllSum % 101));
        }
        return "00";
    }
    private int randomDigest(Random random){
        return random.ints(0,9)
                .findFirst()
                .getAsInt();
    }

}
