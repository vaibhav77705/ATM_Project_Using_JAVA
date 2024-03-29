package ATMProject;
//Main class
import java.util.*;
import java.util.Map.Entry;
import java.io.IOException;
import java.text.DecimalFormat;
public class OptionMenu extends Account{
	Scanner menuInput=new Scanner(System.in);
	private int selection;
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	HashMap<Integer,Integer> data =new HashMap<>();
	
	// Validate login information customer number and pin 
	
	public void getLogin() throws IOException{
		int x = 1;
		do {
			try {
				data.put(11601501, 2903);
				data.put(11602167, 1998);
				System.out.println("Welcome to the ATM Project!");
				System.out.print("Enter Your Customer Number:  ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.print("Enter Your pin Number:  ");
				setPinNumber(menuInput.nextInt());
			} 
			catch(Exception e) {
				System.out.println("\n"+ "Invalid character(s). Only numbers"+"\n");
				x=2;
			}
			for(Entry<Integer,Integer> entery : data.entrySet()) {
				if(entery.getKey()==getCustomerNumber() && entery.getValue()==getPinNumber()) {
					getAccountType();
				}
				System.out.println("\n"+"Wrong Customer Number or Pin Number "+"\n");
				
			}
		}while(x==1);
	}
	
	/* Display Account type Menu with selection*/
	public void getAccountType() {
		System.out.println(" Select the Account you want to access :");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");
		
		selection=menuInput.nextInt();
		switch(selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3: 
			System.out.println("Thank You for using this ATM, Have a Nice Day.");
			break;
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getAccountType();
		}
	}
	
	public void getChecking() {
		System.out.println("Checking Account :");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		selection=menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Checking Account Bamance: "+ moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You for using this ATM, Have a Nice Day.");
			break;
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getChecking();
			break;
		}
	}
	
	public void getSaving() {
		
		System.out.println("Saving Account :");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		selection=menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Saving Account Bamance: "+ moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You for using this ATM, Have a Nice Day.");
			break;
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getSaving();
			break;
		}
		
	}
	
}

