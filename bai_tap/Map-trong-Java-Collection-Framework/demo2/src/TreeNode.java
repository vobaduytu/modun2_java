class TreeNode<E> {
    protected E element;
    protected
    TreeNode<E> left;
    protected TreeNode<E> right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "element=" + element +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public TreeNode(E e) {
        element = e;

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(60);
        root.left = new TreeNode<>(55);
        root.right = new TreeNode<>(100);

        System.out.println(root);
    }
}

