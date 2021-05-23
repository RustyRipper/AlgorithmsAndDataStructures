
public class Karta {
    private final int wartosc;
    private final int kolor;


    public Karta(int wartosc, int kolor) {
        this.wartosc = wartosc;
        this.kolor = kolor;
    }

    public int getWartosc() {
        return wartosc;
    }

    public int getKolor() {
        return kolor;
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
        }

        switch (kolor) {
            case 0 -> symbol = "kier";
            case 1 -> symbol = "karo";
            case 2 -> symbol = "trefl";
            case 3 -> symbol = "pik";
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
