/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;

import Queue.Queue;
import Trees.Nodes.HNode;
import Trees.Nodes.TNode;

/**
 *
 * @author kagan
 */
public class HeapLL<T extends Comparable<? super T>> {
    public HNode<T> root;

    public HeapLL() {
        this.root = null;
    }
    public HeapLL(HNode<T> root) {
        this.root = root;
    }

    public HNode<T> PARENT(HNode<T> t) {
        return t.parent;
    }
    public HNode<T> LEFT(HNode<T> t) {
        return t.left;
    }
    public HNode<T> RIGHT(HNode<T> t) {
        return t.right;
    }

    public void add(T data) {
        if(root==null) root = new HNode<T>(data, root, null, null);
        else {
            HNode<T> dummy = root;
            while(dummy!=null) {
                if(data.compareTo(dummy.element)<0) {
                    if(dummy.left==null) {
                        dummy.left = new HNode<T>(data, dummy, null, null);
                        return;
                    }
                    dummy = dummy.left;
                } else {
                    if(dummy.right==null) {
                        dummy.right = new HNode<T>(data, dummy, null, null);
                        return;
                    }
                    dummy = dummy.right;
                }
            }
            System.out.println("why did i came to there?");
            return;
        }
    }
    public int remove() {
        /*
        int deleted = array[0];
        array[0] = array[--length];

        heapify_down(0);
        return deleted;
        */
        return 0;
    }
    
    public int get_balance(HNode<T> x) {
        return height(x.left)-height(x.right);
    }
    public HNode<T> findNode(T item, HNode<T> n) {
        if(item==null || n==null) return null;
        int res = item.compareTo(n.element);
        if(res==0) return n;
        else if(res<0) return findNode(item, n.left);
        else return findNode(item, n.right);
    }
    private void rotate_right(HNode<T> x) {
        HNode<T> y = x.left;
        HNode<T> z = y.left;
        
        HNode<T> parent = PARENT(x);
        parent.left = y;
        x.left = y.right;
        y.right = x;
    }
    private void rotate_left(HNode<T> x) {
        HNode<T> y = x.right;
        HNode<T> z = y.right;
        
        HNode<T> parent = PARENT(x);
        parent.right = y;
        x.right = y.left;
        y.left = x;
    }

    public void print(HNode<T> t) {
        if(t.left!=null) print(t.left);
        System.out.print(t.element+", ");
        if(t.right!=null) print(t.right);
    }
    public void printLevel(HNode<T> t) {
        Queue<HNode<T>> q = new Queue<HNode<T>>(255);
        HNode<T> p;
        q.enqueue(t);
        while(!q.isEmpty()) {
            p = q.dequeue();
            System.out.print(p.element+", ");
            if(p.left!=null)
                q.enqueue(p.left);
            if(p.right!=null)
                q.enqueue(p.right);
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return root==null;
    }
    public int height(HNode<T> node) {
        int heightLeft, heightRight, heightval;
        if(node==null) heightval = -1;
        else {
            heightLeft = height(node.left);
            heightRight = height(node.right);
            heightval = 1 + (heightLeft>heightRight?heightLeft:heightRight);
        }
        return heightval;
    }
}
