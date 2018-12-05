package com.scp.java.bean;

public class EmpBean {
	
	 private int eId;
	 private String Name;
	 private String city;
	 private double salary;
 @Override
	public String toString() {
		return "EmpBean [eId=" + eId + ", Name=" + Name + ", city=" + city + ", salary=" + salary + "]";
	}
public int geteId() {
	return eId;
}
public void seteId(int eId) {
	this.eId = eId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}
