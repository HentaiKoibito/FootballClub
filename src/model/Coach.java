package model;
public abstract class Coach extends Employee{
	private int experienceYears;
	
	public Coach(String name,String identifier,int salary,int statusIndicator, int experienceYears){
		super(name,identifier,salary,statusIndicator);
		this.experienceYears=experienceYears;
	}
	
	public void setExperienceYears(int experienceYears){
		this.experienceYears=experienceYears;
	}
	
	public int getExperienceYears(){
		return experienceYears;
	}

}