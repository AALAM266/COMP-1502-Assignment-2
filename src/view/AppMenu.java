package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Toys;

public class AppMenu {
	
private Scanner input; // Scanner object to get the user input
	
	/**
	 * This constructor will initialize the scanner object
	 */
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * This method will show the welcome message to the user
	 */
	public void showWelcomeMsg() {
		System.out.println("******************************************************");
		System.out.println("*        WELCOME TO TOY STORE COMPANY!               *");
		System.out.println("******************************************************");
		System.out.println();
	}
		
	/**
	 * Shows the main menu to the user and prompts the user for the input
	 */
	public void showMainMenu() { 
		System.out.println("How May We Help You?");
		System.out.println();
		System.out.println("\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Save & Exit");
		System.out.println();
	}
		
	/**
	 * Prompts the user to choose an option from the main menu
	 * @return the option chosen by the user
	 */
	public int enterOption() {
		System.out.print("Enter Option: ");
		int choice = -1;
		if (input.hasNextInt()) {
			choice = input.nextInt();
			input.nextLine();  
		} else {
			System.out.println();
			System.out.println("This is not an Integer Number! Try again.");
			System.out.println();
			input.nextLine();  
			return enterOption();  
		}
		
		if (choice < 0 || choice > 4) {
			System.out.println();
			System.out.println("This is not a valid option! Try again.");
			System.out.println();
			return enterOption(); 
		}
		System.out.println();
		return choice;
	}		
	
	/**
	 * Shows the sub menu to the user and prompts the user for the input
	 */
	public void showSearchMenu() { 
		System.out.println("Find Toys With:");
		System.out.println();
		System.out.println("\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.println();
	}
	
	/**
	 * Prompts the user for the serial number of the toy
	 * @param toyInventory 
	 * @return the serial number
	 */
	public String promptSN(ArrayList<Toys> toyInventory) { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Serial Number (SN): ");
		String serialNumber = "0";
		while (true) {
		if (input.hasNextInt()) {
			serialNumber = input.nextLine().trim().toLowerCase();
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			return promptSN(toyInventory);  
		}
		
		if (serialNumber.length() < 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			return promptSN(toyInventory);  
		}
		
		for (Toys t : toyInventory) {
			if (serialNumber == t.getSerialNumber()) {
				System.out.println();
				System.out.println("A Toy With This Serial Number Already Exists! Try Again.");
				System.out.println();
				return promptSN(toyInventory);  
			}	
		}	
		System.out.println();
		return serialNumber;
	}
	}
	
	/**
	 * Prompts the user for the toy name
	 * @return the toy name
	 */
	public String promptToyName() { 
		String name;
		while (true) {
			System.out.print("Enter Toy Name: ");
			name = input.nextLine().trim().toLowerCase();
	
			if (name == null || name.isEmpty()) {
				System.out.println("Name Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return name;
	}

	/**
	 * Prompts the user for the toy type
	 * @return the type of toy
	 */
	public String promptType() { 
		String type;
		while (true) {
			System.out.print("Enter Toy Type: ");
			type = input.nextLine().trim().toLowerCase();
	
			if (type == null || type.isEmpty()) {
				System.out.println("Toy Type Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return type;
	}
	
	
	/**
	 * Prompts the user for the toy brand
	 * @return the brand of the toy
	 */
	public String promptBrand() { 
		String brand;
		while (true) {
			System.out.print("Enter Brand Name: ");
			brand = input.nextLine().trim().toLowerCase();
	
			if (brand == null || brand.isEmpty()) {
				System.out.println("Toy Name Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return brand;
	}
	
	
	/**
	 * Prompts the user for the price of the toy
	 * @return the price of the toy
	 */
	public double promptToyPrice() { 
		double price = -1;
		while (true) {
			System.out.print("Enter Toy Price: ");
			if (input.hasNextDouble()) {
				price = input.nextDouble();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (price < 0) {
				System.out.println();
				System.out.println("Price Cannot Be Negative! Try Again.");
				System.out.println();
				input.nextLine();  
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return price;
	}
	
	/**
	 * Prompts the user for the availablity count of the selected toy
	 * @return the availablity count of the selected toy
	 */
	public int promptAvailableCount() { // Prompts the user for the toy name if the user selects the search by toy name option
		int availableCount = -1;
		while (true) {
			System.out.print("Enter Available Count: ");
			if (input.hasNextInt()) {
				availableCount = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (availableCount < 0) {
				System.out.println();
				System.out.println("Available Count Cannot Be Negative! Try Again.");
				System.out.println();
				input.nextLine();  
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return availableCount;
	}
	
	/**
	 * Prompts the user for the age rating of the toy
	 * @return the age rating for the toy
	 */
	public int promptAgeAppropriate() { // Prompts the user for the toy name if the user selects the search by toy name option
		int appropriateAge = -1;
		while (true) {
			System.out.print("Enter Appropriate Age: ");
			if (input.hasNextInt()) {
				appropriateAge = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (appropriateAge < 0) {
				System.out.println();
				System.out.println("Appropriate Age Cannot Be Negative! Try Again.");
				System.out.println();
				input.nextLine();  
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return appropriateAge;
	}
	
	/**
	 * Prompts the user for the minimum players 
	 * @return the minimum player count
	 */
	public int promptMinPlayers() { 
		int minPlayers = -1;
		while (true) {
			System.out.print("Enter Minimum Number of Players: ");
			if (input.hasNextInt()) {
				minPlayers = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (minPlayers < 0) {
				System.out.println();
				System.out.println("Minimum Number of Players Cannot Be Negative! Try Again.");
				System.out.println();
				input.nextLine();  
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return minPlayers;
	}
	
	/**
	 * Prompts the user for the maximum amount of players
	 * @return the maximum player count
	 */
	public int promptMaxPlayers() { // Prompts the user for the toy name if the user selects the search by toy name option
		int maxPlayers = -1;
		while (true) {
			System.out.print("Enter Maximum Number of Players: ");
			if (input.hasNextInt()) {
				maxPlayers = input.nextInt();
				input.nextLine();  
			} else {
				System.out.println();
				System.out.println("Not an Integer Number! Try again.");
				System.out.println();
				input.nextLine();  
				continue;  
			}
			
			if (maxPlayers < 0) {
				System.out.println();
				System.out.println("Maximum Number of Players Cannot Be Negative! Try Again.");
				System.out.println();
				input.nextLine();  
				continue;  
			} else {
				break;
			}
		}
		System.out.println();
		return maxPlayers;
	}
	
	/**
	 * Prompts the user for the designer name of the toy
	 * @return the designer name
	 */
	public String promptDesigners() { // Prompts the user for the toy name if the user selects the search by toy name option
		String designers;
		while (true) {
			System.out.print("Enter Designer Names (Use ',' to separate the names if there is more than one name): ");
			designers = input.nextLine().trim().toLowerCase();
	
			if (designers == null || designers.isEmpty()) {
				System.out.println("Designers Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return designers;
	}
	
	public void showSearchResultsP1(ArrayList<Toys> toyInventory) { // Shows the search results to the user
		System.out.println("Number of toys in inventory: " + toyInventory.size());
		System.out.println();
		System.out.println("Here are the search results:");
		System.out.println();
	}
		
	public void showSearchResultsP2(Toys t, int n) { // Shows the search results to the user
		System.out.println("\t(" + n + ") " + t);
	}
		
	public int showSearchResultsP3(int n) {
		System.out.println("\t(" + n + ") Back to Main Menu");
		System.out.println();
		System.out.print("Enter option number to purchase: ");
		int mainChoice = input.nextInt();
		System.out.println();
		return mainChoice;
	}
	
	public void showTransactionSuccess() {
		System.out.println("The Transaction Successfully Terminated!");
		System.out.println();
	}
	
	public void showAddNewToySuccess() {
		System.out.println("New Toy Added!");
		System.out.println();
	}
	
	public void showRemoveToySuccess() {
		System.out.println("Item Removed!");
		System.out.println();
	}
	
	/**
	 * Prompts the user to hit enter to continue
	 */
	public void promptPressEnter(){
		System.out.println("Press \"ENTER\" to continue...");
		input.nextLine();
		System.out.println();
	}


	/**
	 * Informs the user that they entered an invalid choice
	 */
	public void showInvalidChoice() {
		System.out.println("Invalid choice");
		System.out.println();
	}
	
	/**
	 * Displays a saving message to the user
	 */
	public void showSavingMsg() {
		System.out.println();
		System.out.println("Saving Data Into Database...");
		System.out.println();
		System.out.println();
		System.out.println("*********** THANKS FOR VISITING US! ***********");
	}
	
	/**
	 * This method will ask the user if they want to play again
	 * @param t 
	 * @return a replay of the game
	 */
	public char promptRemoveToy(Toys t) {
		System.out.print("This Item Found: ");
		System.out.println();
		System.out.println("\t" + t);
		System.out.println();
		System.out.print("Do you want to remove it (Y/N)? ");
		char removeChoice = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		return removeChoice;	
	}
	
	/**
	 * This method will ask the user if they want to play again
	 * @param t 
	 * @return a replay of the game
	 */
	public char promptRemoveToyAgain() {
		char removeChoice = input.nextLine().toLowerCase().charAt(0);
		System.out.println();
		return removeChoice;	
	}


	public String promptSN() {
		System.out.print("Enter Serial Number (SN): ");
		String serialNumber = "0";
		
		if (input.hasNextInt()) {
			serialNumber = input.nextLine().trim().toLowerCase();
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN();  
		}
		
		if (serialNumber.length() != 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			return promptSN();  
		}
		System.out.println();
		return serialNumber;
	}

	/**
	 * Prompts the user for the classification of the figure
	 * @return the classification name
	 */
	public String promptClassification() { // Prompts the user for the toy name if the user selects the search by toy name option
		String classification;
		while (true) {
			System.out.print("Enter Classification (A/D/H): ");
			classification = input.nextLine().trim().toLowerCase();
	
			if (classification == null || classification.isEmpty()) {
				System.out.println("Classification Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return classification;
	}

	/**
	 * Prompts the user for the type of the puzzle
	 * @return the puzzle type
	 */
	public String promptPuzzleType() { // Prompts the user for the toy name if the user selects the search by toy name option
		String puzzleType;
		while (true) {
			System.out.print("Enter Puzzle Type (M/C/L/T/R): ");
			puzzleType = input.nextLine().trim().toLowerCase();
	
			if (puzzleType == null || puzzleType.isEmpty()) {
				System.out.println("Puzzle Type Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return puzzleType;
	}

	public String promptMaterial() {
		String material;
		while (true) {
			System.out.print("Enter Material: ");
			material = input.nextLine().trim().toLowerCase();
	
			if (material == null || material.isEmpty()) {
				System.out.println("Material Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return material;
	}

	public String promptSize() {
		String size;
		while (true) {
			System.out.print("Enter Size (S/M/L): ");
			size = input.nextLine().trim().toLowerCase();
	
			if (size == null || size.isEmpty()) {
				System.out.println("Size Cannot Be Empty! Try Again.");
				System.out.println();
			} else {
				break;
			}
		}
		System.out.println();
		return size;
	}

}
