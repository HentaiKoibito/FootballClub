package model;
public class AssistantCoach extends Coach{
	private boolean wasAPlayer;
	private int expertiseIndicator;
	private Expertise coachExpertise;
	
	public AssistantCoach(String name,String identifier,int salary,int statusIndicator, int experienceYears, boolean wasAPlayer, int expertiseIndicator){
		super(name,identifier,salary,statusIndicator,experienceYears);
		this.wasAPlayer=wasAPlayer;
		this.expertiseIndicator=expertiseIndicator;
		coachExpertise = Expertise.values()[expertiseIndicator-1];
	}
	
	
	public void setWasAPlayer(boolean wasAPlayer){
		this.wasAPlayer=wasAPlayer;
	}
	
	public boolean getWasAPlayer(){
		return wasAPlayer;
	}
	
	public void setExpertiseIndicator(int expertiseIndicator){
		this.expertiseIndicator=expertiseIndicator;
	}
	
	public int getExpertiseIndicator(){
		return expertiseIndicator;
	}
	
	public String getCoachExpertise(){
		String info = coachExpertise;
		return info;
	}
	
	@Override
	public String getAllInformation(){
		String info = getBasicInformation();
		info += "Years of experience: "+getExperienceYears()+"\n";
		info += "Was a player?: "+getWasAPlayer()+"\n";
		info += "Expertise: "+getCoachExpertise()+"\n";
		info += "***************************************"+"\n";
		return info;
	}
	
}