import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DSAExamples {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
//        int[] prod = productExceptSelf(arr);
//        System.out.println("productExceptSelf: " + Arrays.toString(prod));
//
//        int[] nums = {2, 17, 11, 7};
//        int target = 9;
//        int[] pos = twoSumProblem(nums, target);
//        System.out.println("twoSumProblem: " + Arrays.toString(pos));
//
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] result = mergeIntervals(intervals);
//
//        System.out.println("Merged Intervals:");
//        for (int[] interval : result) {
//            System.out.println(Arrays.toString(interval));
//        }
//
//        int[] nums1 = {1, 3};
//        int[] nums2 = {2};
//        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));  // Output: 2.0
//
//
//        int[] nums3 = {1, 2};
//        int[] nums4 = {3, 4};
//        System.out.println("Median: " + findMedianSortedArrays(nums3, nums4));  // Output: 2.5
//
//        int k = 2;
//        System.out.println("The " + k + "-th largest element is: " + findKthLargest(new int[]{3,2,1,5,6,4}, k));  // Output: 5
//
//        int[] topKFrequentElements = topKFrequentElements(new int[]{1, 1, 1, 2, 2, 3}, 3);
//        System.out.println("topKFrequentElements : " + Arrays.toString(topKFrequentElements));

//        String longestPalindrome = longestPalindrome("babad");
//        System.out.println("longestPalindrome : " + longestPalindrome);

//        int atoi = myAtoi("0-1");
//        System.out.println("atoi : " + atoi);

//        int complement = findComplement(5);
//        System.out.println("complement : " + complement);

//        int firstMissingPositive = firstMissingPositive(new int[]{3,4,-1,1});
//        System.out.println("firstMissingPositive : " + firstMissingPositive);

//        int numSubarrayProductLessThanK = numSubarrayProductLessThanK(new int[]{1, 1, 1}, 2);
//        System.out.println("numSubarrayProductLessThanK : " + numSubarrayProductLessThanK);

//        List<Integer> findDisappearedNumbers = findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
//        System.out.println("findDisappearedNumbers : " + findDisappearedNumbers);

//        int maxProfit = maximumProfit(new int[]{2,1,4});
//        System.out.println("maxProfit : " + maxProfit);

//        int maxSubarrayLength = maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2);
//        System.out.println("maxSubarrayLength : " + maxSubarrayLength);

//        int maxArea = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
//        System.out.println("maxArea : " + maxArea);

        boolean backspaceCompare = backspaceCompare("a#c", "b");
        System.out.println("backspaceCompare : " + backspaceCompare);

    }


    public static boolean backspaceCompare(String s, String t) {
        String s1 = getFinalString(s);
        String s2 = getFinalString(t);

        return s1.equals(s2);
    }

    private static String getFinalString(String s) {
        Stack<Character> characters = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                characters.push(ch);
            } else {
                characters.pop();
            }
        }

        return characters.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static int longestMountain(int[] arr) {
//        int left = 0;
//        int right = arr.length - 1;
//        int h = 1;
//        while (left < right) {
//
//            if(arr[right] < arr[h]) {
//                left++;
//            } else {
//
//            }
//        }
return 0;

    }

    public static int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0; int right = height.length-1;

        while (left < right) {

            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;

//        int left = 0;
//        int right = height.length - 1;
//        int maxArea = 0;
//
//        while (left < right) {
//            int currentArea = Math.min(height[left], height[right]) * (right - left);
//            maxArea = Math.max(maxArea, currentArea);
//
//            if (height[left] < height[right]) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//
//        return maxArea;
    }

    public static int reverseNumber(int num) {
        int rev = 0;
        int sign = num < 0 ? -1 : 1;
        try {
            while (num != 0) {
                int rem = num % 10;
                int div = num / 10;
                rev = Math.addExact(Math.multiplyExact(rev, 10), rem);
                num = div;
            }
        } catch (ArithmeticException e) {
            rev = 0;
        }

        return Math.multiplyExact(rev, sign);
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> positions = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words.length; j++) {

                if(i!=j) {
                    String word1 = words[i];
                    String word2 = words[j];

                    String word = word1 + word2;

                    if(isPalindrome(word)) {
                        positions.add(List.of(i,j));
                    }

                }

            }
        }

        return positions;

    }

    private static boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;

        while (left < right) {
            if(word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /*Given an array arr[] of n integers, construct a Product Array prod[] (of the same size)
    such that prod[i] is equal to the product of all the elements of arr[] except arr[i]
    without using the division.*/
    private static int[] productExceptSelf(int[] inputArr) {

        int n = inputArr.length;
        int[] prod = new int[n];
        Arrays.fill(prod, 1);

        int leftProd = 1;
        for (int i=0; i<n; i++) {
            prod[i] = leftProd;
            leftProd *= inputArr[i];
        }
//        System.out.println("leftProd: " + Arrays.toString(prod));

        int rightProd = 1;
        for(int i=n-1; i>= 0; i--) {
            prod[i] *= rightProd;
            rightProd *= inputArr[i];
        }
//        System.out.println("rightProd: " + Arrays.toString(prod));

        return prod;


    }


    public int[] productExceptSelf2(int[] nums) {

        List<Integer> products = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int prod = getProductExceptSelfI(nums, i);
            products.add(prod);
        }

        return products.stream().mapToInt(i -> i).toArray();

    }

    private int getProductExceptSelfI(int[] nums, int i) {
        int product = 1;
        for (int j = 0; j < nums.length; j++) {
            if(i != j) {
                product *= nums[j];
            }
        }
        return product;
    }

    /*Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    Output: [0, 1]  // Because nums[0] + nums[1] = 2 + 7 = 9*/
    private static int[] twoSumProblem(int[] nums, int target) {
        int[] result = new int[2];
//        Map<Integer, Integer> store = new HashMap<>();
//        Arrays.fill(result,1);
//
//        for (int i=0; i< nums.length; i++) {
//
//            Integer complement = Math.subtractExact(target, nums[i]);
//
//            if(store.containsKey(complement)) {
//                result = new int[] { store.get(complement), i };
//            }
//
//            store.put(nums[i], i);
//
//        }

        for (int pos1=0; pos1< nums.length; pos1++) {
            for (int pos2=0; pos2< nums.length; pos2++) {
                if(pos1 != pos2 && Math.addExact(nums[pos1], nums[pos2]) == target) {
                    return new int[]{pos1, pos2};
                }
            }
        }


        return result;
    }

    /*
    * Given a string, find the length of the longest substring without repeating characters.
    * sliding window technique
    * */
    public static int lengthOfLongestSubstring(String s) {
        // Map to store the last seen index of characters
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0; // start index of the current window

        // Iterate over the characters in the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and within the current window, move the start
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                start = map.get(currentChar) + 1;
            }

            // Update the last seen index of the current character
            map.put(currentChar, end);

            // Update the maximum length of the substring found so far
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    /*
    Given a collection of intervals, merge all overlapping intervals.
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    Output: [[1,6],[8,10],[15,18]]
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        // Edge case: if there are no intervals, return an empty array
        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // List to store the merged intervals
        List<int[]> merged = new ArrayList<>();

        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Iterate through the intervals
        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // If the current interval overlaps with the next interval, merge them
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // If not, add the next interval as a new interval
                currentInterval = interval;
                merged.add(interval);
            }
        }

        // Convert the list of merged intervals to a 2D array and return it
        return merged.toArray(new int[merged.size()][]);
    }

    /*
     * Find the Median of Two Sorted Arrays
     * Problem: Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        Double result = 0d;
        List<Integer> merged = Stream.concat(IntStream.of(nums1).boxed(), IntStream.of(nums2).boxed())
                .sorted().toList();

        int mergedListLength = merged.size();
        int medianPosition = 0;
        if(mergedListLength % 2 == 0) { // Even
            medianPosition = Math.floorDiv(mergedListLength, 2);
            System.out.println("even medianPosition : " + medianPosition);
            result = Math.addExact(merged.get(medianPosition-1), merged.get(medianPosition)) / 2.0;
        } else { // Odd
            medianPosition = Math.floorDiv(mergedListLength, 2);
            System.out.println("odd medianPosition : " + medianPosition);
            result = Double.valueOf(merged.get(medianPosition));
        }

        return result;

    }

    /*
     * The problem of finding the number of distinct ways to climb a staircase
     * where you can take 1 or 2 steps at a time is a classic dynamic programming problem.
     * The key insight is that the number of ways to reach step n is the sum of the ways
     * to reach step n-1 and the ways to reach step n-2.
     */
    public static int climbStairs(int n) {
        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Variables to store the number of ways to reach the last two steps
        int oneStepBefore = 2;
        int twoStepsBefore = 1;
        int allWays = 0;

        // Loop to calculate the number of ways for each step from 3 to n
        for (int i = 3; i <= n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }

        return allWays;
    }

    /*
    Given an integer array nums and an integer k, return the kth largest element in the array.
    int[] nums = {3,2,1,5,6,4};
    int k = 2;
    Output: 5  // Because the second largest element is 5.
     */
    public static int findKthLargest(int[] nums, int k) {
        List<Integer> numsSorted = IntStream.of(nums).boxed().sorted().distinct().toList();
        return numsSorted.get(numsSorted.size() - k);

    }

    public static int[] topKFrequentElements(int[] nums, int k) {

        return IntStream.of(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() >= k)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::valueOf)
                .toArray();

    }

    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if(c == ']' || c == '}' || c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if((c == ']' && top != '[')
                    || (c == '}' && top != '{')
                    || (c == ')' && top != '(')) {

                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int lengthOfLongestPalindrome(String s) {

//        long result = 0;
//
//        Map<Character, Long> countMap = s.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//
//        boolean isFirstOdd = false;
//
//        for (Map.Entry<Character, Long> e : countMap.entrySet()) {
//            char ch = e.getKey();
//            long count = e.getValue();
//
//            result += count;
//
//            if(count % 2 != 0) {
//                result += count;
//
//                if(!isFirstOdd) {
//                    isFirstOdd = true;
//                } else {
//                    result--;
//                }
//            }
//
//        }
//
//        return (int) result;

        Map<Character, Long> hm = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        long ans = 0;
        boolean firstodd=true;
        for(Character key:hm.keySet()) {
            long count = hm.get(key);
            ans+=count;

            if(count % 2 != 0){

                if(firstodd){
                    firstodd=false;
                }
                else{
                    ans-=1;
                }
            }
        }
        return (int) ans;


    }

    public static int myAtoi(String s) {
        String trimmedS = s.trim();
        int sign = trimmedS.startsWith("-") ? -1 : 1;
        String trimmedSWithoutSign = trimmedS.startsWith("-") ? trimmedS.substring(1) : trimmedS;

        try {
            int num = 0;

            if(trimmedSWithoutSign.contains("-")) {
                return 0;
            }

            for(char c : trimmedSWithoutSign.toCharArray()) {
                boolean isDigit = Character.isDigit(c);

                if(isDigit && num <= Integer.MAX_VALUE) {
                    boolean isStartingWithZero = Integer.parseInt(String.valueOf(c)) == 0 && num == 0;
                    if(!isStartingWithZero) {
                        num = (num * 10) + Integer.parseInt(String.valueOf(c));
                    }
                }


            }

            return num * sign;

        } catch (ArithmeticException e) {
            return 0;
        }

    }

    public static int findComplement(int num) {

        String binary = Integer.toBinaryString(num);
        System.out.println("binary : " + binary);

        StringBuilder complementedBinary = new StringBuilder();
        for(char ch : binary.toCharArray()) {
            if(ch == '0') {
                complementedBinary.append('1');
            } else if(ch == '1') {
                complementedBinary.append('0');
            }
        }
        System.out.println("complementedBinary : " + complementedBinary);

        int reversedNumber = Integer.parseInt(complementedBinary.toString(), 2);
        System.out.println("reversedNumber : " + reversedNumber);

        return reversedNumber;
    }

    public static int firstMissingPositive(int[] nums) {
//        int maxN = Arrays.stream(nums).max().getAsInt();
//        List<Integer> numsList = IntStream.of(nums).boxed().toList();
//
//        return IntStream.rangeClosed(1, maxN+1)
//                .boxed()
//                .filter(i -> !numsList.contains(i))
//                .min(Integer::compareTo)
//                .orElse(1);
        List<Integer> numsList = IntStream.of(nums).boxed().filter(i -> i > 0).sorted().distinct().toList();
        int n = 1;
        // 1,4,5
        for (int i=0; i<numsList.size(); i++) {

            if(numsList.get(i) != i+1) {
               n = i+1;
               break;
            }
        }
        return n;
    }

    public static int firstDuplicateNumber(int[] nums) {
        Map<Integer, Long> counts = Arrays.stream(nums).boxed()
//                .filter(i -> i > 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.entrySet()
                .stream().filter(e -> e.getValue() == 0)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);
    }

    public static int maximumProfit(int[] prices) {

//        int totalProfit = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            int stockBoughtAtPrice = nums[i];
//
//            Map<Integer, Integer> profitsWithSoldDay = new HashMap<>();
//            for (int j = i + 1; j < nums.length; j++) {
//                int stockSoldAtPrice = nums[j];
//                int stockPrice = Math.subtractExact(stockSoldAtPrice, stockBoughtAtPrice);
//                profitsWithSoldDay.put(stockPrice, j);
//
//            }
//
//            Optional<Map.Entry<Integer, Integer>> maxProfitEntry = profitsWithSoldDay.entrySet().stream()
//                    .filter(e -> e.getKey() > 0)
//                    .max(Comparator.comparingInt(Map.Entry::getKey));
//
//            if(maxProfitEntry.isPresent()) {
//                Integer maxProfit = maxProfitEntry.map(Map.Entry::getKey).orElse(0);
//                Integer maxProfitDay = maxProfitEntry.map(Map.Entry::getValue).orElse(0);
//                totalProfit += maxProfit;
//                i = maxProfitDay+1;
//            }
//        }
//
//        return totalProfit;

        int stockBuyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1 ; i < prices.length ; i++) {
            if(stockBuyPrice > prices[i]) {
                stockBuyPrice = prices[i];
            }
            int profit = Math.subtractExact(prices[i], stockBuyPrice);
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;

    }

    public static int maximumProfitDay(int[] prices) {

        int buyingPrice = prices[0];
        int maxProfit = 0;
//        int maxProfitDay = 0;

        for (int i = 1; i < prices.length; i++) {
            if(buyingPrice < prices[i]) {
                int profit = Math.subtractExact(prices[i], buyingPrice);
                maxProfit += profit;
            }
            buyingPrice = prices[i];
        }

        return maxProfit;

    }

    public static String fractionAddition(String expression) {



        return "";
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        int len = nums.length;
//        List<Integer> numsList = IntStream.of(nums).boxed().filter(i -> i > 0).sorted().distinct().toList();
//        List<Integer> result = new ArrayList<>();
// 5, 8
//        for (int i = 0; i < numsList.size(); i++) {
//            if(numsList.get(i) != i+1) {
//                result.add(i+1);
//            }
//        }
//        int i = 0;
//        while (i < len) {
//            if(i == numsList.size()) {
//                if(!numsList.contains(i+1)) {
//                    result.add(i+1);
//                }
//                break;
//            }
//            if(numsList.get(i) != i+1) {
//                result.add(i+1);
//            }
//            i++;
//        }
//
//        return result;

        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            if(search(nums, i)) {
                result.add(i);
            }
        }
        return result;

    }

    private static boolean search(int[] nums, int n) {
        boolean isFound = false;
        for (int num : nums) {
            if (num == n) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public int findDuplicate(int[] nums) {
        Map<Integer, Long> count = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return count.entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(0);
    }

    private static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        List<Integer> list = Arrays.stream(nums).boxed().toList();
        List<List<Integer>> allSublists = new ArrayList<>();
        for(int i = 0 ; i <= list.size(); i ++ ) {
            for (int j = i + 1; j <= list.size(); j++) {
                List<Integer> sub = list.subList(i, j);
                BigInteger product = getProduct(sub);
                if(product.intValueExact() < k) {
                    allSublists.add(sub);
                    System.out.println("Sublist : " + sub + " with product : " + product);

                }
//                Optional<Integer> product = sub.stream().reduce((x, y) -> x * y);
//                product.filter(p -> p < k).ifPresent(p -> {
//                    allSublists.add(sub);
//                    System.out.println("Sublist : " + sub + " with product : " + p);
//                });
            }
        }


        return allSublists.size();

    }

    public static BigInteger getProduct(List<Integer> list) {
        BigInteger product = BigInteger.ONE;  // Start with 1, as multiplying by 1 does nothing

        // Multiply each number in the list
        for (Integer num : list) {
            product = product.multiply(BigInteger.valueOf(num));
        }

        return product;
    }

    public static List<List<Integer>> getAllSubLists(List<Integer> list) {
        List<List<Integer>> sublists = new ArrayList<>();

        // Generate all possible sublists
        for (int i = 0; i <= list.size(); i++) {
            for (int j = i + 1; j <= list.size(); j++) {
                List<Integer> sub = list.subList(i, j);
                if(!sub.isEmpty()) {
                    sublists.add(sub);
                }
            }
        }

        // Adding the empty list
        sublists.add(new ArrayList<>());

        return sublists;
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        int start = 0;
        int max = 0;

        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);

            while(frequency.containsKey(nums[end]) && frequency.get(nums[end]) > k) {
                frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) - 1);
                start++;
            }

            max = Math.max(max, end - start + 1);

        }

        return max;


    }

    public static int maxSubarrayLengthIncomplete(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();

        List<List<Integer>> getAllTheSubLists = getAllTheSubLists(list)
                .stream()
                .filter(integers -> integers.size() <= k)
                .toList();

        List<Integer> maxList = Collections.max(getAllTheSubLists, Comparator.comparing(List::size));

        return maxList.size();
    }

    public static List<List<Integer>> getAllTheSubLists(List<Integer> list) {
        List<List<Integer>> subLists = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j <= list.size(); j++) {
                List<Integer> subList = list.subList(i, j);
                if(!subList.isEmpty()) {
                    subLists.add(subList);
                }

            }
        }

        return subLists;
    }
}