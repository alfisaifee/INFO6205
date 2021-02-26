import java.util.*;


public class Sorting {

    // 1)  Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1)
            set1.add(n);

        int index = 0;
        int[] temp = new int[set1.size()];
        for(int n : nums2){
            if(set1.contains(n)){
                temp[index++] = n;
                set1.remove(n);
            }
        }

        return Arrays.copyOf(temp, index);
    }

    // 2) Find Nth smallest of an unsorted Array
    public void findNthSmallest(int[] arr, int n) {
        if(arr == null || n >= arr.length || n < 0)
            return;
        findNthSmallest(arr,n,0,arr.length-1);
    }

    private void findNthSmallest(int[] arr, int n, int low, int high){
        if(low > high)
            return;
        int pos = partition(arr,low, high);
        if(pos == n) {
            System.out.println(arr[pos]);
            return;
        }
        if(pos > n)
            findNthSmallest(arr, n, low, pos-1);
        findNthSmallest(arr, n, pos+1, high);
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low-1;
        for(int i=low; i<high; i++){
            if(arr[i] < pivot)
                swap(arr, ++wall, i);
        }
        swap(arr,++wall,high);
        return wall;
    }

    //3) Sort Colors
    public void sortColors(int[] nums){
        int pivot = 1;
        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high){
            if(nums[mid] < pivot)
                swap(nums, low++, mid++);
            else if(nums[mid] == pivot)
                mid++;
            else
                swap(nums, mid, high--);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //4) Pancake Sorting
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for(int i = arr.length - 1; i >= 0; i--){

            int maxId = findMax(arr, 0, i);

            reverse(arr, 0, maxId);
            res.add(maxId + 1);

            reverse(arr, 0, i);
            res.add(i + 1);
        }
        return res;

    }

    private int findMax(int[] nums, int start, int end) {
        int maxId = 0;
        int maxValue = 0;
        for(int i = start; i <= end; i++) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
                maxId = i;
            }
        }
        return maxId;
    }

    private void reverse(int[] nums, int start, int end) {
        int l = start, r = end;
        while(l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }


}
