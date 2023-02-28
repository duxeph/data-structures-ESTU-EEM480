/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author kagan
 * @param <T>
 */
public class LinkedList<T> implements InterfaceLinkedList<T> {
    public DoubleLinkNode<T> first;
    public int size;
    public LinkedList() {
        first = null;
        size = 0;
    }
    
    public void Insert(T newElement, int pos) {
        if(pos<0 || (pos!=0 && first==null)) return;  // (entering minus index) and (entering pos other than 0 when list is empty) are directly avoided
        
        DoubleLinkNode prev, curr = first, newN = new DoubleLinkNode();
        int i = 0;
        newN.Element = newElement;
        
        if(pos==0) {
            newN.right = curr;
            newN.left = null;
            if(curr!=null) curr.left = newN;
            first = newN;
            // (adding_Q) curr -><- curr.next => newN -><- curr -><- curr.next
        } else {
            while(i<pos) {
                if(curr.right==null) {
                    if(i==pos-1) break;
                    return;    // means pos exceeds the size of the list
                }
                curr = curr.right;
                i++;
            }
            if (i==pos-1) {         // means i is equal to the index of the last node - 1, which means add new node to the end
                curr.right = newN;
                newN.right = null;
                newN.left = curr;
                // (adding_Q) curr -> null => curr -><- newN -> null
            } else {                // else if (i>pos-1) including i==pos => pos is indexing some random node between (i is directly equal to pos itself)
                prev = curr.left;

                prev.right = newN;
                newN.left = prev;

                curr.left = newN;
                newN.right = curr;
                // (adding_Q) prev -><- curr => prev -><- newN -><- curr
            }
        }
        size++;
    }
    public T Delete(int pos) {
        if(pos<0 || first==null) return null;  // (entering minus index) and (calling delete operation when list is empty) are directly avoided
        DoubleLinkNode<T> prev, curr = first, next;
        if(pos==0) {                            // deleting index 0 means deleting the head
            if(first.right==null) {             // if list has no any different element
                first = null;
            } else {                            // if list has different elements
                first = curr.right;
                first.left = null;   
            }
            // (removing_Q) null <- first -><- first.right => null <- first.right
        } else {                                // deleting index greater than 0
            for (int i=0; i<pos; i++) {
                if(curr.right==null) return null;  // if entered index exceeds the size of list: throw exception
                curr = curr.right;
            }
            prev = curr.left;
            next = curr.right;

            prev.right = next;
            if(next!=null) next.left = prev;
            // (removing_Q) p -><- n -><- q => p -><- q
        }
        size--;
        return curr.Element;
    }
    public T Peek(int pos) {
        if(pos<0 || first==null) return null;  // (entering minus index) and (calling delete operation when list is empty) are directly avoided
        DoubleLinkNode<T> curr = first;
        if(pos==0) {
            return curr.Element;
        } else {                                // deleting index greater than 0
            for (int i=0; i<pos; i++) {
                if(curr.right==null) return null;  // if entered index exceeds the size of list: throw exception
                curr = curr.right;
            }
            return curr.Element;
        }
    }
    public void Update(T newElement, int pos) {
        if(pos<0 || first==null) return;  // (entering minus index) and (calling delete operation when list is empty) are directly avoided
        DoubleLinkNode<T> curr = first;
        if(pos==0) {
            first.Element = newElement;
        } else {                        // update chosen index
            for (int i=0; i<pos; i++) {
                if(curr.right==null) return;  // if entered index exceeds the size of list: throw exception
                curr = curr.right;
            }
            curr.Element = newElement;
        }
    }
    public Integer indexOf(T element) {
        if(first==null) return null;
        DoubleLinkNode<T> dummy = first;
        Integer c = 0;
        while(dummy!=null) {
            if(dummy.Element.equals(element)) return c;
            dummy = dummy.right;
            c++;
        }
        return null;
    }
    
    @Override
    public String toString() {
        if(first==null) return "";
        DoubleLinkNode dummy = first;
        String c = ""+dummy.Element;
        while(dummy.right!=null) {
            dummy = dummy.right;
            c = c.concat(" "+dummy.Element);
        }
        return c;
    }
}
