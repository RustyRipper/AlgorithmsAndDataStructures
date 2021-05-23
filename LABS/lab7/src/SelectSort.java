import java.util.Comparator;

public class SelectSort {
    private final Comparator<Integer> comparator;

    public SelectSort() {
        comparator = (o1, o2) -> o1 - o2;
    }

    public int[] sort(int[] tablica) {
        int size = tablica.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check)
                if (comparator.compare(tablica[check], tablica[smallest]) < 0)
                    smallest = check;
            swap(tablica, smallest, slot);
        }
        return tablica;
    }

    private void swap(int[] list, int left, int right) {
        if (left != right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}