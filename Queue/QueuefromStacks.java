package Queue;

import Stack.SNode;
import Stack.Stack;

public class QueuefromStacks<AnyType> {
    public Stack<AnyType> main;

    public QueuefromStacks() {
        main = new Stack<>();
    }
    public void enqueue(AnyType item) {
        Stack<AnyType> temp = new Stack<>();
        while(!main.isEmpty()) {
            temp.push(main.pop());
        }
        main.push(item);
        while(!temp.isEmpty()) {
            main.push(temp.pop());
        }
    }
    public AnyType dequeue() {
        if(!main.isEmpty()) return main.pop();
        return null;
    }
    public String toString() {
        SNode<AnyType> top = main.top;
        
        if (top==null) return "[]";
        String c = "[";
        SNode<AnyType> dummy = top;
        while(dummy!=null) {
            c = c.concat(dummy.element.toString()+", ");
            dummy = dummy.link;
        }
        c = c.substring(0, c.length()-2).concat("]");
        return c;
    }
}
