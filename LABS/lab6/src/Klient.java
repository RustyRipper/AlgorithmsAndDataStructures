public class Klient {
    ListQueue<Zamowienie> listaKlienta;

    public Klient(ListQueue<Zamowienie> listaKlienta) {
        this.listaKlienta = listaKlienta;
    }

    public void dodajZamowienie(Zamowienie zamowienie) throws IQueue.FullQueueException {
        listaKlienta.enqueue(zamowienie);
    }
}
