package feature;

import stuff.Feature;
import graphics.Renderer;

public class Text extends Feature{
	
	//attributes
	int x, y;
	String text;
	int size = 12;
	
	//constructor
	public Text(final Renderer rend, int x, int y, String text){
		super(rend);
		super.gfx = rend;
		this.x = x;
		this.y = y;
		this.text = text;
		
	}
	
	public Text(final Renderer rend, int x, int y, final String text, int size){
		super(rend);
		this.x = x;
		this.y = y;
		this.text = text;
		this.size = size;
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
		
		public void translate(int dx, int dy){
			//not sure what this is supposed to do yet
		}
		
		public void render(){
			gfx.drawText(x, y, text, size);
		}
		
		public String getText(){
			return text;
		}
		
//		public void setText(String text){
//			this.text = text;
//		}
		
		public int getSize(){
			return size;
		}
		
		public void setSize(int size){
			this.size = size;
		}

}
