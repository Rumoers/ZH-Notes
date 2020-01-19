package queue;

/**
 * Created by XZH
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){		//定义数组容积capacity
        data = (E[])new Object[capacity + 1];		//循环数组中有意识的浪费一个空间
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){		//无参数的构造函数
        this(10);
    }

    public int getCapacity(){		//循环队列中最多装载的元素数量
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == tail;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void enqueue(E e){	//循环队列入队

        if((tail + 1) % data.length == front)	//判断队列是否“满”
            resize(getCapacity() * 2);		//队列扩容

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override	//（新增代码）
    public E dequeue(){		//循环队列出队


        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];	//出队的元素是队首元素
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)		//队列容量要自动缩减
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    private void resize(int newCapacity){	////（新增代码）定义扩展数组的方法

        E[] newData = (E[])new Object[newCapacity + 1];		//数组特意浪费一个空间
        for(int i = 0 ; i < size ; i ++)		//遍历方式一
            newData[i] = data[(i + front) % data.length];	//将data中的size个元素放到了newData中的[0，size-1]的位置

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){		//打印输出

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");		//队列左侧是队首
        for(int i = front ; i != tail ; i = (i + 1) % data.length){	//遍历方式二
            res.append(data[i]);
            if((i + 1) % data.length != tail)	//判断当前索引不是最后一个元素
                res.append(", ");
        }
        res.append("] tail");		//队列右侧是队尾
        return res.toString();
    }


}
