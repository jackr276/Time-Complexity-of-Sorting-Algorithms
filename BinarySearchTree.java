import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void add(int item){
        root = addRec(root, item);
    }
    private TreeNode addRec(TreeNode root, int item){
        // Tree is empty
        if (root == null) {
            root = new TreeNode(item);
            return root;
        }
        // Otherwise, we must traverse the tree

        // Must go left if this is the case
        if (item < root.getData()) {
           root.setLeft(addRec(root.getLeft(), item));
           // otherwise traverse right
        } else if (item > root.getData()){
            root.setRight(addRec(root.getRight(), item));
        }
        return root;
    }


    public void delete(int item) throws TreeException{
        if (root == null) {
            throw new TreeException("Error. Attempting to delete from an empty tree");
        }
        root = deleteRec(root, item);
    }

    private TreeNode deleteRec(TreeNode root, int item){
        //Tree is empty
        if (root == null){
            return root;
        }

        //Traverse the tree
        if (item < root.getData()){ //traverse left
            root.setLeft(deleteRec(root.getLeft(), item));
        } else if (item > root.getData()){ //traverse right
            root.setRight(deleteRec(root.getRight(), item));
        } else {
            // Only has one child
            if (root.getLeft() == null){
                return root.getRight();
            } else if (root.getRight() == null){
                return root.getLeft();
            }
            // Set root's data to be its inorder successor
            // This would be its minimum value in the right subtree
            root.setData(minValue(root.getRight()));

            root.setRight(deleteRec(root.getRight(), root.getData()));

        }
        return root;
    }


    private int minValue(TreeNode root){
        // Start off with minVal being root's value
        int minVal = root.getData();
        // We need only traverse left here (binary search tree)
        while(root.getLeft() != null){
            minVal = root.getLeft().getData();
            root = root.getLeft();
        }
        return minVal;
    }

    public void printBreadthFirst(){
        // Check to see if tree is empty
        if (root == null){
            System.out.print("The tree is empty");
        } else {
            // Use a queue to ensure the order is right
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()){
                TreeNode removed = nodes.remove();
                System.out.print(" " + removed.getData());
                // Add left node if not null
                if (removed.getLeft() != null){
                    nodes.add(removed.getLeft());
                }
                // Add right node if not null
                if (removed.getRight() != null){
                    nodes.add(removed.getRight());
                }
            }
        }
        System.out.println();
    }

    public void printPostOrderWrapper(){
        if (root == null) {
            System.out.print("The tree is empty");
        } else {
            printPostOrder(root);
        }
        System.out.println();
    }
    private void printPostOrder(TreeNode node){
        if (node == null){
            return;
        }
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());

        System.out.print(node.getData() + " ");
    }

    public void printInOrderWrapper() {
        if (root == null) {
            System.out.print("The tree is empty");
        } else {
            printInOrder(root);
        }
        System.out.println();
    }

    private void printInOrder(TreeNode node){
        if (node == null){
            return;
        }
        printInOrder(node.getLeft());

        System.out.print(node.getData() + " ");

        printInOrder(node.getRight());
    }

    public void printPreOrderWrapper(){
        if (root == null){
            System.out.print("The tree is empty");
        } else {
            printPreOrder(root);
        }
        System.out.println();
    }

    private void printPreOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.getData() + " ");

        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }
}
