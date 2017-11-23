package by.tr.web.task_3_3.dao.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 195700390693810961L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
}
