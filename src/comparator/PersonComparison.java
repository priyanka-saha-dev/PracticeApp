package comparator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonComparison {

    public static void main(String[] args) {

        List<Person> persons = Stream.of(new Person("P1", 30), new Person("P2", 40)).collect(Collectors.toList());
        Comparator<Person> nameAgeComparator = Comparator.comparing(Person::age).thenComparing(Person::age);
        System.out.println("Unsorted :: " + persons);
        persons.sort(nameAgeComparator);
        System.out.println("Sorted :: " + persons);

    }

}

record Person(String name, Integer age) {}