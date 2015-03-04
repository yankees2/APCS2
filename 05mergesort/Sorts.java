public class Sorts{
    private static int[] merged;

    public static void merge(int[] one, int[] two){
	merged = new int[one.length+two.length];
	int x = 0;
	int y = 0;
	int z = 0;
	while (x<one.length && y<two.length && z<merged.length){
	    if (one[x]<two[y]){
		merged[z] = one[x];
		x++;
		z++;
	    } else {
		merged[z] = two[y];
		y++;
		z++;
	    }
	}
    }
    
    public static void main(String[]args){
	int x = 0;
	int[] one = new int[5];
	while (x<5){
	    one[x] = x;
	    x++;
	}
	int y = 0;
	int[] two = new int[5];
	while (y<5){
	    two[y] = y+5;
	    y++;
	}
	Sorts.merge(one, two);
    }
}
