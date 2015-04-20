import java.util.Arrays;

public class MyDeque<T>{
    private Object[] things;
    private int head, tail, size;

    public String name(){
	return "won.brian";
    }

    public MyDeque(){
	things=new Object[10];
    }

    public void addFirst(T value){
	if (size()==0){
	    things[0]=(Object)value;
	    head=0;
	    tail=0;
	}else if(head==0){
	    things[size()-1]=(Object)value;
	    head=size()-1;
	}else{
	    things[head-1]=(Object)value;
	    head--;
	}
	size++;	    
    }

    public void addLast(T value){
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
	size--;
    }
    
    public void resize(Object[]hi){
    }

    public int size(){
	return size;
    }
    
    public String toString(){
	return Arrays.toString(things);
    }

    public static void main (String[]args){
	MyDeque<String> a = new MyDeque<String>();
	a.addFirst("Hey");
	a.addLast("boy");
	System.out.println(a.toString());
    }
}
