import java.util.HashSet;
import java.util.Set;

public class Solution {

    //1)  Rotate Image
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    //2) Reverse Words in a String
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();

        String[] sentSplit = s.trim().split("\\s+");
        int n = sentSplit.length;
        for(int i=0; i< n/2; i++){
            String temp = sentSplit[i];
            sentSplit[i] = sentSplit[n-i-1];
            sentSplit[n-i-1] = temp;
        }

        for(String se : sentSplit)
            str.append(se).append(" ");

        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    //3) Set Matrix Zeroes
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //4) Valid Anagram
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] map = new int[26];
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for (int i : map)
            if (i != 0)
                return false;

        return true;
    }

    //5) Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
