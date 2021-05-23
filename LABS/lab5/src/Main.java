import java.io.*;

import java.util.Scanner;

public class Main {
    TwoWayCycledListWithSentinel<Pracownik> lista;
    ListStack<Pracownik> parking = new ListStack<>();

    public static void main(String[] args) throws IStack.FullStackException, IStack.EmptyStackException {
        new Main().menu();
    }

    public void menu() throws IStack.FullStackException, IStack.EmptyStackException {

        System.out.println("\n\n\n");
        System.out.println("1.Stworz nowa baze danych");
        System.out.println("2.Odczyt bazy z pliku");
        System.out.println("3.Wyswietl wszystkie rekordy");
        System.out.println("4.Wyswietl danych jednego pracownika");
        System.out.println("5.Dopisz nowego pracownika");
        System.out.println("6.Usun pracownika z bazy");
        System.out.println("7.Aktualizacja danych pracownika");
        System.out.println("8.Obliczanie sredniej pensji w firmie");
        System.out.println("9.Oblicz ilu pracowników zarabia poniżej średniej");
        System.out.println("10.Zapis bazy do pliku");
        System.out.println("11.Parking");

        Scanner skaner = new Scanner(System.in);
        int wybor = skaner.nextInt();
        switch (wybor) {
            case 0 -> System.exit(0);
            case 1 -> lista = new TwoWayCycledListWithSentinel<>();
            case 2 -> odczyt();
            case 3 -> wyswietlListe();
            case 4 -> wyswietlPracownika();
            case 5 -> dopiszPracownika();
            case 6 -> usunPracownika();
            case 7 -> aktualizacjaDanychPracownika();
            case 8 -> System.out.println("Srednia pensja: " + obliczSredniaPensje());
            case 9 -> obliczPonizejSredniej();
            case 10 -> zapis();
            case 11 -> parking();
        }
        menu();

    }

    //Done
    private void parking() throws IStack.FullStackException, IStack.EmptyStackException {

        System.out.println("Witaj na parkingu");
        System.out.println("1. Wjedz na parking");
        System.out.println("2. Wyjedz z parkingu");

        Scanner s = new Scanner(System.in);
        int w = s.nextInt();
        int w2 = 0;
        if (w != 0) {
            System.out.println("Wybierz index Pracownika");
            w2 = s.nextInt();
        }
        switch (w) {
            case 0 -> menu();
            case 1 -> parking.push(lista.get(w2));
            case 2 -> {
                ListStack<Pracownik> lista2 = new ListStack<>();
                while (!parking.top().equals(lista.get(w2))) {
                    System.out.println(parking.top().getNazwisko() + " wyjedz z parkingu");
                    lista2.push(parking.pop());
                }
                System.out.println(parking.pop().getNazwisko()+" Do widzenia");

                while (!lista2.isEmpty()) {

                    System.out.println(lista2.top().getNazwisko() + " wjedz na parking");
                    parking.push(lista2.pop());
                }
            }

        }
        parking();
    }

    //Done
    private void zapis() {
        System.out.println("Podaj nazwe pliku .txt");
        String nazwa = new Scanner(System.in).nextLine();
        File file = new File("H:\\sem2\\lab5\\src\\" + nazwa + ".txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {

            for (Pracownik pracownik : lista) {
                bufferedWriter.write(pracownik.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Done
    private void obliczPonizejSredniej() {
        int i = 0;
        for (Pracownik pracownik : lista) {
            if (pracownik.getPensja() < obliczSredniaPensje()) i++;
        }
        System.out.println("Ilosc pracownikow zarabiajacych ponizej sredniej: " + i);
    }

    //Done
    private double obliczSredniaPensje() {
        double srednia = 0;
        for (Pracownik pracownik : lista) {
            srednia += pracownik.getPensja();
        }

        return srednia / lista.size();
    }

    //Done
    private void aktualizacjaDanychPracownika() {
        wyswietlListe();
        System.out.println();
        System.out.println("Wybierz index do zaktualizowania");
        Scanner sk = new Scanner(System.in);
        int w = sk.nextInt();
        System.out.println("Podaj dane");
        System.out.println("Stanowisko Pensja Staz");
        lista.get(w).setStanowisko(sk.next());
        lista.get(w).setPensja(sk.nextDouble());
        lista.get(w).setStaz(sk.nextInt());
        if (lista.get(w).getStaz() >= 10)
            lista.get(w).setPremia(lista.get(w).getPensja() * 0.1);
        else if (lista.get(w).getStaz() >= 20)
            lista.get(w).setPremia(lista.get(w).getPensja() * 0.2);
    }

    //Done
    private void usunPracownika() {
        wyswietlListe();
        System.out.println();
        System.out.println("Wybierz index");
        Scanner sk = new Scanner(System.in);
        lista.remove(sk.nextInt());

    }

    //Done
    private void dopiszPracownika() {
        System.out.println("Podaj dane pracownika");
        System.out.println("Pesel Nazwisko Imie DataUrodzenia Stanowisko Pensja Staz");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] tablica = s.split(" ");
        Pracownik pracownik = new Pracownik(Long.parseLong(tablica[0]), tablica[1], tablica[2], tablica[3], tablica[4], Double.parseDouble(tablica[5]), Integer.parseInt(tablica[6]));
        if (lista.isEmpty()) {
            lista.add(pracownik);
            return;
        }
        for (Pracownik pracownik1 : lista) {
            if (pracownik1.getPesel() > pracownik.getPesel()) {
                lista.add_(lista.indexxOf(pracownik1), pracownik);
                return;
            }
        }
        lista.add(pracownik);

    }

    //Done
    private void wyswietlListe() {
        System.out.println("Lista pracowników");
        int i = 0;
        for (Pracownik pracownik : lista) {
            System.out.println(i + " " + pracownik.toString2());
            i++;
        }
    }

    //Done
    private void wyswietlPracownika() {
        System.out.println("Wybierz index");
        Scanner sk = new Scanner(System.in);
        System.out.println(lista.get(sk.nextInt()).toString2());
    }

    //Done
    private void odczyt() {
        lista = new TwoWayCycledListWithSentinel<>();

        System.out.println("Podaj nazwe pliku .txt");
        String nazwa = new Scanner(System.in).nextLine();
        File file = new File("H:\\sem2\\lab5\\src\\" + nazwa + ".txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String linia;
            String[] tablica;
            while ((linia = bufferedReader.readLine()) != null) {
                tablica = linia.split(" ");
                Pracownik pracownik = new Pracownik(Long.parseLong(tablica[0]), tablica[1], tablica[2], tablica[3], tablica[4], Double.parseDouble(tablica[5]), Integer.parseInt(tablica[6]));
                if (lista.isEmpty()) {
                    lista.add(pracownik);
                } else {
                    boolean flaga = false;
                    for (Pracownik pracownik1 : lista) {
                        if (pracownik1.getPesel() > pracownik.getPesel()) {
                            lista.add_(lista.indexxOf(pracownik1), pracownik);
                            flaga = true;
                            break;
                        }
                    }
                    if (!flaga) {
                        lista.add(pracownik);
                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
