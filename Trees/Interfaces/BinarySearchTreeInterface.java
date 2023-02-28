package Trees.Interfaces;

public interface BinarySearchTreeInterface<T> {
    void add(T item);
    // Adds item to tree if not already present.
    boolean contains(T item);
    // True if item is in tree.
    T min();
    // Returns smallest item in tree.
    T max();
    // Returns largest item in tree.
    T pred(T item);
    // Returns inorder predecessor of item in tree.
    boolean remove(T item);
    // True if item is found and removed from tree.
    T succ(T item);
    // Returns inorder successor of item in tree
}
