public class Path {
    int from;
    int to;
    int length;

    public Path(int from, int to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Path{" +
                "from=" + from +
                ", to=" + to +
                ", length=" + length +
                '}';
    }
}
