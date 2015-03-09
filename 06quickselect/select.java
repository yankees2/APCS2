import java.util.*;

public class select{

    public static void quickselect(int[] hi,int si, int ei){
	int[] d = new int[hi.length];
	for(int i=0;i<hi.length;i++){
	    if (i<si || i>ei){
		d[i] = hi[i];
	    }
	}
	// int bruno = 0;
	// while (bruno<si){
	//     d[bruno] = hi[bruno];
	//     bruno++;
	// }
	// int mars = ei+1;
	// while (mars<hi.length){
	//     d[mars] = hi[mars];
	//     mars++;
	// }
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
	show(d);
	System.out.println(hi[pivot]);
    }

    public static quickselect2(int[]ary,int si,int ei,int n){
	Random rand = new Random();
	int pivot = rand.nextInt(ei-si) + si;
	int swap = ary[ei+1];
	ary[ei+1]=ary[pivot];
	ary[pivot]=swap;
	for(int i=0;i<ei;i++){
	    if (ary[i]>ary[ary.length-1]){
		si=i;
	    }
	}
	for(int i=ei;i>=0;i--){
	    if (ary[i]<ary[ary.length-1]){
		ei=i;
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
	sam[0] = 17;
	sam[1] = 3;
	sam[2] = 10;
	sam[3] = 6;
	sam[4] = 16;
	sam[5] = 8;
	sam[6] = 2;
	sam[7] = 0;
	sam[8] = 46;
	sam[9] = 9;
	select.show(sam);
	select.quickselect(sam,0,9);
    }
}
