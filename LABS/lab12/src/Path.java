public class Path {
    // miejscowosc zrodlowa
    private final int fromTown;
    // miejscowosc docelowa
    private final int toTown;
    // length
    private final int length;

    public Path(int from, int to, int length) {
        this.fromTown = from;
        this.toTown = to;
        this.length = length;
    }

    public int getFromTown() {
        return fromTown;
    }

    public int getToTown() {
        return toTown;
    }


    public int getLength() {
        return length;
    }

}
