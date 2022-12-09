/**
 * Jack Robbins
 * CMP-233
 * Professor Sawh
 * This class is the Node that is used to create the linked list implementation of a stack
 * @param <T> stacknode is generic
 */
public class StackNode<T> {
    private T data;
    private StackNode<T> next;

    public StackNode(T data, StackNode<T> next){
        this.data = data;
        this.next = next;
    }
    public T getData(){return this.data;}

    public void setData(T newData){this.data = newData;}

    public StackNode<T> getNext() {return this.next;}

    public void setNext(StackNode<T> newNext){this.next = newNext;}

    public String toString(){
        return data.toString();
    }

}
