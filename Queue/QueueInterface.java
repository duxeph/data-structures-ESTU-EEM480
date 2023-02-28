package Queue;

public interface QueueInterface<AnyType> {
    public int size();
    public boolean isEmpty();

    public AnyType peek();
    public AnyType dequeue();
    public void enqueue(AnyType newElement);

    public String toString();
}
