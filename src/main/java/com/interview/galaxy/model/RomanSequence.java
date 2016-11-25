package com.interview.galaxy.model;

import com.interview.galaxy.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 14:08
 */
public class RomanSequence {
    private final String romanSequence;
    private boolean isSequenceValid;
    private final List<RomanPair> sequencePairs;

    public RomanSequence(String romanSequence) {
        this.romanSequence = romanSequence;
        sequencePairs = new ArrayList<>();
        validateInvalidRomanNumber();
        createRomanPairList();
    }

    private void validateInvalidRomanNumber() {
        Utils.convertStringToList(romanSequence)
            .stream()
            .forEach(RomanNumber::validateRomanElement);
    }

    public void validateRules() {
        RomanNumber.startValidation(this);
        isSequenceValid = true;
    }

    public List<RomanPair> getSequencePairs() {
        return sequencePairs;
    }

    public boolean isSequenceValid() {
        return this.isSequenceValid;
    }

    public boolean isSequenceMatch(String pattern) {
        return sequencePairs.stream().anyMatch(e -> Pattern.matches(pattern, e.toString()));
    }

    public boolean isMatch(String pattern) {
        return Pattern.matches(pattern, romanSequence);
    }

    @Override
    public String toString() {
        return romanSequence;
    }

    public boolean contains(RomanNumber romanNumber) {
        return romanSequence.contains(romanNumber.name());
    }

    private void createRomanPairList() {
        RomanStack romanStack = RomanStack.getInstance(this);
        while (!romanStack.isEmpty()) {
            sequencePairs.add(new RomanPair(romanStack.pop(), romanStack.pop()));
        }
    }
}
