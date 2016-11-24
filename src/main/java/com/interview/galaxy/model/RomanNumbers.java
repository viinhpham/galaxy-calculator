package com.interview.galaxy.model;

import com.interview.galaxy.util.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vinh Pham
 * Date: 22/11/2016
 * Time: 23:44
 */
public enum RomanNumbers {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int value;

    RomanNumbers(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public static int getValueFromRomanChar(char romanChar) {
        int value = -1;

        switch (romanChar) {
            case 'I':
                value = I.getValue();
                break;
            case 'V':
                value = V.getValue();
                break;
            case 'X':
                value = X.getValue();
                break;
            case 'L':
                value = L.getValue();
                break;

            case 'C':
                value = C.getValue();
                break;

            case 'D':
                value = D.getValue();
                break;

            case 'M':
                value = M.getValue();
                break;

        }

        return value;
    }

    public static RomanNumbers convertStringToRoman(String romanNumber) {
        if (isRoman(romanNumber)) {
            return Arrays.asList(RomanNumbers.values()).stream().filter(e -> e.name().equals(romanNumber)).findFirst().get();
        }
        return null;
    }

    public static boolean isRoman(String element) {
        List romanList = Arrays.asList(RomanNumbers.values()).stream().map(Enum::name).collect(Collectors.toList());
        if (romanList.contains(element)) {
            return true;
        } else {
            return false;
        }
    }
    public static RomanNumbers getRomanAtPos(String string, int index){
        return convertStringToRoman(Utils.getStringAtPos(string,index));
    }
}
