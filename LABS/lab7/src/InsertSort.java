import java.util.Comparator;

public class InsertSort {
    private final Comparator<Integer> comparator;

    public InsertSort() {
        comparator = (o1, o2) -> o1 - o2;
    }

    public int[] sort(int[] tablica) {
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
}