package surveySystem;

import org.simpleframework.xml.ElementArray;

public class TrueFalse extends MultipleChoice{
	//in this case the choices is only 2 - true and false
	@ElementArray(name="tfChoices",required=false)
	private Response[] Choices = new Response[2];
	
	//constructors
	public TrueFalse(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		QuestionType = "True or False";
		Choices[0] = new StringResponse(0, "true");
		Choices[1] = new StringResponse(1, "false");
	}
	
	public TrueFalse(){
		
	}
	
	//methods
	public void build(){
		this.enterPrompt();
	}
	
	public void enterPrompt(){
		//ask specifically for t/f prompt
		System.out.println("Enter prompt for True/False question: ");
		prompt = in.nextLine();
	}
	
	public void display(){
		System.out.println((QuestionNumber + 1) + ". True or False: " + prompt);
		for (int i = 0; i < 2 ; i++){
			Choices[i].display();
		}
	}
	
	public void modify(){
		this.modifyPrompt(); //first modify thy prompt
	}

}
