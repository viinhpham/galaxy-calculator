package com.interview.galaxy.model;
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

    public static int getValueFromRomanChar(char romanChar)
    {
        int value = -1;

        switch(romanChar)
        {
            case 'I' : value = I.getValue();
                break;
            case 'V' : value = V.getValue();
                break;
            case 'X' : value = X.getValue();
                break;
            case 'L' : value = L.getValue();
                break;

            case 'C' : value = C.getValue();
                break;

            case 'D' : value = D.getValue();
                break;

            case 'M' : value = M.getValue();
                break;

        }

        return value;
    }
}
