package com.company;
import java.util.Scanner;


public class Main {

    private static String praxis;
    private static int result;

    public static void main(String[] args) throws Exception {

        Scanner data = new Scanner(System.in);
            System.out.println("Введите два однозначных натуральных числа от 1 до 10 (или от I до X) и знак арифметической операции:");

        praxis = data.nextLine();
        praxis = praxis.replaceAll(" ", "");// так возможно ввести данные и с пробелами, и без пробелов
        data.close();

        try {
            if (praxis.equals("")) {
                throw new Exception("String can not be empty!");
            }

            Parser.numbersParser(praxis);
            Parser.operationParser(praxis);

            Parser parser = new Parser();
            result = Calculator.calculate(parser.getNumber1(), parser.getNumber2(), parser.getOperation());

            if (parser.getFlag()) {
                System.out.println("Результат вычислений: " + result);
            }
            else if (!parser.getFlag()) {
                RomanResultConverter.romanResultToArabic(result);
            }
        }

        catch (RuntimeException ex ) {
            System.out.println("Проверьте корректность введенных данных");
            ex.printStackTrace();
        }
    }
}


