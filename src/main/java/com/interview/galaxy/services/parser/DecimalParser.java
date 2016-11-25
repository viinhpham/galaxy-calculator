package com.interview.galaxy.services.parser;

import com.interview.galaxy.model.RomanPair;
import com.interview.galaxy.model.RomanSequence;

/**
 * Author: Vinh Pham
 * Date: 11/24/16
 * Time: 11:33 PM
 */
public class DecimalParser {
    private static DecimalParser decimalParser;

    public static DecimalParser getInstance() {
        return decimalParser == null? new DecimalParser() : decimalParser;
    }
    public int convert(RomanSequence romanSequence) {
        romanSequence.validateRules();
        return romanSequence.getSequencePairs().stream().mapToInt(RomanPair::operate).sum();
    }
}
