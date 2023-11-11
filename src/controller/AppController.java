package controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

import model.Animals;
import model.BoardGames;
import model.Figures;
import model.Puzzles;
import model.Toys;
import view.AppMenu;

public class AppController {

    private final String FILENAME = "res/toys.txt";
    private AppMenu appMenu;
    private ArrayList<Toys> toyInventory;
    
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
	public void launchApplication() throws Exception { // This method will launch the app and show the main menu to the
														// user
		boolean flag = true;
		int option;

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
				save();
				flag = false;
			default:
				appMenu.showInvalidChoice();
			}
		}

	}
    
	private void searchAndPurchase() {
		
		boolean flag = true;
		int option;

		while (flag) {
			appMenu.showSearchMenu();
			option = appMenu.enterOption();
			int n = 1;

			switch (option) {

			case 1:
				int serialNumber = appMenu.promptSN();
				
				for (Toys t : toyInventory) {
					if (serialNumber == t.getSerialNumber()) {
						appMenu.showSearchResultsP1(t, n);
						n += 1;
					}
					
					
				}
				
				appMenu.showSearchResultsP2(n);
				break;
				
			case 2:
				String name = appMenu.promptToyName();
				
				for (Toys t : toyInventory) {
					if (name == t.getName()) {
						appMenu.showSearchResultsP1(t, n);
						n += 1;
					}
				}
				
				appMenu.showSearchResultsP2(n);
				break;
				
			case 3:
				String type = appMenu.promptType();

				for (Toys t : toyInventory) {
					if (type == t.getToyType()) {
						appMenu.showSearchResultsP1(t, n);
						n += 1;
					}
				}
				
				appMenu.showSearchResultsP2(n);
				break;
				
			case 4:
				appMenu.showMainMenu();
				flag = false;
				break;
				
			default:
				appMenu.showInvalidChoice();
			}
		}
	
	}
	
	private void addNewToy() {
		int serialNumber = appMenu.promptSN(toyInventory);
		
		String name = appMenu.promptToyName();
		String brand = appMenu.promptBrand();
		double price = appMenu.promptToyPrice();
		int availableCount = appMenu.promptAvailableCount();
		int appropriateAge = appMenu.promptAgeAppropriate();
		int minPlayers = appMenu.promptMinPlayers();
		int maxPlayers = appMenu.promptMaxPlayers();
		String designers = appMenu.promptDesigners();
		
		Toys t = new BoardGames(serialNumber, name, brand, price, availableCount, 
				appropriateAge, "BoardGame", minPlayers, maxPlayers, designers);
		toyInventory.add(t);
		
		appMenu.showAddNewToySuccess();
		appMenu.promptPressEnter();
		
	}
	
	private void removeToy() {
		int serialNumber = appMenu.promptSN();
		
		for (Toys t : toyInventory) {
			if (serialNumber == t.getSerialNumber()) {
					
				boolean invalidInput = true;
				char option = appMenu.promptRemoveToy(t);

				while (invalidInput) {
					invalidInput = false;

					switch (option) {

					case 'y':

						toyInventory.remove(t);
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
	}

	/**
	 * This method is called from the launchApplication method, it will save the
	 * data into the txt file
	 * 
	 * @throws Exception
	 */
	private void save() throws Exception { // Save data into the txt file when the user chooses the save and exit option
		File casinoInfo = new File(FILENAME);
		PrintWriter pw = new PrintWriter(casinoInfo);

		appMenu.showSavingMsg();

		for (Toys t : toyInventory) {
			if (t.getToyType() == "BoardGame") {
				BoardGames b = (BoardGames)toyInventory.get(1);
				pw.println(t.format() + b.format());
			}
				
			else if (t.getToyType() == "Figure") {
				Figures f = (Figures)toyInventory.get(1);
				pw.println(t.format() + f.format());
			}
			
			else if (t.getToyType() == "Animal") {
				Animals a = (Animals)toyInventory.get(1);
				pw.println(t.format() + a.format());
			}
			
			else {
				Puzzles p = (Puzzles)toyInventory.get(1);
				pw.println(t.format() + p.format());
			}
			
		}

		pw.close();

		appMenu.showSavingMsg();

	}
	
	/**
	 * This method is called from the constructor, it will load the data from the
	 * txt file into the arraylist
	 * 
	 * @throws Exception
	 */
	private void loadData() throws Exception { // Load data from CasinoInfo.txt into arraylist
		File toyInventoryInfo = new File(FILENAME);
		String currentLine;
		String[] splittedLine;

		if (toyInventoryInfo.exists()) { // checks if the file exists
			Scanner fileReader = new Scanner(toyInventoryInfo);

			while (fileReader.hasNextLine()) { // reads the file line by line

				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				
				if (splittedLine[6].length() == 1) {
					switch (splittedLine[6].toLowerCase().charAt(0)) {
					case 'm':
					case 'c':
					case 'l':
					case 't':
					case 'r':
						
						Toys t = new Puzzles(Integer.parseInt(splittedLine[0]), splittedLine[1].toLowerCase(), 
								splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
								Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
								"Puzzle", splittedLine[6].toLowerCase());
						toyInventory.add(t);
						
						break;

					default:
						break;
					}
				}
				
				else if (splittedLine[7].length() == 1) {
					switch (splittedLine[7].toLowerCase().charAt(0)) {
					case 's':
					case 'm':
					case 'l':
						
						Toys t = new Animals(Integer.parseInt(splittedLine[0]), splittedLine[1].toLowerCase(), 
								splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
								Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
								"Animal", splittedLine[6].toLowerCase(), splittedLine[7].toLowerCase());
						toyInventory.add(t);
						
						break;

					default:
						break;
					}
				}
				
				else if (splittedLine[6].length() == 1) {
					switch (splittedLine[6].toLowerCase().charAt(0)) {
					case 'a':
					case 'd':
					case 'h':
						
						Toys t = new Figures(Integer.parseInt(splittedLine[0]), splittedLine[1].toLowerCase(), 
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
					Toys t = new BoardGames(Integer.parseInt(splittedLine[0]), splittedLine[1].toLowerCase(), 
							splittedLine[2].toLowerCase(), Double.parseDouble(splittedLine[3]), 
							Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[5]), 
							"BoardGame", Integer.parseInt(splittedLine[6]), Integer.parseInt(splittedLine[7]), 
							splittedLine[8].toLowerCase());
					toyInventory.add(t);
				}
			}

			fileReader.close();
		}
	}

    
}
