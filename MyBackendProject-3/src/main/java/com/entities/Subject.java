package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="Subject_Table")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name= "Subject_Id")
	private long suid; //subject ID
	@Column (name= "Subject_Name")
	private String name_su; //Subject name
	@Column (name= "Subject_Level")
	private String level_su; //Subject level for Class level
	@Column (name= "Subject_Category")
	private String cat_su; //Subject Category
	@Column(name="Filter_Sub")
	private String fltr_su;
	
	
	@ManyToMany(mappedBy= "subjects")
	private List<Schoolcls> classes;
	
	
		
	public Subject() {
	
	}


	public Subject(String name_su, String level_su, String cat_su, String fltr_su) {
		
		
		this.name_su = name_su;
		this.level_su = level_su;
		this.cat_su = cat_su;
		this.fltr_su= fltr_su; 
	}




	public long getSuid() {
		return suid;
	}


	public void setSuid(long subjId1) {
		this.suid = subjId1;
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
	
	public String getClasses() {
		StringBuilder sb = new StringBuilder();
		if (classes != null && classes.size() > 0) {
			for (Schoolcls p : classes) {
				sb.append(p.getName_cl() );
			}
	} 
		return sb.toString();
	}


	public void setClasses(List<Schoolcls> classes) {
		this.classes = classes;
	}

	


	public String getFltr_su() {
		return fltr_su;
	}


	public void setFltr_su(String fltr_su) {
		this.fltr_su = fltr_su;
	}


	@Override
	public String toString() {
		return "Subject [suid=" + suid + ", name_su=" + name_su + ", level_su=" + level_su + 
				", cat_su=" + cat_su + "]";
	}
	
	
}
