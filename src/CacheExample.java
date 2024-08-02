import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CacheExample {

    private static Map<String, SoftReference<LargeObject>> cache = new HashMap<>();

    public static LargeObject getFromCache(String key) {
        SoftReference<LargeObject> ref = cache.get(key);
        LargeObject largeObject = Optional.ofNullable(ref).map(SoftReference::get).orElse(new LargeObject());
        cache.put(key, new SoftReference<>(largeObject));
        return largeObject;
    }

    public static void main(String[] args) {
        LargeObject obj1 = getFromCache("key1");
        System.out.println(obj1);
        LargeObject obj2 = getFromCache("key1");
        System.out.println(obj2);
    }
}

class LargeObject {
    private byte[] data = new byte[10 * 1024 * 1024]; // 10 MB
}