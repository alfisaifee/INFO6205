import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {


    // 1) Subtree of Another Tree

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        return isSameTree(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        return (s.val == t.val) && isSameTree(s.left, t.left)
                && isSameTree(s.right, t.right);
    }


    /*----------------------------------------------------------------------------------------------------*/


    // 2) Asteroid Collision

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            if(a > 0) stack.push(a);
            else {
                boolean flag = true;
                while(!stack.isEmpty() && stack.peek() > 0 && flag){
                    if(Math.abs(a) > stack.peek()){
                        stack.pop();
                    }
                    else if(Math.abs(a) == stack.peek()){
                        stack.pop();
                        flag = false;
                    }
                    else if(Math.abs(a) < stack.peek()){
                        flag = false;
                    }
                }
                if(flag) stack.push(a);
            }

        }

        int[] res = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            res[i--]  = stack.pop();
        }
        return res;
    }


    /*----------------------------------------------------------------------------------------------------*/

    // 3) 3Sum

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0) return res;
            int left = i+1;
            int right = nums.length-1;
            if(i != 0 && nums[i-1] == nums[i]) continue;
            while(left < right){
                int sum = nums[left] + nums[i] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left < right && nums[left] == nums[left-1])
                        left++;
                    right--;
                    while(left < right && nums[right] == nums[right+1])
                        right--;
                }
                else if(sum < 0)
                    left++;
                else{
                    right--;
                }
            }
        }

        return res;
    }


    /*----------------------------------------------------------------------------------------------------*/

    // 4) Generate Parentheses

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String temp = "";
        generateParenthesisHelper(n,0,0,res,temp);
        return res;
    }

    private void generateParenthesisHelper(int n, int open, int close, List<String> res,String temp){
        if(close == n)
            res.add(temp);
        if(open < n)
            generateParenthesisHelper(n, open+1, close, res, temp+"(");
        if(close < open)
            generateParenthesisHelper(n, open, close+1, res, temp+")");

    }


    /*----------------------------------------------------------------------------------------------------*/


    // 5) Reverse Nodes in k-Group

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode kTail = null;
        ListNode newHead = null;

        while(curr != null){
            int count = 0;
            curr = head;
            while(count < k && curr != null){
                curr = curr.next;
                count++;
            }

            if(count == k){
                ListNode rev = reverse(head, k);
                if(newHead == null)
                    newHead = rev;
                if(kTail != null)
                    kTail.next = rev;
                kTail = head;
                head = curr;
            }
        }

        if(kTail != null)
            kTail.next = head;
        return newHead == null ? head : newHead;
    }

    public ListNode reverse(ListNode node, int k){
        ListNode prev = null;
        ListNode curr = node;

        while(k > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

}
