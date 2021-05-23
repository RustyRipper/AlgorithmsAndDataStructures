
import java.util.Stack;


public class ONP {

    static Stack<String> stack = new Stack<>();


    public String wykonajONP(String wyrazenie) {
        StringBuilder wynik = new StringBuilder();
        boolean flaga = true;

        wyrazenie = wyrazenie.replaceAll(" ", "");

        for (int i = 0; i < wyrazenie.length(); i++) {
            if (wyrazenie.charAt(i) == '(') {
                stack.push("(");
                flaga = true;
                wynik.append(" ");
            } else if (wyrazenie.charAt(i) == ')') {
                wynik.append(pobierzZeStosuDoNawiasow());
                flaga = false;
            } else if ((wyrazenie.charAt(i) == '+' ||
                    wyrazenie.charAt(i) == '-' ||
                    wyrazenie.charAt(i) == '*' || wyrazenie.charAt(i) == '%' ||
                    wyrazenie.charAt(i) == '/') && !flaga) {
                wynik.append(" ").append(pobierzZeStosu(wyrazenie.substring(i, i + 1)));
                flaga = true;
            } else {
                if (flaga && wyrazenie.charAt(i) == '-') {
                    wynik.append(" ");
                }
                wynik.append(wyrazenie.charAt(i));
                flaga = false;
            }
        }
        wynik.append(pobierzWszystkoZeStosu());
        wynik = new StringBuilder(wynik.toString().replaceAll(" {2}", " "));

        return wynik.toString();

    }

    private static String pobierzZeStosuDoNawiasow() {
        StringBuilder wynik = new StringBuilder();
        String c;
        if (!stack.empty()) {
            c = stack.pop();
            while (!c.equals("(")) {
                wynik.append(" ").append(c);
                if (stack.empty()) break;
                c = stack.pop();
            }
        }
        if (wynik.length() > 0) {
            wynik.insert(0, " ");
        }
        return wynik.toString();
    }


    private static String pobierzZeStosu(String operator) {
        StringBuilder wynik = new StringBuilder();
        String c;
        if (!stack.empty()) {
            c = stack.pop();
            while (((operator.equals("+") || operator.equals("-")) && !c.equals("(")) ||
                    ((operator.equals("/") || operator.equals("*")) && (c.equals("/") || c.equals("*")))) {

                wynik.append(" ").append(c).append(" ");
                if (stack.empty()) break;
                c = stack.pop();
            }
            stack.push(c);
        }
        stack.push(operator);

        return wynik.toString();
    }

    private static String pobierzWszystkoZeStosu() {
        StringBuilder wynik = new StringBuilder();
        String c;
        while (!stack.empty()) {
            c = stack.pop();
            wynik.append(" ").append(c);
        }
        return wynik.toString();
    }

}