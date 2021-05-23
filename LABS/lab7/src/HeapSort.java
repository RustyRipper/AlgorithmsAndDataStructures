import java.util.Comparator;

public class HeapSort {
    Comparator<Integer> comparator;

    public HeapSort() {
        comparator = (o1, o2) -> o1 - o2;
    }

    private void swap(int[] tablica, int left, int right) {
        int temp = tablica[left];
        tablica[left] = tablica[right];
        tablica[right] = temp;

    }

    public void sink(int[] tablica, int index, int n) {
        int idxOfBigger = 2 * index + 1;
        if (idxOfBigger < n) {
            if (idxOfBigger + 1 < n && comparator.compare(tablica[idxOfBigger], tablica[idxOfBigger + 1]) < 0)
                idxOfBigger++;
            if (comparator.compare(tablica[index], tablica[idxOfBigger]) < 0) {
                swap(tablica, index, idxOfBigger);
                sink(tablica, idxOfBigger, n);
            }
        }
    }

    void heapAdjustment(int[] tablica, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            sink(tablica, i, n);
    }


    public int[] sort(int[] tablica) {
        heapsort(tablica, tablica.length);
        return tablica;
    }

    private void heapsort(int[] tablica, int n) {
        heapAdjustment(tablica, n);
        for (int i = n - 1; i > 0; i--) {
            swap(tablica, i, 0);
            sink(tablica, 0, i);
        }
    }
}
