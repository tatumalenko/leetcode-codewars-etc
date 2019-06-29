import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        // System.out.println(repeatedStringMatch("aaaaaaaaaaaab", "ba"));

        //
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // inOrder(root);
        postOrder(root);
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null || stack.size() != 0) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.println(node); // Print left node

            node = node.right;
        }
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);

            if (node.left != null)
                s1.push(node.left);
            if (node.right != null)
                s1.push(node.right);
        }

        while (!s2.isEmpty()) {
            Node node = s2.pop();
            System.out.println(node);
        }
    }

    public static int repeatedStringMatch(String A, String B) {
        StringBuilder manyA = new StringBuilder(A);
        int repeated = 1;
        int maxLength = B.length();

        // If A.length() < B.length(), impossible for B to be substring of A
        while (manyA.length() < maxLength) {
            manyA.append(A);
            repeated++;
        }

        // If A.length() >= B.length(), then only one repeat necessary
        if (manyA.toString().contains(B))
            return repeated;
        else {
            manyA.append(A);
            repeated++;
            if (manyA.toString().contains(B))
                return repeated;
        }

        return -1;
    }
}

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return Integer.toString(this.data);
    }
}