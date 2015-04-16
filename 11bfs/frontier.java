public class frontier{
    MyDeque<coordinate> list = new MyDeque<coordinate>();
    int mode;
    //1 is stack, 2 is queue

    public frontier(int x){
	mode=x;
    }

    public void add(coordinate coord){
	list.addLast(coord);
    }

    public coordinate remove(){
	if(mode==1){
	    return list.removeLast();
	}else{
	    return list.removeFirst();
	}
    }

    public boolean hasNext(){
	return list.size()>0;
    }

    public String toString(){
	int x=0;
	String sup = "";
	MyDeque<coordinate> temp = list;
	while(x<list.size()){
	    sup+=temp.removeFirst();
	    x++;
	}
	return sup;

    }

    public static void main(String[]args){
	frontier a = new frontier(2);
	a.add(new coordinate(1,2));
	a.add(new coordinate(2,3));
	System.out.println(a.remove());
	System.out.println(a.hasNext());
	System.out.println(a.remove());
	System.out.println(a.hasNext());
    }
}

    
