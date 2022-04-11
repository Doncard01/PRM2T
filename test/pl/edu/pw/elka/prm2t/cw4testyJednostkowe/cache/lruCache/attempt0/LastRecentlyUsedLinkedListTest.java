package pl.edu.pw.elka.prm2t.cw4testyJednostkowe.cache.lruCache.attempt0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LastRecentlyUsedLinkedListTest {

    private LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> createNode(String item) {
        return new LastRecentlyUsedDoubleLinkedList.LRUDLLNode<>(item);
    }

    @Test
    void createTest() {
        LastRecentlyUsedDoubleLinkedList<String> l = new LastRecentlyUsedDoubleLinkedList<>(); // empty list
        assertNull(l.head);
        assertNull(l.tail);
    }

    @Test
    void insertOneNodeTest() {
        createTest();
        LastRecentlyUsedDoubleLinkedList<String> l = new LastRecentlyUsedDoubleLinkedList<>(); // empty list
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node1 = createNode("123");
        l.insertAsFirst(node1);
        assertEquals(node1, l.head);
        assertEquals(node1, l.tail);
        assertNull(node1.prev);
        assertNull(node1.next);

    }

    @Test
    void insertAsFirst() {
        LastRecentlyUsedDoubleLinkedList<String> l = new LastRecentlyUsedDoubleLinkedList<>(); // empty list
        assertEquals(0, l.size);
        assertNull(l.head);
        assertNull(l.tail);

        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node1 = createNode("1");
        l.insertAsFirst(node1);
        assertEquals(node1, l.head);
        assertEquals(node1, l.tail);
        assertNull(node1.prev);
        assertNull(node1.next);

        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node2 = createNode("2");
        l.insertAsFirst(node2);
        assertEquals(node2, l.head);
        assertEquals(node1, l.tail);
        assertNull(l.head.prev);
        assertEquals(l.head.next, node1);
        assertNull(l.tail.next);
    }

    @Test
    void moveToFront() {
        LastRecentlyUsedDoubleLinkedList<String> l = new LastRecentlyUsedDoubleLinkedList<>(); // empty list
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node1 = createNode("1");
        l.insertAsFirst(node1);
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node2 = createNode("2");
        l.insertAsFirst(node2);
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node3 = createNode("3");
        l.insertAsFirst(node3);

        l.moveToFront(node1);
        assertEquals(node1, l.head);
        assertEquals(node3, l.head.next);
        assertNull(l.head.prev);
        assertEquals(node3, l.tail.prev);
        assertNull(l.tail.next);
        assertEquals(node1, node3.prev);
        assertEquals(node2, node3.next);
    }

    @Test
    void removeLast() {
        LastRecentlyUsedDoubleLinkedList<String> l = new LastRecentlyUsedDoubleLinkedList<>(); // empty list
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node1 = createNode("1");
        l.insertAsFirst(node1);
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node2 = createNode("2");
        l.insertAsFirst(node2);
        LastRecentlyUsedDoubleLinkedList.LRUDLLNode<String> node3 = createNode("3");
        l.insertAsFirst(node3);

        l.removeLast();
        assertEquals(l.head, node3);
        assertEquals(l.tail, node2);
        assertEquals(node2.prev, node3);
        assertEquals(node3.next, node2);
        assertNull(node2.next);
        assertNull(node3.prev);
    }

    @Test
    void testToString() {
    }
}