package com.interview.galaxy.model;

import com.interview.galaxy.util.Utils;

import java.util.Stack;

/**
 * Author: Vinh Pham
 * Date: 11/24/16
 * Time: 10:36 PM
 */
public class RomanStack {
    private Stack<RomanNumber> stack = new Stack<>();

    private RomanStack(RomanSequence romanSequence) {
        Utils.convertStringToList(romanSequence.toString()).stream().forEach(o -> push(RomanNumber.convertStringToRoman(o)));
    }

    public static RomanStack getInstance(RomanSequence romanSequence) {
        return new RomanStack(romanSequence);
    }

    public RomanNumber pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    private void push(RomanNumber romanNumber) {
        stack.push(romanNumber);
    }

}
