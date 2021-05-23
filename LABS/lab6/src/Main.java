public class Main {
    public static void main(String[] args) throws IQueue.FullQueueException, IQueue.EmptyQueueException {


        Magazyn magazyn = new Magazyn(generujZgloszenia());
        magazyn.zrealizujZamowienia();
        System.out.println("------------------");
        Firma firma = new Firma(7);
        firma.obliczPrzychody();



    }

    public static ListQueue<ZgloszenieKlienta> generujZgloszenia() throws IQueue.FullQueueException, IQueue.EmptyQueueException {
        ListQueue<Klient> listaKlientow = generujKlientow();
        ListQueue<ZgloszenieKlienta> listaZgloszen = new ListQueue<>();
        listaZgloszen.enqueue(new ZgloszenieKlienta("KlientElektroniczny", listaKlientow.dequeue()));
        listaZgloszen.enqueue(new ZgloszenieKlienta("KlientSpozywczy", listaKlientow.dequeue()));
        listaZgloszen.enqueue(new ZgloszenieKlienta("KlientBudowlany", listaKlientow.dequeue()));
        return listaZgloszen;

    }

    public static ListQueue<Klient> generujKlientow() throws IQueue.FullQueueException {

        ListQueue<Klient> listaKlientow = new ListQueue<>();

        listaKlientow.enqueue(new Klient(generujZamowienia()));
        listaKlientow.enqueue(new Klient(generujZamowienia2()));
        listaKlientow.enqueue(new Klient(generujZamowienia3()));
        return listaKlientow;
    }

    private static ListQueue<Zamowienie> generujZamowienia3() throws IQueue.FullQueueException {
        ListQueue<Zamowienie> lista = new ListQueue<>();

        lista.enqueue(new Zamowienie("Cement", 10, 50));
        lista.enqueue(new Zamowienie("Deska", 30, 15));
        lista.enqueue(new Zamowienie("Mlotek", 15, 30));
        return lista;
    }

    private static ListQueue<Zamowienie> generujZamowienia2() throws IQueue.FullQueueException {
        ListQueue<Zamowienie> lista = new ListQueue<>();

        lista.enqueue(new Zamowienie("Ser", 10, 2));
        lista.enqueue(new Zamowienie("Mleko", 10, 3));
        lista.enqueue(new Zamowienie("Chleb", 5, 3));
        return lista;
    }

    public static ListQueue<Zamowienie> generujZamowienia() throws IQueue.FullQueueException {
        ListQueue<Zamowienie> lista = new ListQueue<>();

        lista.enqueue(new Zamowienie("Monitor", 10, 1000));
        lista.enqueue(new Zamowienie("Mysz", 10, 100));
        lista.enqueue(new Zamowienie("Klawiatura", 5, 200));
        return lista;
    }
}
