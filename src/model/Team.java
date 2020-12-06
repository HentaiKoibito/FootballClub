package model;
import java.util.*;
public class Team {
	private String teamName;
	private HeadCoach teamHeadCoach;
	private AssistantCoach[] teamAssistantCoachs;
	private Player[] teamPlayers;
	private arrayList<Lineup> teamLineups;
	private int teamLineupsAmount;
	
	public Team(String teamName, HeadCoach teamHeadCoach){
		this.teamName=teamName;
		this.teamHeadCoach=teamHeadCoach;
		teamAssistantCoach=new AssistantCoach[3];
		teamPlayers = new Player[25];
		teamLineupsAmount=0;
		teamLineups=new arrayList<Lineup>();
	}
	
	public void setTeamName(String teamName){
		this.teamName=teamName;
	}
	
	public String getTeamName(){
		return teamName;
	}
	
	public void setTeamLineupsAmount(int teamLineupsAmount){
		this.teamLineupsAmount=teamLineupsAmount;
	}
	
	public int getTeamLineupsAmount(){
		return teamLineupsAmount;
	}
	
	public boolean playerExists(Player player){
		for(int i=0;i<teamPlayers.length;i++){
			if(teamPlayers[i]!=null){
				if(player.getName().equalsIgnoreCase(teamPlayers[i].getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean addAPlayer(Player player){
		if(!(playerExists(player))){
			for(int i=0;i<teamPlayers.length;i++){
				if(teamPlayers[i]==null){
					teamPlayers[i]=player;
					return true;
				}	
			}
		}	
		return false;
	}
	
	public boolean assistantCoachExists(AssistantCoach assistantCoach){
		for(int i=0;i<teamAssistantCoachs.length;i++){
			if(teamAssistantCoachs[i]!=null){
				if(assistantCoach.getName().equalsIgnoreCase(teamAssistantCoachs[i].getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean addAnAssistantCoach(AssistantCoach assistantCoach){
		if(!(assistantCoachExists(assistantCoach))){
			for(int i=0;i<teamAssistantCoachs.length;i++){
				if(teamAssistantCoachs[i]==null){
					teamAssistantCoachs[i]=assistantCoach;
					return true;
				}	
			}
		}	
		return false;
	}
	
	public boolean lineupExists(Lineup lineup){
		for(int i=0;i<teamLineupsAmount;i++){
			if(teamLineups.get(i)!=null){
				if(lineup.getName().equalsIgnoreCase(teamLineups.get(i).getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean addAnAssistantCoach(AssistantCoach assistantCoach){
		if(!(assistantCoachExists(assistantCoach))){
			teamLineups.add(assistantCoach);
			teamLineupsAmount++;
		}	
		return false;
	}
	
	public String getAssistantCoachs(){
		String info="";
		for(int i=0;i<teamAssistantCoachs;i++){
			info+=teamAssistantCoachs[i].getName()+", ";
		}
		return info;
	}
	
	public String getBasicInformation(){
		String info = "";
		info += "**************  Team **************"+"\n";
		info += "Name: "+getTeamName()+"\n";
		info += "Head Coach: "+teamHeadCoach.getName()+"\n";
		info += "Assistant coachs: "+getSalary()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}