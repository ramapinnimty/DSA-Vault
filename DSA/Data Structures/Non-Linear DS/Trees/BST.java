import java.util.ArrayList;

public class BST {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node: " + value;
        }
    }

    private Node rootNode;

    public void insert(int value) {
        Node newNode = new Node(value);

        if(rootNode == null) {
            rootNode = newNode;
            return;
        }

        Node current = rootNode;
        while(current != null) {
            if(current.value < value) {
                if(current.rightChild == null) {
                    current.rightChild = newNode;
                    return;
                }
                current = current.rightChild;
            }
            else {
                if(current.leftChild == null) {
                    current.leftChild = newNode;
                    return;
                }
                current = current.leftChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = rootNode;
        while(current != null) {
            if(current.value == value)
                return true;

            if(current.value < value)
                current = current.rightChild;
            else
                current = current.leftChild;
        }

        return false;
    }

    public void preOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.value);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void inOrder(Node root) {
        if(root == null)
            return;

        inOrder(root.leftChild);
        System.out.println(root.value);
        inOrder(root.rightChild);
    }

    public void postOrder(Node root) {
        if(root == null)
            return;

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }
    
    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(rootNode, distance, list);

        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if(root == null)
            return;

        if(distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);
    }

    public void levelOrder(Node root) {
        for(int i=0; i<=heightOfTree(); i++) {
            for(var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public int heightOfTree() {
        return heightOfTree(rootNode);
    }

    private int heightOfTree(Node root) {
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(heightOfTree(root.leftChild), heightOfTree(root.rightChild));
    }

    public int minValue() {
        return minValue(rootNode);
    }

    private int minValue(Node root) {
        //   FOR BST : O(log n)   //
        if(root == null)
            throw new IllegalStateException();

        Node current = root;
        while(!isLeaf(current))
            current = current.leftChild;

        return current.value;
        //   FOR BINARY TREE : O(n)   //
        // if(isLeaf(root))
        //     return root.value;

        // return Math.min(root.value, Math.min(minValue(root.leftChild), minValue(root.rightChild)));
    }

    public static void main(String[] args) {
        BST tree = new BST();
        //   INSERT   //
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println("Insertion complete!");

        //   FIND   //
        System.out.println(tree.find(10));

        //   Traversals   //
        System.out.println("Pre-Order: ");
        tree.preOrder(tree.rootNode);
        System.out.println("In-Order: ");
        tree.inOrder(tree.rootNode);
        System.out.println("Post-Order: ");
        tree.postOrder(tree.rootNode);

        int distance = 2;
        System.out.println("Nodes at a distance of " + distance + ": ");
        System.out.println(tree.getNodesAtDistance(distance).toString());
        System.out.println("Level-Order: ");
        tree.levelOrder(tree.rootNode);

        System.out.println("Height of the tree: " + tree.heightOfTree(tree.rootNode));

        System.out.println("Minimum value in the tree is: " + tree.minValue());
    }
}