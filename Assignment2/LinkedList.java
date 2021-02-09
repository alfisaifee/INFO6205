public class LinkedList<T> {

    //1) Swap Nodes in Pair
    //Given a linked list, swap every two adjacent nodes and return its head.
    public Node<T> swapPairs(Node<T> head){
        if(head == null || head.next == null)
            return head;
        Node<T> first = head, second = head.next, prev = null;
        head = second;
        while(first != null && second != null){
            first.next = second.next;
            second.next = first;
            if(prev != null)
                prev.next = second;
            prev = first;
            first = first.next;
            if(first != null)
                second = first.next;
        }
        return head;
    }

    //2) Delete Node in a Linked List
    //Write a function to delete a node in a singly-linked list.
    // You will not be given access to the head of the list, instead you will be given access to the
    // node to be deleted directly.
    public void deleteNode(Node<T> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    //3) Odd Even Linked List
    //Given a singly linked list, group all odd nodes together followed by the even nodes.
    // Please note here we are talking about the node number and not the value in the nodes.
    public Node<T> oddEvenList(Node<T> head) {
        if(head == null || head.next == null)
            return head;
        Node<T> evenHead = head.next;
        Node<T> oddNode = head, evenNode = head.next;
        while(oddNode.next != null && evenNode.next != null){
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;

            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = evenHead;
        return head;
    }

    //4) Split Linked List in Parts
    //Given a (singly) linked list with head node root, write a function to split the linked
    //list into k consecutive linked list "parts".
    public Node<T>[] splitListToParts(Node<T> root, int k) {
        Node<T>[] listArr = new Node[k];

        int size = 0;
        Node<T> curr = root;
        while(curr != null){
            curr = curr.next;
            size++;
        }

        int n = size / k, rem = size % k;
        Node<T> head = root;
        curr = root;
        int i = 0;
        while(curr != null){
            int j = n + (i < rem ? 1 : 0) - 1;
            while(j > 0){
                curr = curr.next;
                j--;
            }

            Node<T> temp = curr.next;
            curr.next = null;
            curr = temp;

            listArr[i++] = head;
            head = curr;
        }
        return listArr;
    }

    //5)Insert into a Sorted Circular Linked List
    //Given a node from a Circular Linked List which is sorted in ascending order,
    //write a function to insert a value insertVal into the list such that it remains a sorted circular list.

    public Node<Integer> insert(Node<Integer> head, int insertVal) {
        Node<Integer> newNode = new Node<>(insertVal);
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        Node<Integer> prev = head, curr = head.next;
        while(curr != head){
            if(insertVal >= prev.data && insertVal <= curr.data)
                break;
            else if(prev.data > curr.data)
                if(insertVal < curr.data || prev.data < insertVal)
                    break;
            prev = curr;
            curr = curr.next;
        }
        prev.next = newNode;
        newNode.next = curr;
        return head;
    }
}
