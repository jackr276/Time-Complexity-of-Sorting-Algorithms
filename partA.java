/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 * Assignment 4 Part A
 *
 * This part of the assignment uses JOptionPane to get an expression from the user, and uses a Stack to
 * determine if the expression is balanced
 */

import javax.swing.*;

public class partA {


    /**
     * The main method. Uses JOptionPane to get user input, then uses checkExpressionBalanced to check
     * if the string the user inputted is balanced. The method will then use JOptionPane to display a
     * message to the user
     * @param args not used
     */
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog("Enter an expression");
        //if -1 is returned, expression is all good
        int posOfUnbalance = checkExpressionBalanced(input);
        if (posOfUnbalance == -1){
            JOptionPane.showMessageDialog(null, "The expression is balanced");
        } else {
            JOptionPane.showMessageDialog(null, "The expression is unbalanced at character " +
                    Integer.toString(posOfUnbalance));
        }
    }


    /**
     * The private helper function that checks if the expression is balanced
     * @param input the string inputted by the user
     * @return -1 if the expression is balanced, or the position of the mistake if it is not balanced
     */
    private static int checkExpressionBalanced(String input){
        Stack<String> myStack = new Stack<>();
        String[] stringList = input.split("");
        // Load open symbols onto the stack
        for (int i = 1; i <= stringList.length; i++) {
            String ch = stringList[i-1];
            if (ch.equals("[") || ch.equals("{") || ch.equals("<")) {
                myStack.push(ch);
            }
            // If a closing symbol is come across, pop the stack and see if it matches
            if (ch.equals("]")|| ch.equals("}") || ch.equals(">")) {
                // if stack is empty then this can't be right
                if (myStack.peek() == null){return i;}

                String top = myStack.pop().getData();
                // The stack was loaded backwards, so these should always match if the expression is balanced
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
