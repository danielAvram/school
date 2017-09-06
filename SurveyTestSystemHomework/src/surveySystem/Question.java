package surveySystem;

/*
 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 * Question class - responsible for all the question objects
 */

import java.util.Scanner;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;

public class Question {
	
	//scanner here
	public Scanner in = new Scanner(System.in);
	
	//attributes
	@Element(required=false)
	public int QuestionNumber;
	@Element(required=false)
	public String prompt;
	@Element(required=false)
	public String QuestionType;
	@ElementArray(required=false)
	public Response[] MyResponse = new Response[10];
	
	
	//constructor
	public Question(){
		QuestionNumber = 0;
		prompt = "";
		QuestionType = "";
		MyResponse[1] = new Response();
	}
	
	public Question(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		prompt = "";
		QuestionType = "";
		MyResponse[1] = new Response();
	}
	
	//methods
	public void display(){
		
	}
	public void enterQuestionType(String _QuestionType){
		//changing questiontype to whatever is passed from parameter
		QuestionType = _QuestionType;
		
	}
	
	public void enterPrompt(){
		System.out.println("Please enter the question's prompt:");
		//change prompt here
		prompt = in.next();
		
	}
	public void modifyPrompt(){
		System.out.println("The existing promt is: " + prompt );
		System.out.println("Do you want to modify the prompt?  Enter integer");
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		int selection = in.nextInt();
		
		switch( selection ){
		case 1: in.nextLine();
				System.out.println("Input what you would like to change the prompt to: ");
				//change prompt here
				prompt = in.nextLine();
				System.out.println("The promt was changed to: " + prompt );
		case 2: break;
			
		default: System.out.println("That wasn't a choice!");
				break;
		}
	}
	public void take(){
		//display the question and choices
		display();
		
		//get the response from the user
		MyResponse[0].getResponse();
		
	}
	
	public String getQuestionType(){
		
		return QuestionType;
	}
	
	//interface for multiple choice
	public void askChoices(){
		
	}
	public void addChoices(){
		
	}
	public void build(){
		
	}
	public void modify(){
		this.modifyPrompt(); //first modify thy prompt
	}

}
