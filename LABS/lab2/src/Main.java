import java.util.*;

public class Main {
    ArrayList<Karta> karty = new ArrayList<>();

    public static void main(String[] args) {
        new Main().menu();
    }

    public void menu() {
        System.out.println("\n\n\n");
        System.out.println("1.Stworz Liste kart");
        System.out.println("2.Wyswietl Liste kart");
        System.out.println("3.Wyswietl ilosc kart");
        System.out.println("4.Wyswietl karty o wartosci");
        System.out.println("5.Wyswietl karty o kolorze");
        System.out.println("6.Usun powtarzajace sie karty");

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
            case 6 -> usunPowtarzajace(karty);
        }
        menu();

    }

    public ArrayList<Karta> utworzListe() {

        ArrayList<Karta> karty = new ArrayList<>();
        Random random = new Random();
        int r1, r2;

        do {
            r1 = random.nextInt(14);
            r2 = random.nextInt(4);
            Karta nowaKarta = new Karta(r1, r2);
            boolean flaga = true;
            if (r1 != 0) {
                for (int i = 0; i <= karty.size() && flaga; i++) {

                    if ((i) == karty.size()) {
                        karty.add(nowaKarta);
                        flaga = false;
                    } else if (karty.size() != 0) {

                        if (karty.get(i).getWartosc() > nowaKarta.getWartosc()) {
                            karty.add(i, nowaKarta);
                            flaga = false;
                        } else if (karty.get(i).getWartosc() == nowaKarta.getWartosc()) {
                            if (karty.get(i).getKolor() >= nowaKarta.getKolor()) {
                                karty.add(i, nowaKarta);
                                flaga = false;

                            }
                        }
                    }
                }
            }


        } while (r1 != 0);
        System.out.println("Lista Stworzona");
        return karty;

    }

    public void wyswietlListe(ArrayList<Karta> karty) {
        for (int i = 0; i < karty.size(); i++) {

            System.out.printf("%2d.   %s", (i + 1), karty.get(i).toString());
            System.out.println();
        }
    }

    public void wyswietlIlosc(ArrayList<Karta> karty) {

        System.out.println("Ilosc elementow listy: " + karty.size());
    }

    public void wyswietlWartosc(ArrayList<Karta> karty, int wartosc) {
        System.out.println("Karty o wartosci " + wartosc);
        for (Karta karta : karty) {
            if (karta.getWartosc() == wartosc) {
                System.out.printf("%s", karta.toString());
                System.out.println();
            }
        }
    }

    public void wyswietlKolor(ArrayList<Karta> karty, int kolor) {
        System.out.println("Karty o kolorze " + kolor);


        Iterator iterator = karty.iterator();
        while (iterator.hasNext()) {
            Karta karta = (Karta) iterator.next();
            if (karta.getKolor() == kolor) {
                System.out.printf("%s", karta.toString());
                System.out.println();
            }

        }
    }

    public void usunPowtarzajace(ArrayList<Karta> karty) {
        karty.add(0, new Karta(1, 0));
        karty.add(0, new Karta(1, 0));
        karty.add(0, new Karta(1, 0));
        System.out.println("Stara lista");
        wyswietlListe(karty);


        for (int i = 0; i < karty.size(); i++) {
            if ((i + 1) != karty.size()) {
                if (karty.get(i).equals(karty.get(i + 1))) {
                    karty.remove(karty.get(i + 1));
                    i--;
                }
            }

        }

        System.out.println("Nowa lista");
        wyswietlListe(karty);


    }
}
