public class Nawiasy {

    public boolean nawiasyZrownowazone(String wyrazenie) throws IStack.EmptyStackException, IStack.FullStackException {

        ArrayStack<Character> stos = new ArrayStack<>();

        for (int i = 0; i < wyrazenie.length(); i++) {
            if (nawiasOtwierajce(wyrazenie.charAt(i))) {
                stos.push(wyrazenie.charAt(i));
            } else if (nawiasZamykajace(wyrazenie.charAt(i))) {
                if (stos.isEmpty()) {
                    return false;
                } else if (sprawdzNawiasy(stos.top(), wyrazenie.charAt(i))) {
                    stos.pop();
                }
            }
        }
        return stos.isEmpty();
    }

    public boolean sprawdzNawiasy(char ch0, char ch1) {

        if (ch0 == '(' && ch1 == ')') return true;
        if (ch0 == '[' && ch1 == ']') return true;
        return ch0 == '{' && ch1 == '}';


    }

    public boolean nawiasOtwierajce(char ch) {
        char[] tablica = new char[]{'[', '{', '('};
        for (char c : tablica) {
            if (ch == c)
                return true;
        }

        return false;

    }

    public boolean nawiasZamykajace(char ch) {
        char[] tablica = new char[]{']', '}', ')'};
        for (char c : tablica) {
            if (ch == c)
                return true;
        }

        return false;

    }

}
