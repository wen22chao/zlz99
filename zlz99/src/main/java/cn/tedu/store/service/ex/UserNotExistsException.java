package cn.tedu.store.service.ex;

public class UserNotExistsException 
	extends DataNotExistsException {

	private static final long serialVersionUID = -4727301496231842766L;

	public UserNotExistsException() {
		super();
	}

	public UserNotExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotExistsException(String message) {
		super(message);
	}

	public UserNotExistsException(Throwable cause) {
		super(cause);
	}

}
