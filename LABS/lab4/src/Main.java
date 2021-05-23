import java.util.*;

public class Main {
    OneWayLinkedListWithHead<Karta> karty = new OneWayLinkedListWithHead<>();
    boolean[] tablica = new boolean[52];

    public static void main(String[] args) {
        new Main().menu();
    }

    public void menu() {
        for(int i=5;i>=0;i--){
            System.out.println(i);
        }
        System.out.println("\n\n\n");
        System.out.println("1.Stworz Liste kart");
        System.out.println("2.Wyswietl Liste kart");
        System.out.println("3.Wyswietl ilosc kart");
        System.out.println("4.Wyswietl karty o wartosci");
        System.out.println("5.Wyswietl karty o kolorze");
        System.out.println("6.Usun zakryte");

        Scanner skaner = new Scanner(System.in);
        int wybor = skaner.nextInt();
        switch (wybor) {
            case 0 -> System.exit(0);
            case 1 -> karty = utworzListe();
            case 2 -> wyswietlListe(karty);
            case 3 -> wyswietlIlosc(karty);
            case 4 -> {
                System.out.println("Wprowadz wartosc");
                System.out.println("1.  As");
                System.out.println("11. Walet");
                System.out.println("12. Dama");
                System.out.println("13. Krol");
                wyswietlWartosc(karty, skaner.nextInt());
            }
            case 5 -> {
                System.out.println("Wprowadz kolor");
                System.out.println("1. Kier");
                System.out.println("2. Karo");
                System.out.println("3. Trefl");
                System.out.println("4. Pik");

                wyswietlKolor(karty, skaner.nextInt() - 1);
            }
            case 6 -> usunZakryte(karty);
        }
        menu();

    }

    public OneWayLinkedListWithHead<Karta> utworzListe() {

        OneWayLinkedListWithHead<Karta> karty = new OneWayLinkedListWithHead<>();
        boolean[] tablica2 = new boolean[52];
        Random random = new Random();
        int r1, r2;

        do {
            r1 = random.nextInt(15);
            r2 = random.nextInt(4);

            if (r1 == 14) {
                Karta karta = new Karta(r1, r2);
                karty.add(karta);
            } else if (r1 != 0 && (!tablica2[r1 + (r2 * 13) - 1])) {

                tablica2[r1 + (r2 * 13) - 1] = true;

                Karta nowaKarta = new Karta(r1, r2);
                boolean flaga = true;

                for (int i = 0; i <= karty.size() && flaga; i++) {

                    if ((i) == karty.size()) {
                        karty.add(nowaKarta);

                        flaga = false;
                    } else if (karty.size() != 0) {

                        if (karty.get(i).getWartosc() > nowaKarta.getWartosc()) {
                            karty.add(i, nowaKarta);
                            flaga = false;
                        } else if (karty.get(i).getWartosc() == nowaKarta.getWartosc()) {
                            if (karty.get(i).getKolor() > nowaKarta.getKolor()) {
                                karty.add(i, nowaKarta);
                                flaga = false;

                            } else if (karty.get(i).getKolor() == nowaKarta.getKolor()) {
                                flaga = false;
                            }
                        }

                    }
                }

            }
        } while (r1 != 0);
        System.out.println("Lista Stworzona");
        tablica = tablica2;
        return karty;

    }

    public void wyswietlListe(OneWayLinkedListWithHead<Karta> karty) {
        for (int i = 0; i < karty.size(); i++) {

            System.out.printf("%2d.   %s", (i + 1), karty.get(i).toString());
            System.out.println();
        }
        System.out.println("wyswietlanie tablicy");
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + " ");
            if ((i + 1) % 13 == 0) System.out.println();
        }
    }

    public void wyswietlIlosc(OneWayLinkedListWithHead<Karta> karty) {

        System.out.println("Ilosc elementow listy: " + karty.size());
        int i = 0;
        for (Karta karta : karty) {
            if (karta.getWartosc() == 14) i++;
        }
        System.out.println("Ilosc zakrytych: " + i);

        System.out.println("Ilosc odkrytych: " + (karty.size() - i));
    }

    public void wyswietlWartosc(OneWayLinkedListWithHead<Karta> karty, int wartosc) {
        System.out.println("Karty o wartosci " + wartosc);
        for (Karta karta : karty) {
            if (karta.getWartosc() == wartosc) {
                System.out.printf("%s", karta.toString());
                System.out.println();
            }
        }
    }

    public void wyswietlKolor(OneWayLinkedListWithHead<Karta> karty, int kolor) {
        System.out.println("Karty o kolorze " + kolor);


        for (Karta karta : karty) {
            if (karta.getKolor() == kolor) {
                System.out.printf("%s", karta.toString());
                System.out.println();
            }

        }
    }

    public void usunZakryte(OneWayLinkedListWithHead<Karta> karty) {

        System.out.println("Stara lista");
        wyswietlListe(karty);


        for (Karta karta : karty) {
            if (karta != null && !karta.getZnacznik()) {
                karty.removee(karta);
            }
        }

        System.out.println("Nowa lista");
        wyswietlListe(karty);

    }
}
