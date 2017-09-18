package com.atguigu.mybits.beans;

import java.util.Date;

public class Student {
	
	private Integer StudentId;
	private String StudentName;
	private Date birth;
	
	public Student() {
		super();
	}
	
	public Student(Integer studentId, String studentName, Date birth) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName="
				+ StudentName + ", birth=" + birth + "]";
	}

	public Integer getStudentId() {
		return StudentId;
	}
	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

}
