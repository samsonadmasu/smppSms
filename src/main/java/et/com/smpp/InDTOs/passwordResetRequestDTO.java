package et.com.smpp.InDTOs;

public class passwordResetRequestDTO {
    private String userName;
    private String password;
    private String oldPassword;
    private String message;
    private boolean passwordResetStatus;

    public passwordResetRequestDTO() {

    }

    public passwordResetRequestDTO(String userName, String password, String oldPassword, String message,
                                   boolean passwordResetStatus) {

        this.userName = userName;
        this.password = password;
        this.oldPassword = oldPassword;
        this.message = message;
        this.passwordResetStatus = passwordResetStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isPasswordResetStatus() {
        return passwordResetStatus;
    }

    public void setPasswordResetStatus(boolean passwordResetStatus) {
        this.passwordResetStatus = passwordResetStatus;
    }
}
