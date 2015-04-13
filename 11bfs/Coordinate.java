public class Coordinate{

    private int row, col, count;

    public void setRow(int row){
	this.row = row;
    }

    public void setCol(int col){
	this.col = col;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public void setCount(int count){
	this.count = count;
    }

    public int getCount(){
	return count;
    }

    public Coordinate(){
	row = 0;
	col = 0;
    }

    public Coordinate(int row, int col, int count){
	this.row = row;
	this.col = col;
	this.count = count;
    }	
}
