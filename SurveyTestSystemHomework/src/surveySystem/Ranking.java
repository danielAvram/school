package surveySystem;

/*
 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */

public class Ranking extends Matching{
	
	//attributes
//	private Response[] leftChoices = new Response[100];

	//constructors
	public Ranking(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		QuestionType = "Ranking";
	}
	
	public Ranking(){
		
	}
	
	//methods
	public void enterPrompt(){
		//ask specifically for t/f prompt
		System.out.println("Enter prompt for ranking choices question: ");
		prompt = in.nextLine();
	}
	
	//here's the builder
	public void build(){
		this.enterPrompt();
		this.askLeft();
		this.askRight();
		this.addLeft();
		this.addRight();
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
		int Left;
		String Right;
		for (int i = 0; i < counter ; i++){
			Left = leftChoices[i].IntAnswer();
			Right = rightChoices[i].StringAnswer();
			
			System.out.println("\t" + Left + "\t" + Right);
		}
		
	}
	
	//left will be similar to matching but will have numbers
	public void askLeft(){
		System.out.println("How many numbers would you like on the left side (rank levels)?");
		//input the number of choices on left
		LeftChoiceNumber = in.nextInt();
	}
	//addLeft is similar to matching, but holds numbers instead of words
	public void addLeft(){
		for (int i = 0; i < LeftChoiceNumber ; i++){
//			System.out.println("Enter choice number " + (i + 1) + " on left:");
			leftChoices[i] = new IntResponse(i, i);
		}
	}
	public void modify(){
		this.modifyPrompt(); //first modify thy prompt
		System.out.println("Do you want to modify the options for ranking?"); //ask modify multiple choice
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		int selection = in.nextInt();
		switch( selection ){
		case 1: this.modifyRight();
		case 2: break;
		}
		this.display();
	}
	
}
