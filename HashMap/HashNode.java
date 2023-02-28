/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HashMap;

/**
 *
 * @author kagan
 * @param <T1>
 * @param <T2>
 */
public class HashNode<T1, T2> {
    public HashNode<T1, T2> link;
    public T1 key;
    public T2 value;
    
    public HashNode(T1 key) {
        this.key = key;
        value = null;
        link = null;
    }
}
