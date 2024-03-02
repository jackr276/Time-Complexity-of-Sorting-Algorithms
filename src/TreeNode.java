/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 *
 * This class is a generic implementation for a node on a binary search tree
 */
public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;


    /**
     * The constructor for treenode. Left and right are always initialized to null
     * @param data the node's data
     */
    public TreeNode(int data){
        this.data = data;
        left = right = null;
    }


    /**
     * A simple getter for the left node
     * @return the left node
     */
    public TreeNode getLeft() {
        return this.left;
    }


    /**
     * A simple setter for the left node
     * @param newLeft the new left node
     */
    public void setLeft(TreeNode newLeft){
        this.left = newLeft;
    }


    /**
     * A simple getter for the right node
     * @return the right node
     */
    public TreeNode getRight() {
        return this.right;
    }


    /**
     * A simple setter for the right node
     * @param newRight the new right node
     */
    public void setRight(TreeNode newRight) {
        this.right = newRight;
    }


    /**
     * A simple getter for the data
     * @return the node's data
     */
    public int getData(){
        return this.data;
    }


    /**
     * A simple setter for the data
     * @param newData the new data
     */
    public void setData(int newData) {
        this.data = newData;
    }


    /**
     * A simple toString method. Simply returns the toString for the data
     * @return the toString of the data
     */
    public String toString(){
        return Integer.toString(this.data);
    }
}
