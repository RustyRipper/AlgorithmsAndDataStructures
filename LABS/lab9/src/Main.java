import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ONP onp = new ONP();
        String wyrazenie;

        System.out.println("Podaj wyrażenie:");
        Scanner scanner = new Scanner(System.in);
        wyrazenie = scanner.nextLine();
        String wyrazenieONP = onp.wykonajONP(wyrazenie);
        System.out.println("-------------------------------------");


        //----------------------------------------
        BST bst = new BST();
        bst.createBST(wyrazenieONP);

        bst.wyswietlInfiksowany();
        bst.wyswietlPostfiksowany();
        System.out.println("Liczba lisci: " + bst.obliczIloscLisci(bst._root));
        System.out.println("Liczba wezlow: " + bst.obliczIloscWezlow(bst._root));
        System.out.println("Wysokosc drzewa: " + bst.obliczWysokosc(bst._root));
        bst.przechodzenieWszerz();

    }
}
