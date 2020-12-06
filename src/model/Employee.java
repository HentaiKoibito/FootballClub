package model;
public abstract class Employee {
	private String name;
	private String identifier;
	private int salary;
	private int statusIndicator;
	private Status employeeStatus;
	
	public Employee(String name,String identifier,int salary,int statusIndicator){
		this.name=name;
		this.identifier=identifier;
		this.salary=salary;
		this.statusIndicator=statusIndicator;
		employeeStatus = Status.values()[statusIndicator-1];
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setIdentifier(String identifier){
		this.identifier=identifier;
	}
	
	public String getIdentifier(){
		return identifier;
	}
	
	public void setSalary(int salary){
		this.salary=salary;
	}
	
	public int getSalary(){
		return salary;
	}
	
	public void setStatusIndicator(int statusIndicator){
		this.statusIndicator=statusIndicator;
	}
	
	public int getStatusIndicator(){
		return statusIndicator;
	}
	
	public String getStatus(){
		String info = employeeStatus;
		return info;
	}
	
	private String getBasicInformation(){
		String info = "";
		info += "**************  Employee **************"+"\n";
		info += "Name: "+getName()+"\n";
		info += "Identifier: "+getIdentifier()+"\n";
		info += "Salary: "+getSalary()+"\n";
		info += "Status: "+getStatus()+"\n";
		return info;
	}
	public abstract String getAllInformation();
}