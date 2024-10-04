public class Node<T> {
    private char data;
    private Node<T> right;
    private Node<T> left;

    public Node(char data) {
        this.data = data;
        right = null;
        left = null;
    }

    // Getters e setters:
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
