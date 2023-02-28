package Trees;

import Trees.Interfaces.BinarySearchTreeInterface;
import Trees.Nodes.TNode;

public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements BinarySearchTreeInterface<T> {

    // not recursive
    public TNode<T> search(T data) {
        TNode<T> current = root;
        int res;
        
        if(current==null) return null;
        while(current.element!=data) { // is ==, already found.
            res = data.compareTo(current.element);
            if(res<0) { // data(what we search for) is less than curren(root)
                current = current.left;
            } else { // data(what we search for) is greater than current(root)
                current = current.right;
            }
            if(current==null) return null;
        }
        return current;
    }
    // recursive
    public TNode<T> findNode(T item, TNode<T> n) {
        if(item==null || n==null) return null;
        int res = item.compareTo(n.element);
        if(res==0) return n; // item == n
        // item is less than n, go to left
        else if(res<0) return findNode(item, n.left);
        // item is greater than the n, go to right
        else return findNode(item, n.right);
    }
    @Override
    public boolean contains(T item) {
        return findNode(item, root)!=null;
    }

    @Override
    public void add(T item) {
        // addNonRec(item);
        root = addRec(root, item);
    }
    public TNode<T> addRec(TNode<T> root, T key) {
        if(root == null) {
            root = new TNode<>(key);
            return root;
        }
        if(key.compareTo(root.element)<0)
            root.left = addRec(root.left, key);
        else if(key.compareTo(root.element)>0)
            root.right = addRec(root.right, key);
        return root;
    }
    public void addNonRec(T item) {
        TNode<T> newNode = new TNode<>(item);
        newNode.left = null;
        newNode.right = null;

        if(root==null) {
            root = newNode;
        } else {
            TNode<T> dummy = root, parent = null;
            while(dummy!=null) {
                parent = dummy;
                if(item.compareTo(dummy.element)<0) {
                    dummy = dummy.left;
                } else {
                    dummy = dummy.right;
                }
            }
            if(item.compareTo(parent.element)<0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }
    @Override
    public boolean remove(T item) {
        root = removeRec(root, item);
        return true;
    }
    public TNode<T> removeRec(TNode<T> root, T key) {
        if(root==null) return root;
        if(key.compareTo(root.element)<0) {
            // if root > key; go to root.left
            root.left = removeRec(root.left, key);
        } else if(key.compareTo(root.element)>0) {
            // if root < key; go to root.right
            root.right = removeRec(root.right, key);
        } else { // if we found the key...
            // replace n with n.right since left is null
            if(root.left == null) return root.right;
            // replace n with n.left since right is null
            else if(root.right == null) return root.left;
            // else, replace n's value with its predecessor
            // (biggest smaller value)
            // and delete predecessor recursively.
            root.element = findMin(root.right).element;
            root.right = removeRec(root.right, root.element);
        }
        return root;
    }
    public TNode<T> removeRec2(TNode<T> root, T key) {
        TNode<T> parent = parent(root, findNode(key, root));
        TNode<T> curr = root;
        
        while(curr!=null && curr.element!=key) {
            parent = curr;
            if(key.compareTo(curr.element)<0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if(curr==null) return root; // key not found
        
        // case 1; node to be deleted has no children
        if(curr.left==null && curr.right==null) {
            if(curr!=root) {
                if(parent.left!=curr) parent.left = null;
                else parent.right = null;
            }
            else root = null;
        }
        // case 2; node to be deleted has two children
        else if(curr.left!=null && curr.right!=null) {
            TNode<T> successor = findMin(curr.right);
            T val = successor.element;
            removeRec2(root, successor.element);
            curr.element = val;
        }
        // case 3; node to be deleted has only one child
        else {
            TNode<T> child = (curr.left!=null)?curr.left:curr.right;
            if(curr!=root) {
                if(curr==parent.left) parent.left = child;
                else parent.right = child;
            } else root = child;
        }
        return root;
    }
    
    @Override
    public T min() {
        TNode<T> dummy = root;
        while(dummy.left!=null) {
            dummy = dummy.left;
        }
        return dummy.element;
    }
    private TNode<T> findMin(TNode<T> minimum) {
        while(minimum.left!=null) {
            minimum = minimum.left;
        }
        return minimum;
    }
    @Override
    public T max() {
        TNode<T> dummy = root;
        while(dummy.right!=null) {
            dummy = dummy.right;
        }
        return dummy.element;
    }
    private TNode<T> findMax(TNode<T> maximum) {
        while(maximum.right!=null) {
            maximum = maximum.right;
        }
        return maximum;
    }

    public TNode<T> parent(TNode<T> key, TNode<T> item) { // key is root in there
        // user wants the parent of the root: given key is equal to the item we look for.
        // which is non-sense.
        if(key==item) return key;
        
        // we found.
        if(key.left==item || key.right==item) return key;
        // if root(key)'s value is greater than the item we look for...
        if(item.element.compareTo(key.element)<0) {
            // go to left
            return parent(key.left, item);
        } else { // go the right otherwise
            return parent(key.right, item);
        }
    }

    @Override
    public T pred(T item) {
        // predecessor of an element is the most bigger element
        // which is also smaller than the given element.
        // = most bigger small value.
        
        TNode<T> y=search(item);
        TNode<T> x=parent(root, y);
        // if its left is not null, then pred is in there.
        // go to its left, and go as deeper as its right!=null
        if(y.left!=null) {
            y = y.left;
            while(y.right!=null) {
                y = y.right;
            }
            return y.element;
        }
        // if it does not have a left node, go to up
        // (y -> x, x -> parent(x)) till y becomes x's right.
        while(parent(root, x)!=null && x.right!=y) {
            y = x;
            x = parent(root, x);
            if(y==x) return null; // we have gone to root
        }
        // if somehow x is right of the y, then x is already pred of y
        if(x.right==y) {
            return x.element;
        }
        // if it is left-most
        return null;
    }
    @Override
    public T succ(T item) {
        // successor of an element is the least element
        // which is also bigger than the given element.
        // = smallest bigger value.
        
        // LOOK AT THE PREDECESSOR, JUST INVERSE OF IT
        // ** LEFT -> RIGHT and VICE VERSA
        
        TNode<T> y=search(item);
        TNode<T> x=parent(root, y);
        // if at the left and has right (left-most included)
        if(y.right!=null) {
            y = y.right;
            while(y.left!=null) {
                y = y.left;
            }
            return y.element;
        }
        // if at the left and does not have right
        while(parent(root, x)!=null && x.left!=y) {
            y = x;
            x = parent(root, x);
            if(y==x) return null;
        }
        if(x.left==y) {
            return x.element;
        }
        // if it is right-most
        return null;
    }
}
