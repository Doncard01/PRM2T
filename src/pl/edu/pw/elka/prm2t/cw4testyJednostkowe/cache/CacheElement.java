package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache;

/**
 * Represents a pair of key and value to address data in the cache.
 * @param <K> Type of the key.
 * @param <V> Type of the value (object stored in the cache).
 */
public interface CacheElement<K, V> extends Key<K>, Value<V> {

    @Override
    K getKey();

    @Override
    V getValue();
}
