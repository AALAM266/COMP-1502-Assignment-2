package model;

public class Puzzles extends Toys {

    @Override
    public String getToyDetails() {
        return "Puzzle - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Puzzle Type: " + getPuzzleType();
    }

    private String puzzleType;

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
    
    

}
