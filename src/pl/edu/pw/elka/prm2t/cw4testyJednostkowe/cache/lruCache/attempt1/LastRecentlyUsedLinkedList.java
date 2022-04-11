package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.attempt1;

import pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.LRUCacheElement;

import java.util.Iterator;

import static pl.edu.pw.elka.prm2t.PRM2TUtil.prn;

/**
 * A specialized linked list with {@code insertAsFirst}, {@code moveToFront}, {@code removeLast} operations.
 * @param <K>
 * @param <V>
 */
class LastRecentlyUsedLinkedList<K, V> implements Iterable<K> {
    private LRUCacheElement<K, V> head;
    private LRUCacheElement<K, V> tail;
    private int size;

    void insertAsFirst(LRUCacheElement<K, V> node) {
        size++;
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
        size--;
        insertAsFirst(node);
    }

    LRUCacheElement<K, V> removeLast() {
        if (tail == null) { // list empty!
            return null;
        }
        size--;
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
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private LRUCacheElement<K, V> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public K next() {
                final K currentKey = current.getKey();
                current = current.next;
                return currentKey;
            }
        };
    }

    public String toString() {
        StringBuilder rv = new StringBuilder("{");
        for (K key : this) {
            rv.append(key).append(", ");
        }
        if (size > 0) {
            rv.deleteCharAt(rv.length() - 1);
            rv.deleteCharAt(rv.length() - 1);
        }
        rv.append("}");
        return rv.toString();
    }

    public static void main(String[] args) {
        LastRecentlyUsedLinkedList<String, String> list = new LastRecentlyUsedLinkedList<>();
        LRUCacheElement<String, String>[] nt = new LRUCacheElement[3];
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
