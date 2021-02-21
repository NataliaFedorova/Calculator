package com.company;

public class Calculator {

    private static int result;

    public static int calculate(int x, int y, String operation){

            switch (operation) {
                case "+":
                    result = x + y;
                    break;
                case "-":
                    result = x - y;
                    break;
                case "*":
                    result = x * y;
                    break;
                case "/":
                    result = x / y;
                    break;
            }
            return result;
    }
}
