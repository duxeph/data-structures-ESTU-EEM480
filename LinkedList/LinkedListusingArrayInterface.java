/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package LinkedList;

/**
 *
 * @author kagan
 * @param <AnyType>
 */
public interface LinkedListusingArrayInterface<AnyType> {
    boolean IsEmpty();
    int Length();
    boolean Find(int k, AnyType x);
    int Search(AnyType x);
    void Delete(int k, AnyType x);
    void Insert(int k, AnyType x);
    void Output();
 }
