package com.jtk.util;

/**
 * <p>
 * Jtk Exception
 * <p>
 * Subclass of Exception, and implements extra methods.
 * 
 * @author Jason
 * 
 */
public class JtkException extends Exception {

	private static final long serialVersionUID = 1L;

	public JtkException() {
		super();
	}

	public JtkException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JtkException(String message, Throwable cause) {
		super(message, cause);
	}

	public JtkException(String message) {
		super(message);
	}

	public JtkException(Throwable cause) {
		super(cause);
	}

	/**
	 * <p>
	 * Return all stack trace messages.
	 * <p>
	 * Instead of {@link Throwable#printStackTrace()}, which prints stack trace
	 * to the standard error output stream, this method returns all the stack
	 * trace messages as a {@code String}.
	 * 
	 * @return all stack trace messages
	 */
	public String getStackTraceString() {
		return StringUtil.printStackTraceToString(this);
	}

}
