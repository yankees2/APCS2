public class frontier{
    MyDeque<coordinate> list = new MyDeque<coordinate>();
    int mode;
    //1 is queue, 2 is stack, 3 is best, 4 is astar

    public frontier(int x){
	mode=x;
    }

    public void add(coordinate coord){
	if(mode==4){
	    list.add(coord,coord.getdist()+coord.getstep());
	}else if(mode==3){
	    list.add(coord,coord.getdist());
	}else{
	    list.addLast(coord);
	}
    }

    public coordinate remove(){
	if(mode==3 || mode==4){
	    return list.removeSmallest();
	}else if(mode==1){
	    return list.removeLast();
	}else{
	    return list.removeFirst();
	}
    }

    public boolean hasNext(){
	return list.size()>0;
    }

    public String toString(){
	return list.toString();
    }

    public static void main(String[]args){
	frontier a = new frontier(2);
	a.add(new coordinate(1,2,5,5));
	a.add(new coordinate(2,3,5,5));
	System.out.println(a.remove());
	System.out.println(a.hasNext());
	System.out.println(a.remove());
	System.out.println(a.hasNext());
    }
}

    
