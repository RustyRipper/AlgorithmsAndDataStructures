import java.util.*;
import java.util.ArrayList;

public class Graph {
    int amountTowns;
    int amountPaths;
    ArrayList<Town> towns;
    List<Path>[] paths;


    @SuppressWarnings("unchecked")
    public Graph(int amount) {
        this.amountTowns = amount;
        amountPaths = 0;
        this.paths = (List<Path>[]) new List[amount];
        for (int i = 0; i < amount; i++) {
            paths[i] = new ArrayList<>();
        }

        towns = new ArrayList<>();

    }

    public void addTown(Town town) {
        towns.add(town);
    }

    public void addPath(Path path) {
        paths[path.getFromTown()].add(path);
        amountPaths++;
    }


    public void dijkstra(int source) {
        ArrayList<Integer> done = new ArrayList<>();
        PriorityQueue<Town> priorityQueue = new PriorityQueue<>(new Comparator<Town>() {
            @Override
            public int compare(Town o1, Town o2) {
                return o1.distance - o2.distance;
            }
        });

        for (Town town : towns) {
            town.setDistance(Integer.MAX_VALUE);
        }
        priorityQueue.add(new Town(source, towns.get(source).name));
        towns.get(source).setDistance(0);

        while (done.size() != amountTowns && priorityQueue.size() != 0) {

            int u = priorityQueue.remove().index;
            done.add(u);

            checkOther(u, done, priorityQueue);
        }
    }

    private void checkOther(int u, ArrayList<Integer> done, PriorityQueue<Town> priorityQueue) {
        int pathLength;
        int newDistance;


        for (int i = 0; i < paths[u].size(); i++) {
            Path v = paths[u].get(i);


            if (!done.contains(v.getToTown())) {
                pathLength = v.getLength();
                newDistance = towns.get(u).distance + pathLength;


                if (newDistance < towns.get(v.getToTown()).distance)
                    towns.get(v.getToTown()).distance = newDistance;


                Town t = new Town(towns.get(v.getToTown()).index, towns.get(v.getToTown()).name);
                t.setDistance(towns.get(v.getToTown()).distance);
                priorityQueue.add(t);
            }
        }
    }


    public void showLengthTo(int source, int target) {

        dijkstra(source);
        if (towns.get(target).distance != 2147483647)
            System.out.println("Droga z " + towns.get(source).name + " do " + towns.get(target).name + " wynosi " + towns.get(target).distance);
        else System.out.println("Brak drogi");
    }

    public void showTowns(int source) {
        dijkstra(source);
        System.out.println("Dostepne miasta oraz ich drogi z " + towns.get(source).name);
        System.out.println("-----------------------------------------");
        for (int i = 0; i < towns.size(); i++) {
            if (i != source && towns.get(i).distance != 2147483647)
                System.out.println("Droga z " + towns.get(source).name + " do " + towns.get(i).name + " wynosi " + towns.get(i).distance);
        }
    }

    public void showList() {
        System.out.println("\n\nWYSWIETLANIE LISTY");
        for (int i = 0; i < paths.length; i++) {
            System.out.println("-----------------");
            System.out.println(towns.get(i).name);
            for (Path path : paths[i]) {

                System.out.println("do " + towns.get(path.getToTown()).name + " = " + path.getLength());

            }

        }
        System.out.println("\n\n");
    }

    int time = 0;

    public void DFS() {
        for (Town town : towns) {
            town.setColor("White");
            town.p = null;
        }
        time = 0;
        for (Town town : towns) {
            if (town.color.equals("White")) {
                DFS_Visit(town);
            }
        }
        System.out.println("\nDFS");
        for (Town town : towns) {

            System.out.println(town.name + " Czas wejscia: " + town.time + " Czas wyjscia: " + town.endTime);
        }
    }

    private void DFS_Visit(Town town) {
        town.color = "Grey";
        time = time + 1;
        town.setTime(time);
        for (Path path : paths[town.index]) {
            if (towns.get(path.getToTown()).color.equals("White")) {
                towns.get(path.getToTown()).p = town;
                DFS_Visit(towns.get(path.getToTown()));
            }
        }
        town.color = "Black";
        time++;
        town.endTime = time;

    }
}

