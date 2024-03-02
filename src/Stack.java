/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 * A generic implementation of a stack using StackNode
 * @param <T> Stack is generic
 */
public class Stack<T> {
    // The very top of the stack
    private StackNode<T> top;


    /**
     * Returns the stacknode on the top
     * @return the top stackNode
     */
    public StackNode<T> peek(){
        return this.top;
    }


    /**
     * Pops the top node off of the stack
     * @return the top node on the stack
     */
    public StackNode<T> pop(){
        StackNode<T> temp = this.top;
        top.setNext(top.getNext());
        this.top = top.getNext();
        return temp;
    }


    /**
     * Pushes a new item onto the top of the stack
     * @param newItem the generic new item
     */
    public void push(T newItem) {
        StackNode<T> newTop = new StackNode<>(newItem, null);
        if (this.top == null) {
            this.top = newTop;
        } else {
            newTop.setNext(this.top);
            this.top = newTop;
        }
    }


    /**
     * Provides a way to write the stack out as a string
     * @return a formatted string representation of the stack
     */
    @Override
    public String toString() {
        StackNode<T> temp = top;
        String returnedString = "";
        while (temp != null){
            returnedString += temp.toString();
            returnedString += " ";
            temp = temp.getNext();
        }
        return returnedString;
    }
}
