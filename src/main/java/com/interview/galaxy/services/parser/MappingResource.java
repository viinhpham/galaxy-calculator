package com.interview.galaxy.services.parser;

import com.interview.galaxy.model.RomanNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 23:14
 */
public class MappingResource {
    private static final Map<String, RomanNumber> intergalacticLangRomanMapping = new HashMap<>();
    private static final Map<String, Float> intergalacticLangElements = new HashMap<>();

    public static String langTokens(){
        return intergalacticLangRomanMapping.size() > 0 ?
                intergalacticLangElements.keySet().stream().reduce((e,a) -> e+="|"+a).get(): "";
    }

    public static String elementTokens(){
        return intergalacticLangElements.size() > 0? intergalacticLangElements.keySet().stream().reduce((e,a) -> e+="|"+a).get():"";
    }
    public static void addForeignLangRomanMapping(String token,RomanNumber romanNumber){
        intergalacticLangRomanMapping .put(token,romanNumber);
    }
    public static float getElementForIntergalacticLang(String token) {
        return intergalacticLangElements.get(token);
    }
    public static RomanNumber getIntergalacticLangRomanMapping(String token) {
        return intergalacticLangRomanMapping.get(token);
    }

    public static boolean containsToken(String token) {
        return intergalacticLangRomanMapping.containsKey(token);
    }

    public static boolean containsElement(String token) {
        return intergalacticLangElements.containsKey(token);
    }

    public static void addElement(String elementName, float cost) {
        intergalacticLangElements.put(elementName,cost);
    }


}
