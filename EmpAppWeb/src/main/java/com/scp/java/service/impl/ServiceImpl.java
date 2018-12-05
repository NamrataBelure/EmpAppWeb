package com.scp.java.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import com.scp.java.Entity.EmpEntity;
import com.scp.java.bean.EmpBean;
import com.scp.java.dao.EmpDao;
import com.scp.java.serivce.EmpService;

@Service
public class ServiceImpl implements EmpService{

	@Autowired
	private EmpDao dao;
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	@Transactional
	public boolean AddEmp(EmpBean bean) {
		return dao.insertEmp(convertBeanToEntity(bean));	
	}
    
	@Transactional
	public EmpBean getEmp(int eId) {
		return convertEntityToBean(dao.FatchEmp(eId));
	}

	@Transactional
	public boolean deleteEmp(int eId) {
		return dao.removeEmp(eId);
	}
    
	@Transactional
	public EmpBean updateEmp(EmpBean Emp) {
	return convertEntityToBean(dao.EditEmp(convertBeanToEntity(Emp)));
	}

	@Transactional
	public List<EmpBean> getallEmp() {
		return convertEntitesToBean(dao.FetchallEmp());
	}

	private EmpEntity convertBeanToEntity(EmpBean e) {
		EmpEntity entity=new EmpEntity();
		entity.setEmpIndentifier(e.geteId());
		entity.setEmpFullNAme(e.getName());
		entity.setEmpCity(e.getCity());
		entity.setTakeHomeSal(e.getSalary());
		return entity;
	}
	private EmpBean convertEntityToBean(EmpEntity emp) {
		EmpBean bean=new EmpBean();
		bean.seteId(emp.getEmpIndentifier());
		bean.setName(emp.getEmpFullNAme());
		bean.setCity(emp.getEmpCity());
		bean.setSalary(emp.getTakeHomeSal());
		return bean;
	}
	
	private List<EmpBean> convertEntitesToBean(List<EmpEntity> entites) {
		List<EmpBean>beans =new ArrayList<EmpBean>();
		for (EmpEntity empEntity : entites) {
		beans.add(convertEntityToBean(empEntity));
		}
		return beans;
		
	}
	
}
