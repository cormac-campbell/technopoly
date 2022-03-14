package game;

import player.Player;
import tile.ChanceCard;
import tile.Tile;
import tile.Property;
import tile.PassGo;
import java.util.Scanner;
import java.util.Random;

public class Game {
	// Global Variables
    private Scanner scanner = new Scanner(System.in);
    
    // Class Attributes
	private Player[] players; 
	private Object[] board = new Object[36];
	
	
	public void initBoard() {
		// Need prices and penalties
		board[0] = new Tile("GO");
		board[1] = new Property("JBS",null,0,0,1);
		board[2] = new ChanceCard();
		board[3] = new Property("Nestle",null,0,0,1);
		board[4] = new Property("Cargill",null,0,0,1);
		board[5] = new Property("Taxis",null,0,0,0);
		board[6] = new Property("Nandos",null,0,0,2);
		board[7] = new Property("KFC",null,0,0,2);
		board[8] = new Property("McDonalds",null,0,0,2);
		board[9] = new Tile(); //UNDEFINED CORNER TILE
		board[10] = new Property("Emerson",null,0,0,3);
		board[11] = new Property("Itachi",null,0,0,3);
		board[12] = new Property("Siemens",null,0,0,3);
		board[13] = new Property("Buses",null,0,0,0);
		board[14] = new Property("VW",null,0,0,4);
		board[15] = new Property("Morcoded",null,0,0,4);
		board[16] = new Property("Aldi",null,0,0,4);
		board[17] = new ChanceCard();
		board[18] = new Tile(); //UNDEFINED CORNER TILE
		board[19] = new Property("Dankse",null,0,0,5);
		board[20] = new Property("AIB",null,0,0,5);
		board[21] = new ChanceCard();
		board[22] = new Property("NatWest",null,0,0,5);
		board[23] = new Property("Harbours",null,0,0,0);
		board[24] = new Property("KPMG",null,0,0,6);
		board[25] = new Property("Deloitte",null,0,0,6);
		board[26] = new Property("PWC",null,0,0,6);
		board[27] = new Tile(); //UNDEFINED CORNER TILE
		board[28] = new Property("Tik Tok",null,0,0,7);
		board[29] = new Property("Youtube",null,0,0,7);
		board[30] = new ChanceCard();
		board[31] = new Property("Netflix",null,0,0,7);
		board[32] = new Property("Airports",null,0,0,0);
		board[33] = new Property("Microsoft",null,0,0,8);
		board[34] = new Property("Samsung",null,0,0,8);
		board[35] = new Property("Apple",null,0,0,8);
		
	}
	
	
	public void resetGame() {
		// Reset Game Code
		this.players = null;
	}

	
	public int rollDice() {
		int dice = 0;
		// Dice Roll Code
        dice = (int)(Math.random()*6+1);
        if(dice == 1) {
            System.out.println(" ------- ");
            System.out.println("|       |");
            System.out.println("|   o   |");
            System.out.println("|       |");
            System.out.println(" ------- ");
        }
        else if(dice == 2) {
            System.out.println(" ------- ");
            System.out.println("|     o |");
            System.out.println("|       |");
            System.out.println("|  o    |");
            System.out.println(" ------- ");
        }
        else if(dice == 3) {
            System.out.println(" ------- ");
            System.out.println("|     o |");
            System.out.println("|   o   |");
            System.out.println("| o     |");
            System.out.println(" ------- ");
        }
        else if(dice == 4) {
            System.out.println(" ------- ");
            System.out.println("| o   o |");
            System.out.println("|       |");
            System.out.println("| o   o |");
            System.out.println(" ------- ");
        }
        else if(dice == 5) {
            System.out.println(" ------- ");
            System.out.println("| o   o |");
            System.out.println("|   o   |");
            System.out.println("| o   o |");
            System.out.println(" ------- ");
        }
        else if(dice == 6) {
            System.out.println(" ------- ");
            System.out.println("| o   o |");
            System.out.println("| o   o |");
            System.out.println("| o   o |");
            System.out.println(" ------- ");
        }
		
		return dice;
	}
	
	public void registerPlayers(){
		// Register Players Code
		// User Inputs Number of Players
		System.out.println("Enter the Number of Players(2-5):");// add while loop and check for player amount
		byte noOfPlayers = scanner.nextByte(); // need error handling
		scanner.nextLine();
		
		//Create newPlayers array
		Player[] newPlayers = new Player[5];
		
		// Register each player to newPlayers
		for(int i=0;i<noOfPlayers;i++) {
			Player newPlayer = new Player();
			System.out.println("Enter Player "+ (i+1) +"'s Username: ");
			String pUsername= scanner.nextLine();
			newPlayer.setUsername(pUsername);
			newPlayers[i] = newPlayer;
		}
		
		// Set players array to newPlayers
		players = newPlayers;
			
		
	}
	public Player[] createPlayOrder() {
	    Player[] order =players;  
		Random rand = new Random();
		for (int i = order.length-1; i > 0; i--)
	    {
	      int index = rand.nextInt(i + 1);
	      // Simple swap
	      Player a = order[index];
	      order[index] = order[i];
	      order[i] = a;
	    }
		players = order;
		return order;
	}
	
	public void displayPlayerOptions(Player player){
		// Display Player Options Code
		boolean valid = false;
			while (valid ==false) {
				System.out.println("Please choose an option:\n  1) Display Current Funds\n  2) Display Owned Property\n  3) Display Free Property\n  4) Roll Dice to Move");
				// Should Sell Property be an option?? - n
				
				// Parse option chose
				byte answer = scanner.nextByte(); // need error handling
				switch(answer) {
				case(1):
					valid =true;
					displayPlayerFunds(player);
					displayPlayerOptions(player);
				case(2):
					valid =true;
					displayOwnedProperty(player);
					displayPlayerOptions(player);
				case(3):
					valid =true;
					displayUnboughtProperty(player);
					displayPlayerOptions(player);
				case(4):
					valid =true;
					movePlayer(player);
				default:
					System.out.println("Error: Invalid Input");				
			}
		}
	}


	
	public void displayPlayerFunds(Player player){
		System.out.println(player.getUsername()+ " Funds: "+player.getFunds());
	}
	
	public void displayOwnedProperty(Player player){
		System.out.println(player.getUsername() + " Property: ");
		for (Property p:player.getOwnedProperty()) {
			System.out.println(" - " +p.getName());
		}
	}
	
	
	public void displayUnboughtProperty(Player player){
		Property p=null;
		System.out.println("Unclaimed Property: ");
		for (Object t:board) {
			if(t.getClass()==p.getClass()) {
				t=(Property)t;
				if(((Property)t).getOwner()==null)
					System.out.println(" - " +((Property)t).getName());
			} 
		}
	}
	
	
	public void movePlayer(Player player){
		// Display Player Options Code
		int move = this.rollDice();
		System.out.println("Player "+player.getUsername()+" moves "+move+" tiles.");
		// Move player on board
	}

	
	public void investTile(Player player, Property tile) {
		// Invest Tile Code
		// Check for existing owner happens in land on tile
		if(tile.getOwner()!=null) {
			if (player.getFunds()>tile.getPrice()) {
				boolean valid=false;
				while(valid==false){
					System.out.println("Are you sure you want to buy this property: " + tile.getName()+"? (Y/N)");
					String answer = scanner.nextLine();
					if (answer.toUpperCase()=="Y") {
						tile.investTile(player);
						tile.setOwner(player);
						player.addOwnedTile(tile);
						valid=true;
					}
					else if (answer.toUpperCase()=="N") {
						System.out.println("Sale called off!");
						auctionTile(tile,player);
						valid=true;
						
					}
					else {
						System.out.println("Error: Please enter Y or N.");
					}
				}
			}
			else {
				System.out.println("Insufficient funds to purchase property.\nCurrent Funds: "+player.getFunds()+"\nProperty Price: "+tile.getPrice());
				auctionTile(tile,player);
			}
		}
		else {
			// Property is owned
			System.out.println("Property owned by "+tile.getOwner()+".");	
		}
		// Ask if player wants to take any more actions this turn
		boolean valid=false;
		while(valid==false){
			System.out.println("Do you want to take any more actions this turn?(Y/N)");
			String answer = scanner.nextLine();
			if (answer.toUpperCase()=="Y") {
				displayPlayerOptions(player);
				valid=true;
			}
			else if (answer.toUpperCase()=="N") {
				valid=true;
			}
			else {
				System.out.println("Error: Please enter Y or N.");
			}
		}
	}


	
	public void sellProperty(Player seller)
	{
		// Sell Property Code
		//step one: display user owned property's 
		displayOwnedProperty(seller);
		//Step two: choose property to sell
		boolean pOwned = false;
		String pName;
		do
		{
		System.out.print("Which Property would you like to sell?(type N to exit) \n");
		pName = scanner.nextLine();
		//exiting method
		if (pName == "N")
			return;
		//checking if input is correct
		if (seller.getOwnedProperty() != null)
		{
			for(Property p:seller.getOwnedProperty())
				{
					if(p.getName() == pName)
					{
						pOwned = true;
					}
				}
		}
		//telling them to input again
		if(pOwned == false)
		{
			System.out.print("Incorrect input try again. \n");
		}
		
		} while (pOwned == false);
		//step three:display players
		System.out.print("Choose Which Player you are looking to sell to. \n");
		for(Player p: players)
		{
			if(p.getUsername() != seller.getUsername())
				System.out.print(p.getUsername());
		}
		String uName;
		boolean uCheck = false;
		//checking input
		do
		{
			System.out.print("Enter Username: ");
			uName = scanner.next();
			for(Player p: players)
			{
				if(p.getUsername() == uName)
					uCheck = true;
			}
			//telling them to try again
			if(uCheck == false)
				System.out.print("Wrong entry try again. spell username correctly");
		} while(uCheck = false);
		//step four choose which price to sell it to the player
		double price;
		System.out.print("Enter price offer(0.00)");
		price = scanner.nextDouble();
		//loop until price is agreed or bid is off 
		boolean agreed = false;
		boolean rejected = false;
		boolean answerC = false;
		String answer;
		//loop the negotiation process 
		do
		{
			System.out.print("The offer is-�" + price + "\n do you accept type Y \n counter offer type C \n Reject Offer type R");
			answerC = false;
			do
			{
				//giving the negotiation options
			 answer = scanner.nextLine();
			if (answer == "Y")
			{
				answerC = true;
				agreed = true;
			}
			else if(answer == "C")
			{
				System.out.print("Enter your counter offer (0.00): ");
				price = scanner.nextDouble();
				answerC = true;
			}
			else if(answer == "R")
			{
				rejected = true;
				System.out.print("Offer rejected.");
			}
			else
			{
				System.out.print("enter a correct value(Y/C/R).");
			}
			
			} while (answerC == false);

		} while(agreed == false && rejected == false);
		
		if (agreed == true)
		{
			System.out.print("Sale Agreed: " + seller.getUsername() + " loses " + pName + " " + uName + " gains" + pName + "for �" + price);
			//removing property from seller property array 
			Property[] replaceP = new Property[20];
			Property addP = new Property();
			int count = 0;
			for (Property p: seller.getOwnedProperty())
			{
				if (p.getName() != pName)
				{
					replaceP[count] = p;
				}
				else //this is used to get the tile so it can be added to the other players class
				{
					addP = p;
				}
			}
			seller.setOwnedProperty(replaceP);
			//adding owned property to buyer
			for(Player p: players) //have to do this since don't have buyer as a parameter
			{
				if(p.getUsername() == uName)
				{
					p.addOwnedTile(addP);
				}
			}
		}
		else
		{
			System.out.print("negotiations unsuccessful.");
		}
	}
	
	public void fileBankruptcy(Player player)
	{
		// File Bankruptcy Code
		System.out.print("Are you sure you want to declare bankruptcy(Yes/No)");
		String answer = "";
		boolean answerC = false;
		do
		{
			if(answer == "Yes")
			{
				for(Property p: player.getOwnedProperty())
				{
					auctionTile(p, player);
				}
				player.setBankrupt(true);
			}
			else if ( answer == "No")
			{
				return;
			}
			else
			{
				System.out.print("incorrect input try again(Yes/No)");
			}
		} while (answerC == false);
		
	}
	
	public void auctionTile(Property tile, Player auctioneer) {
		// Auction Tile Code
		double bid = tile.getPrice(); // Current Winning Bid Amount
		Player winningBid = null; // Current Winning Bidder
		Player currentPlayer=auctioneer; // Player currently bidding
		Player[] playersIn = players; // Players still bidding
		// Print property details
		System.out.println("Currently Auctioning Property:\n"+tile.getDetails());
		boolean valid=false;
		boolean haveWinner=false;
		// Get auctioneer's index in players array to see order
		int index = 0;
		for(Player p:players) {
			if(p==currentPlayer)
				break;
			index++;
		}
		while(!haveWinner) {
			System.out.println("Next Player to Bid: "+players[index]);
			while(!valid){
				System.out.println("Do you want to bid or reject?(Bid/Reject)");
				String answer = scanner.nextLine();
				if (answer.toUpperCase()=="BID") {
					System.out.println("\nMinimum Bid: "+bid+5+"\nEnter bid: ");
					double offer = scanner.nextDouble();
					scanner.nextLine();
					if (offer>bid+5 && currentPlayer.getFunds()>=offer) {
						winningBid=currentPlayer;// currentPlayer is winningBid
						bid=offer;
					}
					else {
						System.out.println("Bid unsuccessful! Next Player!");
						// Take current player out of playersIn
						Player[] placeholder = new Player[5];
						int i=0;
						for(Player p:playersIn) {
							if(p!=currentPlayer) {
								placeholder[i]=p;
								i++;
							}
						}
						playersIn=placeholder;
					}
					valid=true;
				}
				else if (answer.toUpperCase()=="REJECT") {
					System.out.println("Bid unsuccessful! Next Player!");
					valid=true;
					// Take current player out of playersIn
					Player[] placeholder = new Player[5];
					int i=0;
					for(Player p:playersIn) {
						if(p!=currentPlayer) {
							placeholder[i]=p;
							i++;
						}
					}
					playersIn=placeholder;
				}
				else {
					System.out.println("Error: Please enter Bid or Reject.");
				}
			}	
			int count=0;
			for(Player p:playersIn){
				if(p!=null)
					count++;
			}
			if(count==1)
				haveWinner=true;
			// Go to next player after auctioneer in play order
			if(!haveWinner) {
				do{
					if (index != 4) {
						index = 0;
					} else {
						index++;
					} 
				}while (playersIn[index]==null); //find next not null player to bid
			}
			// Next player bids or rejects
		}
		
		// Highest bidder wins property 
		tile.investTile(winningBid);
		winningBid.addOwnedTile(tile);
		
	}
	
	public void passGo(Player player) {
		// Pass Go Code
		PassGo pg = new PassGo();
		pg.passGo(player); // Not sure if this code works as player is not passed by reference
		player.setPassGoCount(player.getPassGoCount() + 1);
	}
	

	
	
	
	/**
	 * Chance card code
	 * 
	 * NOTE: Keep chance card string length to 46 (Include blank spaces in required)
	 * @param player
	 */
	public void pickUpChanceCard(Player player) {
		// Pick Up Chance Card Code
		Random rand = new Random();
		
		//Adjust as chance cards grow
		int numberOfChanceCards = 10;
		
		ChanceCard card = new ChanceCard();
		
		//Text for Chance Cards
		String[] cardText = {"(Card: 0) You have accidentally deleted BitCoin from an old USB, Loose 10% of your funds.", 
				"", 
				"",
				""}; //FILL OUT
		
		int drawCard = rand.nextInt(numberOfChanceCards - 1);
		 
		
		//Set Card Text
		card.setChance(cardText[drawCard]);
		
		//Run code for chance card
		switch(drawCard) {
			case(0):
				//reduce funds by 10%
				double funds = player.getFunds();
				player.setFunds(funds * 0.9);
			
			case(1):
				
			case(2):
				
			case(3):
				
			case(4):
				
			case(5):
				
			case(6):
				
			case(7):
				
			case(8):
				
			case(9):
				
			case(10):
				
			default:
				//Code	
		}
		
		//Prints chance Card
		printChanceCard(card);
		player.setChanceCardCount(player.getChanceCardCount() + 1);
		
	}
	
	/**
	 * Prints out chance card info
	 * @param card
	 */
	public void printChanceCard(ChanceCard card) {
		System.out.println("+----------------------------------------------+");
		System.out.println("|   			  Chance Card				   |");
		System.out.println("+----------------------------------------------+");
		System.out.println(card.getChance());
		System.out.println("+----------------------------------------------+");
	}
	

	
	public void landOnOwnedProperty(Player lander,Player owner, Property property) {
		// Land On Owned Property Code
		if(lander.getFunds()<property.getPenalty()) {
			// Insufficient Funds
			// Ask if they want to sell property to afford penalty or if they want to file bankruptcy
			boolean valid=false;
			while(valid==false){
				System.out.println("Insufficient Funds. Cannot afford penalty."
						+ "\nTo afford penalty, you can sell property, enter S."
						+ "\nOtherwise to file bankruptcy, enter B:");
				String answer = scanner.nextLine();
				if (answer.toUpperCase()=="S") {
					sellProperty(lander);
					// valid=true;
					// If lander has sufficient funds continue, else ask again.
				}
				else if (answer.toUpperCase()=="B") {
					fileBankruptcy(lander);
					valid=true;
				}
				else {
					System.out.println("Error: Please enter S or B.");
				}
			}
			
		}
		else {					
			lander.setFunds(lander.getFunds()-property.getPenalty());
			owner.setFunds(owner.getFunds()+property.getPenalty());
			owner.setAmountCollected(owner.getAmountCollected() + property.getPenalty());
		}
		boolean valid=false;
		while(valid==false){
			System.out.println("Do you want to take any more actions this turn?(Y/N)");
			String answer = scanner.nextLine();
			if (answer.toUpperCase()=="Y") {
				displayPlayerOptions(lander);
				valid=true;
			}
			else if (answer.toUpperCase()=="N") {
				valid=true;
			}
			else {
				System.out.println("Error: Please enter Y or N.");
			}
		}
	}	

	
	public void landOnUnownedProperty(Player lander,Property property) {
		// Land On Unbought Property Code
		// Ask if they want to invest
		boolean valid=false;
		while(valid==false){
			System.out.println("Do you want to invest in this property?(Y/N)");
			String answer = scanner.nextLine();
			if (answer.toUpperCase()=="Y") {
				investTile(lander,property);
				valid=true;
			}
			else if (answer.toUpperCase()=="N") {
				auctionTile(property,lander);
				valid=true;
			}
			else {
				System.out.println("Error: Please enter Y or N.");
			}
		}
		valid=false;
		while(valid==false){
			System.out.println("Do you want to take any more actions this turn?(Y/N)");
			String answer = scanner.nextLine();
			if (answer.toUpperCase()=="Y") {
				displayPlayerOptions(lander);
				valid=true;
			}
			else if (answer.toUpperCase()=="N") {
				valid=true;
			}
			else {
				System.out.println("Error: Please enter Y or N.");
			}
		}
		
	}

	
	
	
	/**
	 * Printing the Board
	 */
	public void printBoard() {
		

		
		/*_____         _                             _       
		/__   \___  ___| |__  _ __   ___  _ __   ___ | |_   _ 
		  / /\/ _ \/ __| '_ \| '_ \ / _ \| '_ \ / _ \| | | | |
		 / / |  __/ (__| | | | | | | (_) | |_) | (_) | | |_| |
		 \/   \___|\___|_| |_|_| |_|\___/| .__/ \___/|_|\__, |
		                                 |_|            |___/ 
		*/
		
		//TO DO: UPDATE PRICES AND ADD CHARACTER PLACES
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("|1         |2         |3         |4         |5         |6         |7         |8         |9         |10        |\n");
		System.out.print("|    GO    |    JBS   |  Chance  |  Nestle  | Cargill  |  Taxis   |  Nando s  |   KFC    |McDonalds |          |\n");
		System.out.print("|          | �------- |   Card   |          |          |          |          |          |          |          |\n");
		System.out.print("|          | OW:----- |          |          |          |          |          |          |          |          |\n");
		System.out.print("|          |          |          |          |          |          |          |          |          |          |\n");
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("|36        |                                                                                       |11        |\n");
		System.out.print("|  Apple   |                                                                                       | Emerson  |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|35        |                                                                                       |12        |\n");
		System.out.print("| Samsung  |                                                                                       |  Hitachi |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|34        |                                                                                       |13        |\n");
		System.out.print("|Microsoft |                                                                                       | Siemens  |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|33        |                                                                                       |14        |\n");
		System.out.print("| Airports |                                                                                       |  Buses   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|32        |                                                                                       |15        |\n");
		System.out.print("| Netflix  |                                                                                       |    VW    |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|31        |                                                                                       |16        |\n");
		System.out.print("|  Chance  |                                                                                       | Morcoded |\n");
		System.out.print("|   Card   |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|30        |                                                                                       |17        |\n");
		System.out.print("| Youtube  |                                                                                       |   Aldi   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|29        |                                                                                       |18        |\n");
		System.out.print("| Tik Tok  |                                                                                       |  Chance  |\n");
		System.out.print("|          |                                                                                       |   Card   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("|28        |27        |26        |25        |24        |23        |22        |21        |20        |19        |\n");
		System.out.print("|          |   PWC    | Deloitte |   KPMG   | Harbours |  Natwest |  Chance  |   AIB    |  Dankse  |          |\n");
		System.out.print("|          |          |          |          |          |          |   Card   |          |          |          |\n");
		System.out.print("|          |          |          |          |          |          |          |          |          |          |\n");
		System.out.print("|          |          |          |          |          |          |          |          |          |          |\n");
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("KEY: OW = Owner | � = Price\n");	
	}
	
	/**
	 * Prints tile information for the player
	 * @param player
	 */
	public void printPlayerLocations(Player player) {
		//Checks Object type for board
		
		//Tiles of property
		if(board[player.getCurrentPositionInt()] instanceof tile.Property) {
			System.out.println("+----------------------------------------------+");
			System.out.println(((Property) board[player.getCurrentPositionInt()]).getName());
			System.out.println("|   			     		       |");
			if(((Property) board[player.getCurrentPositionInt()]).getOwner() == null) {
				System.out.println("|Unowned");
				System.out.println("|   			     		       |");
				System.out.println("|Penalty: " + ((Property) board[player.getCurrentPositionInt()]).getPrice());
			}
			else {
				System.out.println("|Owner: " + ((Property) board[player.getCurrentPositionInt()]).getOwner());
				System.out.println("|   			     		       |");
				System.out.println("|Penalty: " + ((Property) board[player.getCurrentPositionInt()]).getPenalty());
			}
			System.out.println("|   			     		       |");
			System.out.println("|Tile Number: " + (player.getCurrentPositionInt() + 1));
			System.out.println("+----------------------------------------------+");
		}	
		else if(board[player.getCurrentPositionInt()] instanceof tile.Tile) {
			System.out.println("+----------------------------------------------+");
			System.out.println("|" + ((Tile) board[player.getCurrentPositionInt()]).getName());
			System.out.println("|   			     		       |");
			System.out.println("|" + player.getCurrentPositionInt());
			System.out.println("+----------------------------------------------+");
		}
		else if(board[player.getCurrentPositionInt()] instanceof tile.ChanceCard) {
			System.out.println("+----------------------------------------------+");
			System.out.println("|" + ((ChanceCard) board[player.getCurrentPositionInt()]).getName());
			System.out.println("|   			     		       |");
			System.out.println("|" + ((ChanceCard) board[player.getCurrentPositionInt()]).getChance());
			System.out.println("|   			     		       |");
			System.out.println("|" + player.getCurrentPositionInt());
			System.out.println("|   			     		       |");
		}
		else if(board[player.getCurrentPositionInt()] instanceof tile.PassGo) {
			System.out.println("+----------------------------------------------+");
			System.out.println(((PassGo) board[player.getCurrentPositionInt()]).getName());
			System.out.println("|   			     		       |");
			System.out.println(player.getCurrentPositionInt());
			System.out.println("+----------------------------------------------+");
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		Scanner scanner = new Scanner(System.in);
		
		// Registering Players
		
		game.initBoard();
		
		
		game.registerPlayers();
		game.createPlayOrder();
		System.out.println("Users Registered: ");
		for(Player p:game.players) {
			if (p != null)
			{
			System.out.println("\nPlayer: " + p.getUsername());	
			}
		}
		
		int numPlayers = game.players.length;
		
		// Player p= new Player();
		// displayPlayerOptions(p);
		
		
		
		//Game Loop
		int turnCount = 1;
		
		boolean winner = false; //Checks if game has winner for main loop
		
		
		while(!winner) { //Main loop until winner
			for(int i = 0; i < numPlayers; i++) { //Turn loop
				
				//Prints turn information and player (Print board + Player Information)
				game.printBoard();
				System.out.println("\nTurn: " + turnCount); //Prints turn count at start of turn
				System.out.println("Player: " + game.players[i].getUsername());
				
				
				//Player rolls dice (x2)
				System.out.println("Enter anything to roll dice!");
				scanner.nextLine();
				try {
					System.in.read();
				} catch (Exception e) {
				}
				int diceRoll = game.rollDice() + game.rollDice();
				System.out.println("You have rolled a: " + diceRoll);
				
				
				//Moves player
				
				//USED FOR TESTING
				int playerPosition = 0;
				
				try {
					playerPosition = game.players[i].getCurrentPositionInt();//Gets player position as integer
				} catch (Exception e) {
					playerPosition = 1;
				}

				
				//moves player x times and checks if they pass GO
				for(int moves = 0; moves < diceRoll; moves++) { 
					if((playerPosition + 1) == 36) {
						playerPosition = 1;
						
						//Run Pass GO code
						game.passGo(game.players[i]);
						
					}
					else {
						playerPosition++;
					}
				}
				//sets players new position
				game.players[i].setCurrentPositionInt(playerPosition - 1);
				
				
				//Presents options based on tile
				game.printPlayerLocations(game.players[i]);
				
				//Ends turn + Checks if winner
				turnCount++;
				game.players[i].checkObjectives();
			}
		}
	}
}