package com.interview.galaxy.services.parser;

import com.interview.galaxy.api.Parser;
import com.interview.galaxy.model.RomanNumbers;
import com.interview.galaxy.util.Utils;

import static com.interview.galaxy.services.parser.MappingResource.*;
import static com.interview.galaxy.util.Utils.*;

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
             addForeignLangRomanMapping(getStringAtPos(input, 0),
                 RomanNumbers.getRomanAtPos(input, 2));

         } else if (input.matches(".*\\sis\\s\\d+\\sCredits")) {
             addElement(getStringAtLastPos(input.split(" is ")[0]), extractDecimalFromInput(input) / evalRomanFromInput(e));

         } else if (input.matches("how\\s(much|many\\sCredits)\\sis\\s(["+ langTokens()
             +"]+\\s)*(["+ elementTokens()+"]+\\s)*\\?")) {

         } else {
             System.out.println("I have no idea what you are talking about");
         }

    }

    /**
     * Extracts decimal from input
     *
     * @param string input.
     * @return extracted decimal value.
     */
    private  float extractDecimalFromInput(String string) {
        int position = string.split(" ").length - 2;
        return Integer.parseInt(string.split(" ")[position]);
    }
}
