package surveySystem;

/*
 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 * File Class - saves, exports file to xml
 */

import java.util.Scanner;

import org.simpleframework.xml.core.Persister;

import com.sun.org.apache.xml.internal.serialize.Serializer;


public class File {
	//attributes
	
	
	public String fileName;
	//methods
	
	public Scanner in = new Scanner(System.in);
	
	public void outputXML(Survey MySurvey){
		org.simpleframework.xml.Serializer serializer = new Persister();
		
		//get the name of the survey
		fileName = MySurvey.getName();

		java.io.File outputFile = new java.io.File("exports/" + fileName +".xml");
		
		try {
			serializer.write(MySurvey, outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(fileName + " saved!");
		
	}
	
	public Survey inputXML(String fileName){
		org.simpleframework.xml.Serializer serializer = new Persister();
		Survey MySurvey = new Survey();
		
		java.io.File inFile = new java.io.File("exports/" + fileName);
		
		try {
			serializer.read(MySurvey, inFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MySurvey;
		
	}
	
	
	public void readFile(Survey MySurvey){
		
	}

}
