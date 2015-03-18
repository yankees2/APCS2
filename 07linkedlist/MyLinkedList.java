import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    private LNode<T> head,tail;
    private int size;

    public String name(){
	return "won.brian";
    }

    public MyLinkedList(){
    }

    public String toString(){
	String list="[ ";
	LNode<T> temp=head;
	while(temp!=null){
	    list+=temp+",";
	    temp=temp.getNext();
	}
	return list.substring(0,list.length()-1)+" ]";
    }

    public T get(int index){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode<T> out=head;
	    int x=0;
	    while (x<index){
	        out=out.getNext();
		x++;
	    }
	    return out.getValue();
	}
    }
    
    public T set(int index,T value){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode<T> temp=head;
	    for (int i=0;i<index;i++){
		temp=temp.getNext();
	    }
	    T out=temp.getValue();
	    temp.setValue(value);
	    return out;
	}
    }
    
    public boolean add(T add){
	if (size()==0){
	    head=new LNode<T>(add);
	    tail=head;
	}else{
	    tail.setNext(new LNode<T>(add));
	    tail=tail.getNext();
	}
	size++;
	return true;
    }

    public void add(int index,T add){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else if(index==0){
	    LNode<T> more=new LNode<T>(add);
	    more.setNext(head);
	    head=more;
	}else{
	    LNode<T> temp=head;
	    for (int i=0;i<index-1;i++){
		temp=temp.getNext();
	    }
	    LNode<T> more=new LNode<T>(add);
	    more.setNext(temp.getNext());
	    temp.setNext(more);
	}
	size++;
    }

    public T remove(int index){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else if(index==0){
	    T out=head.getValue();
	    head=head.getNext();
	    size--;
	    return out;
	}else{
	    int x=0;
	    LNode<T> temp=head;
	    while(x<index-1){
		temp=temp.getNext();
		x++;
	    }
	    T out=temp.getNext().getValue();
	    temp.setNext(temp.getNext().getNext());
	    size--;
	    return out;
	}
    }

    public int size(){
	return size;
    }

    public int indexOf(T value){
	LNode<T> temp=head;
	for (int i=0;i<size();i++){
	    if (temp.getValue()==value){
		return i;
	    }
	}
	return -1;
    }

    public Iterator<T> iterator(){
	return new MyLLIterator<T>(head);
    }

    private class MyLLIterator<T> implements Iterator<T>{
	LNode<T> holla;
	
	public MyLLIterator(LNode<T> start){
	    LNode<T> a=new LNode<T>(start);
	    holla=a;
	    //how you do this part
	}

        public boolean hasNext(){
	    return holla.getNext()!=null;
	}

	public T next(){
	    holla=holla.getNext();
	    return holla.getValue();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public static void main (String[]args){
	MyLinkedList<String> a=new MyLinkedList<String>();
	a.add("Peace");
	a.add("out");
	System.out.println(a.set(1,"homie"));
	System.out.println(a.toString());
    }

	
	
	
}
