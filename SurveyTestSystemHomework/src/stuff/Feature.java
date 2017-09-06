package stuff;

import feature.Circle;
import feature.Point;
import feature.Text;
import graphics.Renderer;

public class Feature {
	
	//attributes
	public Renderer gfx;
	
	//constructor
	public Feature(Renderer rend){
		this.gfx = rend;
	}
	
	
	//methods
	public void drawLine(int x1, int y1, int x2, int y2){
		gfx.drawLine(x1, y1, x2, y2);
	}
	
	public void drawPoint(int x, int y){
		Point p = new Point(gfx, x, y);
	}
	
	public void drawCircle(int x, int y, int radius){
		Circle c = new Circle(gfx, x, y, radius);
	}
	
	public void drawText(int x, int y, String text, int size){
		Text t = new Text(gfx, x, y, text, size);
	}
	
	public void translate(int dx, int dy){
		//not sure what to do here
	}
	
	public void render(){
		//not sure what to do here
	}

}
