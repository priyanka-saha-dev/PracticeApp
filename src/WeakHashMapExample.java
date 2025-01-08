import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {
    public static void main(String[] args) {
        // Create a WeakHashMap
        Map<Object, String> weakMap = new WeakHashMap<>();

        // Create a key object
        Object key = new Object();
        String value = "WeakHashMap Example";

        // Add the key-value pair to the map
        weakMap.put(key, value);

        // Print the map before garbage collection
        System.out.println("Map before GC: " + weakMap);

        // Remove the strong reference to the key
        key = null;

        // Suggest garbage collection
        System.gc();

        // Allow some time for GC to process
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the map after garbage collection
        System.out.println("Map after GC: " + weakMap);
    }
}
