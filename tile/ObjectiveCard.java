package tile;

public class ObjectiveCard{
	// Variables 
	private boolean completed = false;
	private double reward;
	
	// Getters 
	public boolean getCompleted()
	{
		return this.completed;
	}
	
	public double getReward()
	{
		return this.reward;
	}
	
	// Setters
	public void setCompleted(boolean completed)
	{
		this.completed = completed;
	}

	public void setReward(double reward)
	{
		this.reward = reward;
	}
}
