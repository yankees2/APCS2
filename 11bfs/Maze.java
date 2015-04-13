import java.util.*;
import java.io.*;

public class Maze{
    private char[][] maze;
    private int maxx, maxy;
    private int startx, starty;
    private int endx, endy;
    private int solutionx, solutiony;
    private Frontier frontier = new Frontier();
    private int[][] solutionSet;
    private int[] solution;
    private int finalCount;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    public String name(){
	return "won.brian";
    }

    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " not found.");
	    e.printStackTrace();
	    System.exit(0);
	}
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
	solutionSet = new int[maze.length][maze[0].length];
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
	    return clear + go(0, 0) + toString() + "\n" + show;
	}
	else{
	    return toString();
	}
    }

    private String go(int x, int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try{
	    Thread.sleep(millis);
	}
	catch(InterruptedException e){
	}
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveDFS(boolean animate){
	frontier.addLast(new Coordinate(startx, starty, 1));
	while(frontier.getSize() != 0){
	    if(animate){
		System.out.println(this.toString(true));
		wait(30);
	    }
	    Coordinate A = frontier.removeLast();
	    int x = A.getRow();
	    int y = A.getCol();
	    int[][] possibilities = {
		{x, y+1},{x, y-1},{x-1, y},{x+1, y}
	    };
	    for(int[] possibility : possibilities){
		if(maze[possibility[0]][possibility[1]] == 'E'){
		    maze[x][y] = 'x';
		    solutionSet[x][y] = A.getCount(); 
		    solutionSet[possibility[0]][possibility[1]] = A.getCount()+1;
		    solutionx = possibility[0];
		    solutiony = possibility[1];
		    finalCount = A.getCount()+1;
		    solve(solutionx, solutiony, finalCount);
		    return true;
		}
		if(maze[possibility[0]][possibility[1]] == ' '){
		    solutionSet[x][y] = A.getCount();
		    frontier.addLast(new Coordinate(possibility[0], possibility[1], A.getCount() + 1));
		    maze[x][y] = 'x';
		}
	    }
	}
	return false;
    }



    public boolean solveBFS(boolean animate){
	frontier.addLast(new Coordinate(startx, starty, 1));
	while(frontier.getSize() != 0){
	    if(animate){
		System.out.println(this.toString(true));
		wait(30);
	    }
	    Coordinate A = frontier.removeFirst();
	    int x = A.getRow();
	    int y = A.getCol();
	    int[][] possibilities = {
		{x, y+1},{x, y-1},{x-1, y},{x+1, y}
	    };
	    for(int[] possibility : possibilities){
		if(maze[possibility[0]][possibility[1]] == 'E'){
		    maze[x][y] = 'x';
		    solutionSet[x][y] = A.getCount(); 
		    solutionSet[possibility[0]][possibility[1]]=A.getCount()+1;
		    solutionx = possibility[0];
		    solutiony = possibility[1];
		    finalCount = A.getCount()+1;
		    solve(solutionx, solutiony, finalCount);
		    return true;
		}
		if(maze[possibility[0]][possibility[1]] == ' '){
		    solutionSet[x][y] = A.getCount();
		    frontier.addLast(new Coordinate(possibility[0], possibility[1], A.getCount() + 1));
		    maze[x][y] = 'x';
		}
	    }
	}
	return false;
    }

    public void empty(){
	for(int i = 0; i < maze.length; i++){
	    for(int a = 0; a < maze[i].length; a++){
		if(i == startx && a == starty){
		    maze[i][a] = 'S';
		}
		if(maze[i][a] == 'x'){
		    maze[i][a] = ' ';
		}
	    }
	}
    }

    public void solve(int x, int y, int finalCount){
	solution = new int[finalCount*2+2];
	solution[solution.length-1] = y;
	solution[solution.length-2] = x;
	int halfacoordinate = solution.length -3;
	while(halfacoordinate > 0){
	    int[][]possibilities = {
		{x, y+1},{x, y-1},{x+1, y},{x-1, y}};
	    for(int[]possibility : possibilities){
		if(solutionSet[possibility[0]][possibility[1]] == finalCount-1){
		    solution[halfacoordinate] = possibility[1];
		    halfacoordinate--;
		    solution[halfacoordinate] = possibility[0];
		    x = possibility[0];
		    y = possibility[1];
		    halfacoordinate --;
		    finalCount--;
		}
	    }
	}
    }

    public int[] solutionCoordinates(){
	int [] actualSolution = new int [finalCount*2];
	for(int i = 0; i < actualSolution.length; i++){
	    actualSolution[i] = solution[i+2];
	}
	return actualSolution;
    }

    public static void main(String[]args){
	Maze A = new Maze("data1.dat");
	System.out.println(A.solveDFS(true));
	A.empty();
	System.out.println(Arrays.toString(A.solutionCoordinates()));
    }			  
}
