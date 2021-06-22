

public class Main {
    public static void main(String[] args) {

        int source = 0;

        Graph graph = new Graph(5);

        graph.addTown(new Town(0, "Wroclaw"));
        graph.addTown(new Town(1, "Olawa"));
        graph.addTown(new Town(2, "Brzeg"));
        graph.addTown(new Town(3, "Nysa"));
        graph.addTown(new Town(4, "Opole"));

        graph.addPath(new Path(0, 1, 10));
        graph.addPath(new Path(0, 3, 30));
        graph.addPath(new Path(0, 4, 100));
        graph.addPath(new Path(1, 2, 50));
        graph.addPath(new Path(2, 4, 10));
        graph.addPath(new Path(3, 2, 20));
        graph.addPath(new Path(3, 4, 60));


        graph.showTowns(source);

        graph.showList();

        graph.showLengthTo(3,4);

        graph.DFS();

    }
}
