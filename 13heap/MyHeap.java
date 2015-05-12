public class MyHeap{
    private int[] data;
    private boolean isMax;

    public MyHeap(){
	data = new int[10];
	isMax = true;
    }

    public MyHeap(boolean isMax){
	data = new int[10];
	this.isMax = isMax;
    }

    public int remove(){
    }

    public void add(int x){
	data[data[0]+1]=x;
	pushup(data[0]+1);
    }

    public void pushup(int index){
	if(index!=1){
	    if(compare(data[index],data[index/2])){
		//swap
	    }
	}
    }

    public boolean compare(int child, int parent){
	if(isMax){
	    return child>parent;
	}else{
	    return child<parent;
	}
    }
}