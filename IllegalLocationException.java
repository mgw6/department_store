/**
*The IllegalLocationException is thrown when the entered location is not out, a cart, or out
*
* @author MacGregor Winegard
*	email: macgregor.winegard@stonybrook.edu
*	Stony Brook ID: 114152787
* @version 1 build 1 July 12, 2020
**/

public class IllegalLocationException extends Exception{
	/**
	*Exception can be thrown if the location is illegal
	**/
	
	public IllegalLocationException() {
		super("This is not a valid location!");
	}
	
	
}