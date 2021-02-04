import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private Node<T> root;

    public BinaryTree(){ }

    public BinaryTree(Node<T> root){
        this.root = root;
    }

    /*-----------------------------------------------------------------------------*/

    //1) Balanced Binary Tree
    // Given a binary tree, determine if it is height-balanced.

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node<T> root) {
        if(root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(Node<T> node){
        if(node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    /*-----------------------------------------------------------------------------*/

    //2) Minimum Depth of Binary Tree
    //Given a binary tree, find its minimum depth.
    //The minimum depth is the number of nodes along the shortest path from
    // the root node down to the nearest leaf node.
    public int minDepth(){
        return minDepth(root);
    }

    private int minDepth(Node<T> root){
        if(root == null)
            return 0;
        if(root.left == null)
            return 1 + minDepth(root.right);
        if(root.right == null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /*----------------------------------------------------------------------------*/

    //3) Find Leaves of Binary Tree
    //Given a binary tree, collect a tree's nodes as if you were doing this:
    // Collect and remove all leaves, repeat until the tree is empty.
    public List<List<T>> findLeaves(){
        List<List<T>> res = new ArrayList<>();
        nodeHeight(root, res);
        return res;
    }

    private int nodeHeight(Node<T> node, List<List<T>> res){
        if(node == null)
            return -1;

        int leftHeight = nodeHeight(node.left, res);
        int rightHeight = nodeHeight(node.right, res);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        if(res.size() == currHeight)
            res.add(new ArrayList<>());
        res.get(currHeight).add(node.data);

        return currHeight;
    }

    /*----------------------------------------------------------------------------*/

    //4) Sum of Left Leaves
    //Find the sum of all left leaves in a given binary tree.
    public int sumLeftLeaves(){
        return sumLeftLeaves(root, false);
    }

    private int sumLeftLeaves(Node<T> node, boolean isLeftNode) {
        if(node == null)
            return 0;
        if(isLeaf(node) && isLeftNode)
            return (int) node.data;
        return sumLeftLeaves(node.left, true) + sumLeftLeaves(node.right, false);
    }

    private boolean isLeaf(Node<T> node){
        return node.left == null && node.right == null;
    }

    /*----------------------------------------------------------------------------*/


}
