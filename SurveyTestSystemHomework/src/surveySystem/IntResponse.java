package surveySystem;

/*
 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */

public class IntResponse extends Response {
	
	//attributes
	//MyAnswer is now an integer
	private int MyAnswer;


	public IntResponse(){
		
	}
	
	//constructor
public IntResponse(int _AnswerNumber, int _MyAnswer){
	
	AnswerNumber = _AnswerNumber;
	MyAnswer = _MyAnswer;	
}

public void display(){
	System.out.println("\t" + AnswerNumber + ". " + MyAnswer);
}

public int IntAnswer(){
	
	return MyAnswer;
}

}
