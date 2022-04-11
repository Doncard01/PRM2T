package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache;

/**
 * Represents any cache memory (which is faster than the main memory) with put and get operations.
 * @param <K> The type of the key of the element stored in the memory.
 * @param <V> The type of the value of the element stored in the memory.
 */
public interface Cache<K, V> {

    /**
     * Puts the value into cache, associating it with the given key.
     * @param key the key to be associated with the value.
     * @param value the value stored in memory.
     * @return {@code true} if the value with the specified key already exists in memory, i.e. it was a cache hit.
     */
    boolean put(K key, V value);

    /**
     * Retrieves the value associated with the given key.
     * @param key the key of the needed value.
     * @return the value associated with the given key or {@code null} if there is no value associated with
     * the given key (it was a cache miss).
     */
    V get(K key);
}
