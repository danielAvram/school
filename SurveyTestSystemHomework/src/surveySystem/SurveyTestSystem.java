package surveySystem;

/*

 * Author: Daniel Avram
 * Course: CS350
 * Homework Assignment 2
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class SurveyTestSystem {

	public static Scanner in = new Scanner(System.in);
	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//used for the while loop
		int x = 0;
		
		//declaring survey and test here, setting them to null
		Survey MyForm = new Survey();
		MyForm = null;
		DisplayType display;
		
		
		//while loop here so that i can quit later on
		while( x == 0 ){
		//Here's the first menu output
		System.out.println("Select an option from the menu");
		System.out.println("[1] Create a new Survey");
		System.out.println("[2] Create a new Test");
		System.out.println("[3] Display Survey");
		System.out.println("[4] Display Test");
		System.out.println("[5] Save Survey");
		System.out.println("[6] Save Test");
		System.out.println("[7] Modify an Existing Survey");
		System.out.println("[8] Modify an Existing Test");
		System.out.println("[9] Load Survey");
		System.out.println("[10] Load Test");
		System.out.println("[11] Take Survey");
		System.out.println("[12] Take Test");
		System.out.println("[13] Grade Test");
		System.out.println("[14] Tabulate Survey");
		System.out.println("[15] Tabulate Test");
		System.out.println("[16] Quit Program!");
		int selection = 0;
		selection = in.nextInt();
		
		String input;
		
		//switch case
		switch( selection ){
		// changing QuestionType variable to the appropriate type
		//option 1 is selected
		case 1: System.out.println("What would you like the survey to be called?");
				input = in.next();
				if (MyForm == null){
					MyForm = new Survey();
				}
				MyForm.build(input);
//				MyForm.display();
				x = 1;
				break;
		//option 2 is selected		
		case 2: System.out.println("What would you like the test to be called?");
				input = in.next();
				if (MyForm == null){
					MyForm = new Test();
				}
				MyForm.build(input);
				x = 1;
				break;
		//option 3 is selected		
		case 3:System.out.println("How do you want the survey displayed?");
			System.out.println("[1] Console");
			System.out.println("[2] Png file");
			System.out.println("[3] Jpg file");
			System.out.println("[4] PostScript file");
			int selection2 = in.nextInt();
			switch(selection2){
			case 1:if(MyForm != null){
				display = new StringDisplay();
				MyForm.display(display);
			} else {
					System.out.println("There is no Survey to display!");
			}
					x = 0;
					break;
			case 2: display = new GraphicDisplay(2, MyForm.SurveyName);
					MyForm.display(display);
			}
				x = 0;
				break;
		//option 4 is selected		
		case 4:System.out.println("How do you want the survey displayed?");
		System.out.println("[1] Console");
		System.out.println("[2] Png file");
		System.out.println("[3] Jpg file");
		System.out.println("[4] PostScript file");
		int selection3 = in.nextInt();
		switch(selection3){
		case 1:if(MyForm != null){
			display = new StringDisplay();
			MyForm.display(display);
		} else {
				System.out.println("There is no Survey to display!");
		}
				x = 0;
				break;
		case 2: display = new GraphicDisplay(2, MyForm.SurveyName);
				MyForm.display(display);
		}
			x = 0;
			break; 
		//option 5 is selected		
		case 5: if(MyForm != null){
			File MyFile = new File();
			MyFile.outputXML(MyForm);
//			MyForm.save();
		} else {
				System.out.println("There is no Survey to save!");
		}
				x = 0;
				break;
		//option 6 is selected		
		case 6: if(MyForm != null){
			File MyFile = new File();
			MyFile.outputXML(MyForm);
		} else {
				System.out.println("There is no Test to save!");
		}
				x = 0;
				break;
		//option 7 : modify Survey		
		case 7: System.out.println("What is the name of the survey you would like to modify?");
				String SurveyName;
				SurveyName = in.next();
				//since I don't have load working. I just check if the loaded survey is the same as the name entered.
				if(SurveyName.equals(MyForm.SurveyName) == true){
					//send to modify method
					MyForm.modify();
				}else
				{
					System.out.println("");
					System.out.println("Sorry that Survey does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				}
				x = 0;
				break;
		case 8: System.out.println("What is the name of the test you would like to modify?");
				String TestName;
				TestName = in.next();
				//since I don't have load working. I just check if the loaded survey is the same as the name entered.
				if(TestName.equals(MyForm.SurveyName) == true){
					//send to modify method
					MyForm.modify();
				}else
				{
					System.out.println("");
					System.out.println("Sorry that test does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				}
				x = 0;
				break;
		case 9: System.out.println("What is the name of the survey you want to load?");
				String SurveyLoadN;
				SurveyLoadN = in.next();
				File MyFile = new File();
				MyForm = MyFile.inputXML(SurveyLoadN);
				x = 0;
				break;
		case 10: System.out.println("What is the name of the test you want to load?");
				String TestLoadN;
				TestLoadN = in.next();
				File MyFile2 = new File();
				MyForm = MyFile2.inputXML(TestLoadN);
				x = 0;
				break;
		case 11: in.nextLine();
				System.out.println("What is the name of the survey you want to take?");
				String SurveyTakeN;
				SurveyTakeN = in.nextLine();
				if (SurveyTakeN.equals(MyForm.SurveyName) == true){
					MyForm.take();
					
				}else{
					System.out.println("");
					System.out.println("Sorry that test does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				}
				x = 0;
				break;
		case 12:in.nextLine(); 
				System.out.println("What is the name of the test you want to take?");
				String testTakeN;
				testTakeN = in.nextLine();
				if (testTakeN.equals(MyForm.SurveyName) == true){
					MyForm.take();
					
				}else{
					System.out.println("");
					System.out.println("Sorry that test does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				}
				x = 0;
				break;
		
		case 13:in.nextLine(); 
				System.out.println("What is the name of the test you want to grade?");
				String testGrade;
				testGrade = in.nextLine();
				if (testGrade.equals(MyForm.SurveyName) == true){
					MyForm.gradeTest();
			
				}else{
					System.out.println("");
					System.out.println("Sorry that test does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				} 
				x = 0;
				break;
		case 14: in.nextLine(); 
				System.out.println("What is the name of the survey you want to tabulate?");
				String surveyTab;
				surveyTab = in.nextLine();
				if (surveyTab.equals(MyForm.SurveyName) == true){
					MyForm.tabulate();
	
				}else{
					System.out.println("");
					System.out.println("Sorry that survey does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				} 
				x = 0;
				break;
		case 15: in.nextLine(); 
				System.out.println("What is the name of the test you want to tabulate?");
				String testTab;
				testTab = in.nextLine();
				if (testTab.equals(MyForm.SurveyName) == true){
					MyForm.tabulate();

				}else{
					System.out.println("");
					System.out.println("Sorry that test does not exist. Are you sure you didn't mean: " + MyForm.SurveyName + "?");
				} 
				x = 0;
				break;
				//option 13 selected.. quit program
		case 16: System.out.println("Quiting the Program!");
				x = 2;
				break;
				
		default: System.out.println("Wrong choice champ! Try again");
				System.out.println("");
				break;
				
		}
		
		
		while( x == 1 ){
		
		System.out.println("What kind of question would you like to add? Input the number please.");
		System.out.println("[1] Multiple Choice");
		System.out.println("[2] True/False");
		System.out.println("[3] Short Answer");
		System.out.println("[4] Essay");
		System.out.println("[5] Matching");
		System.out.println("[6] Ranking");
		System.out.println("[7] Back to main menu");
		selection = 0;
		selection = in.nextInt();
		
		switch( selection ){
		// changing QuestionType variable to the appropriate type
		case 1: MyForm.addMultipleChoice();
				x = 1;
				break;
		case 2: MyForm.addTrueFalse();
				x = 1;
				break;
		case 3: MyForm.addShortAnswer();
				x = 1;
				break;
		case 4: MyForm.addEssay();
				x = 1;
				break;
		case 5: MyForm.addMatching();
				x = 1;
				break;
		case 6: MyForm.addRanking();
				x = 1;
				break;
		case 7: x = 0;
				break;
		default: System.out.println("Wrong choice champ! Try again");
				System.out.println("");
				break;
		}
		}
		}

	}

}
