/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

import Queue.QNode;
import Queue.Queue;

/**
 *
 * @author kagan
 * @param <T>
 */
public class StackfromQueue<T> {
    Queue<T> main;
    int top;
    public StackfromQueue() {
        main = new Queue<>();
        top = -1;
    }
    
    public void push(T element) {
        main.enqueue(element);
    }
    public T pop() {
        /*
        Queue<T> temp = new Queue<>();
        while(main.size()!=1) {
            temp.enqueue(main.dequeue());
        }
        T tempElement = main.dequeue();
        while(!temp.isEmpty()) {
            main.enqueue(temp.dequeue());
        }
        return tempElement;
        */
        
        for(int i=0; i<main.size()-1; i++) {
            main.enqueue(main.dequeue());
        }
        T tempElement = main.dequeue();
        return tempElement;
    }
    public void print() {
        String c;
        if(main.isEmpty()) {
            c="[]";
        } else {
            c = "[";
            QNode<T> temp = main.front;
            while(temp!=null) {
                c += temp.element + ", ";
                temp = temp.link;
            }
            c = c.substring(0, c.length()-2) + "]";
        }
        System.out.println(c);
    }
}
