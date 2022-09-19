package sukai.bestjavapractice;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author chengsukai
 * @since 2022-09-19 10:15
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // eliminate obsolete reference
        return elements[--size];
    }

    /**
     * Returns the element at the specified int this list.
     *
     * <p>This method is <i>not</i> guaranteed to run int constant
     * time. In some implementations it may run in time proportional
     * to the element position.
     * </p>
     *
     * @param index index of element to return; must be
     *              non-negative and less than the size of this list
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range({@code index < 0 || index >= this.size()})
     */
    Object get(int index) {
        return elements[index];
    }

    /**
     * 扩容
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
