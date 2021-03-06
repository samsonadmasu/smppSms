package et.com.smpp.model;
// Generated Aug 20, 2019 2:50:16 PM by Hibernate Tools 5.2.11.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Staff generated by hbm2java
 */
@Entity
@Table(name="staff"
    ,catalog="smppSmsDb"
)
public class Staff  implements java.io.Serializable {


     private Long id;
     private Role role;
     private String userName;
     private String firstName;
     private String lastName;
     private String password;
     private String phoneNumber;
     private String email;
     private boolean staffStatus;

    public Staff() {
    }

	
    public Staff(Role role, boolean staffStatus) {
        this.role = role;
        this.staffStatus = staffStatus;
    }
    public Staff(Role role, String userName, String firstName, String lastName, String password, String phoneNumber, String email, boolean staffStatus) {
       this.role = role;
       this.userName = userName;
       this.firstName = firstName;
       this.lastName = lastName;
       this.password = password;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.staffStatus = staffStatus;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role", nullable=false)
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }

    
    @Column(name="userName")
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="firstName")
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="lastName")
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="password")
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="phoneNumber")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="staffStatus", nullable=false)
    public boolean isStaffStatus() {
        return this.staffStatus;
    }
    
    public void setStaffStatus(boolean staffStatus) {
        this.staffStatus = staffStatus;
    }




}


