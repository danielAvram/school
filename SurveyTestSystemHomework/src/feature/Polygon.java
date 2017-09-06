package feature;

import graphics.Renderer;

import java.util.Vector;

import stuff.Feature;

public class Polygon extends Feature {
	
	//attributes
	Vector<Point> points = new Vector<Point>();
	
	
	//constructor
	
	public Polygon(final Renderer rend, final Point... pts){
		super(rend);
		
	}
	
	//methods
	public int size(){
		int size = 10;
		
		//not sure what to put here
		return size;
	}
	
	public Point get(int i){
		//return the point at index i
		return points.get(i);
	}
	
	public void set(int i, Point p){
		//add point p to index i
		points.add(i, p);
	}
	
	public void add(int x, int y){
		//first create point
		Point p = new Point(gfx, x, y);
		System.out.println("Adding: " + x + y);
		//add the point to the vector of points
		points.add(p);
	}
	
	public void add(Point p){
		points.add(p);
	}
	
	public void add(int i, int x, int y){
		//first create point
		Point p = new Point(gfx, x, y);
		points.add(i, p);
	}
	
	public void add(int i, Point p){
		points.add(i, p);
	}
	
	public void remove(int i){
		//remove point at index i
		points.remove(i);
	}
	
	public void remove(Point p){
		points.remove(p);
	}
	
	public void translate(int dx, int dy){
		//not sure what this is supposed to do yet
	}
	
	public void render(){
		int x1, y1, x2, y2;
		for(int i = 0; i < (points.size()-1); i++){
			x1 = points.get(i).getX();
			y1 = points.get(i).getY();
			x2 = points.get(i+1).getX();
			y2 = points.get(i+1).getY();
			System.out.println(x1 + y1 + x2 + y2);
			gfx.drawLine(x1, y1, x2, y2);
			
			//connect to the first point again
			if(i == (points.size()-2)){
				x1 = points.get(0).getX();
				y1 = points.get(0).getY();
				x2 = points.get(i+1).getX();
				y2 = points.get(i+1).getY();
				System.out.println(x1 + y1 + x2 + y2);
				gfx.drawLine(x1, y1, x2, y2);
			}
		}
	}

}
