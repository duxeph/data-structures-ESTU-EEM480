/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees;

import Queue.Queue;
import Trees.Nodes.TNode;

/**
 *
 * @author kagan
 * @param <T>
 */
public class AVL<T extends Comparable<? super T>> {
    public TNode<T> root;
    public AVL() {
        root = null;
    }
    public TNode<T> maxNode(TNode<T> node) {
        TNode<T> current = node;
        while(current.right!=null) {
            current = current.right;
        }
        return current;
    }
    public T maxVal(TNode<T> node) {
        return maxNode(node).element;
    }
    public TNode<T> minNode(TNode<T> node) {
        TNode<T> current = node;
        while(current.left!=null) {
            current = current.left;
        }
        return current;
    }
    public T minVal(TNode<T> node) {
        return minNode(node).element;
    }
    public void del(T element) {
        root = delRec(root, element);
    }
    public TNode<T> delRec(TNode<T> root, T element) {
        if(root==null) return root;
        if(element.compareTo(root.element)<0) {
            root.left = delRec(root.left, element);
        } else if(element.compareTo(root.element)>0) {
            root.right = delRec(root.right, element);
        } else {
            if(root.left==null || root.right==null) {
                TNode<T> temp = null;
                if(root.left==null) {
                    temp = root.right;
                } else if(root.right==null) {
                    temp = root.left;
                }
                root = temp;
            } else {
                TNode<T> temp = minNode(root.right);
                root.element = temp.element;
                root.right = delRec(root.right, temp.element);
            }
        }
        if(root==null) return root;
        
        int factor = balance_factor(root);
        if(factor>1) {
            if(balance_factor(root.left)>=0) {
                return rightRotate(root);
            } else {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        } else if(factor<-1) {
            if(balance_factor(root.right)<=0) {
                return leftRotate(root);
            } else {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }
    public void add(T element) {
        root = addRec(root, element);
    }
    public TNode<T> addRec(TNode<T> root, T element) {
        if(root==null) {
            return new TNode<>(element);
        }
        if(element.compareTo(root.element)<0)
            root.left = addRec(root.left, element);
        else if(element.compareTo(root.element)>0)
            root.right = addRec(root.right, element);
        else
            return root;
        
        int factor = balance_factor(root);
        if(factor>1) {
            if(element.compareTo(root.left.element)<0) {
                return rightRotate(root);
            } else if(element.compareTo(root.left.element)>0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if(factor<-1) {
            if(element.compareTo(root.right.element)>0) {
                return leftRotate(root);
            } else if(element.compareTo(root.right.element)<0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }
    
    public TNode<T> leftRotate(TNode<T> x) {
        TNode<T> y = x.right;
        TNode<T> temp_yleft = y.left;
        y.left = x;
        x.right = temp_yleft;
        return y;
    }
    public TNode<T> rightRotate(TNode<T> y) {
        TNode<T> x = y.left;
        TNode<T> temp_xright = x.right;
        x.right = y;
        y.left = temp_xright;
        return x;
    }
    
    public TNode<T> parent(TNode<T> node, TNode<T> key) {
        if(node==key||node==null||key==null) return null;
        return (node.left==key||node.right==key)?
                node:(key.element.compareTo(node.element)<0?
                parent(node.left, key):parent(node.right, key));
    }
    public TNode<T> search(TNode<T> node, T item) {
        if(node==null||item==null) return null;
        return node.element==item?node:(item.compareTo(node.element)<0?
                search(node.left, item):search(node.right, item));
    }
    public int balance_factor(TNode<T> node) {
        if(node==null) return 0;
        return height(node.left)-height(node.right);
    }
    public int height(TNode<T> node) {
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
    public void print() {
        Queue<TNode<T>> q = new Queue<>(255);
        TNode<T> p;
        q.enqueue(root);
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
}
