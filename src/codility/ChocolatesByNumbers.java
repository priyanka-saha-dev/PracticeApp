package codility;

import java.util.HashSet;
import java.util.Set;

/*
* */
public class ChocolatesByNumbers {

    public static void main(String[] args) {
        int answer = solution(50,3);
        System.out.println("answer :: " + answer);

    }

    private static int solution(int N, int M) {
        Set<Integer> eatenchocolates = new HashSet<>();
        eatenchocolates.add(0);//eat 0

        for (int i = M; i <= N*M; i=i+M) {
            int rem = i % N;
            eatenchocolates.add(rem);
        }
        System.out.println("eaten chocolates : " + eatenchocolates);
        return eatenchocolates.size();
    }
}
