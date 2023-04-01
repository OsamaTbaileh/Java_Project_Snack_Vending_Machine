public enum Coin {
    TEN_CENTS(0.1, "USD"),  
    TWENTY_CENTS(0.2, "USD"), 
    FIFTY_CENTS(0.5, "USD"), 
    ONE_USD(1, "USD");
        private final double value;
        private final String currency;
    private Coin(double value, String currency);
    public double getValue(); 
    public boolean checkCurrency();
}


public enum Note {
    TWENTY_USD(20, "USD"),  
    FIFTY_USD(50, "USD");
        private final int value;
        private final String currency;
	private Note(int value, String currency);
	public int getValue();
    public boolean checkCurrency();
}


public enum Card  {
	UNKNOWN,
	VISA("^4[0-9]{12}(?:[0-9]{3})?$"),
	MASTERCARD("^5[1-5][0-9]{14}|^(222[1-9]|22[3-9]\\d|2[3-6]\\d{2}|27[0-1]\\d|2720)[0-9]{12}$"),
	JCB("^(?:2131|1800|35\\d{3})\\d{11}$"),
	DINERS_CLUB("^3(?:0[0-5]|[68][0-9])?[0-9]{11}$"),
	AMEX("^3[47][0-9]{13}$"),	
	MAESTRO("^(5018|5020|5038|6304|6759|6761|6763)[0-9]{8,15}$"),
	INSTA_PAYMENT("^63[7-9][0-9]{13}$");
        private Pattern pattern;
    private Card();
    private Card(String pattern);  
    public static Card checkCardType(String cardNumber);
}


public class Snack {
        private int slotNumber;
        private String name;
        private double price;
        private int amount;
    public Snack(int slotNumber, String name, double price, int amount);
    public int getSlotNumber();
    public String getName();
    public double getPrice();
    public int getAmount();
    public void removeOneSnack();
}


public class KeyPad {
	public int checkChosenNumber(String chosenInput, int lowerBoundery, int upperBoundary);
}	


public abstract class MoneyCalculations {
	public abstract void addMoneyToStore(int tenCents, int twentyCents, int fiftyCents, 
                                        int oneDollar, int twentyNote, int fiftyNote);
	public double checkMoney(int moneyType);									
    public int[] dispenseSnackAndChange(double moneyChangeToDispense, int[] machineMoneyStore);
}

public interface SnackMachine {
	void addSnackToMenu(int newSlotNumber, String newName, double newPrice, int newAmount);
	void startMachine();
	void displayMenu();
	void newOrder();
	void checkAvailability(String input);
	void selectPaymentMethod(Snack chosenSnack);
	void checkChangeToDispense(double returnedMoney, double userBalance, Snack chosenSnack, int[] userInsertedMoney);
    void dispenseSnackAndChange(double returnedMoney, int[] checkedReturnedMoney, Snack chosenSnack);
}


public class SnackVendingMachine extends MoneyCalculations implements SnackMachine {
        private List<Snack> menu = new ArrayList<>();
        private int[]machineMoneyStore = new int[6];
        private KeyPad keyPad = new KeyPad();
        private Scanner scanInput = new Scanner(System.in);
        private static SnackVendingMachine singleInstance = null;
    public List<Snack> getMenu();
    public int[] getMachineMoneyStore();
    public static SnackVendingMachine getInstance();
    public void addMoneyToStore(int tenCents, int twentyCents, int fiftyCents, int oneDollar, int twentyNote, int fiftyNote);
    public void addSnackToMenu(int newSlotNumber, String newName, double newPrice, int newAmount );
    public void startMachine();
    public void displayMenu();
    public void newOrder();
    public void checkAvailability(String chosenSnackNum);
    public void selectPaymentMethod(Snack chosenSnack);
    public void checkChangeToDispense(double moneyChangeToDispense, double userBalance, Snack chosenSnack, int[] userInsertedMoney);
    public void dispenseSnackAndChange(double moneyChangeToDispense, int[] checkedDispensedMoneyChange, Snack chosenSnack);
    public void dispenseSnackAndChange(Snack chosenSnack);
}


public class Main {
	public static void main(String[] args);
}