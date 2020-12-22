import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);
        root.left = new TreeNode<>(57);
        root.right = new TreeNode<>(120);
        System.out.println(root);
    }

}