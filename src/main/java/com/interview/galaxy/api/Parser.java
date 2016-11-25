package com.interview.galaxy.api;

import java.util.List;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 22:21
 */
public interface Parser {
    /**
     * Parses list of input string to process.
     *
     * @param List of input string.
     *
     * @return List of processed string.
     */
    List<String> parse(List<String> input);
}
