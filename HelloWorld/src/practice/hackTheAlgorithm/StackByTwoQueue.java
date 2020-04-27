package practice.hackTheAlgorithm;

import java.util.Deque;
import java.util.LinkedList;

public class StackByTwoQueue {
    private Deque<Integer> deque;

    public StackByTwoQueue() {
        this.deque = new LinkedList<>();
    }

    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        deque.push(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        deque.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        return deque.peek();
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return deque.size() == 0;
    }

}
