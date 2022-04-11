package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache;

/**
 * Represents any object that can be stored in a cache memory.
 * @param <V> type of the objects stored in the cache.
 */
public interface Value<V> {
    V getValue();
}
