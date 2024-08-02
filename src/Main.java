import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        int missingNumber = Samples.findTheMissingNumber(8, new int[]{1, 2, 4, 6, 3, 7, 8});
//        System.out.println("missingNumber : " + missingNumber);
//
//        boolean isPalindrome = Samples.isPalindrome("A man, a plan, a canal, Panama");
//        System.out.println("isPalindrome : " + isPalindrome);

//        int foodAvailableInHouses = Samples.foodAvailableInHouses(7, 2, 8, new int[]{2,8,3,5,7,4,1,2});
//        System.out.println("foodAvailableInHouses : " + foodAvailableInHouses);

//        char findMaxCharacterInAString = Samples.findMaxCharacterInAString("ssab");
//        System.out.println("findMaxCharacterInAString : " + findMaxCharacterInAString);

//        List<String> fizzbuzz = Samples.fizzbuzz(15);
//        System.out.println("fizzbuzz : " + fizzbuzz);

//        List<Integer> getRandomIntegers = Samples.getRandomIntegers(15, 4);
//        System.out.println("getRandomIntegers : " + getRandomIntegers);
//
//        List<Integer> filterAndSquare = Samples.filterAndSquare(Arrays.asList(10, 5, 8, 9, 2, 3));
//        System.out.println("filterAndSquare : " + filterAndSquare);

//        int x = 5;
//        x = x++ * 2;
//        System.out.println(x);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        Collections.rotate(numbers, 2);
//        System.out.println(numbers);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> subList = numbers.subList(1, 4);
//        numbers.set(2, 10);
//        System.out.println(subList);

//        Map<String, Integer> map = new HashMap<>();
//        map.put("a", 1);
//        map.put("b", 2);
//        map.put("c", 3);
//        map.computeIfAbsent("d", k -> 4);
//        map.computeIfPresent("a", (k, v) -> v + 5);
//        map.putIfAbsent("e",10);
//        System.out.println(map);

//        int[] arr = {1, 2, 3, 4, 5};
//        for (int i = 0; i < arr.length; i++) {
//            if (i % 2 == 0) {
//                continue;
//            }
//            System.out.println(i + " == " + arr[i]);
//        }

//        for (int i = 1; i <= 10; i++) {
//            if (i % 2 == 0) {
//                continue; // Skip the rest of the loop for even numbers
//            }
//            System.out.println(i); // This will only print odd numbers
//        }

//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        System.out.println(queue.peek());
//        queue.remove();
//        System.out.println(queue.peek());

//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//        Integer productOfEven = numbers.stream()
//                .filter(num -> num % 2 == 0)
//                .reduce(1, (a, b) -> a * b);
//        System.out.println(productOfEven); // Output: 48

//        List<String> customSorting = Samples.customSorting(Arrays.asList("apple", "banana", "plum", "pear", "kiwi"));
//        System.out.println("customSorting : " + customSorting);

//        Map<Character, Long> countCharacterOccurrences = Samples.countCharacterOccurrences("hello world");
//        System.out.println("countCharacterOccurrences : " + countCharacterOccurrences);
//
//        List<String> words = List.of("hello", "world");
//        List<Character> findUniqueCharacters = Samples.findUniqueCharacters(words);
//        System.out.println("findUniqueCharacters : " + findUniqueCharacters);

//        NavigableSet<Integer> set = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5));
//        NavigableSet<Integer> headSet = set.headSet(4, true);
//        headSet.add(6);
//        System.out.println(set);
//
//        Stream<String> stream = Stream.of("apple", "banana", "cherry");
//        stream.sorted().forEach(System.out::println);
//
//        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
//        int sum = Arrays.stream(matrix)
//                .flatMapToInt(Arrays::stream)
//                .sum();
//        System.out.println(sum);

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.computeIfAbsent("four", k -> 4);
        map.computeIfPresent("two", (k, v) -> v + 1);
        System.out.println(map);


    }
}