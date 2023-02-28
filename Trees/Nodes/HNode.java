/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trees.Nodes;

/**
 *
 * @author kagan
 */
public class HNode<T> { // heap node
    public T element;
    public HNode<T> parent;
    public HNode<T> left, right;

    public HNode(T item) {
        element = item;
        parent = null;
        left = right = null;
    }
    public HNode(T element, HNode<T> parent, HNode<T> left, HNode<T> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}