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
	 * @return the user's choice
	 */
	public int showMainMenu() { // Shows the main menu to the user
		System.out.println("How May We Help You?");
		System.out.println();
		System.out.println("\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Save & Exit");
		System.out.println();
		System.out.print("Enter Option: ");
		int mainChoice = input.nextInt();
		return mainChoice;
	}
	
	/**
	 * Shows the sub menu to the user and prompts the user for the input
	 * @return the user's choice
	 */
	public int showSearchMenu() { // Shows the sub menu to the user
		System.out.println("Find Toys With:");
		System.out.println();
		System.out.println("\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.println();
		System.out.print("Enter Option: ");
		int mainChoice = input.nextInt();
		return mainChoice;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public int promptSN() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Serial Number (SN): ");
		int serialNumber = input.nextInt();
		return serialNumber;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public String promptToyName() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Toy Name: ");
		String name = input.nextLine().trim().toLowerCase();
		return name;
	}
	
	/**
	 * Prompts the user for the toy name if the user selects the search by toy name option
	 * @return the user's input
	 */
	public String promptType() { // Prompts the user for the toy name if the user selects the search by toy name option
		System.out.print("Enter Type: ");
		String type = input.nextLine().trim().toLowerCase();
		return type;
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
	
}
