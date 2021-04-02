package midterm.Part3;

public class Solution {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public int getMaxConsecutiveOnes(int[] nums){
        int count = 0, result = 0;
        for(int num : nums){
            if(num == 1){
                count++;
            }
            else{
                count = 0;
            }
            if(count > result)
                result = count;
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {0,1,0,1,1,0,1,1,1,0,0,0};
        Solution sol = new Solution();
        System.out.println("Max Consecutive 1s : " + sol.getMaxConsecutiveOnes(arr));

        int[] arr1 = {0,1,0,1,1,0,1,1,1,1,1,0};
        System.out.println("Max Consecutive 1s : " +sol.getMaxConsecutiveOnes(arr1));

        int[] arr2 = {0,0,0,0,0,0,0,0,0,0};
        System.out.println("Max Consecutive 1s : " +sol.getMaxConsecutiveOnes(arr2));
    }
}
