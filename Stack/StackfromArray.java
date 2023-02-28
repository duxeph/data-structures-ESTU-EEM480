/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

/**
 *
 * @author kagan
 * @param <T>
 */
public class StackfromArray<T> {
    public int top = -1;
    public int maxsize = 15;
    public T[] table;
    
    public StackfromArray() {
        table = (T[]) new Object[maxsize];
    }
    public StackfromArray(int syze) {
        maxsize = syze;
        table = (T[]) new Object[maxsize];
    }
    
    public void push(T element) {
        if(top<maxsize) table[++top] = element;
        else System.out.println("[ERROR:PUSH] No empty space to push.");
    }
    public T pop() {
        if(top>-1) return table[top--];
        System.out.println("[ERROR:POP] No element saved to the stack before.");
        return null;
    }
    public T peek() {
        if(top>-1) return table[top];
        System.out.println("[ERROR:PEEK] No element saved to the stack before.");
        return null;
    }
    public void print() {
        if(top==-1) System.out.println("[]");
        String c = "[";
        for(int i=0; i<=top; i++) {
            c += (table[i]+", ");
        }
        System.out.println(c.substring(0, c.length()-2)+"]");
    }
}
