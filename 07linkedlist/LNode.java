public class LNode<T>{
    private T value;
    private LNode<T> next;

    public LNode(T x,LNode<T> n){
	value=x;
	next=n;
    }

    public LNode(T x){
	value=x;
	next=null;
    }
    
    public LNode(){
    }

    public T getValue(){
	return value;
    }

    public void setValue(T x){
	value=x;
    }

    public LNode<T> getNext(){
	return next;
    }

    public void setNext(LNode<T> n){
	next=n;
    }

    public String toString(){
	return ""+value;
    }
}