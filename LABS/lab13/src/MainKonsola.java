
import java.util.Scanner;

public class MainKonsola {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            Graph graph = null;

            String firstLine = scanner.nextLine();
            String[] tab = firstLine.split(" ");
            int n = Integer.parseInt(tab[0]);
            int m = Integer.parseInt(tab[1]);
            if (!(n < 1 || n > 20 || m < 0 || m > 190)) {
                graph = new Graph(n, m);
                String line;
                for (int x = 0; x < m; x++) {
                    line = scanner.nextLine();
                    String[] tab2 = line.split(" ");
                    int i = Integer.parseInt(tab2[0]);
                    int j = Integer.parseInt(tab2[1]);
                    int k = Integer.parseInt(tab2[2]);
                    if (!(i<1 || j<1 || i>n || j>n || k<1 || k>500)) {
                        graph.addPath(new Path(i, j, k));
                    }

                }


                System.out.println("Najkrotsza odleglosc: " + graph.kruskal() + "cm");
            }


        }
    }


//1 - 280
//2 - 0
//3 - 600
//4 - 9500
//5 - 2500
//6 - 700 blad
//7 - 1500


}
