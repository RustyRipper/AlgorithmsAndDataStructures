public class ArrayStack<T> implements IStack<T> {


    private static final int DOMYSLNA_WIELKOSC = 100;

    private T[] tablica;
    private int topIndex;

    @SuppressWarnings("unchecked")
    public ArrayStack(int wielkosc) {
        setTablica((T[]) (new Object[wielkosc]));
        topIndex = 0;
    }

    public ArrayStack() {
        this(DOMYSLNA_WIELKOSC);
    }


    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return topIndex == getTablica().length;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return getTablica()[--topIndex];
    }

    @Override
    public void push(T elem) throws FullStackException {
        if (isFull())
            throw new FullStackException();
        getTablica()[topIndex++] = elem;
    }

    @Override
    public int size() {
        return topIndex;
    }

    @Override
    public T top() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return getTablica()[topIndex - 1];
    }

    @SuppressWarnings("unchecked")
    public void odwrocStos() throws EmptyStackException {
        T[] tablica2 = (T[]) new Object[topIndex];
        int w = topIndex;
        for (int i = 0; i < w; i++) {
            tablica2[i] = pop();

        }

        setTablica(tablica2);
        topIndex = getTablica().length;

    }

    public T[] getTablica() {
        return tablica;
    }

    public void setTablica(T[] tablica) {
        this.tablica = tablica;
    }
}
