package org.datagen;
/*

Ваша задача - найти какое количество раз текст в PATTERN повторяется в TEXT.
Повторения могут пересекаться друг с другом.
Предлагаем циклом перебрать все возможные позиции в TEXT в которых может начинаться PATTERN.
При переборе каждую позицию проверять циклом, перебирая символы в PATTERN и символы, которые идут начиная с перебираемой позиции.
Если при проверке хотя бы один из символов не совпадёт - позиция не подходит и переходим к следующей.
В противном случае нужно увеличить счётчик повторений count.
*/

public class DataTypes {
    public static final String TEXT = "aaababaabaaaabaabaabaabaaababaabaaababaabaaaabaabaabaabbabaabaaababaababaabaabaabaaabbaab";
    public static final String PATTERN = "aab";

    public static void main(String[] args) {
        int count = 0;
        System.out.println(TEXT.length());
        for (int i = 0; i < TEXT.length(); i++) {
            if (TEXT.charAt(i) == PATTERN.charAt(0) && TEXT.charAt(i+1) == PATTERN.charAt(1) && TEXT.charAt(i+2) == PATTERN.charAt(2)) {
                count++;
            }

        }

        System.out.println("Строка " + PATTERN + " встретилась в тексте " + count + " раз");
    }
}
