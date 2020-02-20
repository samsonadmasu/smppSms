package et.com.smpp.model;
// Generated Aug 20, 2019 2:50:16 PM by Hibernate Tools 5.2.11.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BlackList generated by hbm2java
 */
@Entity
@Table(name="blackList"
    ,catalog="smppSmsDb"
)
public class BlackList  implements java.io.Serializable {


     private Long id;
     private String phoneNumber;

    public BlackList() {
    }

    public BlackList(String phoneNumber) {
       this.phoneNumber = phoneNumber;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="phoneNumber")
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}

