package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table (name= "Student_Table")
public class Student {

		@Id()
	//	@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "Student_ID")
		private long sid;
		@Column(name = "First_Name")
		private String fname_std;
		@Column(name = "Last_Name")
		private String lname_std;
		@Column(name = "Phone_Number")
		private long number_std;
		@Column(name = "StudentAddress")
		private String saddress;
		@Column(name = "StudentEmail")
		private String semail;
//		@Column(name = "StudentClass")
//		private String sclass;
		
		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="Class_Id")
		private Schoolcls sch_class;// school class for each student
	
		public Student() {
		
		}


		public Student(long sid, String fname_std, String lname_std, long number_std, String saddress,
				String semail) {
				
			this.sid = sid;
			this.fname_std = fname_std;
			this.lname_std = lname_std;
			this.number_std = number_std;
			this.saddress = saddress;
			this.semail = semail;
			
		}

		
		public long getSid() {
			return sid;
		}
		
		
			
		public void setSid(long sid) {
			this.sid = sid;
		}


		public String getFname_std() {
			return fname_std;
		}
		public void setFname_std(String fname_std) {
			this.fname_std = fname_std;
		}
		public String getLname_std() {
			return lname_std;
		}
		public void setLname_std(String lname_std) {
			this.lname_std = lname_std;
		}
		public long getNumber_std() {
			return number_std;
		}
		public void setNumber_std(long number_std) {
			this.number_std = number_std;
		}
	


		public String getSaddress() {
			return saddress;
		}


		public void setSaddress(String saddress) {
			this.saddress = saddress;
		}


		public String getSemail() {
			return semail;
		}


		public void setSemail(String semail) {
			this.semail = semail;
		}
		
		
		
	
		public String getSch_class() {
			
			 String cln= sch_class.getName_cl();
			
				return cln;
			
		}


		public void setSch_class(Schoolcls sch_class) {
			this.sch_class = sch_class;
		}


		@Override
		public String toString() {
			return "Student [ fname_std=" + fname_std + ", lname_std=" + lname_std + ", number_std="
					+ number_std + ", saddress=" + saddress + ", semail=" + semail + "]";
		}



}
