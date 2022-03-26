package tile;

public class Tile 
{
	// Variables 
	private int tilePosition;
	private int tileGroup;
	private String name;
	
	// Empty Constructor
	public Tile() {
		
	}
	
	// Parameterised Constructor
	public Tile(String name) {
		this.name = name;
	}
	
	
	// Getters and Setters
	public int getTilePosition()
	{
		return this.tilePosition;
	}	
		
	public String getName() {
		return this.name;
	}

	public int getTileGroup()
	{
		return this.tileGroup;
	}
	
	public void setTilePosition(int tilePosition)
	{
		this.tilePosition = tilePosition;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Zero if not a property
	public void setTileGroup(int tileGroup)
	{
		this.tileGroup = tileGroup;
	}	
}
