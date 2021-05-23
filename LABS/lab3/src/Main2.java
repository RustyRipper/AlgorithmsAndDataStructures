import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws IStack.FullStackException, IStack.EmptyStackException {
        Scanner skaner = new Scanner(System.in);
        while (true) {
            String wyrazenie = skaner.nextLine();
            System.out.println(sprawdzPalindrom(wyrazenie));
        }


    }

    public static boolean sprawdzPalindrom(String wyrazenie) throws IStack.FullStackException, IStack.EmptyStackException {
        ArrayStack<Character> stos = new ArrayStack<>();
        ArrayStack<Character> stos2 = new ArrayStack<>();

        wyrazenie = wyrazenie.replaceAll(" ", "");

        for (int i = 0; i < wyrazenie.length(); i++) {
            stos.push(wyrazenie.charAt(i));
            stos2.push(wyrazenie.charAt(i));
            System.out.println(wyrazenie.charAt(i));
        }
        stos.odwrocStos();

        while (!(stos2.isEmpty() && stos.isEmpty())) {
            if(stos.pop()!=stos2.pop()) {
                return false;
            }
        }
        return true;


    }
}
