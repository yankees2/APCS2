public class Recursion implements hw1{
    public String name(){
	return "Won,Brian";
    }

    public int fact(int n)throws IllegalArgumentException{
	if (n<1){
	    throw new IllegalArgumentException();
	} else {
	    return facthelper(n,n-1);
	}
    }

    public int facthelper(int sofar,int next){
	if (next==0){
	    return sofar;
	} else {
	    return facthelper(sofar*next,next-1);
	}
    }

    public int fib(int n)throws IllegalArgumentException{
	if (n<0){
	    throw new IllegalArgumentException();
	} else if (n==0){
    	    return n;
    	} else if (n==1){
    	    return n;
    	} else {
	    return fibhelper(1,1,n-2);
	}
    }

    public int fibhelper(int total,int previous,int count){
	if (count==0){
	    return total;
	} else {
	    return fibhelper(total+previous,total,count-1);
	}
    }

    public double sqrt(double n)throws IllegalArgumentException{
	if (n<0){
	    throw new IllegalArgumentException();
	} else {
	    return sqrthelper(n,1,10);
	}
    }

    public double sqrthelper(double n,double guess,int count){
        if (count==0){
	    return guess;
	} else {
	    return sqrthelper(n,(n/guess+guess)/2,count-1);
	}
    }

    public static void main(String[]args)throws IllegalArgumentException{
	Recursion a = new Recursion();
	System.out.println(a.sqrt(100));
	System.out.println(a.sqrt(-1));
    }
}
