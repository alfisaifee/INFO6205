package midterm.Part2;

import java.util.Stack;

public class Solution {

    //Time complexity : O(N)
    //Space Complexity : O(1)
    public void printPerimeter(TreeNode root){
        if(root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        printPerimeter(root, 0, 0, stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    private void printPerimeter(TreeNode root, int left, int right, Stack<Integer> stack) {
        if(root == null) {
            return;
        }
        if(left == 0 || isLeafNode(root)) {
            System.out.print(root.val + " ");
        }
        else if(right == 0){
            stack.push(root.val);
        }
        printPerimeter(root.right,left, right+1, stack);
        printPerimeter(root.left,left+1, right, stack);
    }

    private boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

    public TreeNode getBinaryTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);

        return root;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        TreeNode node = sol.getBinaryTree();
        sol.printPerimeter(node);
        System.out.println();
    }

}
