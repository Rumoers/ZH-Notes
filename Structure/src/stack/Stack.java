package stack;

/**
 * Created by XZH
 */
public interface Stack<E> {

    int getSize();		//查看栈中总共有多少个元素
    boolean isEmpty();	//判断栈是否为空
    void push(E e);		//【入栈】向栈中添加元素
    E pop();			//【出栈】从栈中拿出栈顶元素
    E peek();			//查看栈顶元素
}