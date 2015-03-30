import java.util.*;

public class MyDeque<T>{
    private Object[] things;
    private int head, tail, size;

    public MyDeque(){
	things=new Object[10];
	size=0;
    }

    public void addFirst(T value){
	if (size()==things.length){
	    resize();
	}
	if (size()==0){
	    things[0]=(Object)value;
	    head=0;
	    tail=0;
	}else if(head==0){
	    things[things.length-1]=(Object)value;
	    head=things.length-1;
	}else{
	    things[head-1]=(Object)value;
	    head--;
	}
	size++;	    
    }

    public void addLast(T value){
	if (size()==things.length){
	    resize();
	}
	if (size()==0){
	    things[0]=(Object)value;
	    head=0;
	    tail=0;
	}else if(tail==things.length-1){
	    things[0]=(Object)value;
	    tail=0;
	}else{
	    things[tail+1]=(Object)value;
	    tail++;
	}
	size++;
    }
    
    public void resize(){
	Object[] newguy = new Object[things.length*2];
	int index=0;
	if(head>tail){
	    while(head<things.length){
		newguy[index]=things[head];
		head++;
		index++;
	    }
	    int x=0;
	    while(x<=tail){
		newguy[index]=things[x];
		x++;
		index++;
	    }
	}else{
	    while(head<=tail){
		newguy[index]=things[head];
		head++;
		index++;
	    }
	}
	head=0;
	tail=index-1;
	things=newguy;		
    }

    public T removeFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	} else {
	    T out=(T)things[head];
	    things[head]=null;
	    if(size()==1){
		head=0;
		tail=0;
	    }else if(head==things.length-1){
		head=0;
	    }else{
		head++;
	    }
	    size--;
	    return out;
	}
    }

    public T removeLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}else{
	    T out=(T)things[tail];
	    things[tail]=null;
	    if (size()==1){
		head=0;
		tail=0;
	    }else if(tail==0){
		tail=things.length-1;
	    }else{
		tail--;
	    }
	    size--;
	    return out;
	}
    }
	    
    public T getFirst(){
	if(size()==0){
	    throw new NoSuchElementException();
	}else{
	    T out=(T)things[head];
	    return out;
	}
    }

    public T getLast(){
	if(size()==0){
	    throw new NoSuchElementException();
	}else{
	    T out=(T)things[tail];
	    return out;
	}
    }

    public int size(){
	return size;
    }

    public int head(){
	return head;
    }

    public int tail(){
	return tail;
    }
    
    public String toString(){
	return Arrays.toString(things);
    }

    public static void main (String[]args){
	MyDeque<String> a = new MyDeque<String>();
	a.addLast("1");
	a.addLast("2");
	a.addLast("3");
	a.addLast("4");
	a.addLast("5");
	a.addLast("6");
	a.addLast("7");
	a.addLast("8");
	a.addLast("9");
	a.addLast("10");
	System.out.println(a.removeFirst());
	System.out.println(a.size());
    }
}
