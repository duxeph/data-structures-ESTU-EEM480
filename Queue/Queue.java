package Queue;


public class Queue<AnyType> extends QNode<AnyType> implements QueueInterface<AnyType>{
    int maxSize;
    public QNode<AnyType> front;
    public QNode<AnyType> rear;
    public Queue() {
        maxSize = 255;
        front = null;
        rear = null;
    }
    public Queue(int size) {
        maxSize = size;
        front = null;
        rear = null;
    }

    public void enqueue(AnyType newElement) {
        if (this.size()+1 != maxSize) {
            QNode<AnyType> n = new QNode<>(), q = new QNode<>();

            if (front == null) {
                n.element = newElement;
                n.link = rear;

                front = n;
            } else {
                n = front;

                while (n.link != rear) {
                    n = n.link;
                }
                q.element = newElement;
                q.link = rear;

                n.link = q;
            }
        } else {
            System.out.println("Queue is full!");
            QNode<AnyType> n = front;
            while(n.link!=null) {
                n = n.link;
            }
            System.out.println("[DEBUG] last="+n+", last.next="+n.link+", rear="+rear);
        }
    }
    public AnyType dequeue() {
        if(this.isEmpty()) {
            System.out.println("Queue is already empty.");
            return null;
        } else {
            QNode<AnyType> n = front;
            front = front.link;
            return n.element;
        }
    }
    public AnyType peek() {
        if (front==null) return null;
        return front.element;
    }
    public AnyType peek(int index) {
        QNode<AnyType> n = front;
        for(int i=0; i<index; i++) {
            n = n.link;
        }
        return n.element;
    }
    public int size() {
        QNode<AnyType> n = front;
        int c=0;

        while(n!=rear) {
            n = n.link;
            c++;
        }
        return c;
    }
    public boolean isEmpty() {
        return front==rear; // front==null?
    }
    public String toString() {
        String c="[";
        QNode<AnyType> n = front;

        if(front==rear) return "[]";
        while(n!=rear) {
            c = c.concat(n.element+", ");
            n = n.link;
        }
        return c.substring(0, c.length()-2)+"]";
    }
}
