/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HashMap;

import LinkedList.LinkedList;

/**
 *
 * @author kagan
 * @param <T>
 */
public interface InterfaceHashMap<T> {
    double get_loadfactor();
    int hash(String key);
    void rehash();
    void add(String key);
    String del(String key);    
    HashNode<String, T> searchFor(String key);
    HashNode<String, T> changeFor(String key, T value);
    LinkedList<String> getKeys();
    void print();
}
