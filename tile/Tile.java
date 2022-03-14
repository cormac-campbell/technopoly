package tile;

public class Tile 
{
//variables 
	private int tilePosition;
	private int tileGroup;
	private String name;
	
	//Empty Constructor
	public Tile() {
		
	}
	
	public Tile(String name) {
		this.name = name;
	}
	
	
	//getters and setters
	public void setTilePosition(int tilePosition)
	{
		this.tilePosition = tilePosition;
	}
	
	public int getTilePosition()
	{
		return this.tilePosition;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	//zero if not a property
	public void setTileGroup(int tileGroup)
	{
		this.tileGroup = tileGroup;
	}
	
	public int getTileGroup()
	{
		return this.tileGroup;
	}
	
}
