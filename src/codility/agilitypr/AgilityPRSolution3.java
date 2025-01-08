package codility.agilitypr;

public class AgilityPRSolution3 {

    public String solution(String S) {
        String[] rows = S.split("\n");

        StringBuilder result = new StringBuilder();
        result.append(rows[0]).append("\n");

        for (int i = 1; i < rows.length; i++) {
            if (!(rows[i].contains(",NULL,")
                    || rows[i].startsWith("NULL,")
                    || rows[i].endsWith(",NULL"))) {
                result.append(rows[i]).append("\n");
            }

            if (!(rows[i].contains("NULL"))) {
                result.append(rows[i]).append("\n");
            }
        }

        return result.toString().trim();
    }

    public String solution1(String S) {
        String[] rows = S.split("\n");

        StringBuilder result = new StringBuilder();
        result.append(rows[0]).append("\n");

        for (int i = 1; i < rows.length; i++) {
            if (!(rows[i].contains("NULL"))) {
                result.append(rows[i]).append("\n");
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        AgilityPRSolution3 solution3 = new AgilityPRSolution3();
        String S = "header,header\nANNUL,ANNULLED\nnull,NILL\nNULL,NULL";
        String result = solution3.solution(S);

        System.out.println(result);
    }
}
