public class MyLinkedList{
    private LNode head,tail;
    private int size;

    public MyLinkedList(){
    }

    public String toString(){
	String list="[ ";
	LNode temp=head;
	while(temp!=null){
	    list+=temp+",";
	    temp=temp.getNext();
	}
	return list.substring(0,list.length()-1)+" ]";
    }

    public int get(int index){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode out=head;
	    int x=0;
	    while (x<index){
	        out=out.getNext();
		x++;
	    }
	    return out.getValue();
	}
    }
    
    public int set(int index,int value){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode temp=head;
	    for (int i=0;i<index;i++){
		temp=temp.getNext();
	    }
	    int out=temp.getValue();
	    temp.setValue(value);
	    return out;
	}
    }
    
    public boolean add(int add){
	if (size()==0){
	    head=new LNode(add);
	    tail=head;
	}else{
	    tail.setNext(new LNode(add));
	    tail=tail.getNext();
	}
	size++;
	return true;
    }

    public void add(int index,int add){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else if(index==0){
	    LNode more=new LNode(add);
	    more.setNext(head);
	    head=more;
	}else{
	    LNode temp=head;
	    for (int i=0;i<index-1;i++){
		temp=temp.getNext();
	    }
	    LNode more=new LNode(add);
	    more.setNext(temp.getNext());
	    temp.setNext(more);
	}
	size++;
    }

    public int remove(int index){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else if(index==0){
	    int out=head.getValue();
	    head=head.getNext();
	    size--;
	    return out;
	}else{
	    int x=0;
	    LNode temp=head;
	    while(x<index-1){
		temp=temp.getNext();
		x++;
	    }
	    int out=temp.getNext().getValue();
	    temp.setNext(temp.getNext().getNext());
	    size--;
	    return out;
	}
    }

    public int size(){
	return size;
    }

    public int indexOf(int value){
	LNode temp=head;
	for (int i=0;i<size();i++){
	    if (temp.getValue()==value){
		return i;
	    }
	}
	return -1;
    }

    public static void main (String[]args){
	MyLinkedList a=new MyLinkedList();
	a.add(10);
	a.add(10);
	a.add(10);
	a.add(1,5);
	a.add(2,6);
       	a.add(3,7);
	a.add(4,8);
	a.set(4,10);
	a.remove(1);
	a.set(5,99);
	System.out.println(a.get(2));
	System.out.println(a.toString());
    }

	
	
	
}
