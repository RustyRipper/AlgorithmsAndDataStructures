public class Karta {
    private int wartosc;
    private int kolor;
    private boolean znacznik;


    public Karta(int wartosc, int kolor) {
        this.wartosc = wartosc;
        if (wartosc == 14) {
            this.znacznik = false;
            this.kolor = 4;

        } else {
            this.kolor = kolor;

            this.znacznik = true;
        }

    }

    public int getWartosc() {
        return wartosc;
    }

    public int getKolor() {
        return kolor;
    }

    public boolean getZnacznik() {
        return znacznik;
    }

    @Override
    public String toString() {

        String figura = wartosc + "";
        String symbol = kolor + "";
        switch (wartosc) {
            case 1 -> figura = "as";
            case 11 -> figura = "walet";
            case 12 -> figura = "dama";
            case 13 -> figura = "krol";
            case 14 -> figura = "()";
        }

        switch (kolor) {
            case 0 -> symbol = "kier";
            case 1 -> symbol = "karo";
            case 2 -> symbol = "trefl";
            case 3 -> symbol = "pik";
            case 4 -> symbol = "";
        }

        return String.format("%6s    %-5s  ", figura, symbol);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Karta)) return false;
        Karta karta = (Karta) o;
        return wartosc == karta.wartosc && kolor == karta.kolor;
    }

}
