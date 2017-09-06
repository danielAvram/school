package surveySystem;

import feature.Text;
import graphics.ImageFileRenderer;
import graphics.PostScriptRenderer;
import graphics.Renderer;

import java.io.IOException;

import stuff.FeatureFactory;
import stuff.Geometry;

public class GraphicDisplay extends DisplayType{
	
	public int type;
	public Renderer render;
	public Geometry g;
	public FeatureFactory featureFactory;
	public String name;
	
	
	public GraphicDisplay(int type, String name){
		this.type = type;
		this.name = name;
		
	}
	
	public void display(String s) throws IOException{
		render = new ImageFileRenderer("png", name+".png");
		featureFactory = new FeatureFactory(render);
		g = featureFactory.createGeometry(1000, 1500);
		Text t = new Text(render, 10, 10, s);
		g.add(t);
		render.initialize(g.getWidth(), g.getHeight());
		g.render();
		render.render();
//		g.render();
	}
	
	
	public void setType(int t){
		this.type = type;
	}
	
	private static Renderer createRenderer(int format, final String output)
			throws IOException
	{
		Renderer render = null;
		switch (format) {
		case 2:
			render = new ImageFileRenderer("png", output+".png");
			break;
		case 3:
			render = new ImageFileRenderer("jpg", output+".jpg");
			break;
		case 4:
			render = new PostScriptRenderer(output+".ps");
			break;
		}
		return render;
	}

}
