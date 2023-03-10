package org.datagen.hackerrank;

import java.util.List;

public class MatrixRotation {



    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        for (int i = 0; i < r; i++) {
            for (int i1 = 0; i1 < matrix.size(); i1++) {
               List<Integer> line = matrix.get(i1);
                for (Integer integer : line) {
                    
                }
                
            }
        }

    }

    public static void main(String[] args) {

        List<Integer> list1 = List.of(1,2,3,4);
        List<Integer> list2 = List.of(5,6,7,8);
        List<Integer> list3 = List.of(9,10,11,12);
        List<Integer> list4 = List.of(13,14,15,16);
        List<List<Integer>> matrix = List.of(list1,list2,list3,list4);

        matrixRotation(matrix,2);
    }
    
}
