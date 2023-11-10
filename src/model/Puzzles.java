package model;

public class Puzzles extends Toys {

    @Override
    public String getToyDetails() {
        return "Puzzle - Serial Number: " + getSerialNumber() + ", Name: " + getName() + ", Puzzle Type: " + getPuzzleType();
    }

    public String toString() {
        return "Puzzles{" +
               "serialNumber=" + getSerialNumber() +
               ", name='" + getName() +
               ", brand='" + getBrand() +
               ", price=" + getPrice() +
               ", availabilityCount=" + getAvailabityCount() +
               ", ageAppropriate=" + getAgeAppropriate() +
               ", toyType='" + getToyType()+
               ", puzzleType='" + puzzleType;
    }


    private String puzzleType;

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
    
    

}
