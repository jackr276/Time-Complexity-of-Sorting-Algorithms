/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 *
 * This class is a generic implementation for a node on a binary search tree
 * @param <T> TreeNode is generic
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;


    /**
     * The constructor for treenode. Left and right are always initialized to null
     * @param data the node's data
     */
    public TreeNode(T data){
        this.data = data;
        left = right = null;
    }


    /**
     * A simple getter for the left node
     * @return the left node
     */
    public TreeNode<T> getLeft() {
        return this.left;
    }


    /**
     * A simple setter for the left node
     * @param newLeft the new left node
     */
    public void setLeft(TreeNode<T> newLeft){
        this.left = newLeft;
    }


    /**
     * A simple getter for the right node
     * @return the right node
     */
    public TreeNode<T> getRight() {
        return this.right;
    }


    /**
     * A simple setter for the right node
     * @param newRight the new right node
     */
    public void setRight(TreeNode<T> newRight) {
        this.right = newRight;
    }


    /**
     * A simple getter for the data
     * @return the node's data
     */
    public T getData(){
        return this.data;
    }


    /**
     * A simple setter for the data
     * @param newData the new data
     */
    public void setData(T newData) {
        this.data = newData;
    }


    /**
     * A simple toString method. Simply returns the toString for the data
     * @return the toString of the data
     */
    public String toString(){
        return this.data.toString();
    }
}
