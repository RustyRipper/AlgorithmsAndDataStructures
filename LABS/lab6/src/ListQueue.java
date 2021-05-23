public class ListQueue<E> implements IQueue<E> {
    OneWayLinkedListWithHeadTail<E> list;

    public ListQueue() {
        list = new OneWayLinkedListWithHeadTail<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        E value = list.remove(0);
        if (value == null) throw new EmptyQueueException();
        return value;
    }

    @Override
    public void enqueue(E elem) throws FullQueueException {
        list.add(elem);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E first() throws EmptyQueueException {
        E value = list.get(0);
        if (value == null) throw new EmptyQueueException();
        return value;
    }


    public void wyswietl() {
        for(E e:list){
            System.out.println(e);
        }
    }
}
