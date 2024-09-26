public class Tree<TYPE extends Comparable> {
    private Node<TYPE> root;

    public Tree() {
        this.root = null;
    }

    public Node<TYPE> getRoot() {
        return root;
    }

    public void add(TYPE data) {

        Node<TYPE> newNode = new Node<TYPE>(data);
        if (root == null) {
            this.root = newNode;
        } else {
            Node<TYPE> currentNode = this.root;
            while(true) {
                // compareTo() retorna 0 se for =, 1 se for >, e -1 se for <
                if (newNode.getData().compareTo(currentNode.getData()) < 0) {
                    if (currentNode.getLeft() != null) {
                        currentNode = currentNode.getLeft();
                    } else {
                        currentNode.setLeft(newNode);
                        break;
                    }
                } else {
                    if (currentNode.getRight() != null) {
                        currentNode = currentNode.getRight();
                    } else {
                        currentNode.setRight(newNode);
                        break;
                    }
                }
            }
        }
    }

    public void remove(TYPE data) {
        root = removeRecursive(root, data);
    }

    private Node<TYPE> removeRecursive(Node<TYPE> current, TYPE data) {
        if (current == null) {
            return null;
        }

        int comparison = data.compareTo(current.getData());

        if (comparison < 0) {
            current.setLeft(removeRecursive(current.getLeft(), data));
        } else if (comparison > 0) {
            current.setRight(removeRecursive(current.getRight(), data));
        } else {
            // Encontrou o nó a ser removido

            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            Node<TYPE> smallestValueNode = findSmallestNode(current.getRight());
            current.setData(smallestValueNode.getData());
            current.setRight(removeRecursive(current.getRight(), smallestValueNode.getData()));
        }

        return current;
    }

    private Node<TYPE> findSmallestNode(Node<TYPE> root) {
        return root.getLeft() == null ? root : findSmallestNode(root.getLeft());
    }


}
