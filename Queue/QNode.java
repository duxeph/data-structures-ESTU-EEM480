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
public class QNode<T> {
    public T element;
    public QNode<T> link;
    
    public QNode() {
        element = null;
        link = null;
    }
    public QNode(T element) {
        this.element = element;
        link = null;
    }
}
