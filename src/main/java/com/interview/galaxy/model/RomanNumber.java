package com.interview.galaxy.model;

import com.interview.galaxy.exception.InvalidRomanException;
import com.interview.galaxy.exception.UnsupportedOperationException;
import com.interview.galaxy.util.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vinh Pham
 * Date: 22/11/2016
 * Time: 23:44
 */
public enum RomanNumber {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int value;
    private static boolean isRomanNumber;

    RomanNumber(int value) {
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

    public static boolean isRomanNumber(String input) {
        validateRomanElement(input);
        return isRomanNumber;
    }

    public static void validateRomanElement(String element) {
        List romanList = Arrays.asList(RomanNumber.values()).stream().map(Enum::name).collect(Collectors.toList());
        if (!romanList.contains(element)) {
            throw new InvalidRomanException("Invalid symbol");
        }
        isRomanNumber = true;
    }

    public static RomanNumber convertStringToRoman(String romanNumber) {
        if (isRomanNumber(romanNumber)) {
            return Arrays.asList(RomanNumber.values()).stream().filter(e -> e.name().equals(romanNumber)).findFirst().get();
        }
        return null;
    }

    public static RomanNumber getRomanAtPos(String string, int index) {
        return convertStringToRoman(Utils.getStringAtPos(string, index));
    }

    public void validate(RomanSequence romanSequence) {
        switch (this) {
            case I:
                if (isSequenceValid(romanSequence, I, "(I[^IXV])")) {
                    throw new InvalidRomanException("Invalid Sequence, I can only be followed by X|V");
                }
                multipleOccurrenceCheck(romanSequence, I, 4);
                break;
            case V:
                multipleOccurrenceCheck(romanSequence, V, 2);
                break;
            case X:
                if (isSequenceValid(romanSequence, X, "(X[^XLC])")) {
                    throw new InvalidRomanException("Invalid Sequence, X can only be followed by L|C");
                }
                multipleOccurrenceCheck(romanSequence, X, 4);
                break;
            case L:
                if (isSequenceValid(romanSequence, L, "(L[^CDM])")) {
                    throw new InvalidRomanException("Invalid Sequence, L can only be followed by C, D or M");
                }
                multipleOccurrenceCheck(romanSequence, L, 2);
                break;
            case C:
                if (isSequenceValid(romanSequence, C, "(C[^CDM])")) {
                    throw new InvalidRomanException("Invalid Sequence, C can only be followed by C, D or M");
                }
                multipleOccurrenceCheck(romanSequence, C, 4);
                break;
            case D:
                if (isSequenceValid(romanSequence, D, "(D[^M])")) {
                    throw new InvalidRomanException("Invalid Sequence, D can only be followed by  M");
                }
                multipleOccurrenceCheck(romanSequence, D, 2);
                break;
            case M:
                multipleOccurrenceCheck(romanSequence, D, 4);
                break;
            default:
                throw new UnsupportedOperationException("Invalid Symbol");
        }
    }

    public static void startValidation(RomanSequence romanSequence) {
        Arrays.asList(RomanNumber.values()).stream().forEach(e -> e.validate(romanSequence));
    }

    private static void multipleOccurrenceCheck(RomanSequence romanExpression, RomanNumber romanNumber, int invalidOccurance) {
        if (romanExpression.isMatch(".*" + romanNumber.name() + "{" + invalidOccurance + ",}.*"))
            throw new InvalidRomanException("Max occurrences allowed for " + romanNumber.name() + " is " + (invalidOccurance - 1));
    }

    private static boolean isSequenceValid(RomanSequence romanSequence, RomanNumber romanNumber, String pattern) {
        return romanSequence.contains(romanNumber) && romanSequence.isSequenceMatch(pattern);
    }
}
