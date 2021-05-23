import java.util.AbstractList;
import java.util.Iterator;

public class OneWayLinkedListWithHeadTail<E> extends AbstractList<E> {

    private class Element {
        private E value;
        private Element next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(E data) {
            this.value = data;
        }
    }

    Element head = null;
    Element tail = null;

    public OneWayLinkedListWithHeadTail() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }


    @Override
    public int size() {
        int pos = 0;
        Element actElem = head;
        while (actElem != null) {
            pos++;
            actElem = actElem.getNext();
        }
        return pos;
    }

    private Element getElement(int index) {
        Element actElem = head;
        while (index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }
        return actElem;
    }

    public boolean add(E e) {
        Element newElem = new Element(e);
        if (head == null) {
            head = newElem;
            tail = newElem;
            return true;
        }

        tail.setNext(newElem);
        tail = newElem;
        return true;
    }

    @Override
    public E get(int index) {
        Element actElem = getElement(index);
        return actElem == null ? null : actElem.getValue();
    }

    public E remove(int index) {
        if (head == null)
            return null;
        if (index == 0) {
            E retValue = head.getValue();
            head = head.getNext();
            return retValue;
        }
        Element actElem = getElement(index - 1);
        if (actElem == null || actElem.getNext() == null)
            return null;

        E retValue = actElem.getNext().getValue();
        if (index == size() - 1) {
            tail = actElem;
        }
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }


    private class InnerIterator implements Iterator<E> {
        Element actElem;

        public InnerIterator() {
            actElem = head;
        }

        @Override
        public boolean hasNext() {
            return actElem != null;
        }

        @Override
        public E next() {
            E value = actElem.getValue();
            actElem = actElem.getNext();
            return value;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }


}
