package Questions.Facebook.Util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final Map<Class<?>, AtomicInteger> idMap = new ConcurrentHashMap<>();

    public static int getNextId(Class<?> clazz) {
        idMap.putIfAbsent(clazz, new AtomicInteger(0));
        return idMap.get(clazz).incrementAndGet();
    }

}
