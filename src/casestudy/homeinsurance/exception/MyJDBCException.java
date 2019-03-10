package casestudy.homeinsurance.exception;

public class MyJDBCException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public MyJDBCException(final String message) {
        super(message);
    }
}
