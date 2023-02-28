package Trees;

import Trees.Nodes.TNode;
import Queue.Queue;

public class BinaryTree<T> {
    public TNode<T> root;
    public BinaryTree(TNode<T> root) {
        this.root = root;
    }
    public BinaryTree() {
        root = null;
    }

    public String displayInorder() {
        TNode<T> dummy = root;
        return displayInorder(dummy);
    }
    public String displayInorder(TNode<T> node) {
        String s = "";
        if(node!=null) {
            // displayInorder(node.left);
            // System.out.println(node.element+", ");
            // displayInorder(node.right);
            s += displayInorder(node.left);
            s += node.element + " ";
            s += displayInorder(node.right);
        }
        return s;
    }
    public String displayPreorder() {
        TNode<T> dummy = root;
        return displayPreorder(dummy);
    }
    public String displayPreorder(TNode<T> node) {
        String s = "";
        if(node!=null) {
            s += node.element + " ";
            s += displayPreorder(node.left);
            s += displayPreorder(node.right);
        }
        return s;
    }
    public String displayPostorder() {
        TNode<T> dummy = root;
        return displayPostorder(dummy);
    }
    public String displayPostorder(TNode<T> node) {
        String s = "";
        if(node!=null) {
            s += displayPostorder(node.left);
            s += displayPostorder(node.right);
            s += node.element + " ";
        }
        return s;
    }
    public String displayLevelorder() {
        TNode<T> dummy = root;
        return displayLevelorder(dummy);
    }
    public String displayLevelorder(TNode<T> node) {
        // procedure:
        // - creating an empty queue
        // - putting root node to the queue
        // - while(queue is not empty);
        // - + dequeue and save a node from queue, print it
        // - + put left, then right nodes of the node we...
        // -    ...took to the queue again, continue to while
        Queue<TNode<T>> q = new Queue<>(255);
        TNode<T> p;
        String s = "";

        q.enqueue(node);
        while(!q.isEmpty()) {
            p = q.dequeue();
            s = s.concat(p.element + " ");
            if(p.left!=null)
                q.enqueue(p.left);
            if(p.right!=null)
                q.enqueue(p.right);
        }
        return s;
    }

    public int height() {
        return height(root);
    }
    public int height(TNode<T> node) {
        // procedure:
        // recursively call height function by giving
        // left and right of the "node" repetitively,
        // return the max.
        int heightLeft, heightRight, heightval;
        if(node==null) heightval = -1; // no leaves(yaprak).
        else { // there may be more nodes at the left or right
            heightLeft = height(node.left); // calculate left
            heightRight = height(node.right); // calculate right
            // -> return max of these two (we kept adding for each leaf)
            heightval = 1 + (heightLeft>heightRight?heightLeft:heightRight);
        }
        return heightval;
    }
}
