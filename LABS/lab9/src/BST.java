import java.util.ArrayDeque;
import java.util.Stack;

public class BST {


    static class Node {
        String value; // element
        Node left;
        Node right;

        Node(String obj) {
            value = obj;
        }

    }


    public Node _root;

    public BST() {
        _root = null;
    }

    public double oblicz() {

        return obliczWezel(_root);

    }

    public double obliczWezel(Node node) {
        if (node.left == null || node.right == null) {
            return Double.parseDouble(node.value);
        }
        double w1 = obliczWezel(node.left);
        String c = node.value;
        double w2 = obliczWezel(node.right);
        if (c.equals("+")) return w1 + w2;
        if (c.equals("-")) return w1 - w2;
        if (c.equals("%")) return w1 % w2;
        if (c.equals("*")) return w1 * w2;
        if (c.equals("/")) return w1 / w2;

        return 0;
    }

    public void createBST(String wyrazenie) {

        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < wyrazenie.length(); i++) {


            StringBuilder s = new StringBuilder("" + wyrazenie.charAt(i));
            if (s.toString().equals(" ")) ;
            else if (s.toString().equals("*") || s.toString().equals("/") || s.toString().equals("+") || s.toString().equals("-") || s.toString().equals("%")) {
                Node node = new Node(s.toString());
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            } else {

                while (!("" + wyrazenie.charAt(i + 1)).equals(" ")) {
                    s.append(wyrazenie.charAt(i + 1));
                    i++;
                }
                Node node = new Node(s.toString());

                stack.push(node);
            }
        }
        _root = stack.pop();
    }

    public void inOrderWalk(ToStringExec exec) {
        inOrderWalk(_root, exec);
    }

    private void inOrderWalk(Node node, ToStringExec exec) {
        if (node != null) {
            exec.nawias(true);
            inOrderWalk(node.left, exec);
            exec.execute(node.value);
            inOrderWalk(node.right, exec);
            exec.nawias(false);
        }
    }

    public void postOrderWalk(ToStringExec exec) {
        postOrderWalk(_root, exec);
    }

    private void postOrderWalk(Node node, ToStringExec exec) {
        if (node != null) {

            postOrderWalk(node.left, exec);
            postOrderWalk(node.right, exec);
            exec.execute(node.value);

        }
    }

    public void wyswietlInfiksowany() {
        ToStringExec exec = new ToStringExec();
        inOrderWalk(exec);
        System.out.println(exec.getResult() + " = " + oblicz());
    }

    public void wyswietlPostfiksowany() {
        ToStringExec exec = new ToStringExec();
        postOrderWalk(exec);
        System.out.println(exec.getResult() + " = " + oblicz());
    }

    public int obliczIloscLisci(Node node) {
        int liczbaLisci;
        if (node.left == null && node.right == null)
            liczbaLisci = 1;
        else {
            assert node.left != null;
            liczbaLisci = obliczIloscLisci(node.left) + obliczIloscLisci(node.right);
        }
        return liczbaLisci;
    }

    public int obliczIloscWezlow(Node node) {
        int liczbaWezlow;
        if (node.left == null && node.right == null)
            liczbaWezlow = 1;
        else {
            assert node.left != null;
            liczbaWezlow = obliczIloscWezlow(node.left) + obliczIloscWezlow(node.right) + 1;
        }
        return liczbaWezlow;

    }

    public int obliczWysokosc(Node node) {
        int wysokoscDrzewa = 0;
        if (node.left == null && node.right == null) {
        } else {
            assert node.left != null;
            int w1 = obliczWysokosc(node.left);
            int w2 = obliczWysokosc(node.right);
            if (w1 < w2) {
                wysokoscDrzewa = w2 + 1;
            } else wysokoscDrzewa = w1 + 1;
        }
        return wysokoscDrzewa;

    }

    public void przechodzenieWszerz() {
        System.out.println("Przechodzenie wszerz: ");
        Node node;
        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(_root);
        node = _root;
        while (!arrayDeque.isEmpty()) {
            if (node.left != null && node.right != null) {
                arrayDeque.add(node.left);

                arrayDeque.add(node.right);
            }
            System.out.print(arrayDeque.remove().value+ " ");
            if (!arrayDeque.isEmpty())
                node = arrayDeque.getFirst();
        }

    }
}