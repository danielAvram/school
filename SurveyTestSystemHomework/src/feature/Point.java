package feature;

import stuff.Feature;
import graphics.Renderer;

public class Point extends Feature{
	//here's my attributes
	private int x;
	private int y;
	
	//constructor
	public Point(final Renderer rend, int x, int y){
		super(rend);
		this.x = x;
		this.y = y;
		//TODO make constructor here
	}
	
	
	//methods
	public int getX(){
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return this.y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void translate(int dx, int dy){
		//not sure what this is supposed to do yet
	}
	
	public void render(){
		gfx.drawPoint(x, y);
	}
	
}
