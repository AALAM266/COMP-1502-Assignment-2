package model;

public class Puzzles extends Toys {

    private String puzzleType;

	public Puzzles(int serialNumber, String name, String brand, double price, int availabityCount, int ageAppropriate,
			String toyType, String puzzleType) {
		super(serialNumber, name, brand, price, availabityCount, ageAppropriate, toyType);
		this.puzzleType = puzzleType;
	}

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
    
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
