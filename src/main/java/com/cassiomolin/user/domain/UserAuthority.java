package com.cassiomolin.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_authorities")
public class UserAuthority implements Serializable {
//	 @Column (name="user_id")
//	private Long user_id;
//	public Long getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(Long user_id) {
//		this.user_id = user_id;
//	}
//	public String getAuthority() {
//		return authority;
//	}
//	public void setAuthority(String authority) {
//		this.authority = authority;
//	}
//	 @Column (name="authority")
//	private String authority;
	@EmbeddedId
	UserAuthorityId id;

	public UserAuthorityId getId() {
		return id;
	}

	public void setId(UserAuthorityId id) {
		this.id = id;
	}
}
