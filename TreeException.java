public class TreeException extends Exception {
    private String m;

    public TreeException(String message){
        this.m = message;
    }

    public String toString(){
        return this.m;
    }
}
