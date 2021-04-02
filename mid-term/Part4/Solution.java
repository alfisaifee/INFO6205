package midterm.Part4;

public class Solution {

    //Time Complexity : O(logN)
    //Space Complexity : O(1)
    public int getIndex(int[] nums, int x){
        if(nums == null || nums.length == 0)
            return -1;
        return getIndex(nums, x, 0, nums.length-1);
    }

    private int getIndex(int[] nums, int x, int left, int right) {
        if(left > right)
            return -1;
        if(nums[left] == x)
            return left;
        int mid = (left + right)/2;
        if(nums[mid] < x){
            return getIndex(nums, x, mid+1, right);
        }else if (nums[mid] > x){
            return getIndex(nums, x, left, mid-1);
        }return getIndex(nums, x, left, mid);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println("First Index : " + sol.getIndex(nums, 7));
        System.out.println("First Index : " + sol.getIndex(nums, 9));
        System.out.println("First Index : " + sol.getIndex(nums, 0));
        System.out.println("First Index : " + sol.getIndex(nums, 15));
        System.out.println("First Index : " + sol.getIndex(nums, 4));
    }
}
