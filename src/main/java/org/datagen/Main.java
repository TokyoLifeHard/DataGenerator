package org.datagen;


import org.datagen.generator.PassportGenerator;
import org.datagen.generator.SnilsGenerator;
import org.datagen.netology.Product;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Main {
    private final static String filePathFemaleLastName = "D:\\DataGenerator\\src\\main\\resources\\femaleLastName.txt";
    private final static String filePathFemaleName = "D:\\DataGenerator\\src\\main\\resources\\femaleNames.txt";
    private final static String filePathPatronymicFemale = "D:\\DataGenerator\\src\\main\\resources\\patronymicFemale.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Product product = new Product("test",100,100);
        Product[] basket = new Product[2];
        Arrays.fill(basket,product);
        Product[] products = Arrays.copyOf(basket, 3);
        System.out.println(Arrays.toString(products));
    }
}
