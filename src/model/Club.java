package model;
import java.util.*;
public class Club{
	private String clubName;
	private String clubNIT;
	private String clubFundationDate;
	private ArrayList<Employee> clubEmployees;
	private int clubEmployeesAmount;
	private Team[] clubTeams;
	private Player[][] dressingRoomA;
	private Player[][] dressingRoomB;
	private Coach[][] clubOffices;
	
	public Club(String clubName,String clubNIT,String clubFundationDate){
		this.clubName=clubName;
		this.clubNit=clubNit;
		this.clubFundationDate=clubFundationDate;
		clubEmployees=new ArrayList<Employee>();
		clubEmployeesAmount=0;
		clubTeams=new Team[2];
		dressingRoomA=new Player[7][6];
		dressingRoomB=new Player[7][7]:
		clubOffices=new Coach[6][6]:
	}
	
	public void setClubName(String clubName){
		this.clubName=clubName;
	}
	
	public String getClubName(){
		return clubName;
	}
	
	public void setClubNIT(String clubNIT){
		this.clubNIT=clubNIT;
	}
	
	public String getClubNIT(){
		return clubNIT;
	}
	
	public void setClubFundationDate(String clubFundationDate){
		this.clubFundationDate=clubFundationDate;
	}
	
	public String getClubFundationDate(){
		return clubFundationDate;
	}
}