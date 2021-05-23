import java.util.Random;

public class Main {
    static int wielkoscTablicy = 5000;

    public static void main(String[] args) {

        int[] tablica = generujTablice();
        System.out.println("Dla: " + wielkoscTablicy);
        GeneratowCiagow generatowCiagow = new GeneratowCiagow(wielkoscTablicy);
        System.out.println("a");
        sortowanie(tablica, generatowCiagow.a());
        System.out.println("b");
        sortowanie(tablica, generatowCiagow.b());
        System.out.println("c");
        sortowanie(tablica, generatowCiagow.c());
        System.out.println("d");
        sortowanie(tablica, generatowCiagow.d());
        System.out.println("e");
        sortowanie(tablica, generatowCiagow.e());




    }


    public static void sortowanie(int[] tablica, int[] tablica_h) {


        ShellSort_v2 shellSort_v2 = new ShellSort_v2(tablica_h);
        ShellSort_v1 shellSort_v1 = new ShellSort_v1(tablica_h);
        ShellSort_v3 shellSort_v3 = new ShellSort_v3(tablica_h);


        int[] tablica2 = skopiujTablice(tablica);
        long millisActualTime;
        long executionTime;

        millisActualTime = System.currentTimeMillis();
        shellSort_v1.sort(tablica2);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("ShellSort1: " + executionTime);

        tablica2 = skopiujTablice(tablica);

        millisActualTime = System.currentTimeMillis();
        shellSort_v2.sort(tablica2);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("ShellSort2: " + executionTime);

        tablica2 = skopiujTablice(tablica);

        millisActualTime = System.currentTimeMillis();
        shellSort_v3.sort(tablica2);
        executionTime = System.currentTimeMillis() - millisActualTime;
        System.out.println("ShellSort3: " + executionTime);

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
}
