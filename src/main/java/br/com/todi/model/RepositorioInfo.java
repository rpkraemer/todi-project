package br.com.todi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todi_repositorio_info")
public class RepositorioInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_repositorio_info")
	private Long ID;
	
	@Column(length = 120)
	private String loginName;
	
	@Column(length = 100)
	private String loginUser;
	
	@Column(length = 250)
	private String loginPass;
	
	@Column(length = 100)
	private String loginDBUser;
	
	@Column(length = 250)
	private String loginDBPass;
	
	@Column(length = 120)
	private String loginDBDriver;
	
	@Column(length = 200)
	private String loginDBURL;
	
	@Column(length = 30)
	private String loginWorkRepository;
	
	@Column(length = 100)
	private String loginWorkUser;
	
	@Column(length = 250)
	private String loginWorkPass;
	
	public RepositorioInfo() { }
	
	public RepositorioInfo(String loginName, String loginUser, String loginPass, String loginDBUser, String loginDBPass,
			String loginDBDriver, String loginDBURL, String loginWorkRepository) {
		this.loginName = loginName;
		this.loginUser = loginUser;
		this.loginPass = loginPass;
		this.loginDBUser = loginDBUser;
		this.loginDBPass = loginDBPass;
		this.loginDBDriver = loginDBDriver;
		this.loginDBURL = loginDBURL;
		this.loginWorkRepository = loginWorkRepository;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getLoginDBUser() {
		return loginDBUser;
	}

	public void setLoginDBUser(String loginDBUser) {
		this.loginDBUser = loginDBUser;
	}

	public String getLoginDBPass() {
		return loginDBPass;
	}

	public void setLoginDBPass(String loginDBPass) {
		this.loginDBPass = loginDBPass;
	}

	public String getLoginDBDriver() {
		return loginDBDriver;
	}

	public void setLoginDBDriver(String loginDBDriver) {
		this.loginDBDriver = loginDBDriver;
	}

	public String getLoginDBURL() {
		return loginDBURL;
	}

	public void setLoginDBURL(String loginDBURL) {
		this.loginDBURL = loginDBURL;
	}

	public String getLoginWorkRepository() {
		return loginWorkRepository;
	}

	public void setLoginWorkRepository(String loginWorkRepository) {
		this.loginWorkRepository = loginWorkRepository;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getLoginWorkUser() {
		return loginWorkUser;
	}

	public void setLoginWorkUser(String loginWorkUser) {
		this.loginWorkUser = loginWorkUser;
	}

	public String getLoginWorkPass() {
		return loginWorkPass;
	}

	public void setLoginWorkPass(String loginWorkPass) {
		this.loginWorkPass = loginWorkPass;
	}
	
	
}
