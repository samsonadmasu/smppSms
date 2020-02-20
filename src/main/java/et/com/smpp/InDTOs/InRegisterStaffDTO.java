package et.com.smpp.InDTOs;

public class InRegisterStaffDTO {
    private long id;
    private long role;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean staffStatus;
    private String message;
    private boolean registrationStatus;


    public InRegisterStaffDTO(long id, long role, String userName, String firstName, String lastName, String password, String phoneNumber, String email, boolean staffStatus, String message, boolean registrationStatus) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.staffStatus = staffStatus;
        this.message = message;
        this.registrationStatus = registrationStatus;
    }

    public InRegisterStaffDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(boolean staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}
