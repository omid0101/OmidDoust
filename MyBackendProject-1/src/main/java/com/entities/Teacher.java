package com.entities;

//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name= "Teacher1_Table")
public class Teacher {

	@Id
	private long tid;
	private String fname_tc;
	private String lname_tc;
	private String expertise_tc; //Teacher Subject Matter expertise
	private String level_tc; //Teacher level for subject level or Class Level
	
	
	public Teacher() {
		
		// TODO Auto-generated constructor stub
	}


	public Teacher(long tid, String fname_tc, String lname_tc, String expertise_tc, String level_tc) {
		
		this.tid = tid;
		this.fname_tc = fname_tc;
		this.lname_tc = lname_tc;
		this.expertise_tc = expertise_tc;
		this.level_tc = level_tc;
	}


	public long getTid() {
		return tid;
	}


	public void setTid(long tid) {
		this.tid = tid;
	}


	public String getFname_tc() {
		return fname_tc;
	}


	public void setFname_tc(String fname_tc) {
		this.fname_tc = fname_tc;
	}


	public String getLname_tc() {
		return lname_tc;
	}


	public void setLname_tc(String lname_tc) {
		this.lname_tc = lname_tc;
	}


	public String getExpertise_tc() {
		return expertise_tc;
	}


	public void setExpertise_tc(String expertise_tc) {
		this.expertise_tc = expertise_tc;
	}


	public String getLevel_tc() {
		return level_tc;
	}


	public void setLevel_tc(String level_tc) {
		this.level_tc = level_tc;
	}


	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", fname_tc=" + fname_tc + ", lname_tc=" + lname_tc + ", expertise_tc="
				+ expertise_tc + ", level_tc=" + level_tc + "]";
	}



	
}
