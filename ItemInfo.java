/**
* The ItemInfo class implements the ItemInfo object that stores 
* all of the relevent information for the item object
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
* @verion 1 Build 1 July 15, 2020
*
**/
public class ItemInfo
{
	private String      name; //name of item
	private double      price; // price of item
	private String      rfidTagNumber; //tag of item
	private String      originalLocation; //location it was initiated at
	private String      currentLocation; // location the item is currently in
	//invariants
	// name is the name of the item
	// price is always positive and displays 2 decimal places
	// rfidTagNumber 9 charecters long and represented in hexa-
	// decimal. Used to encode the radiofrequency
	// original location is always s followed by 5 digits
	// currentLocation is always s followed by 5 digits
	/**
	* Returns an instance of an ItemInfo
	*
	* @param n
	*	name of the item
	*
	* @param p
	*	price of the item
	*
	* Precondition
	*	price must be positive and 2 decimals
	*
	* @param r
	*	the rfidTagNumber of the item
	*
	* Precondition 
	*	rfidTagNumber is 9 hexadecimal charecters long
	*
	* @param l
	*	orignial location of the item, will also be initiated 
	*	as the current location of the item
	*
	**/
	public ItemInfo(String n, double p, String r, String l)
	{
		this.name = n;
		this.price = p;
		this.rfidTagNumber = r;
		this.originalLocation = l;
		this.currentLocation = l;
	}
	/**
	*returns the name of this item
	*
	* @returns
	*	the name of this item
	**/
	public String getName()
	{
		return this.name;
	}
	/**
	*sets the name of the item
	*
	* @param inName
	*	the desired name of the item
	*
	* Postcondition
	*	the name of the item has been changed to inName
	**/
	public void setName(String inName)
	{
		this.name = inName;
	}
	/**
	*returns the price of the info
	*
	* @returns
	*	the price of the item
	**/
	public double getPrice()
	{
		return this.price;
	}
	/**
	* sets the price of the Item
	*
	* @param inPrice
	*	the desired price of the item
	*
	* Precondition:
	*	the price of the item must be positive and 2 decimals
	*
	* Postcondition
	*	the price has been set to the desired amount
	**/
	public void setPrice(double inPrice)
	{
		this.price = inPrice;
	}
	/**
	*returns the rfidTagNumber of the item
	*
	* @returns
	* 	the rfidTagNumber of this item
	**/
	public String getRfidTagNumber()
	{
		return this.rfidTagNumber;
	}
	/**
	* sets the rfidTagNumber of this item
	*
	* @param inRfid
	*	the desired rfid of this item
	*
	* Precondition:
	*	the rfidTagNumber must be 9 hexadecimal charecters long
	*
	* PostCondition
	*	the rfidTagNumber has been changed to inRfid
	**/
	public void setRfidTagNumber(String inRfid)
	{
		this.rfidTagNumber = inRfid;
	}
	/**
	*returns the original location of the tag
	*
	* @returns
	* 	the oroginalLocation of this item
	**/
	public String getOriginalLocation()
	{
		return this.originalLocation;
	}
	/**
	* sets the originalLocation of this item
	*
	* @param inOrigLoc
	*	the desired original location of this item
	*
	* Precondition:
	*	the original location must be "S" followed by 5 digits
	*
	* PostCondition
	*	the originalLocation has been changed to inOrigLoc
	**/
	public void setOriginalLocation(String inOrigLoc)
	{
		this.originalLocation= inOrigLoc;
	}
	/**
	*returns the current location of the tag
	*
	* @returns
	* 	the currentLocation of this item
	**/
	public String getCurrentLocation()
	{
		return this.currentLocation;
	}
	/**
	* sets the currentLocationof this item
	*
	* @param inCurrLoc
	*	the desired current location of this item
	*
	* Precondition:
	*	the original location must be "S" followed by 5 digits
	*
	* PostCondition
	*	the currentLocation has been changed to inCurrLoc
	**/
	public void setCurrentLocation(String inOrigLoc)
	{
		this.currentLocation = inOrigLoc;
	}
	public String toString()
	{
			return String.format("%-20s %-12.2f %-19s %-24s %s\n",
				this.name, this.price, this.rfidTagNumber, 
				this.originalLocation, this.currentLocation);
	}
}// end main