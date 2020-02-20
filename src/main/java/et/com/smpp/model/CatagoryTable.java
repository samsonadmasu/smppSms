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
     private Set<SubscribtionTable> subscribtionTables = new HashSet<SubscribtionTable>(0);
     private Set<MessageTable> messageTables = new HashSet<MessageTable>(0);

    public CatagoryTable() {
    }

    public CatagoryTable(String catagoryName, String representative, Set<SubscribtionTable> subscribtionTables, Set<MessageTable> messageTables) {
       this.catagoryName = catagoryName;
       this.representative = representative;
       this.subscribtionTables = subscribtionTables;
       this.messageTables = messageTables;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="catagoryTable")
    public Set<SubscribtionTable> getSubscribtionTables() {
        return this.subscribtionTables;
    }
    
    public void setSubscribtionTables(Set<SubscribtionTable> subscribtionTables) {
        this.subscribtionTables = subscribtionTables;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="catagoryTable")
    public Set<MessageTable> getMessageTables() {
        return this.messageTables;
    }
    
    public void setMessageTables(Set<MessageTable> messageTables) {
        this.messageTables = messageTables;
    }




}

