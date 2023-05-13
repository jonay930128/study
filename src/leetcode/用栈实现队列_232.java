package leetcode;

import java.util.Stack;

/**
 * @author ruxing.wrx
 * @date 2023/4/22 06:43
 */
public class 用栈实现队列_232 {

    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     *
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     */

    public Stack<Integer> inStack = new Stack<>();
    public Stack<Integer> outStack = new Stack<>();

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.empty()) {
            in2Out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.empty()) {
            in2Out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return outStack.empty() && inStack.empty();
    }

    public void in2Out() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
    }
}
