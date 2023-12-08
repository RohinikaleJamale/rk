package com.example.demo1.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
private int stuId;
private String stuName;
private String stuAddr;
private String stuEmail;
private String stuPass;
public int getStuId() {
	return stuId;
}
public void setStuId(int stuId) {
	this.stuId = stuId;
}
public String getStuName() {
	return stuName;
}
public void setStuName(String stuName) {
	this.stuName = stuName;
}
public String getStuAddr() {
	return stuAddr;
}
public void setStuAddr(String stuAddr) {
	this.stuAddr = stuAddr;
}
public String getStuEmail() {
	return stuEmail;
}
public void setStuEmail(String stuEmail) {
	this.stuEmail = stuEmail;
}
public String getStuPass() {
	return stuPass;
}
public void setStuPass(String stuPass) {
	this.stuPass = stuPass;
}
@Override
public String toString() {
	return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuAddr=" + stuAddr + ", stuEmail=" + stuEmail
			+ ", stuPass=" + stuPass + "]";
}


}
