public class Stack<T> {
    private StackNode<T> top;

    public StackNode<T> peek(){
        return this.top;
    }
    public StackNode<T> pop(){
        StackNode<T> temp = this.top;
        top.setNext(top.getNext());
        return temp;
    }

    public void push(StackNode<T> newTop){
        newTop.setNext(this.top);
        this.top = newTop;
    }

}
