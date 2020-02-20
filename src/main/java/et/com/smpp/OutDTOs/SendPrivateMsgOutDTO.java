package et.com.smpp.OutDTOs;

public class SendPrivateMsgOutDTO {
    private String message;
    private String phoneNumber;

    public SendPrivateMsgOutDTO(String message, String phoneNumber) {
        this.message = message;
        this.phoneNumber = phoneNumber;
    }

    public SendPrivateMsgOutDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
