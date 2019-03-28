package com.bootcamp.e_wallet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bootcamp.e_wallet.config.Connect;
import com.bootcamp.e_wallet.controller.AccountController;
import com.bootcamp.e_wallet.controller.CustomerController;
import com.bootcamp.e_wallet.model.AccountEntity;
import com.bootcamp.e_wallet.model.CustomerEntity;

/**
 * Main App
 *
 */

public class App 
{
	private static CustomerController customerController = new CustomerController();
	private static AccountController accountController = new AccountController();
//	private static SessionFactory sessionFactory;
//	private static SessionFactory factory;
//  private static ServiceRegistry serviceRegistry;
	// obj input etc.
	private static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private static BufferedReader input = new BufferedReader(inputStreamReader);
	private static CustomerEntity customer = new CustomerEntity();
	private static AccountEntity account = new AccountEntity();
	public App(Connect conn) {
		Connect connection = (Connect) Connect.getConnection();
	}
	
    public static void main( String[] args )
    {
    	mainMenu();
    	//getAllCustomer(customerController.getAllCustomer());
    }

    private static void mainMenu () {
		System.out.println("\n");
		System.out.println("\t- Welcome To E-PayPool -");
		System.out.println("_______________________________________");
		System.out.println("");
		System.out.println("1. Registration");
		System.out.println("2. Login");
		System.out.println("_______________________________________");
		System.out.print("Choose [1][2][3] : ");

		try {
			int choice = Integer.parseInt(input.readLine());
			switch (choice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				getRegistration();
				break;
			}
			case 2: {
				getLogin();
				break;
			}
			default: {
				System.out.println("Pilihan salah!");
				mainMenu();
			}
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("This field can't empty!");
			mainMenu();
		}
	}
    
    private static void getLogin() {
		dashboard();
	}

	private static void dashboard () {
		System.out.println("\n");
		System.out.println("\t- Dashboard -");
		System.out.println("_______________________________________");
		System.out.println("");
		System.out.println("1. Add Account");
		System.out.println("2. Add Wallet");
		System.out.println("3. List Account");
		System.out.println("4. List Wallet");
		System.out.println("5. Transaction");
		System.out.println("6. Print");
		System.out.println("7. logout");
		System.out.println("_______________________________________");
		System.out.print("Choose [1][2][3] : ");

		try {
			int choice = Integer.parseInt(input.readLine());
			switch (choice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
				
				break;
			}
			case 4: {
				
				break;
			}
			case 5: {
				menuTrans();
				break;
			}
			case 6: {
				
				break;
			}
			case 7: {
				mainMenu();
				break;
			}
			default: {
				System.out.println("Pilihan salah!");
				mainMenu();
			}
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("This field can't empty!");
			mainMenu();
		}
	}
    

	private static void menuTrans() {
		System.out.println("\n");
		System.out.println("\t- Transaction -");
		System.out.println("_______________________________________");
		System.out.println("");
		System.out.println("1. Top Up");
		System.out.println("2. Transfer");
		System.out.println("3. Tarik Tunai");
		System.out.println("4. Back");
		System.out.println("_______________________________________");
		System.out.print("Choose [1][2][3][4] : ");

		try {
			int choice = Integer.parseInt(input.readLine());
			switch (choice) {
			case 0: {
				System.exit(0);
				break;
			}
			case 1: {
				
				break;
			}
			case 2: {
				
				break;
			}
			case 3: {
							
				break;
			}
			case 4: {
				dashboard();
				break;
			}
			default: {
				System.out.println("Pilihan salah!");
				mainMenu();
			}
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("This field can't empty!");
			mainMenu();
		}
	}

	private static void getRegistration() {
		System.out.println("\n");
		try {
			//random
			int number = new Random().nextInt(900000)+1000000;
			int cusnum = Integer.valueOf(number);
			System.out.println("=================== Form Registrasi Customer ======================");
			System.out.println("___________________________________________________________________");
			System.out.println();
//			System.out.print("No. Customer   : ");
//			int cusnum = Integer.parseInt(input.readLine());
			System.out.print("Firstname             : ");
			String fname = input.readLine();
			System.out.print("Lastname              : ");
			String lname = input.readLine();
			System.out.print("Birtdate (yyyy/mm/dd) : ");
			String birthDate = input.readLine();

			CustomerEntity customer = new CustomerEntity();
			customer.setCustomerNumber(cusnum);
			customer.setFirstName(fname);
			customer.setLastName(lname);
			customer.setBirthDate(birthDate);
			//add customer
			customerController.addCustomer(customer);
			//add account by parameter
			//addAccount(cusnum);
			mainMenu();

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			mainMenu();
		}

	}

	private static void addAccount(int cusnum) {
		System.out.println("\n");
		try {
			//random
			int number = new Random().nextInt(900000)+1000000;
			int accountNumber = Integer.valueOf(number);
			System.out.println("=========================== Add Account ===========================");
			System.out.println("___________________________________________________________________");
			System.out.println();
			System.out.print("Account Name   : ");
			String accountName = input.readLine();
			System.out.print("Balance        : ");
			int balance = Integer.parseInt(input.readLine());

			AccountEntity account = new AccountEntity();
			account.setAccountNumber(accountNumber);
			account.setAccountName(accountName);
			account.setOpenDate(getCurrentDate());
			account.setBalance(balance);
			//account.setCustomerNumber(cusnum);
			//add account
			accountController.addAccount(account);
			mainMenu();

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("This field is can't empty!");
			mainMenu();
		}
	}

	private static void getAllCustomer(List<CustomerEntity> customers) {
		try {
			System.out.println("\n");
			System.out.println("======================= List of Customers ======================");
			System.out.println("________________________________________________________________");
			//Header Table
			System.out.println("| " +getTable("No", 3)
				+ "| " + getTable("Customer No.", 15)
				+ "| " + getTable("First Name", 15)
				+ "| " + getTable("Last Name", 25)
				+ "|" + getTable("Birthdate", 14) + "|");
			System.out.println("----------------------------------------------------------------");
			int i = 1;
			// looping
			for (CustomerEntity row : customers) {
				System.out.println("| " + getTable("" + i, 3)
						+ "| " + getTable("" + row.getCustomerNumber(), 15)
						+ "| " + getTable("" + row.getFirstName(), 15)
						+ "| " + getTable("" + row.getLastName(), 25)
						+ "|"  + getTable("" + row.getBirthDate(), 14)
						+ "|");

				// next no.row
				i += 1;
			}
			System.out.println("________________________________________________________________");
			System.out.println("Successfully loaded!");
			//menuRegist();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.print("Not found!");
			//menuRegist();
		}
	}
	
	private static String getCurrentDate() {
		Date noww = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		return formatDate.format(noww);
	}
	
	public static String getTable(String inputString, int length) {
		return String.format("%1$-" + length + "s", inputString);
	}
}
