package com.springBoot.ptm.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stu_information")
public class Student {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sid", length=5)
	private Long id;
	@Column(name="fname", length=15)
	private String fName;
	@Column(name="lname", length=15)
	private String lname;
	@Column(name="std", length=2)
	private Integer Standard;
	@Column(name="phone", length=10)
	private Integer phone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getStandard() {
		return Standard;
	}
	public void setStandard(Integer standard) {
		Standard = standard;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Student(Long id, String fName, String lname, Integer standard, Integer phone) {
		super();
		this.id = id;
		this.fName = fName;
		this.lname = lname;
		Standard = standard;
		this.phone = phone;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lname=" + lname + ", Standard=" + Standard + ", phone="
				+ phone + "]";
	}
	
	
}
