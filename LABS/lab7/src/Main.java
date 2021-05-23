import java.util.Random;

public class Main {
    static int wielkoscTablicy = 15000;

    public static void main(String[] args) {

        int[] tablica = generujTablice();

        System.out.println("Pomiar dla losowych danych");
        sortowanie(tablica);
        System.out.println("==========================");
        System.out.println("Pomiar dla rosnacych");
        posortujTabliceRosnaco(tablica);
        sortowanie(tablica);
        System.out.println("==========================");
        System.out.println("Pomiar dla malejacych");
        tablica = posortujTabliceMalejaco(tablica);
        sortowanie(tablica);


    }

    public static int[] skopiujTablice(int[] tablica) {
        int[] tablica2 = new int[wielkoscTablicy];
        System.arraycopy(tablica, 0, tablica2, 0, tablica.length);
        return tablica2;

    }

    public static int[] generujTablice() {
        int[] tablica = new int[wielkoscTablicy];
        Random random = new Random();
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = random.nextInt(wielkoscTablicy);
        }
        return tablica;
    }

    public static void posortujTabliceRosnaco(int[] tablica) {
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(tablica, 0, tablica.length - 1);

    }

    public static int[] posortujTabliceMalejaco(int[] tablica) {
        posortujTabliceRosnaco(tablica);
        int[] tab2 = new int[wielkoscTablicy];

        for (int i = 0; i < tablica.length; i++) {
            tab2[i] = tablica[wielkoscTablicy - 1 - i];
        }
        return tab2;
    }

    //-----------------------------------------------------------
    public static void posortujTabliceInsert(int[] tablica) {
        InsertSort insertSort = new InsertSort();
        insertSort.sort(tablica);

    }

    public static void posortujTabliceSelect(int[] tablica) {
        SelectSort selectSort = new SelectSort();
        selectSort.sort(tablica);

    }

    public static void posortujTabliceBubble(int[] tablica) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(tablica);

    }

    public static void posortujTabliceQuick(int[] tablica) {
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(tablica, 0, tablica.length - 1);
    }

    public static void posortujTabliceMerge(int[] tablica) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(tablica, new int[wielkoscTablicy], 0, tablica.length - 1);
    }

    public static void posortujTabliceHeap(int[] tablica) {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(tablica);

    }

    public static void sortowanie(int[] tablica) {


        int[] tablicaTestowa = skopiujTablice(tablica);
        long millisActualTime = System.currentTimeMillis();
        posortujTabliceInsert(tablicaTestowa);
        long executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("InsertSort: " + executionTime);

        int[] tablicaTestowa3 = skopiujTablice(tablica);
        millisActualTime = System.currentTimeMillis();
        posortujTabliceBubble(tablicaTestowa3);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("BubbleSort: " + executionTime);

        int[] tablicaTestowa2 = skopiujTablice(tablica);
        millisActualTime = System.currentTimeMillis();
        posortujTabliceSelect(tablicaTestowa2);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("SelectSort: " + executionTime);

        int[] tablicaTestowa4 = skopiujTablice(tablica);
        millisActualTime = System.currentTimeMillis();
        posortujTabliceQuick(tablicaTestowa4);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("QuickSort: " + executionTime);

        int[] tablicaTestowa6 = skopiujTablice(tablica);
        millisActualTime = System.currentTimeMillis();
        posortujTabliceHeap(tablicaTestowa6);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("HeapSort: " + executionTime);

        int[] tablicaTestowa5 = skopiujTablice(tablica);
        millisActualTime = System.currentTimeMillis();
        posortujTabliceMerge(tablicaTestowa5);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("MergeSort: " + executionTime);
    }
}
