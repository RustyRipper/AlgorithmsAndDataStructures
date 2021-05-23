import java.util.Comparator;

public class BubbleSort {
    private final Comparator<Integer> comparator;

    public BubbleSort() {
        comparator = (o1, o2) -> o1 - o2;
    }

    public int[] sort(int[] tablica) {
        int size = tablica.length;
        for (int i = 1; i < size; ++i) {
            for (int left = 0; left < (size - i); ++left) {
                int right = left + 1;
                if (comparator.compare(tablica[left], tablica[right]) > 0)
                    swap(tablica, left, right);
            }
        }
        return tablica;
    }

    private void swap(int[] tablica, int left, int right) {
        if (left != right) {
            int temp = tablica[left];
            tablica[left] = tablica[right];
            tablica[right] = temp;
        }
    }
}
