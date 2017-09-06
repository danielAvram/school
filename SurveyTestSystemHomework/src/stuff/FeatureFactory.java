package stuff;

import java.util.Vector;

import feature.Circle;
import feature.Point;
import feature.Polygon;
import feature.Rectangle;
import feature.Text;
import graphics.Renderer;

public class FeatureFactory {
	
	//attributes
	private Renderer gfx;
	
	public FeatureFactory(Renderer rend){
		this.gfx = rend;
	}
	
	
	//methods
	public Renderer getRenderer(){
		return gfx;
	}
	
	public Geometry createGeometry(int width, int height){
		Geometry g = new Geometry(width, height);
		
		return g;
	}
	
	public Point createPoint(int x, int y){
		Point p = new Point(gfx, x, y);
		
		return p;
	}
	
	public Circle createCircle(int x, int y, int radius){
		Circle c = new Circle(gfx, x, y, radius);
		
		return c;
	}
	
	public Rectangle createRectangle(int x1, int y1, int x2, int y2){
		Rectangle r = new Rectangle(gfx, x1, y1, x2, y2);
		
		return r;
	}
	
	public Polygon createPolygon(){
		Polygon p = new Polygon(gfx);
		
		return p;
	}
	
	public Text createText(int x, int y, String text){
		Text t = new Text(gfx, x, y, text);
		
		return t;
	}
	
	public Text createText(int x, int y, String text, int size){
		Text t = new Text(gfx, x, y, text, size);
		
		return t;
	}
	

}
