package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import exceptions.MinMaxException;
import exceptions.NegativePriceException;
import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;
import view.AppMenu;

/**
 * The AppController class is responsible for managing the application, it interacts with the user through the AppMenu.
 * It contains methods to add new toys, search for specific toys, remove toys, and a gift suggestion.
 * The main entry point of the application is the launchApplication() method, which
 * displays the main menu to the user and calls the appropriate methods based on the
 * user's choice.
 * 
 * @author Akheel Alam Eddin and Keegan Hong
 * @version 1.0
 */
public class AppController {

    private final String FILENAME = "res/toys.txt";
    private AppMenu appMenu;
    private ArrayList<Toys> toyInventory;
    
	/**
	 * Constructor for the AppController class
	 * @throws Exception 
	 */
    public AppController() throws Exception {
    	toyInventory = new ArrayList<>();
    	appMenu = new AppMenu();
    	
    	loadData();
    	
    	launchApplication();
    }
    
    /**
	 * This method is called from the constructor and will show the main menu to the
	 * user and then call the appropriate method based on the user's choice
	 * 
	 * @throws Exception
	 */
	public void launchApplication() throws Exception { 
		boolean flag = true;
		int option;
		appMenu.showWelcomeMsg();

		while (flag) {
			appMenu.showMainMenu();
			option = appMenu.enterOption();

			switch (option) {

			case 1:
				searchAndPurchase();
				break;
			case 2:
				addNewToy();
				break;
			case 3:
				removeToy();
				break;
			case 4:
				makeGiftSuggestion();
				break;
			case 5:
				save();
				flag = false;
				break;
			default:
				appMenu.showInvalidChoice();
			}
		}

	}

	/**
	 * This method is called from the launchApplication method, it will search for toys based on the user input and allow the user to purchase them
	 */
	private void searchAndPurchase() {
		
		boolean flag = true;
			
		while (flag) {
			
			boolean flag2 = true;
			ArrayList<Toys> toySearchResults = new ArrayList<>();
			appMenu.showSearchMenu();
			int option = appMenu.enterOption();
			int n = 1;
			int choice = -1;
			Toys t1 = null;
			
			switch (option) {

			case 1:
				String serialNumber = appMenu.promptSN();
				
				
				appMenu.showSearchResultsP1(toyInventory);
				boolean toyFound = false;
				for (Toys t : toyInventory) {
					
					if (serialNumber.equalsIgnoreCase(t.getSerialNumber())) {
						appMenu.showSearchResultsP2(t, n);
						toySearchResults.add(t);
						n += 1;
						t1 = t;
						toyFound = true;
					}				
				}
				if (!toyFound) {
					appMenu.showSerialNumberNotFound();
				}
				
				while (flag2) {
					choice = appMenu.showSearchResultsP3(n);
					
					if (choice == n) {
						flag2 = false;
						break;
					}
					
					else if (choice > n || choice < 1) {
						appMenu.showInvalidChoice();
					}
					
					else {
						toySearchResults.remove(choice - 1);
						t1.decreaseAvailableCount();
						appMenu.showTransactionSuccess();
						appMenu.promptPressEnter();
						flag2 = false;
						
					}
					
				}
			
				break;
				
			case 2:
				String name = appMenu.promptToyName();
				
				appMenu.showSearchResultsP1(toyInventory);
				toyFound = false;
				for (Toys t : toyInventory) {
					
					if (name.equalsIgnoreCase(t.getName())) {
						appMenu.showSearchResultsP2(t, n);
						toySearchResults.add(t);
						n += 1;
						t1 = t;
						toyFound = true;
					}
				}
				if (!toyFound) {
					appMenu.showToyNameNotFound();
				}
				
				while (flag2) {
					choice = appMenu.showSearchResultsP3(n);
					boolean invalidCheck = true;
					
					if (choice == n) {
						flag2 = false;
						break;
					}
					
					else if (choice > n || choice < 1) {
						appMenu.showInvalidChoice();
						invalidCheck = false;

					}
					
					else if (choice < n && choice >= 1 && invalidCheck){
						toySearchResults.remove(choice - 1);
						
						t1.decreaseAvailableCount();
						appMenu.showTransactionSuccess();
						appMenu.promptPressEnter();
						flag2 = false;
					}
					
				}
				break;
				
			case 3:
				boolean flag1 = true;
				toyFound = false;
				while (flag1) {		
					String type = appMenu.promptType();
					switch (type) {
					case "boardgame":
					case "animal":
					case "figure":
					case "puzzle":
						flag1 = false;
						break;
	
					default:
						appMenu.showInvalidChoice();
					}
				
				appMenu.showSearchResultsP1(toyInventory);
				for (Toys t : toyInventory) {
					
					if (type.equalsIgnoreCase(t.getToyType())) {
						appMenu.showSearchResultsP2(t, n);
						toySearchResults.add(t);
						t1 = t;
						n += 1;
						toyFound = true;
					}
				}
				}
				if (!toyFound) {
					appMenu.showToyTypeNotFound();
				}
				
				while (flag2) {
					choice = appMenu.showSearchResultsP3(n);
					
					if (choice == n) {
						flag2 = false;
						break;
					}
					
					else if (choice > n || choice < 1) {
						appMenu.showInvalidChoice();
					}
					
					else {
						toySearchResults.remove(choice - 1);
						t1.decreaseAvailableCount();
						appMenu.showTransactionSuccess();
						appMenu.promptPressEnter();
					}
					
				}
				break;
				
			case 4:
				flag = false;
				break;
				
			default:
				appMenu.showInvalidChoice();
			}
			
		}
	
	}
	
	/**
	 * This method is called from the launchApplication method, it will prompt the user for all of the toy's attributes then it
	 * will add it to the arraylist that will eventually get stored in the txt file
	 * @throws NegativePriceException 
	 */
	private void addNewToy() throws NegativePriceException, MinMaxException {
		boolean flag3 = true;
		
		String serialNumber = appMenu.promptSN(toyInventory);
		String name = appMenu.promptToyName();
		String brand = appMenu.promptBrand();
		
		double price = appMenu.promptToyPrice();
		int availableCount = appMenu.promptAvailableCount();
		int appropriateAge = appMenu.promptAgeAppropriate();
		
		while (flag3) {
			Toys t;
			switch (appMenu.promptType()) {
			case "boardgame":
				
				int minPlayers = appMenu.promptMinPlayers();
				int maxPlayers = appMenu.promptMaxPlayers();
				while (minPlayers > maxPlayers) {
					try {
						throw new MinMaxException();
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println();
					}
					
					minPlayers = appMenu.promptMinPlayers();
					maxPlayers = appMenu.promptMaxPlayers();
				break;
				}
				
				String designers = appMenu.promptDesigners();
				
				t = new BoardGames(serialNumber, name, brand, price, availableCount, 
						appropriateAge, "BoardGame", minPlayers, maxPlayers, designers);
				toyInventory.add(t);
				flag3 = false;
				break;
				
			case "figure":
				boolean flag = true;
				String classification = null;
				while (flag ) {
					classification = appMenu.promptClassification();
					switch (classification) {
					case "a":
					case "d":
					case "h":
						flag = false;
						break;
						
					default:
						appMenu.showInvalidChoice();
					}
				}
				
				t = new Figures(serialNumber, name, brand, price, availableCount, 
						appropriateAge, "figure", classification);
				toyInventory.add(t);
				
				flag3 = false;
				break;
				
			case "animal":
				boolean flag1 = true;
				String material = appMenu.promptMaterial();
				String size = null;
				while (flag1) {				
					size = appMenu.promptSize();
					switch (size) {
					case "s":
					case "m":
					case "l":
						flag1 = false;
						break;
						
					default:
						appMenu.showInvalidChoice();
					}
				}
				t = new Animals(serialNumber, name, brand, price, availableCount, 
						appropriateAge, "animal", material, size);
				toyInventory.add(t);
				
				flag3 = false;
				break;
				
			case "puzzle":
				boolean flag2 = true;
				String puzzleType = null;
				while (flag2) {		
					puzzleType = appMenu.promptPuzzleType();
					switch (puzzleType) {
					case "m":
					case "c":
					case "l":
					case "t":
					case "r":
						flag2 = false;
						break;
						
					default:
						appMenu.showInvalidChoice();
					}
				}
				t = new Puzzles(serialNumber, name, brand, price, availableCount, 
						appropriateAge, "puzzle", puzzleType);
				toyInventory.add(t);
				
				flag3 = false;
				break;
			default:
				appMenu.showInvalidChoice();
			}
		}

		appMenu.showAddNewToySuccess();
		appMenu.promptPressEnter();
		
	}
	
	/**
	 * This method is called from the launchApplication method, it will prompt the user for the serial number of the toy they want to remove
	 */
	private void removeToy() {
		String serialNumber = appMenu.promptSN();
		boolean toyRemoval = false;
		Toys t1 = null;
		for (Toys t : toyInventory) {
			if (serialNumber.equals(t.getSerialNumber())) {
					
				boolean invalidInput = true;
				char option = appMenu.promptRemoveToy(t);

				while (invalidInput) {
					invalidInput = false;

					switch (option) {

					case 'y':
						
						t1 = t;
						toyRemoval = true;
						appMenu.showRemoveToySuccess();
						appMenu.promptPressEnter();
						
						break;

					case 'n':

						break;

					default:
						invalidInput = true;
						appMenu.showInvalidChoice();
						option = appMenu.promptRemoveToyAgain();
					}
				}		
			}	
		}
		
		
		if (toyRemoval == true) {
			toyInventory.remove(t1);
		}
		else {
			appMenu.showSerialNumberNotFound();
			removeToy();
		}
	}
	
	/**
	 * This method is called from the launchApplication method, it will prompt the user for either the age rating of the toy, or the type, or the price range
	 * The information will then be used to recommend a gift for the user to buy
	 */
	private void makeGiftSuggestion() {
		final double MAX_PRICE = 1000000;
		int giftCounter = 0;
		int n = 1;
		int choice = -1;
		String type = null;
		int appropriateAge = appMenu.promptGiftAgeAppropriate();
		if (appropriateAge != -1) {
			giftCounter += 1;
		}
		boolean flag1 = true;
		boolean flag2 = true;
		while (flag1) {		
			type = appMenu.promptGiftType();
			switch (type) {
			case "boardgame":
			case "animal":
			case "figure":
			case "puzzle":
				giftCounter += 1;
				flag1 = false;
				break;
			
			case "":
				flag1 = false;
				break;

			default:
				
				appMenu.showInvalidChoice();
			}
		}

		Double price = appMenu.promptToyPriceMin();
		Double price2 = appMenu.promptToyPriceMax(price);
		while(price > price2 && price2 != -1) {
			appMenu.showGiftPriceError();
			price = appMenu.promptToyPriceMin();
			price2 = appMenu.promptToyPriceMax(price);
		}
		
		if (price > price2 && price2 == -1) {
			price2 = MAX_PRICE;
		}
		
		if (price != -1 || price2 != -1) {
			giftCounter += 1;
		}
		
		if (giftCounter == 0) {
			appMenu.showRetryGiftSuggestion();
			makeGiftSuggestion();
		}
		
		appMenu.showSearchResultsP1(toyInventory);
		ArrayList<Toys> toySearchResults = new ArrayList<>();
		appMenu.showSearchResultsP1(toyInventory);
		Toys t1 = null;
		for (Toys t : toyInventory) {
			
			if (type.equalsIgnoreCase(t.getToyType())) {
				appMenu.showSearchResultsP2(t, n);
				toySearchResults.add(t);
				t1 = t;
				n += 1;
			}
			
			if (t.getAppropriateAge() >= appropriateAge && appropriateAge != -1) {
				appMenu.showSearchResultsP2(t, n);
				toySearchResults.add(t);
				t1 = t;
				n += 1;
			}
			
			if (t.getPrice() >= price && t.getPrice() <= price2) {
				appMenu.showSearchResultsP2(t, n);
				toySearchResults.add(t);
				t1 = t;
				n += 1;
			}
		}	

		while (flag2) {
			choice = appMenu.showSearchResultsP3(n);
			
			if (choice == n) {
				flag2 = false;
				break;
			}
			
			else if (choice > n || choice < 1) {
				appMenu.showInvalidChoice();
			}
			
			else {
				toySearchResults.remove(choice - 1);
				
				t1.decreaseAvailableCount();
				toyInventory.remove(choice);
				appMenu.showTransactionSuccess();
				appMenu.promptPressEnter();
			}
			
		}
	}

	/**
	 * This method is called from the launchApplication method, it will save the
	 * data into the txt file when the program is shut down
	 * @throws Exception
	 */
	private void save() { // Save data into the txt file when the user chooses the save and exit option
		try(FileWriter fw = new FileWriter(FILENAME, false)) {

			for (Toys t : toyInventory) {
				
				if (t.getToyType().toLowerCase().equals("boardgame")) {
					BoardGames b = (BoardGames) t; 
					fw.write(b.format());
				}
				else if (t.getToyType().toLowerCase().equals("figure")) {
					Figures f = (Figures) t; 
					fw.write(f.format());
				}
				else if (t.getToyType().toLowerCase().equals("animal")) {
					Animals a = (Animals) t; 
					fw.write(a.format());
				}
				else {
					Puzzles p = (Puzzles) t; 
					fw.write(p.format());
				}
			}	
		appMenu.showSavingMsg();
	} catch (IOException e) {
		e.printStackTrace();
		
	}

	}
	
	/**
	 * This method is called from the constructor, it will load the data from the
	 * txt resource file into the arraylist to be used as the inventory for the application
	 * @throws Exception
	 */
	private void loadData() throws Exception { 
		File toyInventoryInfo = new File(FILENAME);
		String currentLine;
		String[] splittedLine;

		if (toyInventoryInfo.exists()) { // checks if the file exists
			Scanner fileReader = new Scanner(toyInventoryInfo);

			while (fileReader.hasNextLine()) { // reads the file line by line

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				
				if (splittedLine[6].length() == 1 && splittedLine[6].toLowerCase().charAt(0) != 'a' 
						&& splittedLine[6].toLowerCase().charAt(0) != 'd' && splittedLine[6].toLowerCase().charAt(0) != 'h') {
					switch (splittedLine[6].toLowerCase().charAt(0)) {
					case 'm':
					case 'c':
					case 'l':
					case 't':
					case 'r':
						
						Toys t = new Puzzles(splittedLine[0], splittedLine[1].toLowerCase(), 
								splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
								Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
								"Puzzle", splittedLine[6].toLowerCase());
						toyInventory.add(t);
						
						break;

					default:
						break;
					}
				}
				
				else if (splittedLine.length == 8) {
					
					Toys t = new Animals(splittedLine[0], splittedLine[1].toLowerCase(), 
							splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
							Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
							"Animal", splittedLine[6].toLowerCase(), splittedLine[7].toLowerCase());
					toyInventory.add(t);
					
				}
				
				else if (splittedLine[6].length() == 1) {
					switch (splittedLine[6].toLowerCase().charAt(0)) {
					case 'a':
					case 'd':
					case 'h':
						
						Toys t = new Figures(splittedLine[0], splittedLine[1].toLowerCase(), 
								splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
								Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
								"Figure", splittedLine[6].toLowerCase());
						toyInventory.add(t);
						
						break;

					default:
						break;
					}
				}
				
				else {
					String[] numberOfPlayers = splittedLine[6].split("-");
					Toys t = new BoardGames(splittedLine[0], splittedLine[1].toLowerCase(), 
							splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
							Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
							"BoardGame", Integer.parseInt(numberOfPlayers[0]), Integer.parseInt(numberOfPlayers[1]), 
							splittedLine[7].toLowerCase());
					toyInventory.add(t);
				}
			}

			fileReader.close();
		}
	}

    
}
