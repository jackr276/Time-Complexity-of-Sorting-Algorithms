
public class BinarySearchTree<T> {
    private TreeNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void add(int item){
        root = addRec(root, item);
    }
    private TreeNode addRec(TreeNode root, int item){
        // Tree is empty
        if (root == null) {
            root = new TreeNode(item);
            return root;
        }
        // Otherwise, we must traverse the tree

        // Must go left if this is the case
        if (item < root.getData()) {
           root.setLeft(addRec(root.getLeft(), item));
           // otherwise traverse right
        } else if (item > root.getData()){
            root.setRight(addRec(root.getRight(), item));
        }
        return root;
    }


    public void delete(int item){
        root = deleteRec(root, item);
    }

    private TreeNode deleteRec(TreeNode root, int item){
        //Tree is empty
        if (root == null){
            return root;
        }

        //Traverse the tree
        if (item < root.getData()){ //traverse left
            root.setLeft(deleteRec(root.getLeft(), item));
        } else if (item > root.getData()){ //traverse right
            root.setRight(deleteRec(root.getRight(), item));
        } else {
            // Only has one child
            if (root.getLeft() == null){
                return root.getRight();
            } else if (root.getRight() == null){
                return root.getLeft();
            }
            //Set root's data to be its inorder successor
            // This would be its minimum value in the right subtree
            root.setData(minValue(root.getRight()));

            root.setRight(deleteRec(root.getRight(), root.getData()));

        }
        return root;
    }


    private int minValue(TreeNode root){
        // Start off with minVal being root's value
        int minVal = root.getData();
        // We need only traverse left here (binary search tree)
        while(root.getLeft() != null){
            minVal = root.getLeft().getData();
            root = root.getLeft();
        }
        return minVal;
    }
}
