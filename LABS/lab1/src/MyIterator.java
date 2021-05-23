import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {

    private T tablica[];
    private int pozycja = 0;

    public MyIterator(T tablica[]) {
        this.tablica = tablica;
    }

    @Override
    public boolean hasNext() {
        return pozycja < tablica.length;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext())
            return tablica[pozycja++];
        else
            throw new NoSuchElementException();
    }
}
