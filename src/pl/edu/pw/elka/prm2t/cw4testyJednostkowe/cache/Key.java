package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache;

/**
 * Represents any object that can return its unique key among all the objects of the implementing class.
 * @param <K> type of the key.
 */
public interface Key<K> {
    /**
     * @return the key of the object that must be unique among all object of implementing class.
     */
    K getKey();
}
