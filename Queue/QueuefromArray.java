/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Queue;

/**
 *
 * @author kagan
 * @param <T>
 */
public class QueuefromArray<T> {
    public int front = -1, rear = 0;
    public T[] table;
    public int maxsize = 15;
    
    public QueuefromArray() {
        table = (T[]) new Object[maxsize+1];
    }
    public QueuefromArray(int syze) {
        maxsize = syze;
        table = (T[]) new Object[maxsize+1];
    }
    
    public void enqueue(T element) {
        if(rear==maxsize) {
            table[rear] = element;
            rear = 0;
            return;
        }
        if(front==rear+1 || (front==maxsize && rear==0)) {
            System.out.println("[ERROR:ENQUEUE] Queue is full.");
            return;
        }
        
        table[rear++] = element;
        if(front==-1) front++;
    }
    public T dequeue() {
        if(front!=rear && front>-1) {
            if(front==maxsize) {
                front = 0;
                return table[maxsize];
            }
            return table[front++];
        }
        System.out.println("[ERROR:DEQUEUE] There is no element in queue.");
        return null;
    }
    public void print() {
        if(front==-1 || front==rear) {
            System.out.println("[]");
        } else {
            String c = "[";
            int i = front;
            while(true) {
                if(i==maxsize && rear<front) {
                    c += table[i++] + ", ";
                    i = 0;
                    continue;
                }
                if(i==rear) {
                    break;
                }
                c += table[i++] + ", ";
            }
            c = c.substring(0, c.length()-2)+"]";
            System.out.println(c); 
       }
    }
}
