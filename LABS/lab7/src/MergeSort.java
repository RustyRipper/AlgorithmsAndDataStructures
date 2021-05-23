public class MergeSort {

    public void mergeSort(int[] tablica, int[] pomocnicza, int left, int right) {
        if (left == right) return;
        int middleIndex = (left + right) / 2;
        mergeSort(tablica, pomocnicza, left, middleIndex);
        mergeSort(tablica, pomocnicza, middleIndex + 1, right);
        merge(tablica, pomocnicza, left, right);
        for (int i = left; i <= right; i++) {
            tablica[i] = pomocnicza[i];
        }
    }

    private void merge(int[] tablica, int[] pomocnicza, int left, int right) {
        int middleIndex = (left + right) / 2;
        int leftIndex = left;
        int rightIndex = middleIndex + 1;
        int auxIndex = left;
        while (leftIndex <= middleIndex && rightIndex <= right) {
            if (tablica[leftIndex] < tablica[rightIndex]) {
                pomocnicza[auxIndex] = tablica[leftIndex++];
            } else {
                pomocnicza[auxIndex] = tablica[rightIndex++];
            }
            auxIndex++;
        }
        while (leftIndex <= middleIndex) {
            pomocnicza[auxIndex] = tablica[leftIndex++];
            auxIndex++;
        }
        while (rightIndex <= right) {
            pomocnicza[auxIndex] = tablica[rightIndex++];
            auxIndex++;
        }
    }
}
