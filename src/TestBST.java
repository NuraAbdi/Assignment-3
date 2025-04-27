public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(10, "Ten");
        tree.put(5, "Five");
        tree.put(20, "Twenty");

        System.out.println("Tree size: " + tree.size());

        for (BST.Entry<Integer, String> entry : tree) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        tree.delete(5);
        System.out.println("After deleting 5:");
        for (BST.Entry<Integer, String> entry : tree) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
