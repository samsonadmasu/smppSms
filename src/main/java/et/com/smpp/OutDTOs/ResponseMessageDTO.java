package et.com.smpp.OutDTOs;

public class ResponseMessageDTO {
	private boolean status;
	private String message;
	public ResponseMessageDTO(boolean status, String message) {

		this.status = status;
		this.message = message;
	}
	public ResponseMessageDTO() {

	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
