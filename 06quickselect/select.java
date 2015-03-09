import java.util.*;

public class select{

    public static int partition(int[] hi,int si, int ei,int n){
	int a=si;
	int b=ei;
	if (si==ei){
	    return hi[si];
	}
	int[] d = new int[hi.length];
	for (int i=0;i<hi.length;i++){
	    if (i<si || i>ei){
		d[i] = hi[i];
	    }
	}
	Random rand = new Random();
	int pivot = rand.nextInt(ei-si) + si;
	int part = si;
	int end = ei;
	while (part<=end){
	    if (hi[part]<hi[pivot]){
		d[si] = hi[part];
		si++;
	    }else if (hi[part]==hi[pivot]){
	    }else{
		d[ei] = hi[part];
		ei--;
	    }
	    part++;
	}
	d[si] = hi[pivot];
	if (si==n){
	    return d[si];
	}else if (si<n){
	    return partition(d,si,b,n);
	}else if (si>n){
	    return partition(d,a,ei,n);
	}
	return -1;
	    
	//show(d);
	//System.out.println(hi[pivot]);
    }

   
    public static void show(int[]yo){
	String man = "[";
	int x = 0;
	while (x<yo.length-1){
	    man+=yo[x]+",";
	    x++;
	}
	man+=yo[x]+"]";
	System.out.println(man);
    }

    public static void main(String[]args){
	int[] sam = new int[10];
	sam[0] = 7;
	sam[1] = 3;
	sam[2] = 5;
	sam[3] = 6;
	sam[4] = 4;
	sam[5] = 1;
	sam[6] = 2;
	sam[7] = 9;
	sam[8] = 0;
	sam[9] = 8;
	System.out.println(select.partition(sam,0,9,9));
    }
}
