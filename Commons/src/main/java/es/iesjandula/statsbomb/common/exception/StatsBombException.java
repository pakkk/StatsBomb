package es.iesjandula.statsbomb.common.exception;

/**
 * @author Jesus Garcia Puerto
 */
public class StatsBombException extends Exception
{
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -3863955452983684439L;

	/**
	 * Constructor by default
	 */
	public StatsBombException()
	{
		super();
	}

	/**
	 * Constructor with a message
	 * 
	 * @param message, message to send to super class 
	 */
	public StatsBombException(String message)
	{
		super(message);
	}

	/**
	 * Constructor with a message and a exception
	 * 
	 * @param message, message to send to super class
	 * @param exception, a sub-type of Exception with the info of the exception
	 */
	public StatsBombException(String message, Exception exception)
	{
		super(message, exception);
	}
}
