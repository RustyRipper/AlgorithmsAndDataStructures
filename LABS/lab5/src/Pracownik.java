import java.sql.Date;

public class Pracownik {
    private long pesel;
    private String nazwisko;
    private String imie;
    private String dataUrodzenia;
    private String stanowisko;
    private double pensja;
    private int staz;
    private double premia;

    public Pracownik(long pesel, String nazwisko, String imie, String dataUrodzenia, String stanowisko, double pensja, int staz) {
        this.pesel = pesel;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
        this.stanowisko = stanowisko;
        this.pensja = pensja;
        this.staz = staz;

        if (staz >= 20) premia = pensja * 0.2;
        else if (staz >= 10) premia = pensja * 0.1;
        else premia = 0;
    }

    @Override
    public String toString() {
        return pesel + " " + nazwisko + " " + imie + " " + dataUrodzenia + " " + stanowisko + " " + pensja + " " + staz + " " + premia;
    }

    public String toString2() {
        return String.format("%12d  %-14s %-10s %-10s  %-14s %10.2f   %4d   %6.2f ", pesel, nazwisko, imie, dataUrodzenia, stanowisko, pensja, staz, premia);
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }
}

