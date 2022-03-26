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
		board[1] = new Property("JBS",null,60,20,1);
		board[2] = new ChanceCard();
		board[3] = new Property("Nestle",null,70,30,1);
		board[4] = new Property("Cargill",null,75,35,1);
		board[5] = new Property("Taxis",null,150,75,0);
		board[6] = new Property("Nandos",null,100,45,2);
		board[7] = new Property("KFC",null,125,55,2);
		board[8] = new Property("McDonalds",null,130,60,2);
		board[9] = new Tile(); //UNDEFINED CORNER TILE
		board[10] = new Property("Emerson",null,150,70,3);
		board[11] = new Property("Itachi",null,150,70,3);
		board[12] = new Property("Siemens",null,155,75,3);
		board[13] = new Property("Buses",null,150,75,0);
		board[14] = new Property("VW",null,165,85,4);
		board[15] = new Property("Morcoded",null,175,95,4);
		board[16] = new Property("Aldi",null,175,95,4);
		board[17] = new ChanceCard();
		board[18] = new Tile(); //UNDEFINED CORNER TILE
		board[19] = new Property("Dankse",null,175,100,5);
		board[20] = new Property("AIB",null,180,110,5);
		board[21] = new ChanceCard();
		board[22] = new Property("NatWest",null,180,110,5);
		board[23] = new Property("Harbours",null,150,75,0);
		board[24] = new Property("KPMG",null,185,115,6);
		board[25] = new Property("Deloitte",null,190,120,6);
		board[26] = new Property("PWC",null,195,125,6);
		board[27] = new Tile(); //UNDEFINED CORNER TILE
		board[28] = new Property("Tik Tok",null,200,135,7);
		board[29] = new Property("Youtube",null,200,135,7);
		board[30] = new ChanceCard();
		board[31] = new Property("Netflix",null,210,150,7);
		board[32] = new Property("Airports",null,150,75,0);
		board[33] = new Property("Microsoft",null,210,150,8);
		board[34] = new Property("Samsung",null,250,175,8);
		board[35] = new Property("Apple",null,250,175,8);
		
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
		System.out.println("Enter the Number of Players(2-5):");
		String noOfPlayers = scanner.nextLine();
		boolean done = false;
		do
		{
			try
			{
			int d = Byte.parseByte(noOfPlayers);
			 if (Byte.parseByte(noOfPlayers) < 2||Byte.parseByte(noOfPlayers)>5) // byte must be larger than 0
			 {
				 done = false;
				 System.out.println("Invalid Number - Type positive number in(2-5).");
					System.out.println("****************************************");
					System.out.print("Enter Number of players(2-5): ");
					noOfPlayers = scanner.nextLine();
			 }
			 else
			 {
			 done = true;
			 }
			}
			catch (Exception ex) // catch if the entered value is not a integer 
			{
				done = false;
				 System.out.println("Invalid Number - Type positive number in(2-5).");
					System.out.println("****************************************");
					System.out.print("Enter Number of players(2-5): ");
					noOfPlayers = scanner.nextLine();
			}
		} while(done == false);
		
		//Create newPlayers array
		Player[] newPlayers = new Player[5];
		
		// Register each player to newPlayers
		for(int i=0;i<Byte.parseByte(noOfPlayers);i++) {
			Player newPlayer = new Player();
			System.out.println("Enter Player "+ (i+1) +"'s Username: ");
			String pUsername= scanner.nextLine().trim();
			newPlayer.setUsername(pUsername);
			newPlayer.setFunds(500);
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
	
	public void displayPlayerOptions(Player player,boolean hasMoved){
		boolean inputValid=true;
		do {
			// Parse option chose
			try {		
				// Display Player Options Code
				boolean valid = false;
				while (valid ==false) {
					if (!hasMoved)
						System.out.println("Please choose an option:\n  1) Display Current Funds\n  2) Display Owned Property\n  3) Display Free Property\n  4) Sell Property\n  5) Check Objectives\n  6) Roll Dice to Move");
					else
						System.out.println("Please choose an option:\n  1) Display Current Funds\n  2) Display Owned Property\n  3) Display Free Property\n  4) Sell Property\n  5) Check Objectives\n  6) End go");
			
					byte answer = scanner.nextByte();
					scanner.nextLine();
					inputValid=true;
					switch (answer) {
					case (1):
						valid = true;
						displayPlayerFunds(player);
						if (!hasMoved)
							displayPlayerOptions(player, false);
						else
							displayPlayerOptions(player, true);
					case (2):
						valid = true;
						displayOwnedProperty(player);
						if (!hasMoved)
							displayPlayerOptions(player, false);
						else
							displayPlayerOptions(player, true);
					case (3):
						valid = true;
						displayUnboughtProperty(player);
						if (!hasMoved)
							displayPlayerOptions(player, false);
						else
							displayPlayerOptions(player, true);
					case (4):
						valid = true;
						if (player.getOwnedProperty() != null)
							sellProperty(player);
						else
							System.out.println("No Property Available to Sell.");
						if (!hasMoved)
							displayPlayerOptions(player, false);
						else
							displayPlayerOptions(player, true);
					case (5):
						valid = true;
						player.checkObjectives();
						System.out.println(player.getObjectives());
						if (!hasMoved)
							displayPlayerOptions(player, false);
						else
							displayPlayerOptions(player, true);
					case (6):
						hasMoved = true;
						return;
					case(7):
						fileBankruptcy(player);
					default:
						System.out.println("Error: Invalid Input");
						}
					}
		} 
		catch (Exception ex) {
			inputValid = false;
			System.out.println("Input Error");
		} 
	} while (!inputValid);
	}


	
	public void displayPlayerFunds(Player player){
		System.out.println(player.getUsername()+ "'s Funds: "+player.getFunds());
	}
	
	public void displayOwnedProperty(Player player){
		System.out.println(player.getUsername() + " Property: ");
		if (player.getOwnedProperty()!=null) {
			for (Property p : player.getOwnedProperty()) {
				if(p!=null)
					System.out.println(" - " + p.getName());
			} 
		}
	}
	
	
	public void displayUnboughtProperty(Player player){
		System.out.println("Unclaimed Property: ");
		for (Object t:board) {
			if(t instanceof tile.Property) {
				t=(Property)t;
				if(((Property)t).getOwner()==null)
					System.out.println(" - " +((Property)t).getName());
			} 
		}
	}
	
	public void investTile(Player player, Property tile) {
		// Invest Tile Code
		// Check for existing owner happens in land on tile
		if(tile.getOwner()==null) {
			if (player.getFunds()>tile.getPrice()) {
				boolean valid=false;
				while(valid==false){
					System.out.println("Are you sure you want to buy this property: \n" + tile.getDetails()+"\n(Y/N)");
					String answer = scanner.next();
					scanner.nextLine();
					if (answer.toUpperCase().trim().equals("Y")) {
						System.out.println(player.getUsername()+" gains "+tile.getName());
						tile.investTile(player);
						tile.setOwner(player);
						player.addOwnedTile(tile);
						valid=true;
					}
					else if (answer.toUpperCase().trim().equals("N")) {
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
			String answer = scanner.next();
			scanner.nextLine();
			if (answer.toUpperCase().trim().equals("Y")) {
				displayPlayerOptions(player,true);
				valid=true;
			}
			else if (answer.toUpperCase().trim().equals("N")) {
				valid=true;
			}
			else {
				System.out.println("Error: Please enter Y or N.");
			}
			
		}
	}


	
	//next method needed changed
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
			if (pName.toUpperCase().equals("N"))
				return;
			//checking if input is correct
			if (seller.getOwnedProperty() != null)
			{
				for(Property p:seller.getOwnedProperty())
				{
					if(p!=null)
					{		
						if(p.getName().toUpperCase().equals(pName.toUpperCase()))
						{
							pOwned = true;
						}
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
		System.out.println("Choose the Player you are looking to sell to:");
		for(Player p: players)
		{
			if(p!=null) {
				if(!p.getUsername().equals(seller.getUsername()))
					System.out.println(p.getUsername());
		
			}
		}
		String uName;
		boolean uCheck = false;
		//checking input
		do
		{
			System.out.print("Enter Username: ");
			uName = scanner.next();
			scanner.nextLine();
			for(Player p: players)
			{
				if (p!=null) {
					if (p.getUsername().toUpperCase().equals(uName.toUpperCase()))
						uCheck = true;
				}
			}
			if(uName.toUpperCase().equals(seller.getUsername().toUpperCase())){
				System.out.println("You cannot sell to yourself.");
				uCheck=false;
			}
			//telling them to try again
			if(uCheck == false)
				System.out.println("Invalid Entry. Try Again.");
		} while(uCheck == false);
		//step four choose which price to sell it to the player
		String price;
		System.out.println("Enter Price Offer(0.00)");
		price = scanner.nextLine();
		boolean done = false;
		do 
			{
			try
			{
				double d = Double.parseDouble(price);
				if(Double.parseDouble(price) <= 0.00)
				{
					done = false;
					 System.out.println("Invalid Number - Type positive double in(0.00).");
						System.out.println("****************************************");
						System.out.print("Enter Price(0.00): ");
						price = scanner.nextLine();
				}
				else
				{
					done = true;
				}
			}
			catch(Exception ex)
			{
				done = false;
				 System.out.println("Invalid Number - Type positive double in(0.00).");
					System.out.println("****************************************");
					System.out.print("Enter Price(0.00): ");
					price = scanner.nextLine();
			}
		}while(done == false);
		//loop until price is agreed or bid is off 
		boolean agreed = false;
		boolean rejected = false;
		boolean answerC = false;
		String answer;
		//loop the negotiation process 
		do
		{
			System.out.println("The offer is - "  + price + "\nTo Accept, Type Y \nTo Counter Offer, Type C \nTo Reject Offer, Type R:");
			answerC = false;
			do
			{
				//giving the negotiation options
			 answer = scanner.nextLine();
			if (answer.toUpperCase().equals("Y"))
			{
				answerC = true;
				agreed = true;
			}
			else if(answer.toUpperCase().equals("C"))
			{
				System.out.println("Enter your Counter Offer (0.00): ");
				price = scanner.nextLine();
			    done = false;
				do 
					{
					try
					{
						double d = Double.parseDouble(price);
						if(Double.parseDouble(price) <= 0.00)
						{
							done = false;
							 System.out.println("Invalid Number - Type positive double in(0.00).");
								System.out.println("****************************************");
								System.out.print("Enter Price(0.00): ");
								price = scanner.nextLine();
						}
						else
						{
							done = true;
						}
					}
					catch(Exception ex)
					{
						done = false;
						 System.out.println("Invalid Number - Type positive double in(0.00).");
							System.out.println("****************************************");
							System.out.print("Enter Price(0.00): ");
							price = scanner.nextLine();
					}
				}while(done == false);
				
				answerC = true;
			}
			else if(answer.toUpperCase().equals("R"))
			{
				rejected = true;
				answerC = true;
				System.out.println("Offer Rejected.");
			}
			else
			{
				System.out.println("Enter a Valid Value(Y/C/R).");
			}
			
			} while (answerC == false);

		} while(agreed == false && rejected == false);
		
		//making player buying a variable
		Player check = new Player();
		for(Player p: players) //have to do this since don't have buyer as a parameter
		{
			if (p!=null) {
				if (p.getUsername().toUpperCase().equals(uName.toUpperCase())) {
					check = p;
				} 
			}
		}
		
		if (agreed == true && check.getFunds() > Double.parseDouble(price))
		{
			System.out.println("Sale Agreed: " + seller.getUsername() + " loses " + pName + ". \n" + uName + " gains " + pName + " for " + price);
			//removing property from seller property array 
			Property[] replaceP = new Property[20];
			Property addP = new Property();
			int count = 0;
			for (Property p: seller.getOwnedProperty())
			{
				if (p!=null) {
					if (!p.getName().toUpperCase().equals(pName.toUpperCase())) {
						replaceP[count] = p;
					} else //this is used to get the tile so it can be added to the other players class
					{
						addP = p;
					} 
				}
				count++;
			}
			seller.setOwnedProperty(replaceP);
			//adding money to player
			seller.setFunds(seller.getFunds() + Double.parseDouble(price));
			seller.setAmountCollected(seller.getAmountCollected()+Double.parseDouble(price));
			//adding owned property to buyer
			for(Player p: players) //have to do this since don't have buyer as a parameter
			{
				if (p!=null) {
					if (p.getUsername().toUpperCase().equals(uName.toUpperCase())) {
						p.addOwnedTile(addP);
						//removing player money
						p.setFunds(p.getFunds() - Double.parseDouble(price));
						
					} 
				}
			}
		}
		else if (check.getFunds() < Double.parseDouble(price))
			System.out.println("Deal off Not enough available funds.");
		else
		{
			System.out.println("Negotiations Unsuccessful.");
		}
	}

	
	public void fileBankruptcy(Player player)
	{
	
		// File Bankruptcy Code
		System.out.println("Are you sure you want to declare bankruptcy(Y/N)");
		String answer = "";
		boolean answerC = false;
		do
		{ 
			answer = scanner.next();
			if(answer.toUpperCase().trim().equals("Y"))
			{
				if (player.getOwnedProperty()!=null) 
				{
				for(Property p: player.getOwnedProperty())
				{
					if(p!=null)
					auctionTile(p, player);
				}
				}
				player.setBankrupt(true);
				answerC =true;
				System.out.println("Bankruptcy declared");

			}
			else if ( answer.toUpperCase().trim().equals("N"))
			{
				answerC = true;
				System.out.println("Action Cancelled");
			}
			else
			{
				System.out.println("Invalid Input (Y/N):");
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
		while(!haveWinner && players[index]!=null) {
			currentPlayer=players[index];
			System.out.println("Next Player to Bid: "+players[index].getUsername());
			valid=false;
			while(!valid){
				System.out.println("Do you want to bid or reject?(Bid/Reject)");
				String answer = scanner.next();
				scanner.nextLine();
				if (answer.toUpperCase().trim().equals("BID")) {
					System.out.println("\nMinimum Bid: "+(bid+5)+"\nEnter bid: ");
					double offer = scanner.nextDouble();
					scanner.nextLine();
					if (offer>=bid+5 && currentPlayer.getFunds()>=offer) {
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
							}
							else {
								placeholder[i]=null;	
							}
							i++;
						}
						playersIn=placeholder;
					}
					valid=true;
				}
				else if (answer.toUpperCase().trim().equals("REJECT")) {
					System.out.println("Next Player!");
					valid=true;
					// Take current player out of playersIn
					Player[] placeholder = new Player[5];
					int i=0;
					for(Player p:playersIn) {
						if(p!=currentPlayer) {
							placeholder[i]=p;
						}
						else {
							placeholder[i]=null;	
						}
						i++;
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
					if (index == 4) {
						index = 0;
					} else {
						index++;
					} 
				}while (playersIn[index]==null); // Find next not null player to bid
			}
			// Next player bids or rejects
		}
		
		// Highest bidder wins property 
		if(winningBid!=null) {
			tile.investTile(winningBid);
			System.out.println("Auction Over: Property bought by "+winningBid.getUsername()+" for "+bid+".");		
			winningBid.addOwnedTile(tile);
		}
		else {
			System.out.println("Auction Over: Property remains unowned.");
		}
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
				"(Card: 1) A relative has left you a substantial sum in their will, Gain 200", 
				"(Card: 2) The Government has issued a new tax, Lose 5% of your funds",
				"(Card: 3) You stumble apon a gambler in the street, He gives you a dice and says \"If you roll an even number i will double all the money in your account\" ",
				"(Card: 4) You win a prize on a radio show. Gain £100",
				"(Card: 5) You have to pay child support, Lose 20% of your funds",
				"(Card: 6) Your inability to make reasonable finantial decisions has led to you buying stuff you cannot afford. Lose 35%",
				"(Card: 7) You exist, Lose 10% of your funds :)",
				"(Card: 8) You thought you found an infinite money glitch but accidently commited tax fraud. Increase your funds by 50% then lose 50% ",
				"(Card: 9) You have more money now :) Gain 35% of your funds"}; //FILL OUT
		
		int drawCard = rand.nextInt(numberOfChanceCards - 1);
		 
		
		//Set Card Text
		card.setChance(cardText[drawCard]);
		
		//
		System.out.println("+----------------------------------------------+");
		System.out.println("|  		    Chance Card		      |");
		System.out.println("+----------------------------------------------+");
		System.out.println(cardText[drawCard]);
		System.out.println("+----------------------------------------------+");
		
		//Run code for chance card
		double funds = player.getFunds();
		
		
		
		switch(drawCard) {
			case(0):
				//reduce funds by 10%
				System.out.println("Current Funds: " + player.getFunds());
				funds = player.getFunds();
				player.setFunds(funds * 0.9);
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(1):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds + 200);
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(2):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds * 0.95);
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(3):
				System.out.println("Enter anything to roll dice!");
				scanner.nextLine();
				try {
					System.in.read();
				} catch (Exception e) {
				}
				System.out.println("Current Funds: " + player.getFunds());
				int diceRollValue = rollDice();
				funds = player.getFunds();
				if(diceRollValue % 2 == 0) {
					player.setFunds(funds * 2);
				}
				
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(4):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds + 100);
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(5):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds * 0.80);
				
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(6):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds * 0.65);
				
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(7):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds * 0.90);
				
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(8):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds * 1.5);
				funds = player.getFunds();
				player.setFunds(funds * 0.5);
				
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			case(9):
				System.out.println("Current Funds: " + player.getFunds());
				player.setFunds(funds * 1.35);
				
				System.out.println("New Funds: " + player.getFunds());
				break;
				
			default:
				//Code	
				System.out.println("Invalid Token for Chance Card Randomiser");
				break;
		}
		
		//Prints chance Card
		//printChanceCard(card);
		//player.setChanceCardCount(player.getChanceCardCount() + 1);
		
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
				String answer = scanner.next();
				scanner.nextLine();
				if (answer.toUpperCase().trim().equals("S")) {
					sellProperty(lander);
					// valid=true;
					// If lander has sufficient funds continue, else ask again.
				}
				else if (answer.toUpperCase().trim().equals("B")) {
					fileBankruptcy(lander);
					valid=true;
				}
				else {
					System.out.println("Error: Please enter S or B.");
				}
			}
			
		}
		else {					
			System.out.println(lander.getUsername()+" has landed on "+owner.getUsername()+". "+lander.getUsername()+" pays "+owner.getUsername()+" "+property.getPenalty());
			lander.setFunds(lander.getFunds()-property.getPenalty());
			owner.setFunds(owner.getFunds()+property.getPenalty());
			owner.setAmountCollected(owner.getAmountCollected() + property.getPenalty());
		}
		boolean valid=false;
		while(valid==false){
			System.out.println("Do you want to take any more actions this turn?(Y/N)");
			String answer = scanner.next();
			scanner.nextLine();
			if (answer.toUpperCase().trim().equals("Y")) {
				displayPlayerOptions(lander,true);
				valid=true;
			}
			else if (answer.toUpperCase().trim().equals("N")) {
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
			String answer = scanner.next();
			scanner.nextLine();
			if (answer.toUpperCase().trim().equals("Y")) {
				investTile(lander,property);
				valid=true;
			}
			else if (answer.toUpperCase().trim().equals("N")) {
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
			String answer = scanner.next();
			scanner.nextLine();
			if (answer.toUpperCase().trim().equals("Y")) {
				displayPlayerOptions(lander,true);
				valid=true;
			}
			else if (answer.toUpperCase().trim().equals("N")) {
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
		System.out.print("|    GO    |    JBS   |  Chance  |  Nestle  | Cargill  |  Taxis   |  Nandos  |   KFC    |McDonalds |          |\n");
		System.out.print("|          |          |   Card   |          |          |          |          |          |          |          |\n");
		System.out.print("|          |   60    |          |   70    |   75    |   150   |   100   |   125   |   130   |          |\n");
		System.out.print("|          |          |          |          |          |          |          |          |          |          |\n");
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("|36        |                                                                                       |11        |\n");
		System.out.print("|  Apple   |                                                                                       | Emerson  |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|   250   |                                                                                       |   150   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|35        |                                                                                       |12        |\n");
		System.out.print("| Samsung  |                                                                                       |  Hitachi |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|   250   |                                                                                       |   150   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|34        |                                                                                       |13        |\n");
		System.out.print("|Microsoft |                                                                                       | Siemens  |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|   210   |                                                                                       |   155   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|33        |                                                                                       |14        |\n");
		System.out.print("| Airports |                                                                                       |  Buses   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|   150   |                                                                                       |   150   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|32        |                                                                                       |15        |\n");
		System.out.print("| Netflix  |                                                                                       |    VW    |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|   210   |                                                                                       |   165   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|31        |                                                                                       |16        |\n");
		System.out.print("|  Chance  |                                                                                       | Morcoded |\n");
		System.out.print("|   Card   |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |   175   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|30        |                                                                                       |17        |\n");
		System.out.print("| Youtube  |                                                                                       |   Aldi   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("|   200   |                                                                                       |   175   |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+                                                                                       +----------+\n");
		System.out.print("|29        |                                                                                       |18        |\n");
		System.out.print("| Tik Tok  |                                                                                       |  Chance  |\n");
		System.out.print("|          |                                                                                       |   Card   |\n");
		System.out.print("|   200   |                                                                                       |          |\n");
		System.out.print("|          |                                                                                       |          |\n");
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("|28        |27        |26        |25        |24        |23        |22        |21        |20        |19        |\n");
		System.out.print("|          |   PWC    | Deloitte |   KPMG   | Harbours |  Natwest |  Chance  |   AIB    |  Dankse  |          |\n");
		System.out.print("|          |          |          |          |          |          |   Card   |          |          |          |\n");
		System.out.print("|          |   195   |   190   |   185   |   150   |   180   |          |   180   |   175   |          |\n");
		System.out.print("|          |          |          |          |          |          |          |          |          |          |\n");
		System.out.print("+----------+----------+----------+----------+----------+----------+----------+----------+----------+----------+\n");
		System.out.print("KEY: OW = Owner |  = Price\n");	
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
				System.out.println("|Price: " + ((Property) board[player.getCurrentPositionInt()]).getPrice());
				System.out.println("|   			     		       |");
				System.out.println("|Tile Number: " + (player.getCurrentPositionInt() + 1));
				System.out.println("+----------------------------------------------+");
				landOnUnownedProperty(player,(Property) board[player.getCurrentPositionInt()]);
			}
			else {
				System.out.println("|Owner: " + ((Property) board[player.getCurrentPositionInt()]).getOwner().getUsername());
				System.out.println("|   			     		       |");
				System.out.println("|Penalty: " + ((Property) board[player.getCurrentPositionInt()]).getPenalty());
				System.out.println("|   			     		       |");
				System.out.println("|Tile Number: " + (player.getCurrentPositionInt() + 1));
				System.out.println("+----------------------------------------------+");	
				landOnOwnedProperty(player,((Property) board[player.getCurrentPositionInt()]).getOwner(),(Property) board[player.getCurrentPositionInt()]);
			}
			
		}	
		else if(board[player.getCurrentPositionInt()] instanceof tile.ChanceCard) {
			
			int pos = player.getCurrentPositionInt() + 1;
			
			pickUpChanceCard(player);
			
		}
		else if(board[player.getCurrentPositionInt()] instanceof tile.Tile) {
			
			int pos = player.getCurrentPositionInt() + 1;
			
			System.out.println("+----------------------------------------------+");
			System.out.println("|" + ((Tile) board[player.getCurrentPositionInt()]).getName());
			System.out.println("|   			     		       |");
			System.out.println("|" + pos);
			System.out.println("+----------------------------------------------+");
		}
		
		else if(board[player.getCurrentPositionInt()] instanceof tile.PassGo) {
			
			int pos = player.getCurrentPositionInt() + 1;
			
			System.out.println("+----------------------------------------------+");
			System.out.println(((PassGo) board[player.getCurrentPositionInt()]).getName());
			System.out.println("|   			     		       |");
			System.out.println("|" + pos);
			System.out.println("+----------------------------------------------+");
			passGo(player);
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		
		Scanner scanner = new Scanner(System.in);
		
		// Registering Players
		
		game.initBoard();
		
		
		game.registerPlayers();
		game.createPlayOrder();
		String sWinner="";
		System.out.println("Users Registered: ");
		for(Player p:game.players) {
			if (p != null)
			{
			System.out.println("Player: " + p.getUsername());	
			}
		}
		
		int numPlayers = game.players.length;
		
		//Game Loop
		int turnCount = 1;
		
		boolean winner = false; // Checks if game has winner for main loop
		
		
		while(!winner) { // Main loop until winner
			for(int i = 0; i < numPlayers; i++) { //Turn loop
				if (game.players[i]!=null) {
					if (!game.players[i].getBankrupt()) {
						// Prints turn information and player (Print board + Player Information)
						game.printBoard();
						System.out.println("\nTurn: " + turnCount); //Prints turn count at start of turn
						System.out.println("Player: " + game.players[i].getUsername());

						// Display Player Options
						game.displayPlayerOptions(game.players[i],false);

						//Player rolls dice (x2)
						int diceRoll = game.rollDice() + game.rollDice() + 1;
						System.out.println("You have rolled a: " + diceRoll);

						// Moves player

						// USED FOR TESTING
						int playerPosition = 0;

						try {
							playerPosition = game.players[i].getCurrentPositionInt();//Gets player position as integer
						} catch (Exception e) {
							playerPosition = 1;
						}

						// Moves player x times and checks if they pass GO
						for (int moves = 0; moves < diceRoll; moves++) {
							if ((playerPosition + 1) == 36) {
								playerPosition = 1;

								//Run Pass GO code
								game.passGo(game.players[i]);

							} else {
								playerPosition++;
							}
						}
						// Sets players new position
						game.players[i].setCurrentPositionInt(playerPosition - 1);

						// Presents options based on tile
						game.printPlayerLocations(game.players[i]);
						// Ends turn + Checks if winner
						game.players[i].checkObjectives();
						winner = game.players[i].checkWinner();
						if(winner == true)
						   sWinner = game.players[i].getUsername();
						int winnerCount = 0;
						
						//checking for winner
						for (Player p: game.players)
						{
							if(game.players[i]!=null)
							{
								if(!game.players[i].getBankrupt() && winner != true)
								{
									winnerCount++;
									sWinner = game.players[i].getUsername(); // only used when winner is left
								}
							}
						}
						if (winnerCount == 1)
						{
							winner = true;
						}
					} 
				}
			}
			turnCount++;
		}
		System.out.println("Winner is " + sWinner);
	}
}
