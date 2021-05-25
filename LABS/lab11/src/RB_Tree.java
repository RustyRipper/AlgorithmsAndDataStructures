
import java.util.ArrayDeque;
import java.util.ArrayList;

public class RB_Tree {
    private Node root;
    private final Node leaf;

    public RB_Tree() {
        this.leaf = new Node();
        leaf.color = false;

    }

    static class Node {
        boolean color = true; //Red - true, Black - false
        String key;
        Node parent;
        Node left;
        Node right;
        ArrayList<Integer> lineNumbers;

        public Node(String key, int number) {
            this.key = key;
            lineNumbers = new ArrayList<>();
            this.lineNumbers.add(number);
        }

        public Node() {
        }
    }

    public void inOrderWalk(ToStringExec exec) {
        inOrderWalk(root, exec);
    }

    private void inOrderWalk(Node node, ToStringExec exec) {
        if (node != null) {

            inOrderWalk(node.left, exec);
            if (node.lineNumbers != null)
                exec.execute(node.key, node.lineNumbers);
            inOrderWalk(node.right, exec);

        }
    }

    public void TreeInsert(String statement, int verse) {
        Node z = new Node(statement, verse);
        z.left = leaf;
        z.right = leaf;


        Node y = null;
        Node x = root;


        while (x != null && x.key != null) {
            y = x;
            if (z.key.compareTo(x.key) < 0)
                x = x.left;
            else if (z.key.compareTo(x.key) == 0) {
                x.lineNumbers.add(verse);
                return;
            } else
                x = x.right;
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.key.compareTo(y.key) < 0) {
            y.left = z;
        } else y.right = z;

        if (z.parent == null) {
            z.color = false;
            return;

        }
        if (z.parent.parent == null) {
            return;

        }
        y = new Node();  // uncle
        while (z.parent.color && z.parent != root) {
            if (z.parent == z.parent.parent.left) {
                y = z.parent.parent.right;
                if (y.color) {
                    // case 1
                    y.color = false;
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        // case 2
                        z = z.parent;
                        leftRotate(z);
                    }
                    // case 3
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    rightRotate(z.parent.parent);
                }
            } else {
                y = z.parent.parent.left;
                if (y.color) {
                    // case 1
                    y.color = false;
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        // case 2
                        z = z.parent;
                        rightRotate(z);
                    }
                    // case 3
                    z.parent.color = false;
                    z.parent.parent.color = true;
                    leftRotate(z.parent.parent);
                }
            }
            if (z == root) {
                break;
            }
        }
        root.color = false;


    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null)
            this.root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;

        y.right = x;
        x.parent = y;
    }

    public void przechodzenieWszerz() {
        System.out.println("Przechodzenie wszerz: ");
        Node node;
        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        node = root;
        while (!arrayDeque.isEmpty()) {
            if (node.left.left != null && node.left.right != null) {
                arrayDeque.add(node.left);
            }
            if (node.right.left != null && node.right.right != null)
                arrayDeque.add(node.right);

            System.out.print(arrayDeque.remove().key + " ");
            if (!arrayDeque.isEmpty())
                node = arrayDeque.getFirst();
        }

    }

    public void TreeDelete(String statement) {
        Node z = root;
        Node x, y;
        while (z != leaf) {
            if (z.key.equals(statement)) {
                break;
            }
            if (statement.compareTo(z.key) < 0) {
                z = z.left;
            } else {
                z = z.right;
            }
        }
        if (z == leaf) {
            System.out.println("\n!!!!Not find");
            return;
        }
        if (z.left == leaf && z.right == leaf) {
            y = z;
        } else y = minimum(z.right);

        if (y.left != leaf) x = y.left;
        else x = y.right;
        x.parent = y.parent;

        if (y.parent == leaf) root = x;
        else if (y == y.parent.left) y.parent.left = x;
        else y.parent.right = x;

        if (y != z) {
            swap(z, y);
        }


        if (!y.color) {
            repairDelete(x);
        }
    }

    private void swap(Node x, Node y) {
        Node p = x;
        x.key = y.key;
        x.lineNumbers = y.lineNumbers;
        y.key = p.key;
        y.lineNumbers = p.lineNumbers;
    }

    public Node minimum(Node node) {
        while (node.left != leaf) {
            node = node.left;
        }
        return node;
    }

    private void repairDelete(Node x) {
        Node w;
        while (x != root && !x.color) {
            if (x == x.parent.left) {
                w = x.parent.right;
                if (w.color) {
                    // case 1
                    w.color = false;
                    x.parent.color = true;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }

                if (!w.left.color && !w.right.color) {
                    // case 2
                    w.color = true;
                    x = x.parent;
                } else {
                    if (!w.right.color) {
                        // case 3
                        w.left.color = false;
                        w.color = true;
                        rightRotate(w);
                        w = x.parent.right;
                    }

                    // case 4
                    w.color = x.parent.color;
                    x.parent.color = false;
                    w.right.color = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                w = x.parent.left;
                if (w.color) {
                    // case 1
                    w.color = false;
                    x.parent.color = true;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }

                if (!w.left.color && !w.right.color) {
                    // case 2
                    w.color = true;
                    x = x.parent;
                } else {
                    if (!w.left.color) {
                        // case 3
                        w.right.color = false;
                        w.color = true;
                        leftRotate(w);
                        w = x.parent.left;
                    }

                    // case 4
                    w.color = x.parent.color;
                    x.parent.color = false;
                    w.left.color = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = false;
    }
}
