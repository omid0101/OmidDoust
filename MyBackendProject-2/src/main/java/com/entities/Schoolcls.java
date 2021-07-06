package com.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;





//School Class Entity
@Entity
@Table (name= "Class_Table")
public class Schoolcls {
	

	@Id
	@Column(name="Class_Id")
	private long clid;
	@Column (name="Class_Name")
	private String name_cl;
	@Column (name="Class_Level")
	private String level_cl; //Class level corresponding to the student level 
	@Column(name= "Class_Type")
	private String type_cl; //Online or In-class or combined
	
	@ManyToMany(cascade = CascadeType.ALL) //Many to May relationship with subjects
	@JoinTable(name = "Class_Subject", joinColumns = { @JoinColumn(name = "Class_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Subject_id") })
	private Set<Subject> subjects;

	@ManyToMany(cascade = CascadeType.ALL) //Many to Many relationship with teachers
	@JoinTable(name = "Class_Teacher", joinColumns = { @JoinColumn(name = "Class_id") }, inverseJoinColumns = {
			@JoinColumn(name = "Teacher_id") })
	private Set<Teacher> teachers;
	
	
	@OneToMany(mappedBy = "sch_class", cascade = CascadeType.ALL) //One to Many relationship with students
//	@JoinTable(name = "Class_Student", joinColumns = { @JoinColumn(name = "Class_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "Student_id") })
	private Set<Student> students;
	

	public Schoolcls() {
				
	}

	public Schoolcls(long clid, String name_cl, String level_cl, String type_cl, Set<Subject> subjects, 
			Set<Teacher> teachers, Set<Student> students) {
		
		this.clid = clid;
		this.name_cl = name_cl;
		this.level_cl = level_cl;
		this.type_cl = type_cl;
		this.subjects= subjects;
		this.teachers=teachers;
		this.students=students;
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
	
	public String getSubjects() {
		StringBuilder sb = new StringBuilder();
		if (subjects != null && subjects.size() > 0) {
			for (Subject p : subjects) {
				sb.append(p.getName_su() + ",");
			
		}
		
	}
		return sb.toString();
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	
	public String getTeachers() {
		
		StringBuilder sb = new StringBuilder();
		if (teachers != null && teachers.size() > 0) {
			for (Teacher p : teachers) {
				sb.append(p.getFname_tc()+ p.getLname_tc() +  ",");
			}
	} 
		return sb.toString();
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getStudents() {
	
		StringBuilder sb = new StringBuilder();
		if (students != null && students.size() > 0) {
			for (Student p : students) {
				sb.append(p.getFname_std()+ p.getLname_std() +  ",");
			}
	} 
		return sb.toString();
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
}
