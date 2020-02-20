package et.com.smpp.InDTOs;

public class InUpdateStaffDTO {
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean staffStatus;

    public InUpdateStaffDTO(long id, String userName, String firstName, String lastName, String password, String phoneNumber, String email, boolean staffStatus) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.staffStatus = staffStatus;
    }

    public InUpdateStaffDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
