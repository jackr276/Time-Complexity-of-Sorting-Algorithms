/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 * Assignmet 4 part c
 *
 * The partC class is used to implement partC of assignment 4. Presents the user with 7 options about adding to,
 * deleting from, and printing a binary search tree in 4 different ways.
 */

import java.util.Scanner;


public class partC {
    /**
     * The main method that takes in user input and calls appropriate methods in the BinarySearchTree class
     * as needed
     * @param args not used
     */
    public static void main(String[] args){
        displayMenu();
        BinarySearchTree bst = new BinarySearchTree();
        Scanner in = new Scanner(System.in);

        int userInput = Integer.parseInt(in.nextLine());
        while (userInput < 7 && userInput > 0){

            if (userInput == 1) {
                // Perform an add operation
                System.out.print("Enter a number to add: ");
                int number = Integer.parseInt(in.nextLine());
                bst.add(number);
                // redisplay the menu
                displayMenu();
                userInput = Integer.parseInt(in.nextLine());

            } else if (userInput == 2){
                // Perform the delete
                System.out.print("Enter a number to delete: ");
                int deleted = Integer.parseInt(in.nextLine());
                try {
                    bst.delete(deleted);
                } catch (TreeException e){
                    System.out.println(e.toString());
                }
                // redisplay the menu
                displayMenu();
                userInput = Integer.parseInt(in.nextLine());

            } else if (userInput == 3){
                // display breadth first
                bst.printBreadthFirst();
                // Show menu
                displayMenu();
                userInput = Integer.parseInt(in.nextLine());

            } else if (userInput == 4){
                // display post-order
                bst.printPostOrderWrapper();
                // Show menu
                displayMenu();
                userInput = Integer.parseInt(in.nextLine());

            } else if (userInput == 5){
                // display in-order
                bst.printInOrderWrapper();
                // Show menu
                displayMenu();
                userInput = Integer.parseInt(in.nextLine());

            } else if (userInput == 6) {
                // display pre-order
                bst.printPreOrderWrapper();
                // Show menu
                displayMenu();
                userInput = Integer.parseInt(in.nextLine());
            }
        }
    }


    /**
     * A simple private helper function that displays the menu
     */
    private static void displayMenu(){
        System.out.println("1.    Add an item");
        System.out.println("2.    Delete an item");
        System.out.println("3.    Print the tree breadth-first");
        System.out.println("4.    Print the tree post-order");
        System.out.println("5.    Print the tree in-order");
        System.out.println("6.    Print the tree pre-order");
        System.out.println("7.    Exit");
        System.out.print("Enter option: ");

    }
}
