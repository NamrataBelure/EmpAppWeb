package com.scp.java.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmpInfo")
public class EmpEntity {

@Id
@GeneratedValue(strategy=GenerationType.TABLE)
 private int empIdentifier;
 private String empFullNAme;
 private String empCity;
 private double takeHomeSal;
@Override
public String toString() {
	return "EmpEntity [empIndentifier=" + empIdentifier + ", empFullNAme=" + empFullNAme + ", empCity=" + empCity
			+ ", takeHomeSal=" + takeHomeSal + "]";
}
public int getEmpIndentifier() {
	return empIdentifier;
}
public void setEmpIndentifier(int empIndentifier) {
	this.empIdentifier = empIdentifier;
}
public String getEmpFullNAme() {
	return empFullNAme;
}
public void setEmpFullNAme(String empFullNAme) {
	this.empFullNAme = empFullNAme;
}
public String getEmpCity() {
	return empCity;
}
public void setEmpCity(String empCity) {
	this.empCity = empCity;
}
public double getTakeHomeSal() {
	return takeHomeSal;
}
public void setTakeHomeSal(double takeHomeSal) {
	this.takeHomeSal = takeHomeSal;
}
 
 
}
