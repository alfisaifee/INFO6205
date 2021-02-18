public class DoubleLinkedList<T> {

    public DoubleLinkedListNode<T> head;

    public void addHead(T data){
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addTail(T data){
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        DoubleLinkedListNode<T> curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
    }

    public int size(){
        if(head == null)
            return 0;
        int count = 0;
        DoubleLinkedListNode<T> curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }

    public void print(){
        if(head == null)
            return;
        DoubleLinkedListNode<T> curr = head;
        while(curr != null){
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    //Add to tail, Add to head, size, print list functions to the class.
}
