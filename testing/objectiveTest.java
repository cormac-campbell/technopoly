package testing;
import static org.junit.Assert.*;
import org.junit.Test;
import game.Game;
import player.Player;
import tile.Tile;
import tile.Property;
public class objectiveTest {
	static private int numOfTiles = 36;
	static Property[] ps = new Property[numOfTiles];
	@Test
	public void test() {
		// TODO Auto-generated method stub
				tileCreation();
		
				 //testing objective methods
				 Player p1 = new Player();
				 
				 p1.setUsername("cc");
				 p1.setObjectives();
				 //no objective complete
				 p1.setAmountCollected(0);
				 p1.setCurrentPosition(ps[0]);
				 p1.setPassGoCount(0);
				 p1.setFunds(1000.00);
				 p1.checkObjectives();
				 assertEquals(false,p1.checkWinner());
				 System.out.println(p1.getObjectives() + "\n");
				 //first objective complete
				 p1.setPassGoCount(5);
				 p1.checkObjectives();
				 System.out.println(p1.getObjectives() + "\n");
				 assertEquals(false,p1.checkWinner());
				 //second objective complete
				  p1.addOwnedTile(ps[35]);
				 p1.addOwnedTile(ps[34]);
				 p1.addOwnedTile(ps[33]);
				 p1.checkObjectives();
				 System.out.println(p1.getObjectives() + "\n");
				 assertEquals(false,p1.checkWinner());
				 //third objective complete
				 p1.setFunds(1500.00);
				 p1.checkObjectives();
				 System.out.println(p1.getObjectives() + "\n");
				 assertEquals(false,p1.checkWinner());
				 //fourth objective complete
				 p1.setAmountCollected(505.15);
				 p1.checkObjectives();
				 System.out.println(p1.getObjectives() + "\n");
				 assertEquals(false,p1.checkWinner());
				 //fifth objective being complete
				 p1.setChanceCardCount(5);
				 p1.checkObjectives();
				 System.out.println(p1.getObjectives() + "\n");	
				 if(p1.checkWinner() == true)
					 System.out.println("Winner");
				 else
					 System.out.println("Not won yet");
				 assertEquals(true,p1.checkWinner());
	}
	
	public static void tileCreation()
	{
		//setting tiles position
		
		for (int i = 0; i < 36; i++)
		{
			Property t = new Property();
			t.setTilePosition(i + 1);
			
			if(i == 1 || i == 3 || i == 4)
				t.setTileGroup(1);
			else if(i == 6 || i == 7 || i == 8)
				t.setTileGroup(2);
			else if(i == 10 || i == 11 || i == 12)
				t.setTileGroup(3);
			else if(i == 14 || i == 15 || i == 17)
				t.setTileGroup(4);
			else if(i == 19 || i == 20 || i == 22)
				t.setTileGroup(5);
			else if(i == 24 || i == 25 || i == 26)
				t.setTileGroup(6);
			else if(i == 28 || i == 29 || i == 31)
				t.setTileGroup(7);
			else if(i == 33 || i == 34 || i == 35)
				t.setTileGroup(8);
			else
				t.setTileGroup(0);
			
			ps[i] = t;
		}
}
}
