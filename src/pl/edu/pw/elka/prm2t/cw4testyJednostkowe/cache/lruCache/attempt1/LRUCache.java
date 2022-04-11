package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.attempt1;

import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.Cache;
import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.LRUCacheElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static pl.edu.pw.elka.prm2t.PRM2TUtil.prn;

public class LRUCache<K, V> implements Cache<K, V>, Iterable<K> {
    private final int maxSize;

    private final LastRecentlyUsedLinkedList<K, V> lastRecentlyUsedList;
    private final Map<K, LRUCacheElement<K, V>> map;

    public LastRecentlyUsedLinkedList<K, V> getLastRecentlyUsedList() {
        return lastRecentlyUsedList;
    }

    public Map<K, LRUCacheElement<K, V>> getMap() {
        return map;
    }

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        lastRecentlyUsedList = new LastRecentlyUsedLinkedList<>();
        map = new HashMap<>(maxSize);
    }

    @Override
    public Iterator<K> iterator() {
        return lastRecentlyUsedList.iterator();
    }

    @Override
    public boolean put(K key, V value) {
        LRUCacheElement<K, V> node = map.get(key);
        if (node != null) { // cache hit!
            lastRecentlyUsedList.moveToFront(node);
            return true;
        }
        // cache miss!
        if (map.size() >= maxSize) { // cache full!
            LRUCacheElement<K, V> last = lastRecentlyUsedList.removeLast();
            map.remove(last.getKey());
        }
        node = new LRUCacheElement<>(key, value);
        map.put(key, node);
        lastRecentlyUsedList.insertAsFirst(node);
        return false;
    }

    @Override
    public V get(K key) {
        LRUCacheElement<K, V> node = map.get(key);
        if (node != null) {
            lastRecentlyUsedList.moveToFront(node);
            return node.getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        return lastRecentlyUsedList.toString();
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        prn("cache: %s", cache);
        cache.put("1", "11");
        prn("cache: %s", cache);
        cache.put("2", "22");
        prn("cache: %s", cache);
        cache.put("3", "33");
        prn("cache: %s", cache);
        cache.put("4", "44");
        prn("cache: %s", cache);
        prn("cache.get(\"1\"): %s", cache.get("1"));
        prn("cache: %s", cache);
        prn("cache.get(\"1\"): %s", cache.get("1"));
        prn("cache: %s", cache);
    }
}