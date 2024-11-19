import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodilityTest {

    public static void main(String[] args) {

        int[] coins = {1,1,0,1,1};
        int numberOfCoinsToFlipForAlternateSeries = numberOfCoinsToFlipForAlternateSeries(coins);
        System.out.println("numberOfCoinsToFlipForAlternateSeries : " + numberOfCoinsToFlipForAlternateSeries);
    }


    private static int numberOfCoinsToFlipForAlternateSeries(int[] nums) {

        int flipCount1 = 0;
        int flipCount2 = 0;

        int N = nums.length;

        if (N == 0 || N == 1) return 0;

        //0,1,2,3,4,5 << Index
        //1,0,1,0,1 << comb1
        //0,1,0,1,0 << comb2
        //1,1,0,1,1 << Problem

        for (int i = 0; i < nums.length; i++) {
            if(i%2 == 0) {
                if(nums[i] != 1) flipCount1++;
                if(nums[i] != 0) flipCount2++;
            } else if(i%2 != 0) {
                if(nums[i] != 0) flipCount1++;
                if(nums[i] != 1) flipCount2++;
            }

        }

        return Math.min(flipCount1, flipCount2);
    }

    private static int deleteAorB(String s) {

        int minDeletions = 0;
        int countB = 0;
        for (char ch : s.toCharArray()) {

            if(ch == 'A') {
                minDeletions++;
                minDeletions = Math.min(minDeletions, countB);
            } else if (ch == 'B') {
                countB++;
            }
        }

        return minDeletions;


    }
}
