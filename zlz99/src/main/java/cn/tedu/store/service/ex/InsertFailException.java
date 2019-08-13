package cn.tedu.store.service.ex;

public class InsertFailException extends ServiceException {

	private static final long serialVersionUID = -246681774226409720L;

	public InsertFailException() {
		super();
	}

	public InsertFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsertFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertFailException(String message) {
		super(message);
	}

	public InsertFailException(Throwable cause) {
		super(cause);
	}

}
