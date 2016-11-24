package com.interview.galaxy.services.parser;

import com.interview.galaxy.api.Parser;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 22:20
 */
public class InputParser implements Parser{
    /**
     * {@inheritDoc}
     */
     @Override
    public void parse(String input) {

         if(input.matches("\\S+\\s(is)\\s\\S+")) {

         } else if (input.matches(".*\\sis\\s\\d+\\sCredits")) {

         } else if (input.matches("how\\s(much|many\\sCredits)\\sis\\s(["+ MappingResource.langTokens()+"]+\\s)*(["+ MappingResource.elementTokens()+"]+\\s)*\\?")) {

         }

    }
}
