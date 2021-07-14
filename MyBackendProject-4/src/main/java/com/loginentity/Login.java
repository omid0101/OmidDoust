package com.loginentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login_Table")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Login_Id")
	private int lgid;
	@Column(name="User_FirstName")
	private String ufname;
	@Column(name="User_LastName")
	private String ulname;
	@Column(name="User_Login")
	private String ulogin;
	@Column(name="User_Password")
	private String upassword;
	
	
	
	public Login() {
		
	}



	public Login(String ufname, String ulname, String ulogin, String upassword) {
	
		this.ufname = ufname;
		this.ulname = ulname;
		this.ulogin = ulogin;
		this.upassword = upassword;
	}



	public int getLgid() {
		return lgid;
	}



	public void setLgid(int lgid) {
		this.lgid = lgid;
	}



	public String getUfname() {
		return ufname;
	}



	public void setUfname(String ufname) {
		this.ufname = ufname;
	}



	public String getUlname() {
		return ulname;
	}



	public void setUlname(String ulname) {
		this.ulname = ulname;
	}



	public String getUlogin() {
		return ulogin;
	}



	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}



	public String getUpassword() {
		return upassword;
	}



	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}



	@Override
	public String toString() {
		return "Login [lgid=" + lgid + ", ufname=" + ufname + ", ulname=" + ulname + ", ulogin=" + ulogin
				+ ", upassword=" + upassword + "]";
	}

	
}
