package tile;

public class ObjectiveCard{
//variables 
	private boolean completed = false;
	private double reward;
	
	//setters
	
	public void setReward(double reward)
	{
		this.reward = reward;
	}
	
	public void setCompleted(boolean completed)
	{
		this.completed = completed;
	}
	
	//getters 
	
	public double getReward()
	{
		return this.reward;
	}
	
	public boolean getCompleted()
	{
		return this.completed;
	}
}
