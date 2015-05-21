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
    public void pushdown(int index){
	if(!((index*2)>data[0])){
	    if(isMax){
		if(index*2==data[0]){
		    if(data[index*2]>data[index]){
			int temp = data[index];
			data[index] = data[index*2];
			data[index*2] = temp;
		    }
		}else if(data[index*2]>data[index] && data[index*2+1]>data[index]){
		    if(data[index*2]>data[index*2+1]){
			int temp = data[index];
			data[index] = data[index*2];
			data[index*2] = temp;
			pushdown(index*2);
		    }else{
			int temp = data[index];
			data[index] = data[index*2+1];
			data[index*2+1] = temp;
			pushdown(index*2+1);
		    }
		}else if(data[index*2]>data[index]){
		    int temp = data[index];
		    data[index] = data[index*2];
		    data[index*2] = temp;
		    pushdown(index*2);
		}else if(data[index*2+1]>data[index]){
		    int temp = data[index];
		    data[index] = data[index*2+1];
		    data[index*2+1] = temp;
		    pushdown(index*2+1);
		}
	    }else{
		if(index*2==data[0]){
		    if(data[index*2]<data[index]){
			int temp = data[index];
			data[index] = data[index*2];
			data[index*2] = temp;
		    }
		}else if(data[index*2]<data[index] && data[index*2+1]<data[index]){
		    if(data[index*2]<data[index*2+1]){
			int temp = data[index];
			data[index] = data[index*2];
			data[index*2] = temp;
			pushdown(index*2);
		    }else{
			int temp = data[index];
			data[index] = data[index*2+1];
			data[index*2+1] = temp;
			pushdown(index*2+1);
		    }
		}else if(data[index*2]<data[index]){
		    int temp = data[index];
		    data[index] = data[index*2];
		    data[index*2] = temp;
		    pushdown(index*2);
		}else if(data[index*2+1]<data[index]){
		    int temp = data[index];
		    data[index] = data[index*2+1];
		    data[index*2+1] = temp;
		    pushdown(index*2+1);
		}
	    }
	}
    }

    public void add(int x){
        if(data[0]+1>=data.length){
	    resize();
	}
	data[data[0]+1]=x;
	pushup(data[0]+1);
	data[0]=data[0]+1;
    }

    public void resize(){
	int[] temp = new int[(data[0]+1)*2];
	int x = 0;
	while(x<data[0]+1){ 
	    temp[x] = data[x];
	    x++;
	}
	data = temp;
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
	a.add(5);
	a.add(6);
	a.add(7);
	a.add(8);
	a.add(9);

	a.add(10);
	//a.add(11);

	System.out.println(a.toString());
    }
}
