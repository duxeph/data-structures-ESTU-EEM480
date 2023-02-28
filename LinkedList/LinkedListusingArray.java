/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LinkedList;

/**
 *
 * @author kagan
 * @param <AnyType>
 */
public class LinkedListusingArray<AnyType> implements LinkedListusingArrayInterface<AnyType> {
    private int Length;
    private int MaxSize = 10;
    private AnyType[] elements;

    public LinkedListusingArray() {
        elements = (AnyType []) new Object[MaxSize];
        Length = 0;
    }
    
    public LinkedListusingArray(int Syze) {
        MaxSize = Syze;
        elements = (AnyType []) new Object[MaxSize];
        Length = 0;
    }
    
    public int Length() {
            return Length;
    }

    public boolean IsEmpty(){
            return Length == 0;
    }

    public boolean Find(int k, AnyType x){
            if (k < 1 || k > Length) return false;
             x = elements[k-1];
             return true;
    }

    public int Search(AnyType x){
            for(int i = 0; i < Length; i++)
                    if(elements[i] == x)
                            return ++i;
            return 0;
    }

    public void Delete(int k, AnyType x){
        if (Find(k,x)){
            for(int i=k; i <= Length; i++)
                elements[i] = elements[i+1];
            Length--;
        }
        else
            throw new IndexOutOfBoundsException("Invalid Index :" + Integer.toString(k));
    }

    public void Insert(int k, AnyType x){
        if(k < 0 || k > MaxSize )
            throw new IndexOutOfBoundsException("Invalid Index :" + Integer.toString(k));
        if (k == MaxSize)
            throw new IndexOutOfBoundsException("List is Full");
        for(int i = Length - 1; i >= k; i--)
            elements[i+1] = elements[i];
        elements[k] = x;
        Length++;
        }

    public void Output(){
        String s = "[";
        for (int i = 1; i <= Length; i++){
            if (i>1) s += ", ";
            s += elements[i];
        }
        System.out.println(s + "]");	
    }

    @Override
    public String toString(){
        String s = "[ ";
            for (int i = 1; i <= Length; i++){
                    if (i>1) s += ", ";
                    s += elements[i];
            }
            s += " ]";
            return(s);
    }
    
}
