package model;

public class BoardGames extends Toys {

    private int minPlayers;
    private int maxPlayers;
    private String designers;
    
	/**
	 * Constructor for the BoardGames class
	 * @param serialNumber serial number of the toy
	 * @param name name of the toy
	 * @param brand brand of the toy
	 * @param price price of the toy
	 * @param availabityCount availability count of the toy
	 * @param ageAppropriate appropriate age range of the toy
	 * @param toyType type of toy 
	 * @param minPlayers minimum number of players
	 * @param maxPlayers maximum number of players
	 * @param designers designer(s) of the board game
	 */
	public BoardGames(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, int minPlayers, int maxPlayers, String designers) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
	}

	/**
	 * Getter method for the minimum number of players
	 * @return the minimum number of players
	 */
	public int getMinPlayers() {
		return minPlayers;
	}

	/**
	 * Setter method for the minimum number of players
	 * @param minPlayers the minimum number of players to set
	 */
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	/**
	 * Getter method for the maximum number of players
	 * @return the maximum number of players
	 */
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
	 * Setter method for the maximum number of players
	 * @param maxPlayers the maximum number of players to set
	 */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	/**
	 * Getter method for the designer(s)
	 * @return the designer(s)
	 */
	public String getDesigners() {
		return designers;
	}

	/**
	 * Setter method for the designer(s)
	 * @param designers the designer(s) to set
	 */
	public void setDesigners(String designers) {
		this.designers = designers;
	}
    
	/**
 	* This method will return string representation of the object.
 	* @return a string representation of the object, including the minimum and maximum number of players as well as the designer(s)
 	*/
	@Override
	public String toString() {
    	return super.toString() + ", Number of Players: " + getMinPlayers() + "-" + getMaxPlayers() + ", Designer(s): " + getDesigners();
    }
	

	/**
	 * Returns a formatted string representation of the board game's minimum and maximum number of players and designers.
	 * @return formatted string representation of the board game's minimum and maximum number of players and designers
	 */
	@Override
	public String format() {
			return super.format() + ";" + getMinPlayers() + ";" + getMaxPlayers() + ";" + getDesigners() + "\n";		
	}

}
