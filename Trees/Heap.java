package Trees;

import Stack.Stack;

public class Heap {
    int[] array;
    int length;
    String type;

    public Heap(int size) {
        array = new int[size];
        length = 0;
        type = "max";
    }
    public Heap(int size, String type) {
        array = new int[size];
        length = 0;
        this.type = type;
    }
    
    public void heapsort() {
        Heap sortedarray = new Heap(length, type);
        sortedarray.array = array.clone();
        sortedarray.length = length;
        
        Stack<Integer> stack = new Stack<>();
        System.out.print("+ heap sorted array is: ");
        while(sortedarray.length!=0) {
            stack.push(sortedarray.remove());
            System.out.print(stack.peek()+", ");
        }
        System.out.println();
    }

    // return 0 if i == 0, (i-1)/2 else
    public int parent(int i) {
        return i==0?0:(i-1)/2;
    }
    public int LEFT(int i) {
        return (2*i+1);
    }
    public int RIGHT(int i) {
        return (2*i+2);
    }
    public void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void add(int data) {
        if(length==0) array[0] = data;
        else {
            array[length] = data;
            if(type=="max") {
                heapify_up(length);
            } else {
                heapify_up_lower(length);
            }
        }
        length++;
    }
    public int remove() {
        int deleted = array[0];
        array[0] = array[--length];

        if(type=="max") {
            heapify_down(0);
        } else {
            heapify_down_lowest(0);
        }
        return deleted;
    }

    private void heapify_up(int i) {
        if(i>0&&array[parent(i)]<array[i]) {
            swap(i, parent(i));
            heapify_up(parent(i));
        }
    }
    private void heapify_up_lower(int i) {
        if(i>0&&array[parent(i)]>array[i]) {
            swap(i, parent(i));
            heapify_up_lower(parent(i));
        }
    }
    private void heapify_down(int i) {
        int left = LEFT(i), right = RIGHT(i), largest = i;

        if(left<length && array[left] > array[i]) {
            largest = left;
        }
        if(right<length && array[right] > array[largest]) {
            largest = right;
        }
        if(largest!=i) {
            swap(i, largest);
            heapify_down(largest);
        }
    }
    private void heapify_down_lowest(int i) {
        int left = LEFT(i), right = RIGHT(i), smallest = i;

        if(left<length && array[left] < array[i]) {
            smallest = left;
        }
        if(right<length && array[right] < array[smallest]) {
            smallest = right;
        }
        if(smallest!=i) {
            swap(i, smallest);
            heapify_down_lowest(smallest);
        }
    }

    public String toString() {
        String s = "";
        for(int i=0; i<length; i++) {
            s+=array[i]+" ";
        }
        return s;
    }
    public int getSize() {
        return length;
    }
    public boolean isEmpty() {
        return length==0;
    }
}
