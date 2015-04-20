public class coordinate{
    int x,y,dist,step;
    coordinate prev;

    public coordinate(int hi,int bye,int a,int b){
	x=hi;
	y=bye;
	dist=(a-x)+(b-y);
	step=0;
    }

    public coordinate(int hi,int bye,int a,int b,coordinate p){
	x=hi;
	y=bye;
	dist=(a-x)+(b-y);
	prev=p;
	step=p.getstep()+1;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public coordinate getprev(){
	return prev;
    }
    
    public int getdist(){
	return dist;
    }

    public int getstep(){
	return step;
    }

    public String toString(){
	return "["+x+","+y+"]";
    }

    public static void main(String[]args){
	coordinate point = new coordinate(3,4,5,5);
	System.out.println(point.toString());
    }
}
