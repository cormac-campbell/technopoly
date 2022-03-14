package tile;
import player.Player;

public class PassGo extends Tile 
{
	// variables
	private double reward = 200.00;
	
	// methods
	public void passGo(Player cPlayer)
	{
		cPlayer.setFunds(cPlayer.getFunds() + reward);
	}
}
