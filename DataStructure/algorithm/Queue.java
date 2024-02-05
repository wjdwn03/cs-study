public class Queue {
    private static int MAX_QUEUE_SIZE = 10;
    private int rear,front,size;
    private int[] data = new int[MAX_QUEUE_SIZE];

    public Queue() {
        front = rear = size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void add(int item) {
        //이 부분이 배열을 환형으로 만들어 주는 부분이다.
        rear = (rear + 1) % data.length;
        data[rear] = item;
        size++;
    }

    public int pop() {
        if(isEmpty()) throw new NoSuchElementException();
        //이 부분이 배열을 환형으로 만들어 주는 부분이다.
        front = (front + 1) % data.length;
        int item = data[front];
        data[front] = 0;
        size--;

        return item;
    }

    public int peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return data[front];
    }
}