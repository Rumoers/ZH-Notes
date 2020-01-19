package queue;

/**
 * Created by XZH
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){	//构造函数，传入数组容量
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){	//查看静态数组容量
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e){
        array.addLast(e);	//增
    }

    @Override
    public E dequeue(){
        return array.removeFirst();	//拿出队首
    }

    @Override
    public E getFront(){
        return array.getFirst();	//查看队首
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");	//数组左侧是队首
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));	//将队列的每个元素都放到 res 中
            if(i != array.getSize() - 1)	//如果 i 不是array 的最后一个元素
                res.append(", ");
        }
        res.append("] tail");	//数组右侧是队尾
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);		//添加元素
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);	//取出元素
            }
        }
    }
}