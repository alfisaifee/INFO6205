package midterm.Part1;


import java.util.HashSet;
import java.util.Set;

class Solution{
    //Time Complexity : O(N + M), N -> len N1, M -> len N2
    // Space Complexity : O(N)
    public boolean areConverging(ListNode n1, ListNode n2){
        if(n1 == null || n2 == null)
            return false;
        Set<ListNode> set = new HashSet<>();
        while(n1 != null){
            set.add(n1);
            n1 = n1.next;
        }
        while(n2!=null){
            if(set.contains(n2)){
                return true;
            }
            n2 = n2.next;
        }
        return false;
    }

    public ListNode arrToLinkedList(int[] arr){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i=0; i<arr.length; i++){
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head.next;
    }

    public void convergeListNode(ListNode n1, ListNode n2){
        ListNode curr1 = n1;
        ListNode curr2 = n2;
        while(curr1.next != null){
            curr1 = curr1.next;
        }
        for(int i=0; i<4; i++){
            curr2 = curr2.next;
        }
        curr1.next = curr2;
    }



    public static void main(String[] args){
        Solution sol = new Solution();

        int[] arr1 = {5, 2};
        int[] arr2 = {6,9,3,8,4,7};
        ListNode n1 = sol.arrToLinkedList(arr1);
        ListNode n2 = sol.arrToLinkedList(arr2);
        sol.convergeListNode(n1, n2);
        System.out.println("Is Converging : " + sol.areConverging(n1, n2));


        ListNode n3 = sol.arrToLinkedList(arr1);
        ListNode n4 = sol.arrToLinkedList(arr2);
        System.out.println("Is Converging : " + sol.areConverging(n3, n4));
    }
}
