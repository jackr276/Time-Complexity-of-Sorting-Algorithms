/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 * This class is the Node that is used to create the linked list implementation of a stack
 * @param <T> stacknode is generic
 */
public class StackNode<T> {
    // The data in the node
    private T data;
    // The next node
    private StackNode<T> next;


    /**
     * The constructor for the StackNode
     * @param data the data for the node
     * @param next the next node
     */
    public StackNode(T data, StackNode<T> next){
        this.data = data;
        this.next = next;
    }


    /**
     * A simple getter for the data of the node
     * @return the data in the node
     */
    public T getData(){return this.data;}


    /**
     * A simple setter for the data in the ndoe
     * @param newData the newData to be set
     */
    public void setData(T newData){this.data = newData;}


    /**
     * A simple getter for the next node
     * @return the memory address of the next node
     */
    public StackNode<T> getNext() {return this.next;}


    /**
     * A simple setter for the next node
     * @param newNext the memory address of the new next node
     */
    public void setNext(StackNode<T> newNext){this.next = newNext;}


    /**
     * A simple toString. We only care about the data in the node, so return data.tostring
     * @return data.tostring
     */
    public String toString(){
        return data.toString();
    }

}
