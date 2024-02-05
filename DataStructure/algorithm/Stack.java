public class Stack {
    private static int MAX_STACK_SIZE = 10;
    private int top;
    private int[] data = new int[MAX_STACK_SIZE];
 
    public Stack() {
        top = -1;
    }
 
    public void push(int data_) throws Exception {
        if (isFull()) {
            throw new Exception("스택이 가득 찼습니다.");
        }
        data[++top] = data_;
    }
 
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("스택이 비었습니다.");
        }
        return data[top--];
    }
 
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("스택이 비었습니다.");
        }
        return data[top];
    }
 
    public boolean isEmpty() {
        return top == -1;
    }
 
    public boolean isFull() {
        return top == MAX_STACK_SIZE - 1;
    }
 
    public int size() {
        return top + 1;
    }
}