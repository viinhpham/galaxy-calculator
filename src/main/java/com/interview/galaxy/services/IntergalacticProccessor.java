package com.interview.galaxy.services;

import com.interview.galaxy.api.IntergalacticManagement;
import com.interview.galaxy.api.Parser;
import com.interview.galaxy.services.parser.InputParser;

import java.util.List;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 13:37
 */
public class IntergalacticProccessor implements IntergalacticManagement{
    private static IntergalacticProccessor intergalacticCalculator;

    public IntergalacticProccessor() {
    }

    public static IntergalacticProccessor getInstance(){
        return  intergalacticCalculator == null ? new IntergalacticProccessor() : intergalacticCalculator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> process(List<String> inputTransactions) {
        Parser parser = new InputParser();
        return  parser.parse(inputTransactions);
    }
}
