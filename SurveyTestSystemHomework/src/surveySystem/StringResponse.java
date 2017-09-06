package surveySystem;

import org.simpleframework.xml.Element;



public class StringResponse extends Response {
	
	
	//constructor
	public StringResponse(int _AnswerNumber, String _MyAnswer){
		AnswerNumber = _AnswerNumber;
		MyAnswer = _MyAnswer;
		
	}
	public StringResponse() {
		
	}
	
	public void display(){
		System.out.println("\t" + AnswerNumber + ". " + MyAnswer);
	}
	
	public String StringAnswer(){
		
		return MyAnswer;
	}
	
	public void changeResponse(String _MyAnswer){
		MyAnswer = _MyAnswer;
	}

}
