import java.util.ArrayList;

public class GeneratowCiagow {
    private int wielkoscTablicy;

    public GeneratowCiagow(int wielkoscTablicy) {
        this.wielkoscTablicy = wielkoscTablicy;
    }

    public int[] a() {

        ArrayList<Integer> lista = new ArrayList<>();

        for (int h = 1; 3 * h + 1 < wielkoscTablicy; h = 3 * h + 1) {

            lista.add(h);
        }
        int[] tablica = new int[lista.size()];
        for (int i = 0; !lista.isEmpty(); i++) {
            tablica[i] = lista.remove(lista.size() - 1);
        }
        return tablica;
    }

    public int[] b() {

        ArrayList<Integer> lista = new ArrayList<>();


        for (int h = 1; (Math.pow(2, h) - 1) < wielkoscTablicy; h++) {

            lista.add((int) (Math.pow(2, h) - 1));
        }
        int[] tablica = new int[lista.size()];
        for (int i = 0; !lista.isEmpty(); i++) {
            tablica[i] = lista.remove(lista.size() - 1);
        }
        return tablica;
    }

    public int[] c() {

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        for (int h = 1; (Math.pow(2, h) + 1) < wielkoscTablicy; h++) {

            lista.add((int) (Math.pow(2, h) + 1));
        }
        int[] tablica = new int[lista.size()];
        for (int i = 0; !lista.isEmpty(); i++) {
            tablica[i] = lista.remove(lista.size() - 1);
        }
        return tablica;
    }

    public int[] d() {

        ArrayList<Integer> lista = new ArrayList<>();
        int h1 = 1;
        int h2 = 1;
        for (int h = 1; h2 + h1 < wielkoscTablicy; h = h2 + h1) {

            lista.add(h);
            h1 = h2;
            h2 = h;

        }
        int[] tablica = new int[lista.size()];
        for (int i = 0; !lista.isEmpty(); i++) {
            tablica[i] = lista.remove(lista.size() - 1);
        }
        return tablica;
    }

    public int[] e() {

        ArrayList<Integer> lista = new ArrayList<>();


        for (double h = wielkoscTablicy/2; (int)h>1; h = 3*h/4) {

            lista.add((int) h);


        }
        lista.add(1);
        int[] tablica = new int[lista.size()];
        for (int i = 0; !lista.isEmpty(); i++) {
            tablica[i] = lista.remove(0);
        }
        return tablica;
    }
}
