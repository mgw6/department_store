/**
* The IllegalRfidException is thrown when the inputted RFID is not legl
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
* @version 1 build 1 July 12, 2020
**/


public class IllegalRfidException extends Exception{
	/**
	*Exception can be thrown if the RFID is illegal
	**/
	
	public IllegalRfidException() {
		super("This is not a valid RFID!");
	}
	
	
}
