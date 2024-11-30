package codesignal;

import java.util.Arrays;
import java.util.List;

public class StringPatternMatching {

    public static void main(String[] args) {
        int answer = apply("010", "amazing");
        System.out.println(answer);
    }


    private static int apply(String pattern, String source) {

//        We’ll say that a substring source[l..r] matches pattern if the following three conditions are met:
//        – The pattern and substring are equal in length.
//        – Where there is a 0 in the pattern, there is a vowel in the substring.
//        – Where there is a 1 in the pattern, there is a consonant in the substring.

        int patternLength = pattern.length();
        int sourceLength = source.length();
        int matches = 0;
        if(patternLength == sourceLength) return 1;

        for (int i = 0; i < sourceLength; i++) {
            String subSource = source.substring(i, Math.min(i+patternLength, sourceLength));

            int matchesSubString = getMatches(pattern, subSource);

            if(matchesSubString == patternLength) {
                System.out.println("Matching subSource : " + subSource);
                matches++;
            }
        }

        return matches;
    }

    private static int getMatches(String pattern, String subSource) {
        int matches = 0;
        for (int j = 0; j < subSource.length(); j++) {
            char p = pattern.charAt(j);
            char s = subSource.charAt(j);

            if(isValidCharacter(p, s)){
                matches++;
            }
        }
        return matches;
    }

    private static boolean isValidCharacter(char p, char s) {
        boolean isValid = false;
        if(p == '0'){
            isValid = isVowel(s);
        } else if (p == '1') {
            isValid = !isVowel(s);
        }
        return isValid;
    }

    private static boolean isVowel(char ch) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        return vowels.contains(ch);
    }
}
