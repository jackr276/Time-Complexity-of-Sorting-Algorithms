/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 *
 * The BinarySearchTree class is made for a binary search tree of integers. Supports delete, add, breadth-first print,
 * post-order print, in-order print, pre-order print
 */
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {
    // The root is all that is needed to keep track of the tree
    private TreeNode root;


    // To initialize, set the root to be null
    public BinarySearchTree(){
        this.root = null;
    }


    /**
     * This is a simple wrapper for the add method
     * @param item the item to be added
     */
    public void add(int item){
        root = addRec(root, item);
    }


    /**
     * The actual add method. Is implemented recursively and needs a node and the item to be added.
     * @param root the node used to keep track of the tree
     * @param item the item to be added
     * @return either the left or right node, this method is recursive
     */
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


    /**
     * A simple wrapper for the delete method
     * @param item the item to be deleted
     * @throws TreeException throws an exception if the user tries to delete from an empty tree
     */
    public void delete(int item) throws TreeException{
        if (root == null) {
            throw new TreeException("Error. Attempting to delete from an empty tree");
        }
        root = deleteRec(root, item);
    }


    /**
     * The recursive actual delete method. Recursively traverses the tree to find the item to be deleted. If the
     * item is not found, nothing is deleted
     * @param root the root node
     * @param item the item to be deleted
     * @return either the left or right node, delete is recursive
     */
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


    /**
     * A simple helper method that finds the minimum value in the tree. Is used by delete to determine where to
     * travers
     * @param root the node
     * @return an integer minimum value
     */
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


    /**
     * The method that prints Breadth-first. Uses a queue to keep track of the nodes that have been removed to ensure
     * that a FIFO structure is maintained when printing the tree
     */
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


    /**
     * A simple wrapper method for the printPostOrder method. Prints the tree is empty if it's empty, otherwise
     * calls printPostOrder
     */
    public void printPostOrderWrapper(){
        if (root == null) {
            System.out.print("The tree is empty");
        } else {
            printPostOrder(root);
        }
        System.out.println();
    }


    /**
     * A recursive implementation of printing post order. Calls itself on node.getLeft and node.getRight before
     * printing the node's data, this way inorder structure is maintained
     * @param node the node that is returned, either left or right
     */
    private void printPostOrder(TreeNode node){
        if (node == null){
            return;
        }
        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());

        System.out.print(node.getData() + " ");
    }


    /**
     * A simple wrapper for the printInOrder method. Prints if the tree is empty, otherwise calls
     * printInOrder
     */
    public void printInOrderWrapper() {
        if (root == null) {
            System.out.print("The tree is empty");
        } else {
            printInOrder(root);
        }
        System.out.println();
    }


    /**
     * A recursive implementation of printing inOrder. Calls printInOrder on the left side first, then prints the node,
     * then calls the function on the right side of the tree, to maintain an in-order structure
     * @param node the node passed into the functions
     */
    private void printInOrder(TreeNode node){
        if (node == null){
            return;
        }
        printInOrder(node.getLeft());

        System.out.print(node.getData() + " ");

        printInOrder(node.getRight());
    }


    /**
     * A simple wrapper method for the preOrder method. Checks if the tree is empty, otherwise calls
     * printInOrder
     */
    public void printPreOrderWrapper(){
        if (root == null){
            System.out.print("The tree is empty");
        } else {
            printPreOrder(root);
        }
        System.out.println();
    }


    /**
     * The recursize implementation of the printPreOrder method. First prints the data in the node, then calls
     * itself on the left and then right subtrees. This way, the tree is printed in reverse
     * @param node the node that is passed in
     */
    private void printPreOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.getData() + " ");

        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }
}
