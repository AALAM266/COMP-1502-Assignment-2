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
	
	
	public void showWelcomeMsg() {
		System.out.println("******************************************************");
		System.out.println("*        WELCOME TO TOY STORE COMPANY!               *");
		System.out.println("******************************************************");
		System.out.println();
	}
		
	/**
	 * Shows the main menu to the user and prompts the user for the input
	 */
	public void showMainMenu() { // Shows the main menu to the user
		System.out.println("How May We Help You?");
		System.out.println();
		System.out.println("\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Save & Exit");
		System.out.println();
	}
		
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
			input.nextLine();  
			return enterOption(); 
		}
		
		return choice;
	}		
	
	/**
	 * Shows the sub menu to the user and prompts the user for the input
	 */
	public void showSearchMenu() { // Shows the sub menu to the user
		System.out.println("Find Toys With:");
		System.out.println();
		System.out.println("\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.println();
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @param toyInventory 
	 * @return the user's input
	 */
	public int promptSN(ArrayList<Toys> toyInventory) { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Serial Number (SN): ");
		int serialNumber = -1;
		
		if (input.hasNextInt()) {
			serialNumber = input.nextInt();
			input.nextLine();  
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN(toyInventory);  
		}
		
		if (String.valueOf(serialNumber).length() < 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN(toyInventory);  
		}
		
		for (Toys t : toyInventory) {
			if (serialNumber == t.getSerialNumber()) {
				System.out.println();
				System.out.println("A Toy With This Serial Number Already Exists! Try Again.");
				System.out.println();
				input.nextLine();  
				return promptSN(toyInventory);  
			}	
		}
		
		return serialNumber;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public String promptToyName() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Toy Name: ");
		String name = input.nextLine().trim().toLowerCase();
		System.out.println();
		return name;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public String promptType() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Type: ");
		String type = input.nextLine().trim().toLowerCase();
		System.out.println();
		return type;
	}
	
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public String promptBrand() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Toy Brand: ");
		String brand = input.nextLine().trim().toLowerCase();
		System.out.println();
		return brand;
	}
	
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public double promptToyPrice() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Toy Price: ");
		double price = input.nextDouble();
		System.out.println();
		return price;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public int promptAvailableCount() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Available Count: ");
		int availableCount = input.nextInt();
		System.out.println();
		return availableCount;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public int promptAgeAppropriate() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Appropriate Age: ");
		int appropriateAge = input.nextInt();
		System.out.println();
		return appropriateAge;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public int promptMinPlayers() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Minimum Number of Players: ");
		int minPlayers = input.nextInt();
		System.out.println();
		return minPlayers;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public int promptMaxPlayers() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Maximum Number of Players: ");
		int maxPlayers = input.nextInt();
		System.out.println();
		return maxPlayers;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public String promptDesigners() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Designer Names (Use ',' to separate the names if there is more than one name): ");
		String designers = input.nextLine().trim().toLowerCase();
		System.out.println();
		return designers;
	}
	
	
	public void showSearchResultsP1(Toys t, int n) { // Shows the search results to the user
		System.out.println("Here are the search results:");
		System.out.println();
		System.out.println("\t(" + n + ") " + t);
	}
		
	public int showSearchResultsP2(int n) {
		System.out.println("\t(" + n + ") Back to Main Menu");
		System.out.println();
		System.out.print("Enter option number to purchase: ");
		int mainChoice = input.nextInt();
		return mainChoice;
	}
	
//	public int showSNSearchResults(ArrayList<Toys> toyInventory, int serialNumber) { // Shows the search results to the user
//		int n = 1;
//		System.out.println("Here are the search results:");
//		System.out.println();
//		for (Toys t : toyInventory) {
//			if (serialNumber == t.getSerialNumber()) {
//				System.out.println("\t(" + n + ") " + t);
//				n += 1;
//			}
//		}
//		
//		System.out.println("\t(" + n + ") Back to Main Menu");
//		System.out.println();
//		System.out.print("Enter option number to purchase: ");
//		int mainChoice = input.nextInt();
//		return mainChoice;
//	}
//		
//	public int showToyNameSearchResults(ArrayList<Toys> toyInventory, String name) { // Shows the search results to the user
//		int n = 1;
//		System.out.println("Here are the search results:");
//		System.out.println();
//		for (Toys t : toyInventory) {
//			if (name == t.getName()) {
//				System.out.println("\t(" + n + ") " + t);
//				n += 1;
//			}
//		}
//		
//		System.out.println("\t(" + n + ") Back to Main Menu");
//		System.out.println();
//		System.out.print("Enter option number to purchase: ");
//		int mainChoice = input.nextInt();
//		return mainChoice;
//	}
//	
//	public int showTypeSearchResults(ArrayList<Toys> toyInventory, String toyType) { // Shows the search results to the user
//		int n = 1;
//		System.out.println("Here are the search results:");
//		System.out.println();
//		for (Toys t : toyInventory) {
//			if (toyType == t.getToyType()) {
//				System.out.println("\t(" + n + ") " + t);
//				n += 1;
//			}
//		}
//		
//		System.out.println("\t(" + n + ") Back to Main Menu");
//		System.out.println();
//		System.out.print("Enter option number to purchase: ");
//		int mainChoice = input.nextInt();
//		return mainChoice;
//	}
	
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
		System.out.println();
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


	public int promptSN() {
		System.out.print("Enter Serial Number (SN): ");
		int serialNumber = -1;
		
		if (input.hasNextInt()) {
			serialNumber = input.nextInt();
			input.nextLine();  
		} else {
			System.out.println();
			System.out.println("Serial Number should only contain digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN();  
		}
		
		if (String.valueOf(serialNumber).length() < 10) {
			System.out.println();
			System.out.println("The Serial Number's length MUST Be 10 Digits! Try again.");
			System.out.println();
			input.nextLine();  
			return promptSN();  
		}
		
		return serialNumber;
	}

}
