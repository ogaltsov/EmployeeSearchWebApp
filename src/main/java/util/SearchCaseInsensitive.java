package util;


public class SearchCaseInsensitive {

    public static String caseInsensitive(String word) {
        char[] stringArray = word.trim().toCharArray();
        stringArray[0] = Character.toUpperCase(stringArray[0]);
        for(int i = 1; i<stringArray.length; i++)
            stringArray[i] = Character.toLowerCase(stringArray[i]);
        word = new String(stringArray);
        return word;
        }
    }
