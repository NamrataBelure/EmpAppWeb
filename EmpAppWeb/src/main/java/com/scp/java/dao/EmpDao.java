package com.scp.java.dao;

import java.util.List;

import com.scp.java.Entity.EmpEntity;
import com.scp.java.bean.EmpBean;


public interface EmpDao {
	  public boolean insertEmp(EmpEntity emp);
	  public EmpEntity FatchEmp(int empIndentifier);
	  public boolean removeEmp(int empIndentifier);
	  public EmpEntity EditEmp(EmpEntity emp);
	  public List<EmpEntity>FetchallEmp();
}
