import java.io.*;

public class Main {
    public static void main(String[] args) {
        for (int jj = 1; jj <= 7; jj++) {
            String path = "H:\\sem2\\lab13\\src\\da" + jj + ".txt";
            Graph graph = null;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
                String firstLine = bufferedReader.readLine();
                String[] tab = firstLine.split(" ");
                int n = Integer.parseInt(tab[0]);
                int m = Integer.parseInt(tab[1]);
                if (!(n < 1 || n > 20 || m < 0 || m > 190)) {
                    graph = new Graph(n, m);

                    for (int ii = 0; ii < Integer.parseInt(tab[1]); ii++) {

                        String line = bufferedReader.readLine();
                        String[] tab2 = line.split(" ");
                        int i = Integer.parseInt(tab2[0]);
                        int j = Integer.parseInt(tab2[1]);
                        int k = Integer.parseInt(tab2[2]);
                        if (!(i<1 || j<1 || i>n || j>n || k<1 || k>500)) {
                            graph.addPath(new Path(i, j, k));
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            assert graph != null;
            System.out.println("da" + jj + " Najkrotsza odleglosc: " + graph.kruskal() + "cm");


        }
    }


}
//1 - 280
//2 - 0
//3 - 600
//4 - 9500
//5 - 2500
//6 - 700blad
//7 - 1500

