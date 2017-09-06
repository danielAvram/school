package surveySystem;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;


public class MultipleChoice extends Question {
	
	//attributes
	@Element(name="numberChoices")
	private int NumberChoices = 0;
	@ElementArray(name="MCResponses")
	private Response[] Choices = new Response[10];
//	private Answer[] Response = new Answer[1];
//	private Answer[] CorrectAnswer = new Answer[1];
	
	//constructor
	public MultipleChoice(){
		prompt = "";
		NumberChoices = 0;
		QuestionType = "Multiple Choice";
		
	}
	
	public MultipleChoice(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		prompt = "";
		NumberChoices = 0;
		QuestionType = "Multiple Choice";
		
	}
	
	//methods
	public void build(){
		this.enterPrompt();
		this.askChoices();
		this.addChoices();
		
	}
	
	public void enterPrompt(){
		//ask specifically for MC prompt
		System.out.println("Enter prompt for multiple choice question: ");
		prompt = in.nextLine();
	}
	public void askChoices(){
		System.out.println("How many choices for question " + (QuestionNumber + 1) +"?");
		NumberChoices = in.nextInt();
	}
	public void display(){
		System.out.println((QuestionNumber + 1) + ". " + prompt);
		for (int i = 0; i < NumberChoices ; i++){
			Choices[i].display();
		}
	}
	
	public void take(){
		System.out.println((QuestionNumber + 1) + ". " + prompt);
		for (int i = 0; i < NumberChoices ; i++){
			Choices[i].display();
		}
	}
	
	public void addChoices(){
		String input;
		in.nextLine();
		//for loop to add choices
		for (int i = 0; i < NumberChoices ; i++){
			System.out.println("Enter choice number " + (i + 1) + ":");
			input = in.nextLine();
			Choices[i] = new StringResponse(i, input);
		}
		
	}
	
	public void modify(){
		this.modifyPrompt(); //first modify thy prompt
		System.out.println("Do you want to modify the choices?"); //ask modify multiple choice
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		int selection = in.nextInt();
		
		switch( selection ){
		case 1: in.nextLine();
				this.display();
				System.out.println("Which choice would you like to change? Input integer.");
				int choice2Change = in.nextInt();
				Choices[choice2Change].display();
				in.nextLine();
				System.out.println("What do you want to change the choice too?");
				String newChoice;
				newChoice = in.nextLine();
				Choices[choice2Change].changeResponse(newChoice);
				this.display();
		case 2: break;
			
		default: System.out.println("That wasn't a choice!");
				break;
		}
		
	}
	

}
