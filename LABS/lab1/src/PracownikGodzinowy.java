public class PracownikGodzinowy extends Pracownik {

    private int liczba_godz;
    private double stawka;

    public PracownikGodzinowy(String nazwisko, String imie, long pesel, String stanowisko, int staz, int liczba_godz, double stawka) {
        super(nazwisko, imie, pesel, stanowisko, staz);
        this.stawka = stawka;
        this.liczba_godz = liczba_godz;
    }

    @Override
    public double pensja() {
        return stawka * liczba_godz;
    }

    public String toString() {
        return super.toString() + String.format("%.2f", pensja());
    }
}
