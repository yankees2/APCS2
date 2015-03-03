import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	int y = 0;
	while (y<board.length){
	    int x = 0;
	    while (x<board.length){
		if (board[y][x]>=10){
		    ans += board[y][x] + " ";
		} else {
		    ans += board[y][x] + "  ";
		}
		x++;
	    }
	    ans += "\n";
	    y++;
	}
	return clear + hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];
	int y = 0;
	while (y<size){
	    int x = 0;
	    while (x<size){
		board[y][x] = 0;
		x++;
	    }
	    y++;
	}
    }

    public String name(){
	return "won.brian";
    }

    
    public boolean solve(){
	return solve(0,0);
    }

    public boolean solve(int startx, int starty){
	return solve(startx,starty,1);			
    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(20);
	if (currentMoveNumber>board.length*board.length){
	    return false;
	} else if (x<0 || x>=board.length || y<0 || y>=board.length){
	    return false;
	} else if (board[y][x]>0){
	    return false;
	} else if (currentMoveNumber == board.length*board.length){
	    board[y][x] = currentMoveNumber;
	    return true;
	} else {
	    board[y][x] = currentMoveNumber;
	    if (solve(x-2,y+1,currentMoveNumber+1) || solve(x-1,y+2,currentMoveNumber+1) || solve(x+1,y+2,currentMoveNumber+1) || solve(x+2,y+1,currentMoveNumber+1) || solve(x+2,y-1,currentMoveNumber+1) || solve(x+1,y-2,currentMoveNumber+1) || solve(x-1,y-2,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1)){
		return true;
	    }
	} 
	board[y][x]=0;
	return false;
    }

    public static void main(String[]arrr){
	KnightsTour t = new KnightsTour(5);
	t.solve(3,3);
	System.out.println(t);
    }
}
