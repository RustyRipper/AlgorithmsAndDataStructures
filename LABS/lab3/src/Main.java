import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IStack.FullStackException, IStack.EmptyStackException {
        Scanner skaner = new Scanner(System.in);
        while (true) {

            String wyrazenie = skaner.nextLine();
            Nawiasy nawiasy = new Nawiasy();
            System.out.println(nawiasy.nawiasyZrownowazone(wyrazenie));

        }
    }

}
