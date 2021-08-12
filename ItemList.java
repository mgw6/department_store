/**
*The ItemList class implements the ItemList object which is a doubly linked
*list of ItemInfoNodes, and contains references to the head and tail.
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
*
* @version 1 build 1 July 15, 2020
**/
import java.util.regex.*;
public class ItemList
{
	int maxSize = 50;
	private ItemInfoNode head;
	private ItemInfoNode tail;
	private ItemInfoNode pointer;
	public ItemList()
	{
		this.head = null;
		this.tail = null;
		this.pointer = null;
	}
	/**
	* Gets the length of the list of items
	*
	* @returns
	*	an int that is the number of items in the list
	**/
	public int listLength()
	{
		this.pointer = this.head;
		int answer = 0;
		while (this.pointer.getNext() != null && this.pointer != null) // going all the way to the end
		{					
			this.pointer = this.pointer.getNext();
			answer++;
		}
		if (answer == 0)
		{
			return answer;
		} else {
			return answer +1;
		}
	}
	/**
	*inserts a new ItemInfoNode into the list
	*
	* @param name
	*	the name of the item
	*
	* @param rfidTag
	*	the tag number of the item
	*
	* @param price
	*	the price of the item
	*
	*@param initPosition
	*	the initial location of the item
	*
	* Postcondition;
	*	the item has been added to the list in the proper location
	*	based on the rfid tag and ABC order
	**/
	public void insertInfo(String name, String rfidTag, double price,
							String initPosition)
	{//O(n^2) because worst case it has to go through the while loop
		int x = 0;
		ItemInfo tempIn = new ItemInfo(name, price, rfidTag, initPosition); // makes a temp item
		ItemInfoNode newNode = new ItemInfoNode(tempIn); // makes the new node
		if(this.head == null) //  nothing in list
		{ // so we make a new head
			this.head = newNode;
			this.tail = newNode;
		} else if(rfidTag.compareTo(this.head.getInfo().getRfidTagNumber()) <=0) { // new head
			this.head.setPrev(newNode);	
			newNode.setNext(this.head);
			this.head = newNode;
		} else if(rfidTag.compareTo(this.tail.getInfo().getRfidTagNumber()) >=0) { // new tail
			this.tail.setNext(newNode);
			newNode.setPrev(this.tail);
			this.tail = newNode;
		} else { // its somewhere in the middle
			this.pointer = this.head;
			while (rfidTag.compareTo(this.pointer.getNext().getInfo().getRfidTagNumber()) >=0)
			{					
				this.pointer = this.pointer.getNext();
			} // now we're adding after
			newNode.setPrev(this.pointer);
			newNode.setNext(this.pointer.getNext());
			this.pointer.getNext().setPrev(newNode);
			this.pointer.setNext(newNode);
		}
	} // end insert info
	/**
	* prints a neatly formatted list of all the items currently in the list
	**/
	public void printAll()
	{ // O(n) because it goes through the entire list
		this.pointer = this.head;
		System.out.printf("%-20s %-14s %-12s %-24s %s\n", 
			"Item Name", "Price", "RFID", 
			"Original Location", "Current Location" );
		System.out.printf("___________________________________");
		System.out.printf("____________________________");
		System.out.printf("___________________________________\n");
		while(this.pointer !=null)
		{
			System.out.print(this.pointer.getInfo().toString());
			this.pointer = this.pointer.getNext();
		}
	}
	/**
	*Removes all items located as "out"
	*
	*Postcondition: all items checked out are removed from the list
	**/
	public void removeAllPurchased()
	{ // O(n^2) because it into while then 2 if loops
		this.pointer = this.head;
		while(this.pointer != null)
		{
			if (this.pointer.getInfo().getCurrentLocation().equals("out"))
			{		
				if (this.pointer == this.head && this.pointer == this.tail)
				{ // head and tail
					this.head = null;
					this.tail = null;	
					this.pointer = null;
				} else if(this.pointer == this.head && this.pointer != this.tail) { // its the head
					this.head = this.pointer.getNext();
					this.head.setPrev(null);
					this.tail = this.head;
				} else if(this.pointer != this.head && this.pointer == this.tail) { // if its the tail
					this.tail = this.tail.getPrev();
					this.tail.setNext(null);
					this.pointer = this.tail;
				} else { // not head or tail
					this.pointer.getPrev().setNext(this.pointer.getNext());
					this.pointer.getNext().setPrev(this.pointer.getPrev());
					this.pointer = this.pointer.getPrev();
				}
			} else {
				this.pointer = this.pointer.getNext();
			}
		}		
	}
	/**
	*changes the current location of an item to a different location
	*
	* @param rfidTag
	*	the rfid tag of the desired item
	*
	* @param source
	* 	the current location of the item
	*
	* @param dest
	*	the desired location we want the item in
	*
	* @returns answer
	* 	whether or not the specified item is found
	*
	* Postcondition:
	*	the item in the list has been moved
	**/
	public boolean moveItem(String rfidTag, String Source, String dest)
	{ //  O(n^2) because worst case it goes into an if loops
		boolean answer = false;
		this.pointer =  this.head;
		while(this.pointer != null && answer == false)
		{
			if (this.pointer.getInfo().getRfidTagNumber().equals(rfidTag) 
				&& this.pointer.getInfo().getCurrentLocation().equals(Source))
				{
					this.pointer.getInfo().setCurrentLocation(dest);
					answer = true;
				}		
			this.pointer = this.pointer.getNext();
		}		
		return answer;
	}
	/**
	*This mehthod removes an item from a list
	*	Idk if I'll use it but here it is
	* @param rmNode
	*	the node that is desired to be taken out of the list
	*
	* Postcondition:
	*	the item has been removed from the list
	**/
	public void removeItem(ItemInfoNode rmNode)
	{ 
		rmNode.getPrev().setNext(this.pointer.getNext()); //routes the pointers last to the next one
		rmNode.getNext().setPrev(this.pointer.getPrev()); //routes the pointers next back to the pointers last
		if(rmNode.getNext() == null)
			this.tail = rmNode.getPrev();
		if(rmNode.getPrev() == null)
			this.head = rmNode.getNext();	
	}
	/**
	*prints all the items in a specified location*
	*
	* @param Location
	*	The specified location that all items will be printed from
	**/
	public void printByLocation(String location)
	{ // O(n^2) because worst case it goes into an if loop
		this.pointer = this.head;
		System.out.printf("%-20s %-14s %-12s %-24s %s\n", 
			"Item Name", "Price", "RFID", 
			"Original Location", "Current Location" );
		System.out.printf("___________________________________");
		System.out.printf("____________________________");
		System.out.printf("___________________________________\n");
		while (this.pointer != null)
		{
			if (this.pointer.getInfo().getCurrentLocation().equals(location))
				System.out.println(this.pointer.getInfo().toString());
			this.pointer =this.pointer.getNext();
		}		
	}
	/**
	*moves all items in a specified cart to "out"
	*
	* @param cartNumber
	*	the cart that will be checked out
	*
	* Postcondition:
	* 	all items located in the given cart have had their current location updated to "out"
	*
	* @returns 
	*	the total cost of the items that were checked out
	**/
	public double checkOut(String cartNumber)
	{ // O(n^2) becasue worst case it goes into an if loop
		this.pointer = this.head;
		double totalCost = 0;
		while (this.pointer != null)
		{
			if (this.pointer.getInfo().getCurrentLocation().equals(cartNumber))
			{
				this.pointer.getInfo().setCurrentLocation("out");
				System.out.printf("%s", this.pointer.getInfo().toString());
				totalCost = totalCost + this.pointer.getInfo().getPrice();
			}
			this.pointer =this.pointer.getNext();
		}
		return totalCost;	
	}
	/**
	* Prints all items with the specified RFID tag number
	*
	* @param inTag
	* the specified RFID that will be printed
	**/
	public void printByTag(String inTag)
	{
		this.pointer = this.head;
		System.out.printf("%-20s %-14s %-12s %-24s %s\n", 
			"Item Name", "Price", "RFID", 
			"Original Location", "Current Location" );
		System.out.printf("___________________________________");
		System.out.printf("____________________________");
		System.out.printf("___________________________________\n");
		while (this.pointer != null)
		{
			if (this.pointer.getInfo().getRfidTagNumber().equals(inTag))
				System.out.println(this.pointer.getInfo().toString());
			this.pointer =this.pointer.getNext();
		}	
	}
	
	/**
	* Moves all items that are not on their shelves back onto their shelves
	* 
	* Postcontition: 
	* 	all items not on thier original shelves are now on their original shelves
	**/
	public void cleanStore()
	{ // O(n^3) because worst case it goes into 2 if loops
		this.pointer = this.head;
		while(this.pointer !=null)
		{
			if(!this.pointer.getInfo().getCurrentLocation().equals(this.pointer.getInfo().getOriginalLocation()))
			{
				if (listShelfChecker(this.pointer.getInfo().getCurrentLocation()) == true) 
				{// shelf number is s + 5 digit number
					this.pointer.getInfo().setCurrentLocation(this.pointer.getInfo().getOriginalLocation());
				}
			}
			this.pointer = this.pointer.getNext();
		}	
	}
	
	/**
	*returns whether or not the current location is a shelf
	* used in the clean store method
	* @param maybeShelf
	* 	the current location of the item, which we are checking to see if it is a shelf
	* 
	* @returns 
	* whether or not it is a shelf
	**/
	public boolean listShelfChecker(String maybeShelf)
	{ //https://www.youtube.com/watch?v=s_PfopWcMwI
	  //https://www.youtube.com/watch?v=hQSbnIWhizk
		return maybeShelf.matches("s[0-9]{5}");
	}
} //end class