package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache;

import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.CacheElement;

public class LRUCacheElement<K, V> implements CacheElement<K, V> {
    private final K key;
    private final V value;

    public LRUCacheElement<K, V> prev;
    public LRUCacheElement<K, V> next;

        public LRUCacheElement(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
