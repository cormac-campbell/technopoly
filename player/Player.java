package player;

import tile.Tile;
import tile.ObjectiveCard;
import tile.Property;

public class Player {
	// Class Attributes
	private String username;
	private double funds;
	private Tile currentPosition;
	private int currentPositionInt;
	private Property[] ownedProperty = new Property[20];
	private ObjectiveCard[] objectives = new ObjectiveCard[5];
	// Objective variables 
	private int chanceCardCount = 0;
	private int passGoCount = 0;
	private double amountCollected = 0;
	private boolean bankrupt;
	
	
	// Constructors  
	public Player(String username, double funds, Tile currentPosition, Property[] ownedProperty, ObjectiveCard[] objectives, int chanceCardCount, int passGoCount, double amountCollected, boolean bankrupt) 
	{
		this.currentPositionInt = 0;
		setUsername(username);
		setFunds(funds);
		setCurrentPosition(currentPosition);
		setOwnedProperty(ownedProperty);
		setObjectives();
		setChanceCardCount(chanceCardCount);
		setPassGoCount(passGoCount);
		setAmountCollected(amountCollected);
		setBankrupt(bankrupt);
	}
	
	public Player()
	{
		this(null,0.0,null,null,null,0,0,0, false);
	}
	
	
	// Getters
	public String getUsername() {
		return username;
	}
	public double getFunds() {
		return funds;
	}
	public Object getCurrentPosition() {
		return currentPosition;
	}

	public int getCurrentPositionInt() {
		return currentPositionInt;
	}
	
	public Property[] getOwnedProperty() {
		return ownedProperty;
	}	
	
	public int getChanceCardCount()
	{
		return this.chanceCardCount;
	}
	
	public int getPassGoCount()
	{
		return this.passGoCount;
	}
	
	public double getAmountCollected()
	{
		return this.amountCollected;
	}
	
			public String getObjectives()
		{
			String str1 = "Objective one not completed.(Pass go 5 times)";
			String str2 = "Objective two not completed.(Own a tile set)";
			String str3 = "Objective three not completed.(Reach a funds value of 1,500)";;
			String str4 = "Objective four not completed.(Collect 500 from other players)";;
			String str5 = "Objective five not completed.(Collect five chance cards)";;
			
			if (objectives[0].getCompleted() == true)
				str1 = "Objective one completed.(Pass go 5 times)";
			
			if (objectives[1].getCompleted() == true)
				str2 = "Objective two completed.(Own a tile set)";
			
			if (objectives[2].getCompleted() == true)
				str3 = "Objective three completed.(Reach a funds value of 1,500)";
			
			if (objectives[3].getCompleted() == true)
				str4 = "Objective four completed.(Collect 500 from other players)";
			
			if (objectives[4].getCompleted() == true)
				str5 = "Objective five completed.(Collect five chance cards)";
			
			return str1 + "\n" + str2 + "\n" + str3 + "\n" + str4 + "\n" + str5;
		}
	
	public boolean getBankrupt()
	{
		return this.bankrupt;
	}
			
	// Setters
	public void setUsername(String username) {
		this.username=username;
	}

	public void setFunds(double funds) {
		this.funds=funds;
	}

	public void setCurrentPosition(Tile currentPosition) {
		this.currentPosition=currentPosition;
	}

	public void setCurrentPositionInt(int currentPositionInt) {
		this.currentPositionInt = currentPositionInt;
	}

	public void setOwnedProperty(Property[] ownedProperty) {
		this.ownedProperty=ownedProperty;
	}

	public void setChanceCardCount(int chanceCardCount)
	{
		this.chanceCardCount = chanceCardCount;
	}
	
	public void setPassGoCount(int passGoCount)
	{
		this.passGoCount = passGoCount;
	}
	
	public void setAmountCollected(double amountCollected)
	{
		this.amountCollected = amountCollected;
	}
		
	public void setObjectives()
	{
		ObjectiveCard obj = new ObjectiveCard();
		obj.setReward(100.00);
		objectives[0] = obj;
		ObjectiveCard obj2 = new ObjectiveCard();
		obj2.setReward(200.00);
		objectives[1] = obj2;
		ObjectiveCard obj3 = new ObjectiveCard();
		obj3.setReward(100.00);
		objectives[2] = obj3;
		ObjectiveCard obj4 = new ObjectiveCard();
		obj4.setReward(100.00);
		objectives[3] = obj4;
		ObjectiveCard obj5 = new ObjectiveCard();
		obj5.setReward(50.00);
		objectives[4] = obj5;
	}
	
	public void setBankrupt(boolean bankrupt)
	{
		this.bankrupt = bankrupt;
	}
	
	// Class Methods
	public void changeFunds(double amount) {
		this.funds+=amount;
	}
	
	public void addOwnedTile(Property newProperty) {
		// add newTile to ownedTiles array
		int index=0;
		boolean gainedProperty=false;
		Property[] newOwnedProperty = new Property[20];
		if (this.ownedProperty!=null) {
			for (Property p : this.ownedProperty) {
				if (p != null) {
					newOwnedProperty[index] = p;
				}
				else {
					if(!gainedProperty) {
						newOwnedProperty[index] = newProperty;
						gainedProperty =true;
					}
				}
				index++;
			}
			
		}
		else
			newOwnedProperty[0]=newProperty;
		this.ownedProperty=newOwnedProperty;
	}

	
	// Checking if objectives are done
	public void checkObjectives()
	{
		//checking objective one
		if (passGoCount == 5  && objectives[0].getCompleted() == false)
		{
			objectives[0].setCompleted(true);
			setFunds(getFunds() + objectives[0].getReward());
		}
		//checking objective two
		if(objectives[1].getCompleted() == false)
		{
		checkTileSets();
		if (objectives[1].getCompleted() == true)
			setFunds(getFunds() + objectives[1].getReward());
		}
		//checking objective three
		if (getFunds() >= 1500.00 && objectives[2].getCompleted() == false)
		{
			objectives[2].setCompleted(true);
			setFunds(getFunds() + objectives[2].getReward());
		}
		
		//checking objective four 
		if (amountCollected >= 500.00 && objectives[3].getCompleted() == false)
		{
			objectives[3].setCompleted(true);
			setFunds(getFunds() + objectives[3].getReward());
		}
		
		//checking objective five
		if (chanceCardCount == 5  && objectives[4].getCompleted() == false)
		{
			objectives[4].setCompleted(true);
			setFunds(getFunds() + objectives[4].getReward());
		}
	}
	
	// Checking for completed sets
	public void checkTileSets()
	{
		if(ownedProperty == null)
		{
			return;
		}
		else
		{
			for (int i = 1; i < 9; i++)
			{
				int count = 0;
				for(int x = 0; x < 20; x++)
				{
					if (ownedProperty[x] != null)
					{
					if (ownedProperty[x].getTileGroup() == i)
						count++;
					}
				}
				if(count == 3)
					objectives[1].setCompleted(true);
			}
		}
	}
	// Checking winner
	public boolean checkWinner()
	{
		if (objectives[0].getCompleted() == true && objectives[1].getCompleted() == true
				&&objectives[2].getCompleted() == true&&objectives[3].getCompleted() == true
				&&objectives[4].getCompleted() == true)
			return true;
		else
			return false;
	}
}
