public class QuickSort {


    public void quicksort(int[] tab, int l, int r) {
        if (l < r) {
            int q = partition(tab, l, r);
            quicksort(tab, l, q - 1);
            quicksort(tab, q + 1, r);
        }
    }

    public int partition(int[] tab, int l, int r) {
        int piv = tab[r];
        int i = l - 1, j = r;
        while (i < j) {
            while (tab[++i] < piv) ;
            while (j > l && tab[--j] > piv) ;
            if (i < j) {
                swap(tab, i, j);
            }


        }
        swap(tab, i, r);
        return i;
    }

    private void swap(int[] tab, int i, int j) {
        int z = tab[i];
        tab[i] = tab[j];
        tab[j] = z;
    }
}
