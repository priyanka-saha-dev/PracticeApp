import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        String ans = s.solution("ACCAABBC");
        int ans = s.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(ans);
    }
//    public String solution(String S) {
//        // Implement your solution here
//
//        while(S.contains("AA") || S.contains("BB") || S.contains("CC") ) {
//            S = transform(S);
//        }
//
//        return S;
//    }
//
//    private String transform(String s) {
//
//        if(s.contains("AA")) {
//            return s.replace("AA", "");
//        } else if(s.contains("BB")) {
//            return s.replace("BB", "");
//        } else if(s.contains("CC")) {
//            return s.replace("CC", "");
//        }
//        return s;
//    }

    public int solution(int[] A) {
        // Implement your solution here
        // 1, 3, 6, 4, 1, 2 >> 5

        List<Integer> nums = Arrays.stream(A).sorted().distinct().boxed().collect(Collectors.toList());

        int num = 1;
        for (int n : nums) {
            if(nums.contains(num)) {
                num++;
            } else {
                break;
            }
        }
        
        return num;
    }
}
