package com.company;

public class Parser {

    // арабские или римские цифры. Римское - возвращаем значение через энам. Арабское - в инт. Проверка условия 2

    private static String operation;
    private static int x;
    private static int y;
    private static boolean flag;

    public Parser() {

    }

    public static void numbersParser (String pr) throws Exception {

        //получаем строковый массив чисел из примера

        String[] digits = pr.split("[+-/*=]");

        if (digits.length != 2) {
            throw new ArrayIndexOutOfBoundsException("Проверьте корректность введённых данных");
        }

        try { // если целое число - преобразовываем строку в целое
            x = Integer.parseInt(digits[0]);
            y = Integer.parseInt(digits[1]);
            flag = true;

            if ((x >= 11) || (x <= 0) || (y >= 11) || (y <= 0)) {
                throw new Exception("Числа должны быть в промежутке от 1 до 10");
            }
        }

        catch (NumberFormatException ex) { // если строка находится в enum римких чисел - возвращаем  соответствующее арабское значение
            Number number1 = Number.valueOf(digits[0]);
            Number number2 = Number.valueOf(digits[1]);
            x = number1.getArabic();
            y = number2.getArabic();
            flag = false;
        }

        catch (IllegalArgumentException ex) { // если не арабское число и не находится в enum
            ex.printStackTrace();
        }
    }

    public static void operationParser (String o) {

        if (o.contains("+")) {
            operation = "+";
        }
        if (o.contains("-")) {
            operation = "-";
        }
        if (o.contains("*")) {
            operation = "*";
        }
        if (o.contains("/")) {
            operation = "/";
        }
    }

    public int getNumber1() {
        return x;
    }

    public int getNumber2() {

        return y;
    }

    public String getOperation() {

        return operation;
    }

    public boolean getFlag() {
        return flag;
    }
}
