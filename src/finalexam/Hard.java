package finalexam;
/**
 * @author Marven Parmar
 */
import exception.GameLostException;
import exception.WalkAwayException;

public class Hard extends Game{
	
	static int max_questions = 5;
	static String gameType = "Hard";
	
	/**
	 * 
	 * @param username
	 */
	public Hard(String username) {
		super(username);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * For the Game round one 
	 * @throws WalkAwayException
	 * @throws GameLostException
	 */
	public void roundOne() throws WalkAwayException,GameLostException {
		super.round(Hard.max_questions, true, false, 1);
	}
	
	/**
	 * For the Game round two 
	 * @throws WalkAwayException
	 * @throws GameLostException
	 */
	public void roundTwo() throws WalkAwayException, GameLostException {
		super.round(Hard.max_questions, true, true, 2);
	}
	
	/**
	 * For the Game round three 
	 * @throws WalkAwayException
	 * @throws GameLostException
	 */
	public void roundThree() throws WalkAwayException, GameLostException {
		super.round(Hard.max_questions, true, false, 3);
	}
	
}
