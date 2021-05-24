import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String statement = loadFromFile("H:\\sem2\\lab10\\src\\statement2.txt");
        System.out.println(statement+"\n");
        ArrayList<BST> trees = createTrees(statement);
        PriorityQueue<BST> priorityQueue = createQueue(trees);


        BST bst = createBST(priorityQueue);
int i;
        bst.codeTree();
        bst.showCodes();

        saveToFile(bst, "H:\\sem2\\lab10\\src\\result2.txt", statement);

        String statement2 = loadFromFile("H:\\sem2\\lab10\\src\\result2.txt");
        System.out.println("\n"+statement2);
        System.out.println("\nUNCODE\n");
        System.out.println(bst.unCode(statement2));
    }


    private static String loadFromFile(String file) {
        String statement = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file)))) {

            statement = bufferedReader.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private static ArrayList<BST> createTrees(String st) {
        ArrayList<BST> trees = new ArrayList<>();
        String statement = st;
        while (statement.length() != 0) {
            String sign = String.valueOf(statement.charAt(0));
            int value = 0;
            for (int j = 0; j < statement.length(); j++) {
                if (sign.equals(String.valueOf(statement.charAt(j))))
                    value++;
            }
            statement = statement.replace(sign, "");
            trees.add(new BST(sign, value));


        }
        return trees;
    }

    private static PriorityQueue<BST> createQueue(ArrayList<BST> trees) {
        trees.sort(new Comparator<>() {
            @Override
            public int compare(BST o1, BST o2) {
                return o1._root.value - o2._root.value;
            }
        });
        PriorityQueue<BST> priorityQueue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(BST o1, BST o2) {
                if (o1._root.value - o2._root.value == 0) {
                    BST.Node one = o1._root;
                    BST.Node two = o2._root;
                    int i1 = 0;
                    int i2 = 0;
                    while (one.right != null) {
                        i1++;
                        one = one.right;
                    }
                    while (two.right != null) {
                        i2++;
                        two = two.right;
                    }
                    if (i1 - i2 == 0) {
                        one = o1._root;
                        two = o2._root;
                        while (one.left != null) {
                            i1++;
                            one = one.right;
                        }
                        while (two.left != null) {
                            i2++;
                            two = two.right;
                        }
                        if (i1 - i2 == 0)
                            return one.sign.compareTo(two.sign);
                    }
                    return i1 - i2;
                }
                return o1._root.value - o2._root.value;
            }
        });
        priorityQueue.addAll(trees);
        return priorityQueue;
    }

    private static BST createBST(PriorityQueue<BST> priorityQueue) {

        while (priorityQueue.size() > 1) {
            BST left = priorityQueue.poll();
            BST right = priorityQueue.poll();
            assert right != null;
            BST bst = new BST(null, left._root.value + right._root.value);
            bst._root.left = left._root;
            bst._root.right = right._root;
            priorityQueue.add(bst);

        }
        return priorityQueue.poll();
    }

    private static void saveToFile(BST bst, String file, String statement) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < statement.length(); i++) {
            String z = String.valueOf(statement.charAt(i));
            for (Code code : bst.codes) {
                if (code.sign.equals(z)) {
                    result.append(code.code);
                    break;
                }
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(file)))) {
            bufferedWriter.write(String.valueOf(result));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
