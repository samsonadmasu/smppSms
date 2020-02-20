package et.com.smpp.OutDTOs;

public class AllUsersLoginResponseDTO {

	private String token;
	private String authorities;
	
	public AllUsersLoginResponseDTO(String token, String authorities) {
		this.token = token;
		this.authorities = authorities;
	}

	public AllUsersLoginResponseDTO() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	
}
