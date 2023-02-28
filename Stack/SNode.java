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
public class SNode<T> {
    public T element;
    public SNode<T> link;
    
    public SNode() {
        element = null;
        link = null;
    }
    public SNode(T element) {
        this.element = element;
        link = null;
    }
}
