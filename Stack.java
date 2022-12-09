public class Stack<T> {
    private StackNode<T> top;

    public StackNode<T> peek(){
        return this.top;
    }
    public StackNode<T> pop(){
        StackNode<T> temp = this.top;
        top.setNext(top.getNext());
        this.top = top.getNext();
        return temp;
    }

    public void push(T newItem) {
        StackNode<T> newTop = new StackNode<>(newItem, null);
        if (this.top == null) {
            this.top = newTop;
        } else {
            newTop.setNext(this.top);
            this.top = newTop;
        }
    }

    @Override
    public String toString() {
        StackNode<T> temp = top;
        String returnedString = "";
        while (temp != null){
            returnedString += temp.toString();
            temp = temp.getNext();
        }
        return returnedString;
    }
}
