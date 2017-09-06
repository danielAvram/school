package surveySystem;

public class ShortAnswer extends Essay{
	
	
	//constructors
	public ShortAnswer(int _QuestionNumber){
		QuestionNumber = _QuestionNumber;
		QuestionType = "Short Answer";
		MyResponse[0] = new StringResponse(0, "Input short answer response in this space.");
	}
	public ShortAnswer(){
		
	}
	
	//methods
	public void enterPrompt(){
		//ask specifically for t/f prompt
		System.out.println("Enter prompt for short answer question: ");
		prompt = in.nextLine();
	}
	
	public void build(){
		this.enterPrompt();
	}
	
	//display for ShortAnswer
	public void display(){
		System.out.println((QuestionNumber + 1) + ". " + prompt);
		MyResponse[0].display();
	}

}
