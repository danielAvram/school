package surveySystem;

/*

 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 * Response class, responsible for holding responses, choices, answers, and correct answers
 */


import java.util.Scanner;

import org.simpleframework.xml.Element;

public class Response {
	//scanner
	
	public Scanner in = new Scanner(System.in);
	
	@Element(name="AnswerNumber",required=false)
	public int AnswerNumber;
	@Element(name="MyAnswer", required=false)
	public String MyAnswer;
	
	//constructors
	public Response(){
		AnswerNumber = 0;
		MyAnswer = "";
	}

	public Response(int _AnswerNumber){
		AnswerNumber = _AnswerNumber;
//		in.nextLine();
		System.out.println("Please enter answer " + (AnswerNumber+1) + ":");
		MyAnswer = in.nextLine();
	}
	
	public Response(int _AnswerNumber, String _MyAnswer){
		AnswerNumber = _AnswerNumber;
		MyAnswer = _MyAnswer;
		
	}
	
	//methods
	public Boolean Compare(Response userResponse){
		Boolean correct = null;
		
		if(MyAnswer.equals(userResponse.StringAnswer())){
			correct = true;
		}else{
			correct = false;
		}
		
		return correct;
	}
	
	public void getResponse(){
		//ask user for their input
//		System.out.println("Please input your response: ");
//		MyAnswer = in.next();
//		AnswerNumber = 1;
	}
	
	public void take(){
		
	}
	
	public void display(){
		System.out.println(MyAnswer);
	}
	
	public String StringAnswer(){
		
		return MyAnswer;
	}
	
	public int IntAnswer(){
		
		return AnswerNumber;
	}
	
	public void changeResponse(String _MyAnswer){
	}
}
