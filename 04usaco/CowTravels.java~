public class CowTravels{
    private static int N = 4;
    private static int M = 5;
    private static int T = 6;
    private static char[][] pasture = {{'.','.','.','*','.'},
				       {'.','.','.','*','.'},
				       {'.','.','.','.','.'},
				       {'.','.','.','.','.'}};
    private static int R1 = 0;
    private static int C1 = 2;
    private static int R2 = 0;
    private static int C2 = 4;
    
    public static int move(){
	T--;
	return move(R1+1,C1,T) + move(R1,C1+1,T) + move(R1-1,C1,T) + move(R1,C1-1,T);
    }

    public static int move(int r, int c,int t){
	if(r < 0 || r >= N || c < 0 || c >= M)
	    return 0;
	if(pasture[r][c] == '*')
	    return 0;
	if(r == R2 && c == C2 && t == 0)
	    return 1;
	if(t == 0)
	    return 0;
	return move(r+1,c,t-1) + move(r,c+1,t-1) + move(r-1,c,t-1) + move(r,c-1,t-1);
    }

    public static void main(String[] args){
	System.out.println(move());
    }
}