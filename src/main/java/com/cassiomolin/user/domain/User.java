package com.cassiomolin.user.domain;

import com.cassiomolin.security.domain.Authority;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Persistence model that represents a user.
 *
 * @author cassiomolin
 */
@Entity
@Table(name="user")
@NamedQueries({
	@NamedQuery(name="User.findByStaffId", query="SELECT u FROM User u WHERE u.staffId = :staffId")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="staffId")
    private Long staffId;

//    @Column(name = "customer_flag")
//    private boolean customerFlag;

	@Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean active;

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    private Set<Authority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public User() {
    }

//    public boolean isCustomerFlag() {
//        return customerFlag;
//    }
//
//    public void setCustomerFlag(boolean customerFlag) {
//        this.customerFlag = customerFlag;
//    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
    public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}
