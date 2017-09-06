package surveySystem;

/*

 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementMap;


public class Test extends Survey {
	
	Scanner in = new Scanner(System.in);
	
	//here are correct answers 
	private Response[][] correctAnswers = new Response[100][100];
//	private int QuestionAnswer = 0;
	
	
	private int AnswerIndex = 0;
	
	private int CorrectChoiceNumber = 0;
	
	
	//constructor
	public Test(){
		
	}
	
	//methods
//	public void display(){
//		System.out.println(SurveyName + " now displaying...");
//		System.out.println("\t");
//		for(int i = 0; i < QuestionsNumber; i++){
//			MyQuestions[i].display();
//		}
//	}
	
	public void modify(){
		System.out.println("Which question would you like to modify? Enter integer question number");
		int modifyQuestion = in.nextInt();
		if(modifyQuestion > MyQuestions.length){
			System.out.println("That question is out of scope! Try again");
			this.modify();
		}else{
			//I subtract 1 from here because of the array indexing (starts at 0)
			this.modifyQuestion(modifyQuestion-1);
			System.out.println("Want to modify the correct answer?");
			System.out.println("[1] Yes, modify correct answer");
			System.out.println("[2] No, do not modify correct answer");
			int selection = in.nextInt();
			switch( selection ){
			case 1: this.modifyCorrect(modifyQuestion-1);
			case 2: break;
			default: System.out.println("Try again");
			}
		}
	}
	
	//I hesitate to do this, but I think in order to enable the user to add correct answer, I'm going to need to readd all the addQuestion methods :(
	public void addMultipleChoice(){
		MyQuestions[QuestionsNumber] = new MultipleChoice(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		this.ChooseCorrect();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
	}

	
	public void addTrueFalse(){
		MyQuestions[QuestionsNumber] = new TrueFalse(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		this.ChooseCorrect();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
		
	}
	
	public void addEssay(){
		MyQuestions[QuestionsNumber] = new Essay(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		this.ChooseCorrect();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
		
	}
	
	public void addShortAnswer(){
		MyQuestions[QuestionsNumber] = new ShortAnswer(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		this.ChooseCorrect();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
	}
	
	public void addMatching(){
		MyQuestions[QuestionsNumber] = new Matching(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		this.ChooseCorrect();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();	
	}
	
	public void addRanking(){
		MyQuestions[QuestionsNumber] = new Ranking(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		this.ChooseCorrect();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
		
	}
	
	public void askCorrectNumber(){
		if(MyQuestions[QuestionsNumber].QuestionType.equals("Multiple Choice") == true){
		
			System.out.println("How many correct choices are there?");
			CorrectChoiceNumber = in.nextInt();
		}else{
			CorrectChoiceNumber = 1;
		}
	}
	
	public void addCorrectChoice(){
		String input;
		
		for( int i = 0; i < CorrectChoiceNumber ; i++){
			input = getResponse(i);
//			correctAnswers[QuestionsNumber][i] = new StringResponse(QuestionsNumber, input);
			super.correctAnswerMap.put(QuestionsNumber, new StringResponse(QuestionsNumber, input));
		}
		
	}
	
	public String getResponse(int i){
		String input;
		System.out.println("Input correct answer " + (i+1) + "/" + CorrectChoiceNumber);
		//TODO add error checking here
		input = in.next();
		return input;
	}
	
	public void ChooseCorrect(){
		this.askCorrectNumber();
		this.addCorrectChoice();
	}
	public void modifyCorrect(int mod){
		//show correct, change
		correctAnswers[mod][0].display();
		in.nextLine();
		System.out.println("What you want to change it to?");
		String newString = in.nextLine();
		correctAnswers[mod][0].changeResponse(newString);
	}
	
	public void save(){
		
	}
	public void load(){
		
	}
	
	public void gradeTest(){
		double testScore = 0;
		int maxScore = 100;
		boolean correct;
		int q = userResponseMap.size();
		if(q > 0){
			double pointsQuestion = maxScore / QuestionsNumber;
			System.out.println("There are "+ QuestionsNumber + " questions on the test.  Each question is worth " + pointsQuestion);
			for(int i = 0; i < QuestionsNumber; i++){
				if(MyQuestions[i].QuestionType.equals("Essay")){
					System.out.println("Question: " + (i+1) + " -- essay Graded later");
					maxScore = (int) (maxScore - pointsQuestion);
				}else{
				correct = correctAnswerMap.get(i).Compare(userResponseMap.get(MyQuestions[i]));
				if(correct == true){
					System.out.println("Question: " + (i+1) + " " + pointsQuestion + "/" + pointsQuestion);
					testScore = testScore + pointsQuestion;
				}else{
					System.out.println("Question: " + (i+1) + " " + "0/" + pointsQuestion);
				}
			}
			}
		System.out.println("Test score is: " + testScore + "/" + maxScore);
		}else{
			System.out.println("It appears that there's no questions!");
		}
		
	}

}
