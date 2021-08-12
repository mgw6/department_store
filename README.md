# Department Store

This program was as homework assignment for Data Structures an Algorithms (CSE 214) at Stony 
Brook University. Written in July 2020. 

The Department Store java application contains a method that provides
menu with options to interact with the program and update the store
inventory information. This program is made to simulate an Amazon store 
with no cashers, so it tracks all items by their Radio Frequency Identification 
(RFID) number. 

Menu Options include:
- Clean Store:
	- Returns all items in the store to their correct location
- Instert an item into the list:
	- Add an item to the store. 
- List Item 
	- User is prompted to enter a shelf location, then all items at that location are printed.
	- Printed info includes name, price, RFID, original location and current location.  
- Move an item
	- The user enters the RFID number of an item, and its current location, and then
	is prompted to enter the new location for the item. 
- Checkout
	- The user enters a cart number, and all of the items in that cart moved to checkout. 
- Print all items in store
	- List all items in the store, their nam, price, RFID, original location and current location. 
- Print by RFID tag number
        - All items in the store are printed, ordered by RFID number. 
- Update inventory System
	- removes all items in checkout from the store. 

To use this program, compile and run DepartmentStore.java
