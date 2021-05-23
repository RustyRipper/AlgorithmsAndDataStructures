public interface IStack<E> {
    boolean isEmpty();

    boolean isFull();

    E pop() throws EmptyStackException;

    void push(E elem) throws FullStackException;

    int size();

    E top() throws EmptyStackException;

    class EmptyStackException extends Exception {
    }

    class FullStackException extends Exception {
    }


}
