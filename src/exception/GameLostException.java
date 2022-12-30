package exception;

/**
 * @author Marven Parmar
 *
 */
public class GameLostException extends Exception{
	/**
	 * Constructor with arg
	 * @param username
	 */
	public GameLostException(String username) {
		// Call parent class exception's constructor and pass message
		super("\nAlas Wrong Answer! Sorry, You lost the game! \nIt was fun having you here "+ username);
	}

}
