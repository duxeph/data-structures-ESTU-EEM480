package Trees.Nodes;

public class TNode<T> { // tree node
    public T element;
    public TNode<T> left, right;

    public TNode(T item) {
        element = item;
        left = right = null;
    }
    public TNode(T item, TNode<T> left, TNode<T> right) {
        element = item;
        this.left = left;
        this.right = right;
    }

    // BINARY SEARCH NODE
    /*
    public T data;
    public TNode<T> parent;
    // BINARY SEARCH NODE
    public TNode(T data, TNode<T> parent) {
        this.data = data;
        this.parent = parent;
    }
     */
}
