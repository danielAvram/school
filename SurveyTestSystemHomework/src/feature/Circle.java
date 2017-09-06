package feature;

import stuff.Feature;
import graphics.Renderer;


public class Circle extends Feature {
	
	//attributes
	private int x, y, radius;
	
	
	//constructor
	public Circle(final Renderer rend, int x, int y, int radius){
		super(rend);
		super.gfx = rend;
		this.x = x;
		this.y = y;
		this.radius = radius;
		
	}
	
	
	//methods
		public int getX(){
			return x;
		}
		
		public void setX(int x){
			this.x = x;
		}

		public int getY(){
			return y;
		}
		
		public void setY(int y){
			this.y = y;
		}
		
		public int getRadius(){
			return radius;
		}
		
		public void setRadius(int radius){
			this.radius = radius;
		}
		
		public void translate(int dx, int dy){
			//not sure what this is supposed to do yet
		}
		
		public void render(){
			//is this what i'm supposed to do for render()?
			gfx.drawCircle(x, y, radius);
		}

}
