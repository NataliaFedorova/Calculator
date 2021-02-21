package com.company;

import java.util.ArrayList;

public class RomanResultConverter {

    private static String dozensRomanresult;

    public static void romanResultToArabic(int result) {

        /*
        Для результата в римских цифрах:
        1. Определяем количество разрядов
        2. Если однозначное: сразу сопоставляем с энамом римских значений и ыаодим результат в римских;
        3. Если двузначное или трёхзначное(100):
           получаем десятки из enum согласно порядковому номеру каждого при помощи метода getDozensForRomanResult()
           Соединяем десятки и единицы и выводим результат в римских
         */

        if (result == 0) {
            System.out.println(0);
        }
        else {
            Number[] numbers = Number.values(); // получаем массив значений энама numbers
            var categories = new ArrayList<Integer>();

            int a = result;
            while (a != 0) { // получаем все разряды из результата в categories
                categories.add(a % 10);
                a /= 10;
            }

            int r = categories.size(); // получаем количество разрядов в результате

            if (r == 1) { // если однозначное число
                Number unitsRomanresult = numbers[categories.get(0) - 1];
                System.out.println("Результат вычислений: " + unitsRomanresult);
            }

            else if ((r == 2) || (r == 3)) { // если двузначное число

                if (result % 10 == 0) { // если круглое двузначное число
                    Number dozensRoman = numbers[categories.get(1) - 1];
                    dozensRomanresult = dozensRoman.getDozensForRomanResult();
                    System.out.println("Результат вычислений: " + dozensRomanresult);
                }

                else { // если не круглое двузначное число
                    Number unitsRomanresult = numbers[categories.get(0) - 1];
                    Number dozensRoman = numbers[categories.get(1) - 1];
                    dozensRomanresult = dozensRoman.getDozensForRomanResult();
                    System.out.println("Результат вычислений: " + dozensRomanresult + unitsRomanresult);
                }
            }
        }
    }
}
