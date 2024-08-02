import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Samples {

    public static int findTheMissingNumber(int n, int[] array) {

        List<Integer> allNumbers = IntStream.of(1, n).boxed().toList();
        List<Integer> inputs = Arrays.stream(array).boxed().toList();

        Optional<Integer> result = allNumbers.stream().filter(num -> !inputs.contains(num)).findFirst();
        return result.orElse(0);
    }

    public static boolean isPalindrome(String input) {

        String sanitisedInput = input.chars().mapToObj(c -> (char) c)
                .filter(Character::isAlphabetic)
                .map(String::valueOf).collect(Collectors.joining());

        StringBuffer reversedStr = new StringBuffer(sanitisedInput).reverse();

        return reversedStr.toString().equalsIgnoreCase(sanitisedInput);
    }

    public static int foodAvailableInHouses(int r, int unit, int n, int[] food) {
        int totalFoodNeeded = Math.multiplyExact(r, unit);
//        System.out.println("totalFoodNeeded : " + totalFoodNeeded);
        int result = 0;

        int totalFood = 0;
        for (int i = 0; i < food.length - 1; i++) {
//            System.out.println("i : " + i);
            totalFood += food[i];
//            System.out.println("totalFood : " + totalFood);

            if (totalFood >= totalFoodNeeded) {
                result = i + 1;
//                System.out.println("done result : " + result);
                break;
            }
        }


        return result;
    }

    public static char findMaxCharacterInAString(String s) {

//        Set<Character> characters = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
//        List<Character> charactersAll = s.chars().mapToObj(c -> (char) c).toList();
//        Map<Character, Long> counts = new HashMap<>();
//
//        //s = ssab
//        //cs = s,a,b
//        characters.forEach(c -> {
//            long count = charactersAll.stream().filter(ca -> ca == c).count();
//            counts.put(c, count);
//        });
//
//        Character result1 = Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
//        System.out.println(result1);
//        return result1;

        Map<Character, Long> characterCount = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return Collections.max(characterCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static List<String> fizzbuzz(int n) {

        List<String> results = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String result = "";

            if (i % 3 == 0 && i % 5 == 0) {
                result = "fizzbuzz";
            } else if (i % 3 == 0) {
                result = "fizz";
            } else if (i % 5 == 0) {
                result = "buzz";
            } else {
                result = String.valueOf(i);
            }

            results.add(result);

        }

        return results;
    }

    public static List<Integer> getRandomIntegers(int n, int size) {

        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.ints(size, 0, n).boxed().collect(Collectors.toList());

    }

    public static List<Integer> filterAndSquare(List<Integer> numbers) {
        // Complete the implementation
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> Math.multiplyExact(n, n))
                .collect(Collectors.toList());
    }

//    public List<Future<String>> executeTasks(List<Callable<String>> tasks) {
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        try {
//            return executor.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new RuntimeException("Task execution interrupted", e);
//        } finally {
//            executor.shutdown();
//        }
//    }

    // Fill in the gaps to create a custom comparator that sorts a list of strings by their length,
    // and then alphabetically for strings of the same length.
    // [kiwi, pear, plum, apple, banana]
    public static List<String> customSorting(List<String> strings) {
        strings.sort(Comparator.comparing(String::length).thenComparing(String::toString).reversed());
        return strings;
    }

    //Fill in the gaps to count the number of occurrences of each character in a string using the Stream API.
    public static Map<Character, Long> countCharacterOccurrences(String input) {
        return input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static <T> List<T> mergeLists(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }

    public static List<Character> findUniqueCharacters(List<String> words) {
        return words.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .distinct().collect(Collectors.toList());
    }

    public static String reverseWords(String sentence) {
        List<String> words = Stream.of(sentence.split(" ")).collect(Collectors.toList());
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(Samples::isEven).mapToInt(Integer::intValue).sum();
    }

    public static int sumOfEvenNumbersForN(int n) {
        return IntStream.range(0, n).filter(Samples::isEven).sum();
    }

    public static List<String> sortByLengthAscending(List<String> words) {
        return words.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static Map<Character, Long> countsByFirstLetter(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
    }

    public static Optional<Integer> findMaxValue(List<Integer> nums) {
        return nums.stream().max(Integer::compareTo);
    }

    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static int fibonacci(int n) {
        if(n == 0){
            return n;
        }
        int a= 0, b = 1, c;
        for (int i=1; i<=n; i++) {
            c = a + b;
            a = b;
            b = a;
        }
        return b;
    }

    public static Set<Integer> findDuplicates(List<Integer> nums) {
        Map<Integer, Long> counts = nums.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts.entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    public static boolean isPallindrome(String word) {
        StringBuffer reverse = new StringBuffer(word);
        reverse.reverse();
        return reverse.toString().equalsIgnoreCase(word);
    }

    public static int calculateTotalWordLength(List<String> words) {
        return words.stream().mapToInt(String::length).sum();
    }

    public static Map<Boolean, List<Integer>> partitionByEvenOdd(List<Integer> nums) {
        return nums.stream().collect(Collectors.partitioningBy(Samples::isEven));
    }

    public static Optional<Integer> findMaxEvenNumber(List<Integer> nums) {
        return nums.stream().filter(Samples::isEven).max(Integer::compareTo);
    }

    public static Integer findMaxLength(List<Integer> nums) {
        return Collections.max(nums, Comparator.comparingInt(i -> String.valueOf(i).length()));
    }

    public static List<Integer> sortAscending(List<Integer> nums) {
        return nums.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    }

    public static boolean isEven(int n) {
        return n%2==0;
    }

}
