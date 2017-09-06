package surveySystem;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;

/*
 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */

public class Matching extends Question{
	
	//attributes
	@Element
	public int LeftChoiceNumber;
	@Element
	public int RightChoiceNumber;
	@ElementArray
	public Response[] leftChoices = new Response[100];
	@ElementArray
	public Response[] rightChoices = new Response[100];
	
	//constructors
	public Matching(){
		//TODO add for empty const.
	}
	
	public Matching(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		QuestionType = "Matching";
	}
	
	//methods
	public void enterPrompt(){
		//ask specifically for t/f prompt
		System.out.println("Enter prompt for matching question: ");
		prompt = in.nextLine();
	}
	public void display(){
		//outputting here will be fun.. 
		System.out.println((QuestionNumber + 1) + ". " + prompt);
		int counter = 0;
		if (LeftChoiceNumber < RightChoiceNumber){
			counter = RightChoiceNumber;
		}else{
			counter = LeftChoiceNumber;
		}
//		System.out.println(counter);
		String Left;
		String Right;
		for (int i = 0; i < counter ; i++){
			Left = leftChoices[i].StringAnswer();
			Right = rightChoices[i].StringAnswer();
			
			System.out.println("\t" + Left + "\t" + Right);
		}
		
	}
	public void displayLabeled(){
		//outputting here will be fun.. 
		System.out.println((QuestionNumber + 1) + ". " + prompt);
		int counter = 0;
		if (LeftChoiceNumber < RightChoiceNumber){
			counter = RightChoiceNumber;
		}else{
			counter = LeftChoiceNumber;
		}
//		System.out.println(counter);
		String Left;
		String Right;
		for (int i = 0; i < counter ; i++){
			Left = leftChoices[i].StringAnswer();
			Right = rightChoices[i].StringAnswer();
			
			System.out.println(i + ". \t" + Left + "\t" + Right);
		}
		
	}
	public void askLeft(){
		System.out.println("How many choices would you like on the left side (words)?");
		//input the number of choices on left
		LeftChoiceNumber = in.nextInt();
	}
	public void askRight(){
		System.out.println("How many choices would you like on the right side (keys)?");
		//input the number of choices on right
		RightChoiceNumber = in.nextInt();
		
	}
	public void addLeft(){
		String input;
		for (int i = 0; i < LeftChoiceNumber ; i++){
//			in.nextLine();
			System.out.println("Enter choice number " + (i + 1) + " on left:");
			input = in.nextLine();
			leftChoices[i] = new StringResponse(i, input);
		}
		
	}
	public void addRight(){
		String input;
		for (int i = 0; i < RightChoiceNumber ; i++){
//			in.nextLine();
			System.out.println("Enter choice number " + (i + 1) + " on right:");
			input = in.next();
			rightChoices[i] = new StringResponse(i, input);
		}
		
	}
	public void modify(){
		this.modifyPrompt(); //first modify thy prompt
		System.out.println("Do you want to modify the options for matching?"); //ask modify multiple choice
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		int selection = in.nextInt();
		switch( selection ){
		case 1: System.out.println("Do you want to modify the options for matching?"); //ask modify multiple choice
				System.out.println("[1] Left");
				System.out.println("[2] Right");
				int selection2 = in.nextInt();
				switch( selection2 ){
				case 1: this.modifyLeft();
				case 2: this.modifyRight();
				}
		case 2: break;
		}
		this.display();
	}
	public void modifyLeft(){
		//first output the display
		System.out.println("Here is the question: ");
		this.displayLabeled();
		System.out.println("");
		System.out.println("Above are the matching options with a number label.");
		System.out.println("Input the integer of the index for the left side choice.");
		int leftIndex = in.nextInt();
		//pull out the choice and display it then change it
		System.out.println("The choice is currently: ");
		leftChoices[leftIndex].display();
		in.nextLine();
		System.out.println("What do you want to change left choice number " + leftIndex + " to?");
		String newLeft;
		newLeft = in.nextLine();
		leftChoices[leftIndex].changeResponse(newLeft);
	}
	public void modifyRight(){
		//first output the display
		System.out.println("Here is the question: ");
		this.displayLabeled();
		System.out.println("");
		System.out.println("Above are the matching options with a number label.");
		System.out.println("Input the integer of the index for the right side choice.");
		int rightIndex = in.nextInt();
		//pull out the choice and display it then change it
		System.out.println("The choice is currently: ");
		rightChoices[rightIndex].display();
		in.nextLine();
		System.out.println("What do you want to change right choice number " + rightIndex + " to?");
		String newRight;
		newRight = in.nextLine();
		rightChoices[rightIndex].changeResponse(newRight);
	}
	
	public void build(){
		//here's the mighty builder that could
		this.enterPrompt();
		this.askLeft();
		this.askRight();
		in.nextLine();
		this.addLeft();
		this.addRight();
	}
	
	public void take(){
		this.display();
	}
}
