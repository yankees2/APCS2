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
}