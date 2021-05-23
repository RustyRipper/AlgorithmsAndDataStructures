import java.util.ArrayList;

public class Firma {
    ArrayList<Magazyn> magazyny;

    public Firma(int iloscMagazynow) throws IQueue.EmptyQueueException, IQueue.FullQueueException {
        magazyny= new ArrayList<>(iloscMagazynow);
        while(magazyny.size()<iloscMagazynow){
            magazyny.add(new Magazyn(Main.generujZgloszenia()));
        }
    }
    public void obliczPrzychody() throws IQueue.EmptyQueueException {
        double sumaPrzychodow=0.0;
        for(Magazyn magazyn:magazyny){
            sumaPrzychodow+=magazyn.obliczPrzychody();
        }
        System.out.println("Przychody firmy: "+sumaPrzychodow);
    }
}
