package codility;

import java.util.Arrays;
import java.util.Stack;

/*
* */
public class ValidParanthesis {

    public static void main(String[] args) {
        boolean answer = isValidParanthesis("{}}");
        System.out.println("answer :: " + answer);

//        int[] answer = solution(0, nums);
//        Arrays.stream(answer).forEach(System.out::println);
    }

    private static boolean isValidParanthesis(String s) {

        Stack<Character> characters = new Stack<>();

        for (char ch : s.toCharArray()) {
            if(ch == '[' || ch == '{' || ch == '(') {
                characters.push(ch);
            } else {
                Character top = characters.pop();

                if(characters.isEmpty()) {
                    return false;
                }

                if(
                        (ch == ']' && top != '[')
                        || (ch == '}' && top != '{')
                        || (ch == ')' && top != '(')
                ) {
                    return false;
                }
            }
        }

        return characters.isEmpty();
    }
}
