package es.iesjandula.statsbomb.common.exception;

import java.io.PrintWriter;
import java.io.Serial;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jesus Garcia Puerto
 * @author Neil Hdez
 */
public class StatsBombException extends Exception
{
	/** Constants - Default Error Code */
	private static final String DEFAULT_ERROR_CODE    = "UNEXPECTED_ERROR" ;

	/** Constants - Default Error Message */
	private static final String DEFAULT_ERROR_MESSAGE = "Unexpected error occurred" ;

	/** Attribute - Code */
	private final String code ;

	/**
	 * Serial version UID
	 */
	@Serial
	private static final long serialVersionUID = -3863955452983684439L;

	/**
	 * Constructor by default
	 */
	public StatsBombException()
	{
		this(StatsBombException.DEFAULT_ERROR_CODE, StatsBombException.DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * Constructor by default with exception
	 */
	public StatsBombException(Exception exception)
	{
		this(StatsBombException.DEFAULT_ERROR_CODE, StatsBombException.DEFAULT_ERROR_MESSAGE, exception);
	}

	/**
	 * Constructor with a message
	 * 
	 * @param message, message to send to super class 
	 */
	public StatsBombException(String code, String message)
	{
		super(message);

		this.code = code;
	}

	/**
	 * Constructor with a message and an exception
	 * 
	 * @param message, message to send to super class
	 * @param exception, a sub-type of Exception with the info of the exception
	 */
	public StatsBombException(String code, String message, Exception exception)
	{
		super(message, exception);

		this.code = code;
	}

	/**
	 * This method is useful to return a map with the code and message about the exception
	 *
	 * @return a map with the code and message with the exception
	 */
	public Map<String, Object> getBodyExceptionMessage()
	{
		Map<String, Object> mapBodyException = new HashMap<>();

		mapBodyException.put("code", this.code);
		mapBodyException.put("message", this.getMessage());
		mapBodyException.put("exception", this.generateStackTrace());

		return mapBodyException;
	}

	/**
	 * @return stack trace converted to string
	 */
	private String generateStackTrace()
	{
		final StringWriter stringWriter = new StringWriter() ;
		final PrintWriter printWriter   = new PrintWriter(stringWriter) ;
		this.printStackTrace(printWriter) ;

		return stringWriter.toString() ;
	}

}

