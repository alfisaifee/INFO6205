public class SearchingAndSorting {

    //1) Find K Closest Elements https://leetcode.com/problems/find-k-closest-elements/
    // Given a sorted integer array arr, two integers k and x, return the k closest
    // integers to x in the array. The result should also be sorted in ascending order.
    public List<Integer> findClosestElements(int[] nums, int k, int x) {

        List<Integer> res = new ArrayList<>();
        int left = 0, right = nums.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - nums[mid] > nums[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; ++i) {
            res.add(nums[i]);
        }
        return res;

    }


    //2) Find Intersection of 2 sorted arrays https://leetcode.com/problems/intersection-of-two-arrays/
    //Given two arrays, write a function to compute their intersection.
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


    //3) Peak Index in a mountain https://leetcode.com/problems/peak-index-in-a-mountain-array/
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length-1;

        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < arr[mid+1])
                low = mid+1;
            else
                high = mid;
        }

        return low;
    }

    //4)
    // Given a string S, check if the letters can be rearranged so that two characters
    // that are adjacent to each other are not the same.
    //If possible, output any possible result.  If not possible, return the empty string.
    public String reorganizeString(String S) {

        int[] hash = new int[26];
        for(int i=0; i<S.length(); i++)
            hash[S.charAt(i)-'a']++;

        int max = 0, letter = 0;
        for(int i=0; i<hash.length; i++){
            if(hash[i] > max){
                max = hash[i];
                letter = i;
            }
        }

        if(max > (S.length()+1)/2)
            return "";

        char[] res = new char[S.length()];
        int index = 0;
        while(hash[letter] > 0){
            res[index] = (char)(letter+'a');
            index += 2;
            hash[letter]--;
        }

        for(int i=0; i<hash.length; i++){
            while(hash[i] > 0){
                if(index >= res.length)
                    index=1;
                res[index] = (char)(i+'a');
                index += 2;
                hash[i]--;
            }
        }

        return String.valueOf(res);
    }


    //5) Count number of 1's in sorted binary array
    // https://www.geeksforgeeks.org/count-1s-sorted-binary-array/
    public int countOnesSortedBinary(int[] arr) {
        if(arr[arr.length-1] == 1)
            return arr.length;
        if(arr[0] == 0)
            return 0;
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == 1)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }

}
