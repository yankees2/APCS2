import java.util.*;
public class MyDeque<T>{
    private Object [] deque;
    private int head;
    private int tail;
    private int size;
    public MyDeque(){
	deque = new Object [1];
	size = 0;
    }

    public void resize(){
	if(size == deque.length){
	    Object [] newdeque = new Object [size*2];
	    for(int i = 0; i < size; i++){
		newdeque[i] = deque[(head+i)%size];
	    }
	    deque = newdeque;
	    head = 0;
	    tail = size-1;
	}
    }

    public String name(){
	return "won.brian";
    }

    public String toString(){
	return Arrays.toString(deque);
    }

    public void addFirst(T value){
	resize();
	head--;
	if(head < 0){
	    head = (head+deque.length)%deque.length;
	}
	deque[head] = value;
	size += 1;
    }

    public T removeFirst(){
	T removed = (T)deque[head];
	deque[head] = null;
	head++;
	if(head >= deque.length){
	    head = head - deque.length;
	}
	size --;
	return removed;
    }

    public void addLast(T value){
	resize();
	tail++;
	if(tail >= deque.length){
	    tail = tail - deque.length;
	}
	deque[tail] = value;
	size++;
    }

    public T removeLast(){
	T removed = (T)deque[tail];
	deque[tail] = null;
	tail--;
	if(tail < 0){
	    tail += deque.length;
	}
	size--;
	return removed;
    }

    public T getFirst(){
	return (T)deque[head];
    }

    public T getLast(){
	return (T)deque[tail];
    }

    public int getSize(){
	return size;
    }
}
