package org.datagen.hackerrank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> grades = new ArrayList<>(4);
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        List<Integer> integers = List.of(1, 3, 2, 6, 1, 2);
        //System.out.println(gradingStudents(grades).toString());

        System.out.println(divisibleSumPairs(6, 3, integers));
        Set<Integer> set = new HashSet<>(integers);
        System.out.println(set.toString());
        int i = migratoryBirds(integers);
        System.out.println(dayOfProgrammer(2016));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {

        for (int i = 0; i < grades.size(); i++) {
            Integer grade = grades.get(i);
            if (grade >= 38){
                if (5 -(grade % 5) < 3){
                    grades.set(i, (grade + (5 - (grade % 5))));
                }
            }

        }
        return grades;
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        int d1 = 0;
        int d2 = 0;
        if (v2 > v1 && x2 > x1){
            return "NO";
        }else if (x2 < x1){

        }
        return "";
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int pairs = 0;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = 1; j < ar.size(); j++) {
                if (i<j){
                    if ((ar.get(i)+ar.get(j))%k == 0){
                        pairs++;
                    }
                }
            }
        }
        return pairs;

    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Set<Integer> integers = new HashSet<>(arr);
        HashMap<Integer, Integer> map = new HashMap<>(arr.size());
        int max = 0;
        int res = 0;
        for (Integer integer : integers) {
            map.put(integer,0);
            for (Integer integer1 : arr) {
                if (integer.equals(integer1)){
                    map.put(integer,map.get(integer)+1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue()>max) {
                max = integerIntegerEntry.getValue();
                res = integerIntegerEntry.getKey();
            }
        }

        return res;
    }

    public static String dayOfProgrammer(int year) {
        // Write your code here
        LocalDate date = LocalDate.of(year,01,01);
        String europeanDatePattern = "dd.MM.yyyy";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        return date.plusDays(255).format(europeanDateFormatter).toString();
    }


}
