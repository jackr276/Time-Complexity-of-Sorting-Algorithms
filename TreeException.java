/**
 * @author Jack Robbins
 * CMP-233
 * Professor Sawh
 *
 * This is the TreeException classed that is thrown by the delete method in the BinarySearchTree class
 */
public class TreeException extends Exception {
    private String m;


    public TreeException(String message){
        this.m = message;
    }


    public String toString(){
        return this.m;
    }
}
