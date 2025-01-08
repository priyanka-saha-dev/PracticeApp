package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumAddUpToATarget {

    public static void main(String[] args) {
        int[] result = apply(new int[]{2,7,11,15}, 9);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] apply(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if(map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(numbers[i], i);

        }
        return new int[]{};
    }
}
