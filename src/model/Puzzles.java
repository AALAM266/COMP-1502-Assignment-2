package model;

public class Puzzles extends Toys {

    private String puzzleType;

	/**
	 * Constructor for the Puzzles class
	 * @param serialNumber serial number of the toy
	 * @param name name of the toy
	 * @param brand brand of the toy
	 * @param price price of the toy
	 * @param availabityCount availability count of the toy
	 * @param ageAppropriate appropriate age range of the toy
	 * @param toyType type of toy
	 * @param puzzleType type of puzzle
	 */
	public Puzzles(String serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String puzzleType) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.puzzleType = puzzleType;
	}

	/**
	 * Getter method for the puzzle type
	 * @return the puzzle type
	 */
	public String getPuzzleType() {
		return puzzleType;
	}

	/**
	 * Setter method for the puzzle type
	 * @param puzzleType the puzzle type to set
	 */
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}


	/**
 	* This method will return string representation of the object.
 	* @return a string representation of the object, including the puzzle type
 	*/
    public String toString() {
    	return super.toString() + ", Puzzle Type: " + getPuzzleType();
    }
    
    /**
	 * This method will format the player's name, balance and number of wins
	 * @return a properly formatted string
	 */
	public String format() {
			return ";" + getPuzzleType();	
	}

}
