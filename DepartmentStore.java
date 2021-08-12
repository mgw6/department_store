/**
* The Department Store java application contains a method that provides
* menu with options to interact with the program and update the store
* inventory information
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
*
* @version 1 Build 1 July 19 2020
**/

import java.util.Scanner;

public class DepartmentStore
{
	/**
	*the main method provides the user an interface to interact
	* with all of the other programs
	**/
	public static void main(String args[])
	{
		System.out.printf("\nWelcome!");
		//general variables
		boolean quit = false; //  to termiante applciation
		ItemList list1 = new ItemList();

		// menu variabals
		String     choice;
		Scanner    menuChoice = new Scanner(System.in);

		// insert item variables
		String    inName;
		double    inPrice;
		String    inTag;
		String    inPosition;
		Scanner   scanName     = new Scanner(System.in);
		Scanner   scanPrice    = new Scanner(System.in);
		Scanner   scanTag      = new Scanner(System.in);
		Scanner   scanPosition = new Scanner(System.in);
		
		// move item variables
		String    inMoveRfid;
		String    inSource;
		String    inDest;
		Scanner   scanMoveRfid = new Scanner(System.in);
		Scanner   scanSource   = new Scanner(System.in);
		Scanner   scanDest     = new Scanner(System.in);
		boolean   didIt        = false;
		
		//List by location variables
		String   inLocation;
		Scanner  scanLocation = new Scanner(System.in);
		
		//checkout
		String    inCheckout;
		Scanner   scanCheckout = new Scanner(System.in);
		double outTotal;
		
		// print by tag variables
		String     inPrintTag;
		Scanner    scanPrintTag = new Scanner(System.in);



		while (!quit)
		{
			printMenu();
			choice = menuChoice.nextLine().toUpperCase();

			if (choice.equals("C")) //  clean store
			{
				list1.cleanStore();
				
			} else if(choice.equals("I")) { // insert item				
				
				System.out.printf("Please type the item name: ");
				inName = scanName.nextLine();
				
				try
				{
					System.out.printf("\nPlease type the price of the item: ");
					inPrice = scanPrice.nextDouble();
					if (inPrice < 0)
					{
						throw new IllegalArgumentException();
					}
				} catch(IllegalArgumentException k) {
					inPrice = -1;
					while (inPrice <0)
					{						
						System.out.println("\nPlease input a positive price!");	
						System.out.printf("Please type the price of the item: ");
						inPrice = scanPrice.nextDouble();	
					}
				}
				
				try
				{
					System.out.printf("\nPlease enter the RFID tag: ");
					inTag = scanTag.nextLine().toUpperCase();
					if (DepartmentStore.rfidChecker(inTag) ==  false)
					{
						throw new IllegalRfidException();
					}
				} catch (IllegalRfidException j ){
					inTag = "";
					while (DepartmentStore.rfidChecker(inTag) ==  false)
					{
						System.out.println("A valid RFID is 9 charecters between 0-9 and A-f");
						System.out.printf("\nPlease enter the RFID tag: ");
						inTag = scanTag.nextLine().toUpperCase();
					}				
				}
				
				
				System.out.printf("\nPlease enter the initial position of the item: ");
				inPosition = scanPosition.nextLine().toLowerCase();
				try
				{
					if (DepartmentStore.shelfChecker(inPosition) == false)
						throw new IllegalLocationException();
				} catch (IllegalLocationException m) {
					inPosition = "";
					while (DepartmentStore.shelfChecker(inPosition) ==  false)
					{
						System.out.println("A valid shelf starts with 's' and is followed by 5 digits");
						System.out.printf("Please input a valid shelf number: ");
						inPosition = scanPosition.nextLine().toLowerCase();
					}			
				}
				
				
				list1.insertInfo(inName, inTag, inPrice, inPosition);

			} else if(choice.equals("L")) { //list by location
				System.out.printf("Please input the desired location: ");
				inLocation = scanLocation.nextLine().toLowerCase();
				
				try
				{
					if (DepartmentStore.shelfChecker(inLocation) == false)
						throw new IllegalLocationException();
				} catch (IllegalLocationException m) {
					inPosition = "";
					while (DepartmentStore.shelfChecker(inLocation) ==  false)
					{
						System.out.println("A valid shelf starts with 's' and is followed by 5 digits");
						System.out.printf("Please input a valid shelf number: ");
						inLocation = scanLocation.nextLine().toLowerCase();
					}			
				}
				
				list1.printByLocation(inLocation);
			



			} else if(choice.equals("M")) { // Move item in store
				System.out.printf("Please type the RFID number: ");			
				inMoveRfid = scanMoveRfid.nextLine().toUpperCase();
				try
				{
					if (DepartmentStore.rfidChecker(inMoveRfid) ==  false)
					{
						throw new IllegalRfidException();
					}
				} catch (IllegalRfidException j ){
					inMoveRfid = "";
					while (DepartmentStore.rfidChecker(inMoveRfid) ==  false)
					{
						System.out.println("A valid RFID is 9 charectets between 0-9 and A-f");
						System.out.printf("\nPlease enter the RFID tag: ");
						inMoveRfid = scanMoveRfid.nextLine().toUpperCase();
					}				
				}
						
				System.out.printf("Please input the current location of the item: ");
				inSource = scanSource.nextLine().toLowerCase();
				try
				{
					if (DepartmentStore.shelfChecker(inSource) == false && DepartmentStore.cartChecker(inSource) == false && inSource.equals("out"))
						{
							throw new IllegalLocationException();
						}
				} catch (IllegalLocationException m) {
					inSource = "";
					while (DepartmentStore.shelfChecker(inSource) ==  false && DepartmentStore.cartChecker(inSource) == false && !inSource.equals("out"))
					{
						System.out.println("A valid shelf starts with 's' and is followed by 5 digits");
						System.out.println("A valid cart starts with 'c' and is followed by 3 digits");
						System.out.printf("Please input a valid location: ");
						inSource = scanSource.nextLine().toLowerCase();
					}			
				}
				
				System.out.printf("Please input the desired destination: ");
				inDest = scanDest.nextLine().toLowerCase();
				
				try
				{
					if (DepartmentStore.shelfChecker(inDest) == false
						&& DepartmentStore.cartChecker(inDest) == false
						&& !inDest.equals("out"))
						{
							throw new IllegalLocationException();
						}
				} catch (IllegalLocationException n) {
					inDest = "";
					while (DepartmentStore.shelfChecker(inDest) ==  false
						&& DepartmentStore.cartChecker(inDest) == false
						&& !inDest.equals("out"))
					{
						System.out.println("A valid shelf starts with 's' and is followed by 5 digits");
						System.out.println("A valid cart starts with 'c' and is followed by 3 digits");
						System.out.printf("Please input a valid location: ");
						inDest = scanDest.nextLine().toLowerCase();
					}			
				}
								
				didIt = list1.moveItem(inMoveRfid, inSource, inDest);
				
				if(didIt == true)
					System.out.println("The item was found and moved");
				if(!didIt)
					System.out.println("The item was unable to be located");		

			} else if(choice.equals("O")) { // checkout
			
				System.out.printf("Please input the desired cart number: ");
				inCheckout = scanCheckout.nextLine().toLowerCase();
				try
				{
					if (DepartmentStore.cartChecker(inCheckout) == false)
						{
							throw new IllegalLocationException();
						}
				} catch (IllegalLocationException n) {
					inCheckout = "";
					while (DepartmentStore.cartChecker(inCheckout) == false)
					{
						System.out.println("A valid cart starts with 'c' and is followed by 3 digits");
						System.out.printf("Please input a valid cart: ");
						inCheckout = scanCheckout.nextLine().toLowerCase();
					}			
				}				
				outTotal = list1.checkOut(inCheckout);
				System.out.printf("Total: $%.2f\n", outTotal);
			

			} else if(choice.equals("P")) { //print all items in store	
				list1.printAll();

			} else if(choice.equals("R")) { // print by RFID tag number
				//this one is the optional bonus
				System.out.printf("Please input the desired tag number: ");
				inPrintTag = scanPrintTag.nextLine().toUpperCase();
				
				try
				{
					if (DepartmentStore.rfidChecker(inPrintTag) ==  false)
					{
						throw new IllegalRfidException();
					}
				} catch (IllegalRfidException j ){
					inMoveRfid = "";
					while (DepartmentStore.rfidChecker(inPrintTag) ==  false)
					{
						System.out.println("A valid RFID is 9 charectets between 0-9 and A-f");
						System.out.printf("\nPlease enter the RFID tag: ");
						inPrintTag = scanPrintTag.nextLine().toUpperCase();
					}				
				}
				
				list1.printByTag(inPrintTag);
				
			} else if(choice.equals("U")) { //update inventory system
				list1.removeAllPurchased();
			} else if(choice.equals("Q")) { // quit
				quit = true;
			} else {
				System.out.printf("\nThats not an option!\n");
			}
		} //  end !quit
		System.out.printf("\nThanks for shopping with us!\n\n");
	} // end main







	//methods used in main

	/**
	* prints out a menu of the options
	**/
	public static void printMenu()
	{
		System.out.printf("\nMenu:\n");
		System.out.printf("Select the letter of the desired choice:\n");
		System.out.printf("\tC - Clean Store\n");
		System.out.printf("\tI - Insert an item into the list\n");
		System.out.printf("\tL - List item by location\n");
		System.out.printf("\tM - Move an item in the store\n");
		System.out.printf("\tO - Checkout\n");
		System.out.printf("\tP - Print all items in store\n");
		System.out.printf("\tR - Print by RFID tag number\n");
		System.out.printf("\tU - Update inventory System\n");
		System.out.printf("\tQ - Exit the program\n");
		System.out.printf("Choice: ");
	}
	
	
	/**
	*returns whether or not the string is a shelf
	*
	* @param maybeShelf
	* 	the current location of the item, which we are checking to see if it is a shelf
	* 
	* @returns 
	* whether or not it is a shelf
	**/
	public static boolean shelfChecker(String maybeShelf)
	{ //https://www.youtube.com/watch?v=s_PfopWcMwI
	  //https://www.youtube.com/watch?v=hQSbnIWhizk
		return maybeShelf.matches("s[0-9]{5}+");
	}
	
	
	/**
	*returns whether or not the string is a cart
	*
	* @param maybeCart
	* 	the current location of the item, which we are checking to see if it is a shelf
	* 
	* @returns 
	* whether or not it is a cart
	**/
	public static boolean cartChecker(String maybeCart)
	{ 
		return maybeCart.matches("c[0-9]{3}+");
	}
	
	/**
	*returns whether or not the string is an RFID
	* used in the clean store method
	* @param maybeRfid
	* 	the current location of the item, which we are checking to see if it is a shelf
	* 
	* @returns 
	* whether or not it is an RFID
	**/
	public static boolean rfidChecker(String maybeRfid)
	{ 
		return maybeRfid.matches("[A-Fa-f0-9]{9}+");
	}
} // end class
