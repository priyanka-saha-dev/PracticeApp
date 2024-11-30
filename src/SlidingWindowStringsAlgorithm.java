import java.util.*;

public class SlidingWindowStringsAlgorithm {

    public static void main(String[] args) {

//        int lengthOfLongestSubstringWithoutRepeatingCharacters = lengthOfLongestSubstringWithoutRepeatingCharacters("abac");
//        System.out.println("lengthOfLongestSubstringWithoutRepeatingCharacters : " + lengthOfLongestSubstringWithoutRepeatingCharacters);
//
//        String longestSubstringWithoutRepeatingCharacters = longestSubstringWithoutRepeatingCharacters("abac");
//        System.out.println("longestSubstringWithoutRepeatingCharacters : " + longestSubstringWithoutRepeatingCharacters);

        int lengthOfLongestSubstringWithoutRepeatingCharacters2 = lengthOfLongestSubstringWithoutRepeatingCharacters2("abac");
        System.out.println("lengthOfLongestSubstringWithoutRepeatingCharacters2 : " + lengthOfLongestSubstringWithoutRepeatingCharacters2);

        String longestSubstringWithoutRepeatingCharacters2 = longestSubstringWithoutRepeatingCharacters2("abac");
        System.out.println("longestSubstringWithoutRepeatingCharacters2 : " + longestSubstringWithoutRepeatingCharacters2);

    }

    private static String longestSubstringWithoutRepeatingCharacters(String word) {
        // abac
        // ab
        // ba
        // ac
        // aba
        // bac >> Result

        int start = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        int maxLength = 0;
        int startPos = -1, endPos = -1;

        for (int end = 0; end < word.length(); end++) {

            Character ch = word.charAt(end);

            if(characterCount.containsKey(ch) && characterCount.getOrDefault(ch, 0) >= start){
                start = characterCount.getOrDefault(ch, 0) + 1;
            }

            characterCount.put(ch, end);
            int windowSize = end - start + 1;
//            maxLength = Math.max(maxLength, windowSize);

            if(windowSize >= maxLength) {
                maxLength = windowSize;
                startPos = start;
                endPos = end;
            }
        }

        String result = "";
        if(startPos == -1 || endPos == -1) {
            return "";
        } else {
            return word.substring(startPos, endPos+1);
        }

    }

    private static String longestSubstringWithoutRepeatingCharacters2(String word) {
        // abac
        // ab
        // ba
        // ac
        // aba
        // bac >> Result

        int start = 0;
        Set<Character> chars = new TreeSet<>();
        int maxLength = 0;
        int startPos = -1, endPos = -1;

        for (int end = 0; end < word.length(); end++) {

            Character ch = word.charAt(end);

            if(chars.contains(ch)){
                chars.remove(ch);
                start++;
            }

            chars.add(ch);

            int windowSize = end - start + 1;

            if(windowSize >= maxLength) {
                maxLength = windowSize;
                startPos = start;
                endPos = end;
            }
        }

        if(startPos == -1 || endPos == -1) {
            return "";
        } else {
            return word.substring(startPos, endPos+1);
        }

    }

    private static int lengthOfLongestSubstringWithoutRepeatingCharacters(String word) {
        // abac
        // ab
        // ba
        // ac
        // aba
        // bac >> Result

        int start = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        int maxLength = 0;

        for (int end = 0; end < word.length(); end++) {

            Character ch = word.charAt(end);

            if(characterCount.containsKey(ch) && characterCount.getOrDefault(ch, 0) >= start){
                start = characterCount.getOrDefault(ch, 0) + 1;
            }

            characterCount.put(ch, end);
            int windowSize = end - start + 1;
            maxLength = Math.max(maxLength, windowSize);
        }


        return maxLength;
    }

    private static int lengthOfLongestSubstringWithoutRepeatingCharacters2(String word) {
        // abac
        // ab
        // ba
        // ac
        // aba
        // bac >> Result


        Set<Character> chars = new HashSet<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < word.length(); end++) {

            Character ch = word.charAt(end);

            if(chars.contains(ch)){
                chars.remove(ch);
                start++;
            }

            chars.add(ch);

            int windowSize = end - start + 1;
            maxLength = Math.max(maxLength, windowSize);
        }


        return maxLength;
    }
}
