package et.com.smpp.model;
// Generated Aug 20, 2019 2:50:16 PM by Hibernate Tools 5.2.11.Final


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name="role"
    ,catalog="smppSmsDb"
)
public class Role  implements java.io.Serializable {


     private Long id;
     private String roleName;
     private Set<Staff> staffs = new HashSet<Staff>(0);

    public Role() {
    }

    public Role(String roleName, Set<Staff> staffs) {
       this.roleName = roleName;
       this.staffs = staffs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="roleName")
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="role")
    public Set<Staff> getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }




}


