package queue;

/**
 * Created by XZH
 *
 * @description
 */
public interface Queue<E> {

    int getSize();    //查看队列中总共有多少个元素
    boolean isEmpty();//判断队列是否为空
    void enqueue(E e);//【入队】向队列中添加元素
    E dequeue();        //【出队】从队列中拿出栈顶元素
    E getFront();        //查看队首元素
}
