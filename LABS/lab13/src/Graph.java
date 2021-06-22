import java.util.*;

public class Graph {

    int amountNodes;
    int amountPaths;
    List<Path>[] paths;

    @SuppressWarnings("unchecked")
    public Graph(int amountNodes, int amountPaths) {
        this.amountNodes = amountNodes;
        this.amountPaths = amountPaths;
        this.paths = (List<Path>[]) new List[amountNodes];
        for (int i = 0; i < amountNodes; i++) {
            paths[i] = new ArrayList<>();
        }
    }

    public void addPath(Path path) {
        paths[path.from - 1].add(path);
    }

    public int kruskal() {
        int length = 0;
        ArrayList<Path> listT = new ArrayList<>();
        PriorityQueue<Path> listL = new PriorityQueue<>(new Comparator<Path>() {
            @Override
            public int compare(Path o1, Path o2) {
                return o1.length - o2.length;
            }
        });
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < amountNodes; i++) {
            listL.addAll(paths[i]);
            nodes.add(new ArrayList<>());
            nodes.get(i).add(i + 1);
        }


        while (listL.size() != 0) {
            Path path = listL.poll();
            int from = 0;
            int to = 0;
            boolean flag = true;
            for (ArrayList<Integer> alist : nodes) {
                for (Integer integer : alist) {
                    if (integer == path.from) {
                        from = nodes.indexOf(alist);
                        for (Integer integer1 : alist) {
                            if (integer1 == path.to) {
                                flag = false;
                            }
                        }
                    }
                }
            }

            if (flag) {
                for (ArrayList<Integer> alist : nodes) {
                    for (Integer integer : alist) {
                        if (integer == path.to) {
                            to = nodes.indexOf(alist);
                        }
                    }
                }

                while (!nodes.get(to).isEmpty()) {
                    nodes.get(from).add(nodes.get(to).remove(0));
                }
                listT.add(path);
                length += path.length;
            }

            if(listL.size() == 0 && nodes.get(from).size()!=amountNodes ){
                System.out.println("Brak wszystkich polaczen");
            }

        }
        

        return length;
    }
}
