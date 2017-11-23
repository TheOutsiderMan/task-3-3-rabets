package by.tr.web.task_3_3.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -8754333695913678090L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
	
}
