package database;

import java.util.*;

/**
 * 
 * @author Marven Parmar
 *
 */
public class QuestionDb {
	
	private static int id = 0;
	private String question;
	private String answer;
	private ArrayList<String> options;
	
	
	/**
	 * Constructor with arguments to create question object
	 * @param question
	 * @param answer
	 * @param options
	 */
	public QuestionDb(String question, String answer,  ArrayList<String> options) {
		
		this.id = this.id + 1;
		this.question = question;
		this.answer = answer;
		this.options = options;
	}

	
	
	/**
	 * Get method
	 * @return int id counter
	 */
	public static int getId() {
		return id;
	}

	/**
	 * Getter for question 
	 * @return String
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Getter for question 
	 * @return String
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Get options method
	 * @return Arraylist of String
	 */
	public ArrayList<String> getOptions() {
		return options;
	}
	
	/**
	 * Get option from index
	 * @param n
	 * @return String
	 */
	public String getOption(int n) {
		return options.get(n);
	}



}
