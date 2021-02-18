public class LinkedList<T> {

    /*1) Merge In Between Linked Lists
    You are given two linked lists: list1 and list2 of sizes n and m respectively.
    Remove list1's nodes from the ath node to the bth node, and put list2 in their place.*/
    public Node<T> mergeInBetween(Node<T> list1, int a, int b, Node<T> list2) {
        Node<T> curr1 = list1;
        for(int i=0; i<a-1; i++)
            curr1 = curr1.next;

        Node<T> temp = curr1.next;
        curr1.next = list2;

        Node<T> curr2 = list2;
        while(curr2.next != null)
            curr2 = curr2.next;

        for(int i=0; i<b-a+1; i++)
            temp = temp.next;

        curr2.next = temp;

        return list1;
    }

    /*2) Swapping Nodes in a Linked List
    You are given the head of a linked list, and an integer k.
    Return the head of the linked list after swapping the values of the kth node from
    the beginning and the kth node from the end (the list is 1-indexed). */

    public Node<T> swapNodes(Node<T> head, int k) {
        Node<T> start = head, end = head;
        for(int i=1; i<k; i++)
            end = end.next;

        Node<T> temp = end;

        while(end.next != null){
            end = end.next;
            start = start.next;
        }

        T tempVal = start.data;
        start.data = temp.data;
        temp.data = tempVal;

        return head;
    }

    /*3) Remove Linked List Elements
    Remove all elements from a linked list of integers that have value val.*/
    public Node<Integer> removeElements(Node<Integer> head, int val) {
        Node<Integer> curr = head;
        while(curr != null && curr.data == val){
            curr = curr.next;
            head = curr;
        }

        while(curr != null){
            while(curr.next != null && curr.next.data == val)
                curr.next = curr.next.next;
            curr = curr.next;
        }

        return head;
    }

    /*4) Delete N Nodes After M Nodes of a Linked List
    Given the head of a linked list and two integers m and n.
    Traverse the linked list and remove some nodes in the following way:
    - Start with the head as the current node.
    - Keep the first m nodes starting with the current node.
    - Remove the next n nodes
    - Keep repeating steps 2 and 3 until you reach the end of the list.
    Return the head of the modified list after removing the mentioned nodes.
     */

    public Node<T> deleteNodes(Node<T> head, int m, int n) {
        Node<T> curr = head, prev = curr;
        while(curr != null){
            for(int i=0; i<m && curr != null; i++){
                prev = curr;
                curr = curr.next;
            }

            for(int j=0; j<n && curr != null; j++)
                curr = curr.next;

            if(curr != null){
                prev.next = curr;
                prev = curr;
            }
            else
                prev.next = null;
        }
        return head;
    }
}
