package Questions.Amazon.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final Map<Class<?>, AtomicInteger> idGenerator = new ConcurrentHashMap<>();

    public static int getNextId(Class<?> clazz) {
        idGenerator.putIfAbsent(clazz, new AtomicInteger(0));
        return idGenerator.get(clazz).incrementAndGet();
    }
}
