import java.util.ArrayList;
import java.util.Comparator;

public class BST {


    public static class Node {
        String sign;
        public int value;
        Node left;
        Node right;

        Node(String sign, int value) {
            this.sign = sign;
            this.value = value;
        }

    }

    public ArrayList<Code> codes = new ArrayList<>();

    public Node _root;

    public BST(String sign, int value) {
        _root = new Node(sign, value);
    }

    public void codeTree() {
        String statement = "";

        StringBuilder sb = new StringBuilder(statement);
        codeTree(_root, sb);

        codes.sort(new Comparator<>() {
            @Override
            public int compare(Code o1, Code o2) {
                if (o2.value - o1.value == 0)
                    return o1.code.compareTo(o2.code);
                return o2.value - o1.value;
            }
        });
    }

    private void codeTree(Node node, StringBuilder sb) {
        if (node.left == null && node.right == null) {

            //System.out.println(node.sign + " - "+node.value + "  " + sb.toString());
            codes.add(new Code(node.sign, sb.toString(), node.value));
            return;
        }

        assert node.left != null;

        codeTree(node.left, (sb.append("0")));
        sb.delete(sb.length() - 1, sb.length());
        codeTree(node.right, (sb.append("1")));
        sb.delete(sb.length() - 1, sb.length());
    }

    public void showCodes() {
        for (Code code : codes) {
            System.out.println(code.sign + " - " + code.value + "    " + code.code);
        }
    }

    public String unCode(String statement) {
        StringBuilder statement2 = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        Node node = _root;
        for (int i = 0; i < statement.length(); ) {

            while (node.left != null && node.right != null) {
                sb.append(statement.charAt(i));
                if (String.valueOf(statement.charAt(i)).equals("0")) {
                    node = node.left;
                } else if (String.valueOf(statement.charAt(i)).equals("1")) {
                    node = node.right;
                }
                i++;
            }
            statement2.append(node.sign);
            node = _root;
            sb = new StringBuilder();

        }
        return String.valueOf(statement2);
    }
}