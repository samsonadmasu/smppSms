package et.com.smpp.OutDTOs;

import et.com.smpp.model.Role;
import et.com.smpp.model.Staff;

public class OutStaffDTO {
    private Long id;
    private Role role;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean staffStatus;

    public OutStaffDTO() {
    }

    public OutStaffDTO(Long id, Role role, String userName, String firstName, String lastName, String password, String phoneNumber, String email, boolean staffStatus) {
        this.id = id;
//        this.role = role;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.staffStatus = staffStatus;
    }


    public OutStaffDTO(final Staff entity) {
        this.id = entity.getId();
   //     this.role = entity.getRole();
        this.userName = entity.getUserName();
        this.firstName = entity.getFirstName();
        this.lastName =entity.getLastName();
        this.password = entity.getPassword();
        this.phoneNumber = entity.getPhoneNumber();
        this.email = entity.getEmail();
        this.staffStatus = entity.isStaffStatus();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
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
}
