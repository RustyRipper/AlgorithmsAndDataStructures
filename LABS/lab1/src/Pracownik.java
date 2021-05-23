import java.io.Serializable;

public abstract class Pracownik implements Serializable {

    private String nazwisko;
    private String imie;
    private long pesel;
    private String stanowisko;
    private int staz;

    public Pracownik() {
    }

    public Pracownik(String nazwisko, String imie, long pesel, String stanowisko, int staz) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.stanowisko = stanowisko;
        this.staz = staz;
    }

    public void wyswietl() {
        System.out.println(toString());
    }

    public abstract double pensja();

    public String toString() {
        return String.format("%-10s  %-10s %-12d %-15s %-7d", nazwisko, imie, pesel, stanowisko, staz);

    }

}
