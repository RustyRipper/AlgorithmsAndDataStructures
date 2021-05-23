import java.util.Comparator;

public class ShellSort_v3 {


    private final Comparator<Integer> comparator;
    private int[] tablica_h;

    public ShellSort_v3(int[] tablica_h) {
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
                sortInsert(tablica);
            } else sortMinTab(tablica, i, h);
        }
    }

    private void sortMinTab(int[] tablica, int startIndex, int h) {
        for (int i = startIndex + h; i < tablica.length; i += h) {
            for (int left = 0; left + h < tablica.length; left += h) {
                int right = left + h;
                if (comparator.compare(tablica[left], tablica[right]) > 0)
                    swap(tablica, left, right);
            }
        }


    }


    public int[] sortInsert(int[] tablica) {
        for (int i = 1; i < tablica.length; ++i) {
            int value = tablica[i];
            int temp;
            int j;
            for (j = i; j > 0 && comparator.compare(value, temp = tablica[j - 1]) < 0; --j)
                tablica[j] = temp;
            tablica[j] = value;
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

