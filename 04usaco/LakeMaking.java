public class LakeMaking{
    static private int R = 4;
    static private int C = 6;
    static private int E = 22;
    static private int N = 2;
    static private int[][] pasture = {{28,25,20,32,34,36},
				      {27,25,20,20,30,34},
				      {24,20,20,20,20,30},
				      {20,20,14,14,20,20}};
    static private int[][] instructions = {{0,3,4},
					   {0,0,10}};

    public static void main(String[] args){
	stomp();
	System.out.println(calc());
    }

    public static void stomp(){
	for(int n = 0;n < N;n++){
	    int max = pasture[instructions[n][0]][instructions[n][1]];
	    for(int x = instructions[n][0];x < instructions[n][0] + 3;x++){
		for(int y = instructions[n][1];y < instructions[n][1] + 3;y++){
		    if(pasture[x][y] > max){
			max = pasture[x][y];
		    }
		}
	    }
	    max -= instructions[n][2];
	    for(int x = instructions[n][0];x < instructions[n][0] + 3;x++){
		for(int y = instructions[n][1];y < instructions[n][1] + 3;y++){
		    if(pasture[x][y] > max){
			pasture[x][y] = max;
		    }
		}
	    }
	}
    }

    public static int calc(){
	int e = 0;
	for(int x = 0;x < R;x++){
	    for(int y = 0;y < C;y++){
		if(pasture[x][y] < E)
		    e += E - pasture[x][y];
	    }
	}
	return e * 72 * 72;
    }
}