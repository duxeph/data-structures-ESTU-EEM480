/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package LinkedList;

/**
 *
 * @author kagan
 * @param <T>
 */
public interface InterfaceLinkedList<T> {
    public void Insert(T newElement, int pos);
    public T Delete(int pos);
    public T Peek(int pos);
    public void Update(T newElement, int pos);
    public Integer indexOf(T element);
    @Override
    public String toString();
}
