package Stack;

public interface StackInterface<AnyType> {
    public int size();
    public boolean isEmpty();

    public AnyType peek();
    public AnyType pop();
    public void push(AnyType item);

    public String toString();
}