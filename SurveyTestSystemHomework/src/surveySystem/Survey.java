package surveySystem;

/*

 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

@Root(name="root")
public class Survey {
	
	//here are my attributes for survey, made of questions
	@Element(name="surveyname")
	public String SurveyName;
	@ElementArray(name="myQuestions", required=true)
	public Question[] MyQuestions = new Question[100];
	
	
	@Element(name="questionNumber")
	public int QuestionsNumber = 0;
//	private Response[] Response = new Response[100];
	public Scanner in = new Scanner(System.in);
	
	//for taking survey
	private Response[][] userResponse = new Response[100][100];
	
	@ElementMap(name="userResponseMap")
	public Map<Question,Response> userResponseMap  = new HashMap<Question, Response>();
	
	@ElementMap(name="correctAnswerMap", required=true)
	public Map<Integer, Response> correctAnswerMap = new HashMap<Integer, Response>();
	
	//constructor
	public Survey(){
//		this.whater.put(new Question, new Answer());
//		this.whater.get(Question);//REsponse
		
		
	}
	
	
	//methods
	public void build(String _SurveyName){
		SurveyName = _SurveyName;
		
	}
	
	public void display(DisplayType d) throws IOException{
		String s = (SurveyName + " now displaying...");
//		System.out.println(SurveyName + " now displaying...");
//		System.out.println("\t");
		d.display(s);
		for(int i = 0; i < QuestionsNumber; i++){
			MyQuestions[i].display();
		}
	}
	
	public void addMultipleChoice(){
		MyQuestions[QuestionsNumber] = new MultipleChoice(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
	}

	
	public void addTrueFalse(){
		MyQuestions[QuestionsNumber] = new TrueFalse(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
		
	}
	
	public void addEssay(){
		MyQuestions[QuestionsNumber] = new Essay(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
		
	}
	
	public void addShortAnswer(){
		MyQuestions[QuestionsNumber] = new ShortAnswer(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
	}
	
	public void addMatching(){
		MyQuestions[QuestionsNumber] = new Matching(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();	
	}
	
	public void addRanking(){
		MyQuestions[QuestionsNumber] = new Ranking(QuestionsNumber);
		MyQuestions[QuestionsNumber].build();
		MyQuestions[QuestionsNumber].display();
		
		//increment QuestionsNumber
		this.incrementQuestionsNumber();
		
	}
	
	//which question you wanna change?
	public void modify(){
		System.out.println("Which question would you like to modify? Enter integer question number");
		int modifyQuestion = in.nextInt();
		if(modifyQuestion > MyQuestions.length){
			System.out.println("That question is out of scope! Try again");
			this.modify();
		}else{
			//I subtract 1 from here because of the array indexing (starts at 0)
			this.modifyQuestion(modifyQuestion-1);
		}
	}
	
	//modifying starts here
	//I think I can get away with only doing a modify question method..
	public void modifyQuestion(int modifyQuestion){
		MyQuestions[modifyQuestion].modify();
	
	}
	
//	public void modifyMultipleChoice(){
//		MyQuestions[QuestionsNumber] = new MultipleChoice(QuestionsNumber);
//		MyQuestions[QuestionsNumber].build();
//		MyQuestions[QuestionsNumber].display();
//		
//		//increment QuestionsNumber
//		this.incrementQuestionsNumber();
//	}
//
//	
//	public void modifyTrueFalse(){
//		MyQuestions[QuestionsNumber] = new TrueFalse(QuestionsNumber);
//		MyQuestions[QuestionsNumber].build();
//		MyQuestions[QuestionsNumber].display();
//		
//		//increment QuestionsNumber
//		this.incrementQuestionsNumber();
//		
//	}
//	
//	public void modifyEssay(){
//		MyQuestions[QuestionsNumber] = new Essay(QuestionsNumber);
//		MyQuestions[QuestionsNumber].build();
//		MyQuestions[QuestionsNumber].display();
//		
//		//increment QuestionsNumber
//		this.incrementQuestionsNumber();
//		
//	}
//	
//	public void modifyShortAnswer(){
//		MyQuestions[QuestionsNumber] = new ShortAnswer(QuestionsNumber);
//		MyQuestions[QuestionsNumber].build();
//		MyQuestions[QuestionsNumber].display();
//		
//		//increment QuestionsNumber
//		this.incrementQuestionsNumber();
//	}
//	
//	public void modifyMatching(){
//		MyQuestions[QuestionsNumber] = new Matching(QuestionsNumber);
//		MyQuestions[QuestionsNumber].build();
//		MyQuestions[QuestionsNumber].display();
//		
//		//increment QuestionsNumber
//		this.incrementQuestionsNumber();	
//	}
//	
//	public void modifyRanking(){
//		MyQuestions[QuestionsNumber] = new Ranking(QuestionsNumber);
//		MyQuestions[QuestionsNumber].build();
//		MyQuestions[QuestionsNumber].display();
//		
//		//increment QuestionsNumber
//		this.incrementQuestionsNumber();
//		
//	}
	
	
	public void load(){
		
		
	
	}
	public void take(){
		//display the number of questions
		System.out.println("This form has " + QuestionsNumber + " questions.  Time limit for this exam is: UNLIMITED");
		System.out.println("The program will now iterate through each question");
		
		for (int i = 0; i < QuestionsNumber; i++){
			MyQuestions[i].take();
			if ( (MyQuestions[i].QuestionType.equals("Multiple Choice")) == true){
//			System.out.println(MyQuestions[i].QuestionType);
				System.out.println("How many answers would you like to input?");
				int numberAnswers = in.nextInt();
				for (int j = 0; j < numberAnswers; j++){
//					System.out.println("i is " + i + " j is " + j);
//					userResponse[i][j] = new Response(j);
					this.userResponseMap.put(MyQuestions[i], new Response(j));
				}
			}else{
//				userResponse[i][0] = new Response(0);
				this.userResponseMap.put(MyQuestions[i], new Response(0));
			}
		}
		
	}
	public void tabulate(){
		int tF = 0;
		int t = 0;
		int f = 0;
		int mC = 0;
		int sA = 0;
		int eS = 0;
		int mR = 0;
		
		for(int i = 0; i < QuestionsNumber; i++){
			if(MyQuestions[i].QuestionType.equals("True or False")){
				tF++;
			}else if(MyQuestions[i].QuestionType.equals("Multiple Choice")){
				mC++;
			}else if(MyQuestions[i].QuestionType.equals("Short Answer")){
				sA++;
			}else if(MyQuestions[i].QuestionType.equals("Essay")){
				eS++;
			}else if((MyQuestions[i].QuestionType.equals("Matching")) || MyQuestions[i].QuestionType.equals("Ranking")){
				mR++;
			}
		}
		
		System.out.println("True and False: " + tF);
		System.out.println("Multiple Choice " + mC);
		System.out.println("Short Answer: " + sA);
		System.out.println("Essay: " + eS);
		System.out.println("Matching or Ranking: " + mR);
		
	}
	
//	public void addMultipleChoice(){
//		
//	}
//	
//	public void addTrueFalse(){
//		
//	}
//	
//	public void addEssay(){
//		
//	}
//	
//	public void addShortAnswer(){
//		
//	}
//	
//	public void addMatching(){
//		
//	}
//	
//	public void addRanking(){
//		
//	}
	
	public void incrementQuestionsNumber(){
		//increments questionsnumber by 1
		QuestionsNumber++;
	}
	
	public String getName(){
		
		return SurveyName;
	}
	
	//QUIT METHOD
	public void quit(){
		
	}


	public void gradeTest() {
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
