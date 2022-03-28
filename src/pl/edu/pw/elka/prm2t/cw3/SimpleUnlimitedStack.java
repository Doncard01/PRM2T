package pl.edu.pw.elka.prm2t.cw3;
/**
 * Adam Staciwa, Radosław Szawłowski
 * @author
 */

import static pl.edu.pw.elka.prm2t.cw3.PRM2TUtil.prn;

public class SimpleUnlimitedStack<ItemType> {
    public static final int currentSize = 4;

    private ItemType[] stack = (ItemType[]) new Object[currentSize];

    private int top = 0; //konwencja: pierwsza wolna komórka

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }



    public void push(ItemType item) {
        if (top == stack.length) {

            int dlugosc = stack.length;
            dlugosc*=1.75;
            int newSize = stack.length + dlugosc;

            ItemType[] newStack = (ItemType[]) new Object[newSize];
            for (int i=0; i<stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
            newStack = null;
        }

        stack[top++] = item;
    }

    public ItemType pop() {
        if (isEmpty()) {
            throw new StackEmptyException("stack is empty, maxSize=" + currentSize);
        }
        ItemType item = stack[--top];
        stack[top] = null; //na potrzeby sprzątania
        return item;
    }

    public static void main(String... args) {
        SimpleUnlimitedStack<String> stack = new SimpleUnlimitedStack<>();
        stack.push("Napis");
        stack.push("element drugi");
        stack.push("trzeci element");
        stack.push("czwarty element");
        stack.push("piąty element");
        stack.push("szósty element");
        stack.push("siódmy element");

        while (!stack.isEmpty()) {
            prn("zdjęto ze stosu: [%s]", stack.pop());
        }
    }
}
