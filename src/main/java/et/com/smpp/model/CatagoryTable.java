package et.com.smpp.model;
// Generated Mar 3, 2020 10:30:23 AM by Hibernate Tools 5.2.11.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatagoryTable generated by hbm2java
 */
@Entity
@Table(name="catagoryTable"
    ,catalog="smppSmsDb"
)
public class CatagoryTable  implements java.io.Serializable {


     private Long id;
     private String catagoryName;
     private String representative;
     private boolean status;
     private Boolean currentActive;
     private Boolean catagoryStatus;

    public CatagoryTable() {
    }

	
    public CatagoryTable(boolean status) {
        this.status = status;
    }
    public CatagoryTable(String catagoryName, String representative, boolean status, Boolean currentActive, Boolean catagoryStatus) {
       this.catagoryName = catagoryName;
       this.representative = representative;
       this.status = status;
       this.currentActive = currentActive;
       this.catagoryStatus = catagoryStatus;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="catagoryName")
    public String getCatagoryName() {
        return this.catagoryName;
    }
    
    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    
    @Column(name="representative")
    public String getRepresentative() {
        return this.representative;
    }
    
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    
    @Column(name="Status", nullable=false)
    public boolean isStatus() {
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }

    
    @Column(name="currentActive")
    public Boolean getCurrentActive() {
        return this.currentActive;
    }
    
    public void setCurrentActive(Boolean currentActive) {
        this.currentActive = currentActive;
    }

    
    @Column(name="CatagoryStatus")
    public Boolean getCatagoryStatus() {
        return this.catagoryStatus;
    }
    
    public void setCatagoryStatus(Boolean catagoryStatus) {
        this.catagoryStatus = catagoryStatus;
    }




}


