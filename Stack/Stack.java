package Stack;

public class Stack<AnyType> extends SNode<AnyType> implements StackInterface<AnyType>{
    public SNode<AnyType> top;
    public Stack() {
        top = null;
    }

    public int size() {
        if (top==null) {
            return 0;
        } else {
            SNode<AnyType> dummy = top;
            int c = 0;
            while(dummy!=null) {
                dummy = dummy.link;
                c ++;
            }
            return c;
        }
    }
    public boolean isEmpty() {
        return top == null;
    }
    public AnyType peek() {
        if (top!=null) return top.element;
        return null;
    }
    public AnyType pop() {
        if (top==null) return null;
        SNode<AnyType> temp = top;
        top = top.link;
        return temp.element;
    }
    public void push(AnyType item) {
        SNode<AnyType> dummy = new SNode<>();
        dummy.element = item;
        if (top==null) {
            dummy.link = null;
            top = dummy;
        }
        else {
            dummy.link = top;
            top = dummy;
        }
    }
    public String toString() {
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
