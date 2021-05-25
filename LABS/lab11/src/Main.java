import java.io.*;

public class Main {
    public static void main(String[] args) {
        RB_Tree rb = createRB_Tree("H:\\sem2\\lab11\\src\\text.txt");

        ToStringExec exec = new ToStringExec();
        rb.inOrderWalk(exec);
        System.out.println(exec.getResult());
        rb.przechodzenieWszerz();
        System.out.println();

        rb.TreeDelete("pada");
        exec.clear();
        rb.inOrderWalk(exec);
        System.out.println(exec.getResult());

        rb.przechodzenieWszerz();
    }

    private static RB_Tree createRB_Tree(String path) {

        RB_Tree rb = new RB_Tree();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
            String line;
            int verse = 1;
            while ((line = bufferedReader.readLine()) != null) {

                String[] table = line.split(" ");
                for (int j = 0; j < table.length; j++) {
                    table[j] = table[j].replaceAll("\\.", "");
                    table[j] = table[j].replaceAll(",", "");
                    table[j] = table[j].replaceAll("-", "");
                    if (!table[j].equals(""))
                        rb.TreeInsert(table[j], verse);
                }

                verse++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return rb;
    }
}
