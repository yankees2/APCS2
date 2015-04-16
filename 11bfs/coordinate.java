public class coordinate{
    int x,y;

    public coordinate(int hi,int bye){
	x=hi;
	y=bye;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public String toString(){
	return "["+x+","+y+"]";
    }

    public static void main(String[]args){
	coordinate point = new coordinate(3,4);
	System.out.println(point.toString());
    }
}
