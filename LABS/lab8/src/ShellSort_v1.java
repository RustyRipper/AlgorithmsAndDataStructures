import java.util.Comparator;

public class ShellSort_v1 {


    private final Comparator<Integer> comparator;
    private int[] tablica_h;

    public ShellSort_v1(int[] tablica_h) {
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
            sortMinTab(tablica, i, h);
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
}

