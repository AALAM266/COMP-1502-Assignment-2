private void addNewToy() {
    boolean flag3 = true;
    String serialNumber = null;
    String name = null;
    String brand = null;
    double price = 0;

    while (true)
    try {
        serialNumber = appMenu.promptSN(toyInventory);
        name = appMenu.promptToyName();
        brand = appMenu.promptBrand();
        price = appMenu.promptToyPrice();
        if (price < 0) {
            throw new NegativePriceException("Price cannot be negative");
        }
    } catch (NegativePriceException e) {
        System.out.println(e.getMessage());
        break;
    }

    int availableCount = appMenu.promptAvailableCount();
    int appropriateAge = appMenu.promptAgeAppropriate();
    