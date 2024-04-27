package com.ciq.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT_TAB")
public class Student {
	
	@Id
	@Column(name = "S_ID")
	private int sid;
	
	@Column(name = "S_NAME")
	private String sname;
	
	@Column(name = "S_FEE")
	private double sfee;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, double sfee) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sfee = sfee;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getSfee() {
		return sfee;
	}

	public void setSfee(double sfee) {
		this.sfee = sfee;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sfee=" + sfee + "]";
	}

}
