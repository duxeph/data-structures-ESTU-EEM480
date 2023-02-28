/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

import Comparable.Comparable;

/**
 *
 * @author kagan
 * @param <T>
 */
public class LList<T extends Comparable<? super T>> implements recitationInterface<T> {
    public LNode<T> head;
    public int listsize;
    public LList() {
        head = null;
        listsize = 0;
    }
    
    public void push(T element) {
        LNode<T> newNode = new LNode<>();
        newNode.element = element;
        if(listsize++==0) {
            head = newNode;
        } else {
            LNode<T> dummy = head;
            while(dummy.link!=null) {
                dummy = dummy.link;
            }
            dummy.link = newNode;
        }
    }
    public T pop() {
        if(listsize==0) return null;
        
        T tobereturned;
        if(listsize==1) {
            tobereturned = head.element;
            head = null;
            return tobereturned;
        }

        LNode<T> dummy = head;
        while(dummy.link.link!=null) {
            dummy = dummy.link;
        }
        tobereturned = dummy.link.element;
        dummy.link = null;
        
        return tobereturned;
    }
    
    public class listIterator<T> implements iterator<T> {
        LNode iteratorPointer;
        T returned;
        
        public listIterator() {
            iteratorPointer = head;
        }
        
        public boolean hasNext() {
            return iteratorPointer != null;
        }
        
        public T next() {
            returned = (T) iteratorPointer.element;
            iteratorPointer = iteratorPointer.link;
            return returned;
        }
    }
    public listIterator<T> iterator() {
        return new listIterator<>();
    }
    
    @Override
    public T findMax() {
        /*
        if(listsize==0) return null;
        LNode<T> dummy = head;
        T max = head.element;
        while(dummy!=null) {
            if(max.compareTo(dummy.element)<0) {
                max = dummy.element;
            }
            dummy = dummy.link;
        }
        return max;
        */
        listIterator<T> myIt = new listIterator();
        T itVal, max = head.element;
        while(myIt.hasNext()) {
            itVal = myIt.next();
            if(max.compareTo(itVal)<0) {
                max = itVal;
            }
        }
        return max;
    }
    @Override
    public void listStudents() {
        listIterator<T> myIt = new listIterator();
        while(myIt.hasNext()) {
            System.out.println(myIt.next());
        }
    }

    @Override
    public String toString() {
        if(listsize==0) return "empty";
        String c = "[\n";
        LNode<T> dummy = head;
        while(dummy!=null) {
            c += "\t"+dummy.element+",\n";
            dummy = dummy.link;
        }
        return c.substring(0, c.length()-2)+"\n]";
    }
    public void print() {
        System.out.println(this);
    }
}
