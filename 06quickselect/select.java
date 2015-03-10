import java.util.*;

public class select{

    public static int quickselect(int[] hi,int si, int ei,int n){
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
	    return quickselect(d,si,b,n);
	}else if (si>n){
	    return quickselect(d,a,ei,n);
	}
	return -1;
	    
	//show(d);
	//System.out.println(hi[pivot]);
    }

    public static int quickselect2(int[]ary,int si,int ei,int n){
	int a=si;
	int b=ei;
	Random rand = new Random();
	int pivot = rand.nextInt(ei-si+1)+si;
	int swap = ary[ei+1];
	ary[ei+1]=ary[pivot];
	ary[pivot]=swap;
	int pivot2=ei+1;
	boolean keepgoing=true;
	while(keepgoing){
	    while (si<ei && ary[si]<ary[pivot2]){
		si++;
	    }
	    while (ei>si && ary[ei]>ary[pivot2]){
		ei++;
	    }
	    if (si==ei){
		swap=ary[si];
		ary[si]=ary[pivot2];
		ary[pivot2]=swap;
		keepgoing=false;
	    }else{
		swap=ary[ei];
		ary[ei]=ary[si];
		ary[si]=swap;
	    }
	}
	if (si<n){
	    return quickselect2(ary,si+1,b,n);
	}else if(si>n){
	    return quickselect2(ary,a,si-1,n);
	}else{
	    show(ary);
	    return ary[si];
	}
	
	
    }

    public static void quicksort(int[]ary){
    	quickH(ary,0,ary.length-2);
	show(ary);
    }

    public static void quickH(int[]ary,int si,int ei){
    	boolean keepgoing=true;
    	while(keepgoing){
    	    if (si==ei){
    		keepgoing=false;
    	    }else{
		int a=si;
		int b=ei;
		System.out.println(si);
		System.out.println(ei);
    		Random rand = new Random();
    		int pivot = rand.nextInt(ei-si+1)+si;
    		int swap = ary[ei+1];
    		ary[ei+1]=ary[pivot];
    		ary[pivot]=swap;
		int pivot2=ei+1;
		boolean keepgoing2=true;
		while(keepgoing2){
		    while (si<ei && ary[si]<ary[pivot2]){
			si++;
		    }
		    while (ei>si && ary[ei]>ary[pivot2]){
			ei++;
		    }
		    if (si==ei){
			swap=ary[si];
			ary[si]=ary[pivot2];
			ary[pivot2]=swap;
			keepgoing2=false;
		    }else{
			swap=ary[ei];
			ary[ei]=ary[si];
			ary[si]=swap;
		    }
		}
		quickH(ary,si+1,b+1);
		quickH(ary,a,si-1);
	    }
	}
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
	select.quicksort(sam);
    }
}
