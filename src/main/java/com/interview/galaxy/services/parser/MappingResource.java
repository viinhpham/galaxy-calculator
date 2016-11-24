package com.interview.galaxy.services.parser;

import com.interview.galaxy.model.RomanNumbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Vinh Pham
 * Date: 23/11/2016
 * Time: 23:14
 */
public class MappingResource {
    private static final Map<String, RomanNumbers> intergalacticLangRomanMapping = new HashMap<>();
    private static final Map<String, Float> intergalacticLangElements = new HashMap<>();

    public static String langTokens(){
        return intergalacticLangRomanMapping.size() > 0 ?
                intergalacticLangElements.keySet().stream().reduce((e,a) -> e+="|"+a).get(): "";
    }

    public static String elementTokens(){
        return intergalacticLangElements.size() > 0? intergalacticLangElements.keySet().stream().reduce((e,a) -> e+="|"+a).get():"";
    }
    public static void addForeignLangRomanMapping(String token,RomanNumbers romanNumber){
        intergalacticLangRomanMapping .put(token,romanNumber);
    }
    public static float getElementForIntergalacticLang(String token) {
        return intergalacticLangElements.get(token);
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
