/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LZW;

import LinkedList.DoubleLinkNode;
import LinkedList.LinkedList;

/**
 *
 * @author kagan
 */
public class LZW {
    public LinkedList<LZWNode> table = new LinkedList<>();
    public String message;
    public String encoded;
    
    public LZW(String message) {
        this.message = message;
        
        String first = this.message.substring(0, 1);
        table.Insert(new LZWNode(first, 0), 0);
        encoded="";
    }
    public void message() {
        System.out.println(encoded);
    }
    // in indexOf function, we simply check whether we have added A to the table before.
    public void encode() {
        String A;
        int i = 1;

        while(message.length()>0) {
            A = message.substring(0, i);
            System.out.println("mess: "+message+", A: "+A+", index of A: "+indexOf(A));
            
            // A exists in table
            if(indexOf(A)!=-1) {
                // if there is no more char except than A, end compression.
                if(message.equals(A)) {
                    encoded+=indexOf(A);
                    message="";
                    break;
                }
                // if there is, increase i and go for one char longer string
                i++;
            }
            // A does not exist in table
            else {
                // if i is equal to 1, then we do not have any before data,
                // we can directly use it.
                if(i==1) {
                    // insert it to data, add it to encode, use it.
                    table.Insert(new LZWNode(A, table.size), table.size);
                    encoded+=table.size-1;
                    message = message.substring(1, message.length());
                }
                // we have increased i before, so we should decrease i by 1
                // and use A for i minus 1 (i-1).
                else {
                    // add A to table, encode it, set i to 1 again.
                    table.Insert(new LZWNode(A, table.size), table.size);
                    encoded+=indexOf(A.substring(0, A.length()-1));
                    message = message.substring(i-1, message.length());
                    i = 1;
                }
            }
        }
    }
    public int indexOf(String mess) {
        for(int i=0; i<table.size; i++) {
            if(table.Peek(i).string.equals(mess)) {
                return i;
            }
        }
        return -1;
    }
}
