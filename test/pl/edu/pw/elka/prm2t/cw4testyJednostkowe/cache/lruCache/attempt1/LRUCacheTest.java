package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.attempt1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.LRUCacheElement;

class LRUCacheTest {

    @Test
    void put() {
        LRUCache cache = new LRUCache<>(5);
        LRUCacheElement el = new LRUCacheElement(1, "jeden");


        cache.put(el.getKey(), el.getValue());
        assertEquals(cache.getLastRecentlyUsedList(), el.getKey());

    }

    @Test
    void get() {
        // write your code here
    }
}