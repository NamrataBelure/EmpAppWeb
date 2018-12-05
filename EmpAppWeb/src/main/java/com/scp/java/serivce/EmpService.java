package com.scp.java.serivce;

import java.util.List;

import com.scp.java.Entity.EmpEntity;
import com.scp.java.bean.EmpBean;

public interface EmpService {
  public boolean AddEmp(EmpBean e);
  public EmpBean getEmp(int eId);
  public boolean deleteEmp(int eId);
  public EmpBean updateEmp(EmpBean emp);
  public List<EmpBean> getallEmp();
 
}
