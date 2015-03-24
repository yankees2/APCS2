public class MyQueue<T>{
    private MyLinkedList<T>queue;

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    public void enqueue(T n){
	queue.add(n);
    }

    public T dequeue(){
	return queue.remove();
    }

    public String toString(){
	return queue.toString();
    }

}
