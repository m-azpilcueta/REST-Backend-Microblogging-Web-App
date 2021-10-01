package es.udc.asi.restexample.model.service.dto;

public class UserBasicDTO {
	private Long id;
	private String login;
	
	
	public UserBasicDTO(Long id, String login) {
		this.id = id;
		this.login = login;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}
