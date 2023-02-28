/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMap;

import LinkedList.LinkedList;

/**
 *
 * @author kagan
 * @param <T>
 */
public class HashMap<T> implements InterfaceHashMap<T> {
    public HashNode<String, T>[] table;
    public LinkedList<String> keySet;

    public double load = 0;
    public int size=71;
    private final double rehashRate = 0.59;
    private final double sizeUpdateRate = 1.83;
    
    public HashMap() {
        keySet = new LinkedList<>();
        table = (HashNode<String, T>[]) new HashNode<?, ?>[size];
    }
    public double get_loadfactor() {
        return (load/size);
    }
    
    public int hash(String key) { // hash function
        int hashcode = 0;
        for(int i=0; i<key.length(); i++) {
            hashcode += key.charAt(i)*31^(key.length()-i-1); // key.charAt(i)*31^(key.length()-i-1)
        }
        /* // alternative method
        int hashcode = 5381;
        for(int i=0; i<s.length(); i++) {
            hashcode = hashcode * 33 + i;
        } */
        return hashcode%(size);
    }
    public void rehash() {
        int oldsize = size;
        // updates size
        size = (int)(size*sizeUpdateRate);

        // creates a new table, with new size
        HashNode<String, T>[] newTable = (HashNode<String, T>[]) new HashNode<?, ?>[size];
        // control variables
        HashNode<String, T> dummy, temp;
        T latestValue;
        int hashcode, c;
        
        // for each key in the table;
        for(int i=0; i<oldsize; i++) {
            // increments c for each step, goes to cth link for each step
            // (only if there is a collision). by doing so, we are planning
            // not to lose the rest of the node:
            // if we directly apply linking operation and does not do in that way,
            // (go to cth node for each step and increment c, but link directly the
            // table[i]th link)
            // we are going to lose the table[i]th node, and the rest of it.
            c = 0;
            while(true) {
                // create a variable to represent current key
                dummy = table[i];
                // go to c(th) element of the key
                for(int j=0; j<c; j++) {
                    dummy = dummy.link;
                }
                // if there is not such an element at that index of the current key, simply break
                if(dummy==null) break;
                // else...
                // define a new pointer with same key (not to change the from the table directly ~ array's elements not copiable and uses same address else)
                latestValue = dummy.value;
                dummy = new HashNode<>(dummy.key);
                dummy.value = latestValue;
                // find the new key mapped with the updated size ~ updated hash function
                hashcode = hash(dummy.key);
                // for the new hashcode found, copy the last copied element to the new point which is changed according to the new size
                if(newTable[hashcode]!=null) {  // if there is another item copied to that key before, connect them to our dummy
                    temp = dummy;
                    temp.link = newTable[hashcode];
                    newTable[hashcode] = temp;
                } else {                        // if that key is already empty, put dummy directly to there
                    temp = dummy;
                    temp.link = null;
                    newTable[hashcode] = temp;
                }
                // increment c: c is asserted to control if there is another items in a specific key. if so, we go to c(th) element of the current key each step.
                c++;
            }
        }
        table = newTable;
    }
    
    public void add(String key) {
        if(searchFor(key)!=null) {
            // System.out.println("[EXCEPTION] This item is already in map!");
            return;
        }
        load++; keySet.Insert(key, 0);
        
        int hashcode = hash(key);
        HashNode<String, T> newElement = new HashNode<>(key);
        
        if(table[hashcode]==null) { // if hashcode(th) key is empty, directly put new item.
            // System.out.println("[NO-COLLSN] key: "+hashcode+".   value: "+key);
            table[hashcode] = newElement;
        } else {                    // if hashcode(th) key is not empty, also put them next to the new item.
            // System.out.println("[COLLUSION] key: "+hashcode+"... value: "+key);
            // rehash();    // avoidable collusion. ~ may cause infinite loops: needs a great hash function
            // add(s);
            newElement.link = table[hashcode];
            table[hashcode] = newElement;
        }
        // rehash if new load leads to load/size > rehashRate
        if(load/size>=rehashRate) rehash();
    }
    public String del(String key) {
        if(searchFor(key)==null) {
            // System.out.println("[EXCEPTION] There is not such an item with key "+key+"!");
            return null;
        }
        HashNode<String, T> dummy = table[hash(key)];
        if(dummy.key.equals(key)) { // finds element in the first check ([1st ~ wanted element] -> [] -> [] ->)
            if(dummy.link==null) {  // if key has only 1 item
                table[hash(key)] = null;
            } else {                // if key has more than 1 items (2 or more)
                table[hash(key)] = dummy.link;
            }
            load -= 1;
            if(keySet.Delete(keySet.indexOf(key))==null) {
                System.out.println("[EXCEPTION] An exception has occured during update of key set. Please check.");
            }
            return key;
        }
        while(dummy.link!=null) {   // finds element in the second or latest checks ([] -> [2rd ~ may be wanted element] -> [3rd ~ may be wanted element] -> [] -> [] ->)
            if(dummy.link.key.equals(key)) {
                if(dummy.link.link!=null) dummy.link = dummy.link.link;
                else dummy.link = null;
                load -= 1;
                if(keySet.Delete(keySet.indexOf(key))==null) {
                    System.out.println("[EXCEPTION] An exception has occured during update of key set. Please check.");
                }
                return key;
            }
            dummy = dummy.link;
        }
        return null; // if somehow came there (not expected)
    }
    
    public HashNode<String, T> searchFor(String key) {
        int hashcode = hash(key);
        HashNode<String, T> dummy;
        // if key is null -> abort directly
        if(table[hashcode]==null) return null;
        // else, copy table to a dummy
        dummy = table[hashcode];
        // for each element in that key...
        while(dummy!=null) {
            // check whether that element is equal to our wanted element
            // if so return it
            if(dummy.key.equals(key)) return dummy;
            // else go to next element
            dummy = dummy.link;
        }
        return null;
    }
    public HashNode<String, T> changeFor(String key, T value) {
        // TOTALLY SAME WITH SEARCHFOR, DIFFERENT PART IS EXPLAINED BELOW, JUST ABOVE THE DIFFERENCE
        int hashcode = hash(key);
        HashNode<String, T> dummy;
        if(table[hashcode]==null) return null;
        dummy = table[hashcode];
        while(dummy!=null) {
            if(dummy.key.equals(key)) {
                // all same with searchFor
                // only the line "dummy.value = value" is added ~ update operation
                dummy.value = value;
                return dummy;
            }
            dummy = dummy.link;
        }
        return null;
    }
    
    public LinkedList<String> getKeys() {
        // returns all the keys
        return keySet;
    }
    
    public void print() {
        System.out.print("printing: ");
        for(int i=0; i<size; i++) {
            if(table[i]!=null) {
                HashNode<String, T> dummy = table[i];
                System.out.print("{"+i+":"+dummy.key);
                while(dummy.link!=null) {
                    dummy = dummy.link;
                    System.out.print("->"+dummy.key);
                }
                System.out.print("}, ");
            }
            else System.out.print("{"+i+":"+null+"}, ");
        }
        System.out.println();
    }
}