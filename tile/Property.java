package tile;
import player.Player;

public class Property extends Tile
{
	// Variables
	private String name;
	private Player owner;
	private double price;
	private double penalty;
	private int groupNum;
	
	// Empty Constructor
	public Property() {
		this.name = null;
		this.owner = null;
		this.price = 0;
		this.penalty = 0;
		this.groupNum = 0;
	}
	
	// Parameterised Constructor
	public Property(String name, Player owner, double price, double penalty, int groupNum) {
		this.name = name;
		this.owner = owner;
		this.price = price;
		this.penalty = penalty;
		this.groupNum = groupNum;
	}
	
	// Methods 
	// Getters 
	public String getName()
	{
		return this.name;
	}
	
	public Player getOwner()
	{
		return this.owner;
	}
	
	public double getPrice() 
	{
		return this.price;
	}
	
	public double getPenalty()
	{
		return this.penalty;
	}
	
	public int getGroupNum()
	{
		return this.groupNum;
	}
	// Setters 
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public void setPenalty(double penalty)
	{
		this.penalty = penalty;
	}
	
	public void setGroupNum(int groupNum)
	{
		this.groupNum = groupNum;
	}
	
	
	// Get Property Details method
	public String getDetails()
	{
		if (this.getOwner()!=null) {
			return ("Name: " + this.getName() + "\nOwner: " + this.getOwner().getUsername() + "\nPrice: "
					+ this.getPrice()) + "\nPenalty: " + this.getPenalty();
		}
		else {
			return ("Name: " + this.getName() + "\nOwner: NULL \nPrice: "
					+ this.getPrice()) + "\nPenalty: " + this.getPenalty();
		}
	}
	// Invest method
	public void investTile(Player investor)
	{
		this.owner = investor;
		investor.setFunds(investor.getFunds() - price);
	}
}
