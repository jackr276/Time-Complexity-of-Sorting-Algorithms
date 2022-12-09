import javax.swing.*;
import java.util.ArrayList;

public class partA {
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog("Enter an expression");
        int posOfUnbalance = checkExpressionBalanced(input);
        if (posOfUnbalance == -1){
            JOptionPane.showMessageDialog(null, "The expression is balanced");
        } else {
            JOptionPane.showMessageDialog(null, "The expression is unbalanced at character " +
                    Integer.toString(posOfUnbalance));
        }
    }

    private static int checkExpressionBalanced(String input){
        Stack<String> myStack = new Stack<>();
        String[] stringList = input.split("");
        for (int i = 1; i <= stringList.length; i++) {
            String ch = stringList[i-1];
            if (ch.equals("[") || ch.equals("{") || ch.equals("<")) {
                myStack.push(ch);
            }
            if (ch.equals("]")|| ch.equals("}") || ch.equals(">")) {
                // if stack is empty then this can't be right
                if (myStack.peek() == null){return i;}

                String top = myStack.pop().getData();

                if ((top.equals("[") && !ch.equals("]"))
                    || (top.equals("{") && !ch.equals("}"))
                    || (top.equals("<") && !ch.equals(">"))){
                    return i;
                }

            }
        }
        return -1;
    }
}
