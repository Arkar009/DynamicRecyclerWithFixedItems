package com.myapp.zarnimyosettwin.dynamicloadrecyclertest.models;

import java.util.List;

public class NetworkResponse implements BaseModel{
	private List<EmployeeListItem> employeeList;

	public void setEmployeeList(List<EmployeeListItem> employeeList){
		this.employeeList = employeeList;
	}

	public List<EmployeeListItem> getEmployeeList(){
		return employeeList;
	}

	@Override
 	public String toString(){
		return 
			"NetworkResponse{" + 
			"employeeList = '" + employeeList + '\'' + 
			"}";
		}
}