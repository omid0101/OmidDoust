package com.entities;

import java.util.List;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table( name= "Teacher_Table")
public class Teacher {

	@Id
	@Column(name = "Teacher_Id")
	private long tid;
	@Column(name = "First_Name")
	private String fname_tc;
	@Column(name = "Last_Name")
	private String lname_tc;
	@Column(name = "Teacher_Expertise")
	private String expertise_tc; //Teacher Subject Matter expertise
	@Column(name = "Teacher_Level")
	private String level_tc; //Teacher level for subject level or Class Level
	
	
	@ManyToMany(mappedBy= "teachers")
	private List<Schoolcls> classes;
	
	public Teacher() {
		
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
	
	


	public String getClasses() {
		StringBuilder sb = new StringBuilder();
		if (classes != null && classes.size() > 0) {
			for (Schoolcls p : classes) {
				sb.append(p.getName_cl() +  ",");
			}
	} 
		return sb.toString();
	}


	public void setClasses(List<Schoolcls> classes) {
		this.classes = classes;
	}


	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", fname_tc=" + fname_tc + ", lname_tc=" + lname_tc + ", expertise_tc="
				+ expertise_tc + ", level_tc=" + level_tc + "]";
	}


}
