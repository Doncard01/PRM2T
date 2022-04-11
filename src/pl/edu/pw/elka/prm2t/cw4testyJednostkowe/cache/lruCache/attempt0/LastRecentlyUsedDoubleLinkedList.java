package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.attempt0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static pl.edu.pw.elka.prm2t.PRM2TUtil.prn;

/**
 * A specialized double linked list with {@code insertAsFirst}, {@code moveToFront}, {@code removeLast} operations
 * implemented in constant time. All operations work with list nodes, not with object stored in the list.
 * @param <T>
 */
class LastRecentlyUsedDoubleLinkedList<T> implements Iterable<T> {

    static class LRUDLLNode<T> {
        LRUDLLNode<T> prev;
        final T value;
        LRUDLLNode<T> next;

        LRUDLLNode(T value) {
            this.value = value;
        }
    }

    public LRUDLLNode<T> getHead() {
        return head;
    }

    LRUDLLNode<T> head;
    LRUDLLNode<T> tail;
    int size;

    void insertAsFirst(LRUDLLNode<T> node) {
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

    void moveToFront(LRUDLLNode<T> node) {
        if (node == head) { // already at the front!
            return;
        }
        if (node == tail) { // at the tail
            tail = tail.prev;
            tail.next = null;
            node.next = head;
            node.prev = null;
        }

        LRUDLLNode<T> nodePrev = node.prev;
        LRUDLLNode<T> nodeNext = node.next;
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

    LRUDLLNode<T> removeLast() {
        if (tail == null) { // list empty!
            return null;
        }
        size--;
        LRUDLLNode<T> last = tail;
        if (tail == head) { // one element in the list!
            tail = head = null;
            return last;
        }
        tail.prev.next = null;
        tail = tail.prev;
        return last;
    }

    /**
     * @return current size (i.e. number of nodes) of the list.
     */
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private LRUDLLNode<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                final T currentValue = current.value;
                current = current.next;
                return currentValue;
            }
        };
    }

    public String toString() {
        StringBuilder rv = new StringBuilder("{");
        for (T v : this) {
            rv.append(v).append(", ");
        }
        if (size > 0) {
            rv.deleteCharAt(rv.length() - 1);
            rv.deleteCharAt(rv.length() - 1);
        }
        rv.append("}");
        return rv.toString();
    }

    public static void main(String[] args) {
        LastRecentlyUsedDoubleLinkedList<String> list = new LastRecentlyUsedDoubleLinkedList<>();
        List<LRUDLLNode<String>> nt = new ArrayList<>();
        prn("list: %s", list);
        nt.add(new LRUDLLNode<>("0"));
        list.insertAsFirst(nt.get(0));
        prn("list: %s", list);
        nt.add(new LRUDLLNode<>("1"));
        list.insertAsFirst(nt.get(1));
        prn("list: %s", list);
        nt.add(new LRUDLLNode<>("2"));
        list.insertAsFirst(nt.get(2));
        prn("list: %s", list);

        list.moveToFront(nt.get(1));
        prn("list: %s", list);

        list.removeLast();
        prn("list: %s", list);
        list.removeLast();
        prn("list: %s", list);
        list.removeLast();
        prn("list: %s", list);
    }
}
