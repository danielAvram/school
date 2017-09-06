package stuff;

import java.util.Vector;

public class Geometry {
	
	//attributes
	private Vector<Feature> features = new Vector<Feature>();
	int width, height;
	
	//consturctor
	public Geometry(int w, int h){
		this.width = w;
		this.height = h;
	}
	
	//methods
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int count(){
		return features.size();
	}
	
	public void add(Feature f){
		features.add(f);
	}
	
	public void remove(Feature f){
		features.remove(f);
	}
	
	public void render(){
		for(int i = 0; i < features.size(); i++){
			features.get(i).render();	
		}
	}

}
