import java.util.*;
import java.io.*;

public class Sorts{
    
    public static void mergesort(int[]array){
	array = mergeH(array);
    }

    public static int[] mergeH(int[]whole){
	if (whole.length==1){
	    return whole;
	}else{
	    int[]x = new int[whole.length/2];
	    int[]y = new int[whole.length - whole.length/2];
	    int a = 0;
	    while(a<whole.length){
		if (a<whole.length/2){
		    x[a] = whole[a];
		}else{
		    y[a-whole.length/2] = whole[a];
		}
		a++;
	    }
	    mergeH(x);
	    mergeH(y);
	    return merge(x,y);
	}
      
    }
	
    
    
    public static int[] merge(int[]one, int[]two){
	int[]twelve = new int[one.length+two.length];
	int x = 0;
	int y = 0;
	int z = 0;
	while (z<twelve.length){
	    if (x<one.length && y<two.length){
		if (one[x]<two[y]){
		    twelve[z] = one[x];
		    z++;
		    x++;
		}else{
		    twelve[z] = two[y];
		    z++;
		    y++;
		}
	    }else if(x==one.length && y<two.length){
		twelve[z] = two[y];
		z++;
		y++;
	    }else if(x<one.length && y==two.length){
		twelve[z] = one[x];
		z++;
		x++;
	    }
	}
	return twelve;
    }

    public static void show(int[]hi){
	String sorted = "[";
	int x = 0;
	while (x<hi.length-1){
	    sorted+=hi[x] + ",";
	    x++;
	}
	sorted+=hi[x]+"]";
	System.out.println(sorted);
    }

    public static void main(String[]args){
	Random rand = new Random();
	int[]c = new int[10];
	for(int i=0;i<c.length;i++){
	    c[i] = rand.nextInt(30);
	}
	Sorts.show(c);
	Sorts.mergesort(c);
	Sorts.show(c);
    }
	    

}
		
