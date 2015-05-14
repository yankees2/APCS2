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
	int out = data[1];
	data[1] = data[data[0]];
        data[data[0]] = 0;
	data[0] = data[0]-1;
	pushdown(1);
	return out;
    }

    //make pushdown() then resize()

    public void add(int x){
	data[data[0]+1]=x;
	pushup(data[0]+1);
	data[0]=data[0]+1;
    }

    public void pushup(int index){
	if(index!=1){
	    if(compare(data[index],data[index/2])){
		int temp = data[index];
		data[index] = data[index/2];
		data[index/2] = temp;
	    }
	    pushup(index/2);
	}
    }

    public boolean compare(int child, int parent){
	if(isMax){
	    return child>parent;
	}else{
	    return child<parent;
	}
    }

    public int peek(){
	return data[1];
    }

    public String toString(){
	String hi = "[ ";
	for(int x : data){
	    hi=hi+x+" ";
	}
	hi+="]";
	return hi;
    }

    public static void main(String[]args){
	MyHeap a = new MyHeap();
	a.add(2);
	a.add(4);
	a.add(1);
	a.add(3);
	System.out.println(a.toString());
    }
}