package surveySystem;

/*
 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */

public class Essay extends Question{
	
	
	//constructors
	public Essay(){
		//empty for now
	}
	
	public Essay(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		QuestionType = "Essay";
		MyResponse[0] = new StringResponse(0, "Input essay response in this space.");
	}
	
	//methods
	public void enterPrompt(){
		//ask specifically for t/f prompt
		System.out.println("Enter prompt for essay question: ");
		prompt = in.nextLine();
	}
	
	//build
	public void build(){
		this.enterPrompt();
	}
	
	public void display(){
		System.out.println((QuestionNumber + 1) + ". " + prompt);
		MyResponse[0].display();
	}

}
