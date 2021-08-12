// test file for items
public class ItemTest
{
	public static void main(String args[])
	{
		ItemList list1 = new ItemList();
		
		list1.insertInfo("Shirt", "a2c3b5e67", 3.00, "S300");
		System.out.println("added 1");
		list1.insertInfo("Pants", "c2c3b5e67", 3.00, "S300");
		System.out.println("added 2");
		list1.insertInfo("car", "a2c3b5e67", 21.00, "S300");
		System.out.println("added 3");
		list1.insertInfo("Pants", "b2c3b5e67", 3.00, "S300");
		System.out.println("added 4");
		list1.insertInfo("Pants", "z2c3b5e67", 3.00, "S300");
		System.out.println("added 5");
		
		
		System.out.println(list1.listLength());
		
		list1.printAll();
		
	}
}
