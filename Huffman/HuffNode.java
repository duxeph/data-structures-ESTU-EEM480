/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Huffman;

/**
 *
 * @author kagan
 */
public class HuffNode {
    public Character myChar;
    public Integer myFreq;
    public HuffNode myLeft, myRight;
    public HuffNode(int myFreq) {
        this.myFreq = myFreq;
        myChar = null;
        myLeft = myRight = null;
    }
    public HuffNode(char myChar, int myFreq) {
        this.myChar = myChar;
        this.myFreq = myFreq;
        myLeft = myRight = null;
    }
    
    public String toString() {
        return "("+myChar+", "+myFreq+")";
    }
}
