import java.util.List;

public class Main {
    public static void main(String[] args){
        BinaryTree<Integer> bt = new BinaryTree<>(init());

        System.out.println(bt.minDepth());
        System.out.println("--------------------------");
        System.out.println(bt.sumLeftLeaves());
        System.out.println("--------------------------");
        System.out.println(bt.isBalanced());
        System.out.println("--------------------------");
        List<List<Integer>> lst = bt.findLeaves();
        System.out.println(lst.toString());
    }

    public static Node<Integer> init(){
        Node<Integer> root = new Node<>(1);

        root.left = new Node<>(2);
        root.right = new Node<>(3);

        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        root.left.left.left = new Node<>(8);
        root.left.right.left = new Node<>(9);
        root.right.left.right = new Node<>(10);
        root.right.right.right = new Node<>(11);

        return root;
    }
}
