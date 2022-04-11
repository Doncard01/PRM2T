package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.attempt2;

import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.Cache;
import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.LRUCacheElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static pl.edu.pw.elka.prm2t.PRM2TUtil.prn;

/**
 * Implementation of a Last Recently Used cache policy.
 *
 * Cache can be iterated over the keys.
 *
 * @param <K> Type of keys of objects stored int the cache.
 * @param <V> Type of objects associated with the keys and stored in the cache.
 */
public class LRUCache<K, V> implements Cache<K, V>, Iterable<K> {
    private final int maxSize;

    private LRUCacheElement<K, V> head;
    private LRUCacheElement<K, V> tail;
    private final Map<K, LRUCacheElement<K, V>> cache;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        cache = new HashMap<>(maxSize);
    }

    @Override
    public boolean put(K key, V value) {
        LRUCacheElement<K, V> node = cache.get(key);
        if (node != null) { // cache hit!
            moveToFront(node);
            return true;
        }
        // cache miss!
        if (cache.size() >= maxSize) { // cache full!
            LRUCacheElement<K, V> last = removeLast();
            cache.remove(last.getKey());
        }
        node = new LRUCacheElement<>(key, value);
        cache.put(key, node);
        insertAsFirst(node);
        return false;
    }

    @Override
    public V get(K key) {
        LRUCacheElement<K, V> node = cache.get(key);
        if (node != null) {
            moveToFront(node);
            return node.getValue();
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private LRUCacheElement<K, V> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public K next() {
                K returnValue = current.getKey();
                current = current.next;
                return returnValue;
            }
        };
    }

    void insertAsFirst(LRUCacheElement<K, V> node) {
        if (head == null) { // list empty
            head = tail = node;
            return;
        }
        head.prev = node;
        node.prev = null;
        node.next = head;
        head = node;
    }

    void moveToFront(LRUCacheElement<K, V> node) {
        if (node == head) { // already at the front!
            return;
        }
        if (node == tail) { // at the tail
            tail = tail.prev;
            tail.next = null;
            node.next = head;
            node.prev = null;
        }
        LRUCacheElement<K, V> nodePrev = node.prev;
        LRUCacheElement<K, V> nodeNext = node.next;
        if (nodePrev != null) {
            nodePrev.next = nodeNext;
        }
        if (nodeNext != null) {
            nodeNext.prev = nodePrev;
        }
        //node.prev.next = node.next;
        //node.next.prev = node.prev;
        insertAsFirst(node);
    }

    LRUCacheElement<K, V> removeLast() {
        if (tail == null) { // list empty!
            return null;
        }
        LRUCacheElement<K, V> last = tail;
        if (tail == head) { // one element in the list!
            tail = head = null;
            return last;
        }
        tail.prev.next = null;
        tail = tail.prev;
        return last;
    }

    @Override
    public String toString() {
        StringBuilder rv = new StringBuilder("{");
        for (K key : this) {
            rv.append(key).append(", ");
        }
        if (cache.size() > 0) {
            rv.deleteCharAt(rv.length() - 1);
            rv.deleteCharAt(rv.length() - 1);
        }
        rv.append("}");
        return rv.toString();
    }

    public static void main(String[] args) {
        LRUCache<String, String> list = new LRUCache<>(6);
        LRUCacheElement<String, String>[] nt = new LRUCacheElement[6];
        prn("list: %s", list);
        list.insertAsFirst(nt[0] = new LRUCacheElement<>("1", "11"));
        prn("list: %s", list);
        list.insertAsFirst(nt[1] = new LRUCacheElement<>("2", "22"));
        prn("list: %s", list);
        list.insertAsFirst(nt[2] = new LRUCacheElement<>("3", "33"));
        prn("list: %s", list);

        list.moveToFront(nt[1]);
        prn("list: %s", list);

        list.removeLast();
        prn("list: %s", list);
        list.removeLast();
        prn("list: %s", list);
        list.removeLast();
        prn("list: %s", list);
    }
}
