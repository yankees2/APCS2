import java.util.*;
import java.io.*;

public class Maze{
    private int startx,starty,maxx,maxy,endx,endy;
    private char[][] maze;
    private frontier list;
    private ArrayList<coordinate> solution = new ArrayList<coordinate>();
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String name(){
	return "won.brian";
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	    if(c == 'E'){
		endx = i % maxx;
		endy = i / maxx;
	    }
	}
    }

    public String toString(){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += c;
	    }else{
		ans += c;
	    }
	}
	return ans;
    }

    public String toString(boolean animate){
	if(animate){
	    return clear+go(0,0)+toString()+"\n"+show;
	}else{
	    return toString();
	}
    }

    public void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch (InterruptedException e){
	}
    }

    public boolean solveBFS(){
    	return solveBFS(false);
    }

    public boolean solveDFS(){
    	return solveDFS(false);
    }

    public boolean solveBest(){
	return solveBest(false);
    }

    public boolean AStar(){
	return solveAStar(false);
    }

    public boolean solveBFS(boolean animate){
	return solve(animate,1);
    }

    public boolean solveDFS(boolean animate){
	return solve(animate,2);
    }

    public boolean solveBest(boolean animate){
	return solve(animate,3);
    }

    public boolean solveAStar(boolean animate){
	return solve(animate,4);
    }

    public boolean solve(boolean animate,int mode){
	frontier rest = new frontier(mode);
	coordinate start = new coordinate(startx,starty,endx,endy);
	rest.add(start);
	boolean solved = false;
	while(!solved && rest.hasNext()){
	    if(animate && !solved){
		wait(30);
		System.out.println(toString(true));
	    }
	    coordinate next = rest.remove();
	    if(maze[next.getY()][next.getX()]=='E'){
		solved = true;
		addToSolution(next);
	    }else if(!(maze[next.getY()][next.getX()]=='#' || maze[next.getY()][next.getX()]=='x')){
		maze[next.getY()][next.getX()]='x';
		for(coordinate p :getNeighbors(next)){
		    rest.add(p);
		}
	    }
	}
	showSolution();
	System.out.println(toString());
	System.out.println(solutionString());
	return solved;
    }

    public void showSolution(){
	for(coordinate p:solution){
	    maze[p.getY()][p.getX()]='P';
	}
    }

    public coordinate[] getNeighbors(coordinate point){
        coordinate[] nextTo = new coordinate[4];
	nextTo[0] = new coordinate(point.getX(),point.getY()-1,endx,endy,point);
	nextTo[1] = new coordinate(point.getX()+1,point.getY(),endx,endy,point);
	nextTo[2] = new coordinate(point.getX(),point.getY()+1,endx,endy,point);
	nextTo[3] = new coordinate(point.getX()-1,point.getY(),endx,endy,point);
	return nextTo;
    }

    public void addToSolution(coordinate point){
	while(point.getprev()!=null){
	    solution.add(point);
	    point=point.getprev();
	}
	solution.add(point);
    }

    public String solutionString(){
	int x = solution.size()-1;
	String hi = "";
	while(x>0){
	    hi+=solution.get(x)+"->";
	    x--;
	}
	hi+=solution.get(0);
	return hi;
    }

    public static void main (String[]args){
	Maze a = new Maze("data1.dat");
	if(args[0].equals("1")){
	    System.out.println(a.solveBFS(true));
	}else if(args[0].equals("2")){
	    System.out.println(a.solveDFS(true));
	}else if(args[0].equals("3")){
	    System.out.println(a.solveBest(true));
	}else if(args[0].equals("4")){
	    System.out.println(a.solveAStar(true));
	}
    }
}

    
