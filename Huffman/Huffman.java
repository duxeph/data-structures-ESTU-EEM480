/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Huffman;

import Queue.Queue;

/**
 *
 * @author kagan
 */
public class Huffman {
    public Queue<HuffNode> myQueue;
    public String encoded;
    public Huffman() {
        myQueue = new Queue<>();
    }
    
    // repetitions
    public void add(char key, int freq) {
        myQueue.enqueue(new HuffNode(key, freq));
    }
    
    public void encode() {
        sortQueue(myQueue);
        HuffNode x, y, newHN;
        while(myQueue.size()>1) {
            x = myQueue.dequeue();
            y = myQueue.dequeue();
            newHN = new HuffNode(x.myFreq+y.myFreq);
            newHN.myLeft = x;
            newHN.myRight = y;
            myQueue.enqueue(newHN);
            sortQueue(myQueue);
        }
        name(myQueue.peek(0), "");
    }
    public void name(HuffNode q, String path) {
        if(q.myChar!=null) encoded += ("char: "+q.myChar+", encoded as: "+path+"\n");
        if(q.myLeft!=null) name(q.myLeft, path+"0");
        if(q.myRight!=null) name(q.myRight, path+"1");
    }
    
    public void frontToRear(Queue<HuffNode> q, int qsize) {
        if(qsize<=0) return;
        q.enqueue(q.dequeue());
        frontToRear(q, qsize-1);
    }
    public void pushInQueue(Queue<HuffNode> q, HuffNode temp, int qsize) {
        if(q.isEmpty() || qsize==0) {
            q.enqueue(temp);
        } else if(temp.myFreq<=q.peek(0).myFreq) {
            q.enqueue(temp);
            frontToRear(q, qsize);
        } else {
            q.enqueue(q.dequeue());
            pushInQueue(q, temp, qsize-1);
        }
    }
    public void sortQueue(Queue<HuffNode> q) {
        if(q.isEmpty()) return;
        HuffNode temp = q.dequeue();
        sortQueue(q);
        pushInQueue(q, temp, q.size());
    }
    
    public void print() {
        System.out.println(myQueue);
    }
}
