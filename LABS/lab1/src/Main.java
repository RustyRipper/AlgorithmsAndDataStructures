import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Podaj ilosc pracownikow");
        Scanner skaner = new Scanner(System.in);
        int iloscPracownikow = skaner.nextInt();
        Pracownik[] pracownicy = new Pracownik[iloscPracownikow];


        for (int i = 0; i < iloscPracownikow; i++) {
            System.out.println("Podaj typ G lub E (Godzinowy/Etatowy)");
            String s = skaner.next();
            if (s.equals("G")) {
                System.out.println("Nazwisko Imie Pesel Stanowisko Staz LiczbaGodzin StawkaZaGodzine");
                pracownicy[i] = new PracownikGodzinowy(skaner.next(), skaner.next(), skaner.nextLong(), skaner.next(), skaner.nextInt(), skaner.nextInt(), skaner.nextDouble());
            } else if (s.equals("E")) {
                System.out.println("Nazwisko Imie Pesel Stanowisko Staz Etat StawkaPodstawowa");
                pracownicy[i] = new PracownikEtatowy(skaner.next(), skaner.next(), skaner.nextLong(), skaner.next(), skaner.nextInt(), skaner.nextFloat(), skaner.nextDouble());
            } else {
                System.out.println("Bledny typ");
                i--;
            }

        }


        System.out.println("---------------------------------------------------------------------");
        System.out.println("Nazwisko    Imie       Pesel        Stanowisko      Staz   Pensja");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < pracownicy.length; i++) {
            pracownicy[i].wyswietl();
        }
        System.out.println("---------------------------------------------------------------------");


        File plik = new File("H:\\sem2\\lab1\\src\\text.txt");

        System.out.println("Zapis...");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(plik))) {
            objectOutputStream.writeInt(pracownicy.length);
            for (int i = 0; i < pracownicy.length; i++) {
                objectOutputStream.writeObject(pracownicy[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int iloscPracownikow2 = 0;
        Pracownik[] pracownicy2 = new Pracownik[iloscPracownikow];

        System.out.println("Odczyt...");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(plik))) {
            iloscPracownikow2 = objectInputStream.readInt();
            for (int i = 0; i < pracownicy2.length; i++) {
                pracownicy2[i] = (Pracownik) objectInputStream.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Ilosc pracownikow: " + iloscPracownikow2);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Nazwisko    Imie       Pesel        Stanowisko      Staz   Pensja");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < pracownicy2.length; i++) {
            pracownicy2[i].wyswietl();

        }
        System.out.println("---------------------------------------------------------------------");


        System.out.println("Iterator...");
        MyIterator myIterator = new MyIterator(pracownicy2);

        while (myIterator.hasNext()) {
            ((Pracownik) myIterator.next()).wyswietl();
        }


    }


}
