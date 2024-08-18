import java.util.stream.IntStream;

public class IntStreamTest {

    public static void main(String[] args) {
        int n = 5;
        IntStream.range(0, n).forEach(System.out::println);
    }
}
