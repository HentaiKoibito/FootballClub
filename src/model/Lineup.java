package model;
public class Lineup {
	public final static int ROWS = 10;
	private final static int COLUMNS = 7;
	private String lineupDate;
	private int lineupTacticIndicator;
	private Tactic lineupTactic;
	private int[][] formationMatrix;
	private String formationString;
	
	
	
	public Lineup(String lineupDate, int lineupTacticIndicator, String formationString){
		this.lineupDate=lineupDate;
		this.lineupTacticIndicator=lineupTacticIndicator;
		lineupTactic = Tactic.values()[lineupTacticIndicator-1];
		formationMatrix = new int [ROWS] [COLUMNS];
		this.formationString = formationString;
	}
	
	public void setLineupDate(String lineupDate) {
		this.lineupDate=lineupDate;
	}
	
	public String getLineupDate(){
		return lineupDate;
	}
	
	public void setLineupTacticIndicator(int lineupTacticIndicator){
		this.lineupTacticIndicator=lineupTacticIndicator;
	}
	
	public int getLineupTacticIndicator(){
		return lineupTacticIndicator;
	}
	
	public String getLineupTactic(){
		String info = lineupTactic;
		return info;
	}
	
	public void setFormationString(String formationString){
		this.formationString=formationString;
	}
	
	public String getFormationString(){
		return formationString;
	}
	
	public int[] getPlayersPerRow(String formation){
		String aux = formation.split("-");
		int[] playersPerRow = new int[aux.length];
		for(int i=0;i<aux.length;i++){
			playersPerRow[i]=(int) aux[i];
		}
		return playersPerRow;
	}
	
	public void createFormationMatrix(String formation){
		int[] formationIndicator = getPlayersPerRow(formation);
		switch(formationIndicator.length){
			case 3:
				organizeRows(2,formationIndicator[2]);
				organizeRows(5,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
			case 4:
				organizeRows(2,formationIndicator[3]);
				organizeRows(4,formationIndicator[2]);
				organizeRows(6,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
			case 5:
				organizeRows(2,formationIndicator[4]);
				organizeRows(3,formationIndicator[3]);
				organizeRows(5,formationIndicator[2]);
				organizeRows(6,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
			case 6:
				organizeRows(2,formationIndicator[5]);
				organizeRows(3,formationIndicator[4]);
				organizeRows(4,formationIndicator[3]);
				organizeRows(5,formationIndicator[2]);
				organizeRows(6,formationIndicator[1]);
				organizeRows(8,formationIndicator[0]);
				break;
		}
	}
	
	public void organizeRows(int rowIndicator,int playersPerRow){
		switch(playersPerRow){
			case 1:
				formationMatrix[rowIndicator][3]=1;
				break;
			case 2:
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][4]=1;
				break;
			case 3:
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
			case 4:
				formationMatrix[rowIndicator][1]=1;
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
				break;
			case 5:
				formationMatrix[rowIndicator][1]=1;
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
				formationMatrix[rowIndicator][5]=1;
				break;
			case 6:
				formationMatrix[rowIndicator][1]=1;
				formationMatrix[rowIndicator][2]=1;
				formationMatrix[rowIndicator][3]=1;
				formationMatrix[rowIndicator][4]=1;
				formationMatrix[rowIndicator][5]=1;
				formationMatrix[rowIndicator][6]=1;
				break;
			case 7:
				for(int i=0;i<6;i++){
					formationMatrix[rowIndicator][i]=1;
				}
				break;
		}
	}
	
	public int getStrikers(){
		int count=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<COLUMNS;j++){
				if(formationMatrix[i][j]==1){
					count++;
				}
			}
		}
		return count;
	}
	
	public int getMidfielders(){
		int count=0;
		for(int i=4;i<7;i++){
			for(int j=0;j<COLUMNS;j++){
				if(formationMatrix[i][j]==1){
					count++;
				}
			}
		}
		return count;
	}
	
	public int getDefenders(){
		int count=0;
		for(int i=7;i<10;i++){
			for(int j=0;j<COLUMNS;j++){
				if(formationMatrix[i][j]==1){
					count++;
				}
			}
		}
		return count;
	}
	
	public String getFormationMatrix(){
		String info="";
		for(int i=0;i<ROWS;i++){
			for(int j=0;j<COLUMNS;j++){
				info += formationMatrix[i][j] + " ";
			}
			info+= "\n";
		}
	}
	
	public String getInfo(){
		String info="";
		info += "**************  Lineup **************"+"\n";
		info += "Date: "+getLineupDate()+"\n";
		info += "Tactic: "+getLineupTactic()+"\n";
		info += "Formation ":+getFormationString()+"\n";
		info += getFormationMatrix();
		info += "Strikers: "+getStrikers()+" Midfielders: "+getMidfielders()+" Defenders "+getDefenders();
		info += "*************************************"+"\n";
		return info;
	}
}