public class coordinate{
    private int x,y,prevx,prevy;

    public coordinate(){
    }

    public void setx(int hi){
	prevx=x;
	x=hi;
    }

    public void sety(int hi){
	prevy=y;
	y=hi;
    }

    public int getx(){
	return x;
    }
    
    public int gety(){
	return y;
    }

    public int getprevx(){
	return prevx;
    }

    public int getprevy(){
	return prevy;
    }
}
    