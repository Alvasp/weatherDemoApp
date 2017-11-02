package cl.personal.weatherDemoApp.exception;

public class WeatherDemoAppBaseException extends Exception {

	private static final long serialVersionUID = 1L;
	private String appErrorCode;
	private String appErrorMessage;
	private String appErrorDetail;
	
	public WeatherDemoAppBaseException() {
		// TODO Auto-generated constructor stub
	}

	public WeatherDemoAppBaseException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public WeatherDemoAppBaseException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public WeatherDemoAppBaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public WeatherDemoAppBaseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public String getAppErrorCode() {
		return appErrorCode;
	}

	public void setAppErrorCode(String appErrorCode) {
		this.appErrorCode = appErrorCode;
	}

	public String getAppErrorMessage() {
		return appErrorMessage;
	}

	public void setAppErrorMessage(String appErrorMessage) {
		this.appErrorMessage = appErrorMessage;
	}

	public String getAppErrorDetail() {
		return appErrorDetail;
	}

	public void setAppErrorDetail(String appErrorDetail) {
		this.appErrorDetail = appErrorDetail;
	}

	public WeatherDemoAppBaseException(String appErrorCode, String appErrorMessage, String appErrorDetail) {
		super();
		this.appErrorCode = appErrorCode;
		this.appErrorMessage = appErrorMessage;
		this.appErrorDetail = appErrorDetail;
	}
	
	public WeatherDemoAppBaseException(String appErrorCode, String appErrorMessage, String appErrorDetail, Throwable throwable) {
		super(throwable);
		this.appErrorCode = appErrorCode;
		this.appErrorMessage = appErrorMessage;
		this.appErrorDetail = appErrorDetail;
	}



}
