public class FractionManipulation {


    public String fractionAddition(String expression) {
        int total = 0;
        expression = expression.concat(".");
        expression = expression.concat(".");

        for(int i =0 ; i < expression.length() ; i++) {
            char ch = expression.charAt(i);
            int sign = (ch == '-') ? -1 : 1;
            float div = 0;
            if(Character.isDigit(ch) && expression.charAt(i+1) == '/') {
                div = Integer.parseInt(String.valueOf(ch)) / Integer.parseInt(String.valueOf(expression.charAt(i+2)));
            }

            if(sign < 0) {
                total -= div;
            } else {
                total += div;
            }

        }

        return String.valueOf(total);
    }

}

class Fraction {
    int sign;
    int numerator;
    int denominator;


}

