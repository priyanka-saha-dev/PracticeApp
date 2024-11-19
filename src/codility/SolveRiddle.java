package codility;

/*
* */
public class SolveRiddle {

    public static void main(String[] args) {
        String answer = solution("ab?ac?");
        System.out.println("answer :: " + answer);
    }

    private static String solution(String riddle) {
        String answer = "";
        char[] riddleCharArray = riddle.toCharArray();
        for (int i = 0; i < riddleCharArray.length; i++) {
            char ch = riddleCharArray[i];

            if(ch == '?') {
                char left = riddleCharArray[Math.max(0, i-1)];
                char right = riddleCharArray[Math.min(riddleCharArray.length-1, i+1)];

                char replacement = getReplacementCharacterExcept(left, right);
                answer = answer.concat(String.valueOf(replacement));
            } else {
                answer = answer.concat(String.valueOf(ch));
            }
        }

        return answer;
    }

    private static char getReplacementCharacterExcept(char exclusion1, char exclusion2) {

        String allChars = "abcdefghijklmnopqrstuvwzyx";
        char replacement = 0;
        for (char ch : allChars.toCharArray()) {
            if(ch != exclusion1 && ch != exclusion2) {
                replacement = ch;
                break;
            }
        }

        return replacement;
    }
}
