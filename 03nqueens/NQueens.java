import java.util.*;
import java.io.*;


public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private String[][]board;


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
	int y = 0;
	while (y<board.length){
	    int x = 0;
	    while (x<board.length){
		ans += board[y][x] + " ";
		x++;
	    }
	    ans += "\n";
	    y++;
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	board = new String[size][size];
	int y = 0;
	while (y<size){
	    int x = 0;
	    while (x<size){
		board[y][x] = "*";
		x++;
	    }
	    y++;
	}			
    }

    public String name(){
	return "won.brian";
    }

    
    public boolean solve(){
	return solve(0);		
    }

    public boolean solve(int x){
	return solve(x,x);
    }


		
    public boolean solve(int x,int y){
	System.out.println(this);
	wait(20);
	if (x == board.length){
	    return true;
	} else if (board[y][x].equals("Q")){
	    return false;
	} 	
	int hi = x;
	while (hi>=0){
	    if (board[y][hi].equals("Q")){
		return false;
	    }
	    hi--;
	}
	if (x>y){
	    int a  = y;
            int b = x-y;
	    while (a>=0){
		if (board[a][a+b].equals("Q")){
		    return false;
		}
		a--;
	    }
	    int c = x;
	    int d = y;
	    while (c>=0 && d<board.length){
		if (board[d][c].equals("Q")){
		    return false;
		}
		c--;
		d++;
	    }
	    board[y][x] = "Q";
	} else {
	    int a = x;
	    int b = y-x;
	    while (a>=0){
		if (board[a+b][a].equals("Q")){
		    return false;
		}
		a--;
	    }
	    int c = x;
	    int d = y;
	    while (c>=0 && d<board.length){
		if (board[d][c].equals("Q")){
		    return false;
		}
		c--;
		d++;
	    }
	    board[y][x] = "Q";
	}
	int hello = 0;
	while (hello<board.length){
	    if (solve(x+1,hello)){
		return true;
	    }
	    hello++;
	}
	
	board[y][x] = "*";
	return false;
    }

    public static void main (String[]args){
	NQueens a = new NQueens(8);
        if (a.solve()){
	    System.out.println(a);
	} else {
	    System.out.println("No solution");
	}
    }
}
