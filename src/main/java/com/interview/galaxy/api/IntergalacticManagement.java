package com.interview.galaxy.api;

import java.util.List;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 14:33
 */
public interface IntergalacticManagement {
    /**
     * Processes the input transaction.
     *
     * @param {@link List} inputTransactions
     *
     * @return {@link List} of result.
     */
    List<String> process(List<String> inputTransactions);
}
