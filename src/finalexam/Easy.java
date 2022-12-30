package finalexam;
/**
  @author Marven Parmar
 */

import exception.GameLostException;
import exception.WalkAwayException;

public class Easy extends Game{

	static int max_questions = 3;
	static String gameType = "Easy";
	
	/**
	 * 
	 * @param username
	 */
	public Easy(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * For the Game round one 
	 * @throws WalkAwayException
	 * @throws GameLostException
	 */
	public void roundOne() throws WalkAwayException,GameLostException {
		 super.round(Easy.max_questions, false, true, 1);
	}
	
	/**
	 * For the Game round two 
	 * @throws WalkAwayException
	 * @throws GameLostException
	 */
	public void roundTwo() throws WalkAwayException,GameLostException {
		super.round(Easy.max_questions, true, true, 2);
	}
	
	/**
	 * For the Game round three 
	 * @throws WalkAwayException
	 * @throws GameLostException
	 */
	public void roundThree() throws WalkAwayException,GameLostException {
		super.round(Easy.max_questions, false, true, 3);
	}
	
}
