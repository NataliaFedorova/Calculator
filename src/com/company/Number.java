package com.company;

public enum Number {

    /*
    enum позволяет найти соответствующее арабское значение, если у нас римские от 1 до 10
    getDozensForRomanResult() позволяет получить десятки для результата в римских цифрах, если наш результат - двузначное число
     */

    I(1, "X"),
    II(2, "XX"),
    III(3, "XXX"),
    IV(4, "XL"),
    V(5, "L"),
    VI(6, "LX"),
    VII(7, "LXX"),
    VIII(8,"LXXX"),
    IX(9, "XC"),
    X(10, "C");

    private final int arabic;
    private final String dozensForRomanResult;

    Number (int arabic, String dozensForRomanResult) {
        this.arabic = arabic;
        this.dozensForRomanResult = dozensForRomanResult;
    }


    public int getArabic () {

        return arabic;
    }

    public String getDozensForRomanResult () {

        return dozensForRomanResult;
    }
}
