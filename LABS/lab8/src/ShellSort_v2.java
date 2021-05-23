import java.util.Comparator;

public class ShellSort_v2 {


    private final Comparator<Integer> comparator;
    private int[] tablica_h;

    public ShellSort_v2(int[] tablica_h) {
        this.tablica_h = tablica_h;
        comparator = (o1, o2) -> o1 - o2;
    }

    public int[] sort(int[] tablica) {

        for (int i = 0; i < tablica_h.length; ++i) {
            int h = tablica_h[i];
            sortH(tablica, h);
        }
        return tablica;
    }

    private void sortH(int[] tablica, int h) {
        if (tablica.length < h * 2) {
            return;
        }
        for (int i = 0; i < h; ++i) {
            if (h == 1) {
                sortBubble(tablica);
            } else sortMinTab(tablica, i, h);
        }
    }

    private void sortMinTab(int[] tablica, int startIndex, int h) {
        for (int i = startIndex + h; i < tablica.length; i += h) {
            int value = tablica[i];
            int j;
            for (j = i; j > startIndex; j -= h) {
                int previousValue = tablica[j - h];
                if (comparator.compare(value, previousValue) >= 0) {
                    break;
                }
                tablica[j] = previousValue;

            }
            tablica[j] = value;

        }
    }

    private int[] sortBubble(int[] tablica) {
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

