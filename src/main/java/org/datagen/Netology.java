package org.datagen;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Netology {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            // Выводим информацию о возможных операциях пользователю
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    String spendingsStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    spendings += Integer.parseInt(spendingsStr);
                    break;
                case 3:
                    int sixPercentOffEarnings = tax6PercentOffEarnings(earnings);
                    int earningsMinusSpendings = taxEarningsMinusSpendings(earnings,spendings);

                    if (sixPercentOffEarnings < earningsMinusSpendings){
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + sixPercentOffEarnings + " рублей");
                        System.out.println("Налог на другой системе: " + earningsMinusSpendings + " рублей");
                        System.out.println("Экономия: " +(earningsMinusSpendings - sixPercentOffEarnings));
                    }else if(sixPercentOffEarnings > earningsMinusSpendings) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + earningsMinusSpendings + " рублей");
                        System.out.println("Налог на другой системе: " + sixPercentOffEarnings + " рублей");
                        System.out.println("Экономия: " +(sixPercentOffEarnings - earningsMinusSpendings));
                    } else {
                        System.out.println("Можете выбрать любую систему налогооблажения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }


        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
    public static int tax6PercentOffEarnings(int earnings){
        int tax = (earnings * 6 / 100);
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
}
