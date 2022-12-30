package exception;

/**
 * @author Marven Parmar
 *
 */
public class WalkAwayException extends Exception  {

	/**
	 * Constructor with arg
	 * @param moneyWalkedAway
	 */
	public WalkAwayException(String moneyWalkedAway) {
		// Call parent class exception's constructor and pass message
		 super("Congratulations ! You won $" + moneyWalkedAway + " !" );  
	}

}
