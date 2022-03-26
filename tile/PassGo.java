package tile;
import player.Player;

public class PassGo extends Tile 
{
	// Variables
	private double reward = 200.00;
	
	// Methods
	public void passGo(Player cPlayer)
	{
		cPlayer.setFunds(cPlayer.getFunds() + reward);
	}
}
