package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Subject_Table")
public class Subject {

	@Id
	private long suid; //subject ID
	private String name_su;
	private String level_su; //Subject level for Class level
	private String cat_su; //Subject Category
	
	
	public Subject() {
	
	}


	public Subject(long suid, String name_su, String level_su, String cat_su) {
		
		this.suid = suid;
		this.name_su = name_su;
		this.level_su = level_su;
		this.cat_su = cat_su;
	}


	public long getSuid() {
		return suid;
	}


	public void setSuid(long suid) {
		this.suid = suid;
	}


	public String getName_su() {
		return name_su;
	}


	public void setName_su(String name_su) {
		this.name_su = name_su;
	}


	public String getLevel_su() {
		return level_su;
	}


	public void setLevel_su(String level_su) {
		this.level_su = level_su;
	}


	public String getCat_su() {
		return cat_su;
	}


	public void setCat_su(String cat_su) {
		this.cat_su = cat_su;
	}


	@Override
	public String toString() {
		return "Subject [suid=" + suid + ", name_su=" + name_su + ", level_su=" + level_su + 
				", cat_su=" + cat_su + "]";
	}
	
	
}
