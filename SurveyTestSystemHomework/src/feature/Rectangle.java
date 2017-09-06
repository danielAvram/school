package feature;

import stuff.Feature;
import graphics.Renderer;

public class Rectangle extends Feature{
	
	private static Renderer rend;
	//attributes
	private int x1, y1, x2, y2;

	
	//constructor
	public Rectangle(Renderer rend){
		super(rend);
		this.gfx = rend;
	}
	
	public Rectangle(final Renderer rends, int x1, int y1, int x2, int y2){
		super(rend);
		super.gfx = rends;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
//		this.render();
	}
	
	
	//methods
	public int getX1(){
		return this.x1;
	}
	
	public void setX1(int x){
		this.x1 = x;
	}
	
	public int getY1(){
		return this.y1;
	}
	
	public void setY1(int y){
		this.y1 = y;
	}
	
	public int getX2(){
		return this.x2;
	}
	
	public void setX2(int x){
		this.x2 = x;
	}
	
	public int getY2(){
		return this.y2;
	}
	
	public void setY2(int y){
		this.y2 = y;
	}
	
	public void translate(int dx, int dy){
		//TODO add implementation
	}
	
	public void render(){
//		super.drawLine(x1, y1, x2, y2);
		gfx.drawLine(x1, y1, x2, y1);
		gfx.drawLine(x2, y1, x2, y2);
		gfx.drawLine(x2, y2, x1, y2);
		gfx.drawLine(x1, y2, x1, y1);
	}
}
