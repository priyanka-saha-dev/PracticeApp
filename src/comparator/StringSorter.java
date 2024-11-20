package comparator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringSorter {

    public static void main(String[] args) {

        Comparator<String> comparator = Comparator
                .comparingInt(String::length)
                .reversed()
                .thenComparing(String::compareTo);

        List<String> strings = Stream.of("Apple", "Mango", "Banana", "Kiwis", "Orange", "Berry")
                .sorted(comparator)
                .collect(Collectors.toList());
        //strings.sort(comparator);

        System.out.println("Sorted items");
        System.out.println(strings);
    }
}
