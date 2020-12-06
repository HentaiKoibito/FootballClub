package model;
public class Player extends Employee implements PriceAndLevel{
	private int tShirtNumber;
	private int goalsScored;
	private double averageRating;
	private int positionIndicator;
	private Positions playerPosition;
	private double playerPrice;
	private double playerLevel;

	public Player(String name,String identifier,int salary,int statusIndicator,int tShirtNumber,int goalsScored,double averageRating, int positionIndicator){
		super(name,identifier,salary,statusIndicator);
		this.tShirtNumber=tShirtNumber;
		this.goalsScored=goalsScored;
		this.averageRating=averageRating;
		this.positionIndicator=positionIndicator;
		playerPosition = Positions.values()[positionIndicator-1];
		playerPrice=calculatePrice();
	}
	
	public void setTShirtNumber(int tShirtNumber){
		this.tShirtNumber=tShirtNumber;
	}
	
	public int getTShirtNumber(){
		return tShirtNumber;
	}
	
	public void setGoalsScored(int goalsScored){
		this.goalsScored=goalsScored;
	}
	
	public int getGoalsScored(){
		return goalsScored;
	}
	
	public void setAverageRating(double averageRating){
		this.averageRating=averageRating;
	}
	
	public void setPositionIndicator(int positionIndicator){
		this.positionIndicator=positionIndicator;
	}
	
	public int getPositionIndicator(){
		return positionIndicator;
	}
	
	public String getPosition(){
		String info = playerPosition;
		return info;
	}
	
	@Override
	private double calculatePrice(){
		double price;
		switch(positionIndicator){
			case 1:
				price = (salary*12)+(averageRating*150);
				break;
			case 2:
				price = (salary*13)+(averageRating*125)+(goalsScored*100);
				break;
			case 3:
				price = (salary*14)+(averageRating*135)+(goalsScored*125);
				break;
			case 4:
				price = (salary*15)+(averageRating*145)+(goalsScored*150);
				break;
			default:
				price=0;
				break;
		}
		return price;
	}
	
	@Override
	private void updatePrice(){
		playerPrice=calculatePrice();
	}
	
	@Override
	public String getPrice(){
		return playerPrice;
	}
	
	@Override
	private double calculateLevel(){
		double level;
		switch(positionIndicator){
			case 1:
				level = averageRating*0.9;
				break;
			case 2:
				level = (averageRating*0.9)+(goalsScored/100);
				break;
			case 3:
				level = (averageRating*0.9)+(goalsScored/90);
				break;
			case 4:
				level = (averageRating*0.9)+(goalsScored/80);
				break;
			default:
				level=0;
				break;
		}
		return level;
	}
	
	@Override
	private void updateLevel(){
		playerLevel=calculateLevel();
	}
	
	@Override
	public String getLevel(){
		return playerLevel;
	}
	
	@Override
	public String getAllInformation(){
		String info= getBasicInformation();
		updatePrice();
		updateLevel();
		info += "T-Shirt Number: "+getTShirtNumber()+"\n";
		info += "Goals scored: "+getGoalsScored()+"\n";
		info += "Average rating: "+getAverageRating()+"\n";
		info += "Position: "+getPosition()+"\n";
		info += "Player price: "+getPlayerPrice()+"\n";
		info += "Player level: "+getPlayerLevel()+"\n";
		info += "***************************************"+"\n";
		return info;
	}
}