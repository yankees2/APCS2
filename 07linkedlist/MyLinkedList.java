public class MyLinkedList{
    private LNode head;

    public MyLinkedList(){
    }

    public String toString(){
	String list="[ ";
	LNode temp=head;
	while(temp.getValue()!=null){
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
	    for (int i=0;i<size();i++){
		out=out.getNext();
	    }
	    return out;
	}
    }
    
    public int set(int index,int value){
	if (index<0 || index>=size()){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode temp=head;
	    for (int i=0;i<size();i++){
		temp=temp.getNext();
	    }
	    int out=temp.getValue();
	    temp.setValue(value);
	    return out;
	}
    }
	
}