package com.interview.galaxy.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Vinh Pham
 * Date: 11/24/16
 * Time: 3:09 PM
 */
public class Utils {
    public static List<String> convertStringToList(String string){
        return convertStringToListWithDelimiter(string,"");
    }

    public static List<String> convertStringToListWithDelimiter(String string, String delimiter){
        return new ArrayList<>(Arrays.asList(string.split(delimiter)));
    }

    public static String getStringAtLastPos(String string) {
        return getStringAtPos(string, string.split(" ").length - 1);
    }

    public static String getStringAtPos(String string, int index){
        return string.split(" ")[index];
    }
}
