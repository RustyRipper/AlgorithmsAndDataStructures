public class PracownikEtatowy extends Pracownik {

    private float etat;
    private double stawka;


    public PracownikEtatowy(String nazwisko, String imie, long pesel, String stanowisko, int staz, float etat, double stawka) {
        super(nazwisko, imie, pesel, stanowisko, staz);
        this.etat = etat;
        this.stawka = stawka;
    }

    @Override
    public double pensja() {
        return stawka * etat;
    }

    public String toString() {
        return super.toString() + String.format("%.2f", pensja());
    }
}
