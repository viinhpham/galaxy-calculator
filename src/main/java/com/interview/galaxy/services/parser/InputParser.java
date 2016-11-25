package com.interview.galaxy.services.parser;

import com.interview.galaxy.api.Parser;
import com.interview.galaxy.model.RomanNumber;
import com.interview.galaxy.model.RomanSequence;
import com.interview.galaxy.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.interview.galaxy.services.parser.MappingResource.*;
import static com.interview.galaxy.util.Utils.*;
import static java.util.Arrays.asList;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 22:20
 */
public class InputParser implements Parser {
    /**
     * {@inheritDoc}
     */

    private String parse(String input) {
        String result = null;

        if (input.matches("\\S+\\s(is)\\s\\S+")) {
            RomanNumber romanNumber = RomanNumber.getRomanAtPos(input, 2);
            addForeignLangRomanMapping(getStringAtPos(input, 0), romanNumber);
//            result = romanNumber.name();

        } else if (input.matches(".*\\sis\\s\\d+\\sCredits")) {
            float parsedValue = extractDecimalFromInput(input) / evalRomanFromInput(input);
            addElement(getStringAtLastPos(input.split(" is ")[0]), parsedValue );
//            result = String.valueOf(parsedValue);

        } else if (input.matches("how\\s(much|many\\sCredits)\\sis\\s([" + langTokens()
            + "]+\\s)*([" + elementTokens() + "]+\\s)*\\?")) {
            return asList(input.split(" is ")[1].split(" ")).stream()
                .filter(MappingResource::containsToken)
                .reduce((x,y) -> x += " " + y)
                .get() + (isElementInput(input) ? " "+ getElementName(input)+ " is " + (int)(getElementCost(input) * evalRomanFromInput(input)) + " Credits": " is " + (int)evalRomanFromInput(input));

        } else {
            result = "I have no idea what you are talking about";
        }
        return result;

    }

    /**
     * Extracts decimal from input
     *
     * @param string input.
     *
     * @return extracted decimal value.
     */
    private float extractDecimalFromInput(String string) {
        int position = string.split(" ").length - 2;
        return Integer.parseInt(string.split(" ")[position]);
    }

    private static float evalRomanFromInput(String input) {

        return DecimalParser.getInstance().convert(
            new RomanSequence(
                convertStringToListWithDelimiter(input, " ")
                    .stream()
                    .filter(MappingResource::containsToken)
                    .map(e -> getIntergalacticLangRomanMapping(e).toString())                       .reduce((e, a) -> e += a).get()));
    }

    private static boolean isElementInput(String input){
        return asList(input.split(" ")).stream().anyMatch(MappingResource::containsElement);
    }

    private static float getElementCost(String input){
        return getElementForIntergalacticLang(input);
    }

    private static String getElementName(String input){
        return asList(input.split(" ")).stream().filter(MappingResource::containsElement).findFirst().get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> parse(List<String> input) {
        List<String> result = new ArrayList<>();
        for (String s : input) {
            String out = parse(s);
            if (null != out) {
                result.add(out);
            }
        }
        return result;
        /*return input.stream().filter(Objects::nonNull).map(i -> parse(i)).collect(Collectors.toList());*/
    }
}
