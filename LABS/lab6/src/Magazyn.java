public class Magazyn {
    ListQueue<ZgloszenieKlienta> lista;

    public Magazyn(ListQueue<ZgloszenieKlienta> zgloszenieKlienta) {
        lista = zgloszenieKlienta;
    }

    public void dodajZgloszenie(ZgloszenieKlienta zgloszenieKlienta) throws IQueue.FullQueueException {
        lista.enqueue(zgloszenieKlienta);
    }

    public void zrealizujZamowienia() throws IQueue.EmptyQueueException {
        double sumaKwot = 0.0;
        while (!lista.isEmpty()) {
            ZgloszenieKlienta zgloszenieKlienta = lista.dequeue();
            System.out.println("Klient: " + zgloszenieKlienta.nazwaKlienta);

            double kwota = 0.0;
            while (!zgloszenieKlienta.klient.listaKlienta.isEmpty()) {
                kwota += zgloszenieKlienta.klient.listaKlienta.first().liczbaSztuk * zgloszenieKlienta.klient.listaKlienta.first().cenaJednostkowa;
                zgloszenieKlienta.klient.listaKlienta.dequeue();
            }
            sumaKwot += kwota;
            System.out.println("Zlecenie zrealizowane: " + zgloszenieKlienta.nazwaKlienta + "\nKwota do zapłaty= " + kwota);

        }


        System.out.println("\n\nSuma kwot: " + sumaKwot);

    }

    public double obliczPrzychody() throws IQueue.EmptyQueueException {
        double sumaKwot = 0.0;
        while (!lista.isEmpty()) {
            ZgloszenieKlienta zgloszenieKlienta = lista.dequeue();

            double kwota = 0.0;
            while (!zgloszenieKlienta.klient.listaKlienta.isEmpty()) {
                kwota += zgloszenieKlienta.klient.listaKlienta.first().liczbaSztuk * zgloszenieKlienta.klient.listaKlienta.first().cenaJednostkowa;
                zgloszenieKlienta.klient.listaKlienta.dequeue();
            }
            sumaKwot += kwota;

        }
        return sumaKwot;
    }
}
