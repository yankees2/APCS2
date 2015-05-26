public class RunningMedian{
    private MyHeap max, min;

    public RunningMedian(){
	max = new MyHeap();
	min = new MyHeap(false);
    }

    public void add(int value){
	if(max.size()==0 && min.size()==0){
	    min.add(value);
	}else if(value>getMedian()){
	    if(min.size()>max.size()){
		max.add(min.remove());
		min.add(value);
	    }else{
		min.add(value);
	    }
	}else{
	    if(max.size()>min.size()){
		min.add(max.remove());
		max.add(value);
	    }else{
		max.add(value);
	    }
	}
    }

    public MyHeap getMin(){
	return min;
    }

    public MyHeap getMax(){
	return max;
    }

    public double getMedian(){
	if(max.size()==min.size()){
	    return (max.peek()+min.peek())/2.0;
	}else if(max.size()>min.size()){
	    return max.peek();
	}else{
	    return min.peek();
	}
    }

    public static void main(String[]args){
	RunningMedian a = new RunningMedian();
	a.add(1);
	a.add(5);
	a.add(7);
	a.add(6);
	System.out.println(a.getMedian());
	System.out.println(a.getMin());
	System.out.println(a.getMax());
    }
}
