/**
 * 
 * @author Marven Parmar
 *
 */
package database;

import java.util.*;
import java.io.*;

// database class we will be called as an object in Game class
public class Database {
	
	
	// Private variables
	private static String [] EasyGame = { "100.0" , "500.0", "1000.0", "8000.0", "16000.0", "32000.0", "125000.00", "500000.00", "10000000.00"};
	private static String [] HardGame = { "100.0", "200.00", "300.00" , "500.0", "1000.0", "2000.00", "4000.00", "8000.0", "16000.0", "32000.0", "64000.00", "125000.00", "250000.00",  "500000.00", "10000000.00"};
	private ArrayList<QuestionDb> questiondb = new ArrayList<QuestionDb>();
		
	/**
	 * Method to setup database from txt file
	 */
	public void init() {
		System.out.println("Setting up Database please wait...");
		
		ArrayList<String> options = new ArrayList<String>();
		
		try {
			File file=new File("./src/database/database.txt");    //file path
			FileReader fr= new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			String line; 
			int count = 0; 
			String question = null;
			String answer= null;
			while((line=br.readLine())!=null)  // check file is empty or not
			{  
				
				count++;
				if( count == 7) {
					count = 0;
					//System.out.println("Q: " + question +" answer: " +  answer ); // display the question and answers
					this.questiondb.add(new QuestionDb(question, answer, options));
					options = new ArrayList<String>();
					
				}else if(count==1) {
					
					question = line;
				}else if(count==6) {
					answer = line;
				}else {
					
					options.add(line);
				}
				
				       
			}  
			br.close();
			fr.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			for(int i=0; i<15;i++) {
				
				options.add("Not fine");
				options.add("Not fine");
				options.add("Not fine");
				options.add("I am fine");
				
				this.questiondb.add(new QuestionDb("How are you?", "I am fine", options));
			}
		}
		
		System.out.println("Database setup done!");
	}
	
	/**
	 * function would be in the game
	 * @param n
	 * @return returnQuetionDb
	 */
	public ArrayList<QuestionDb> getArrayOfQuestions(int n){
		ArrayList<QuestionDb> returnQuetionDb = new ArrayList<QuestionDb>();
		Collections.shuffle(this.questiondb);
		do{
			returnQuetionDb.add(questiondb.remove(0));
		}while(returnQuetionDb.size()!=n);
		return returnQuetionDb;
	}
	/**
	 * retrieve mapped money based on Game Type and total question.
	 * @param total_asked_questions
	 * @param game_type
	 * @return value
	 */
	public String getMappedMoney(int total_asked_questions, String game_type) {
		if (game_type.toLowerCase().equals("hard")) {
			return HardGame[total_asked_questions - 1 ] ;
		}
		return EasyGame[total_asked_questions - 1 ] ;
	}
}
