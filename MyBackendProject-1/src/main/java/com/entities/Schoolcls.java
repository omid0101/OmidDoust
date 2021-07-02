package com.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name= "Class_Table")
public class Schoolcls {
	

	@Id
	//@Column
	private long clid;
	//@Column
	private String name_cl;
	//@Column
	private String level_cl; //Class level corresponding to the student level 
	//@Column
	private String type_cl; //Online or In-class or combined

	public Schoolcls() {
				
	}

	public Schoolcls(long clid, String name_cl, String level_cl, String type_cl) {
		
		this.clid = clid;
		this.name_cl = name_cl;
		this.level_cl = level_cl;
		this.type_cl = type_cl;
	}

	public long getClid() {
		return clid;
	}

	public void setClid(long clid) {
		this.clid = clid;
	}

	public String getName_cl() {
		return name_cl;
	}

	public void setName_cl(String name_cl) {
		this.name_cl = name_cl;
	}

	public String getLevel_cl() {
		return level_cl;
	}

	public void setLevel_cl(String level_cl) {
		this.level_cl = level_cl;
	}

	public String getType_cl() {
		return type_cl;
	}

	public void setType_cl(String type_cl) {
		this.type_cl = type_cl;
	}
	
	

}
