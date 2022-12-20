package PhoneBookPackage;

import java.util.*;

class PhonebookManager extends PhoneBookTest 
{    
	public static int userInterface(Scanner input) 
	{
		// The print statements for the UI
		int response = 0;
		String answer;
		System.out.println("[1] Add Contact");
		System.out.println("[2] Edit Contact");
		System.out.println("[3] Search Contact");
		System.out.println("[4] Print Contacts List");
		System.out.println("[5] Close the program");
		System.out.print("What would you like to do: ");
		System.out.println();
		answer = input.nextLine();
        try 
		{   // This try catch statement for catch non-int values
            response = Integer.parseInt(answer);
        }
        catch (Exception e) 
		{   // This will be printed out for non-int inputs
			System.out.println(); 
		}
		return response;						
	}
    
    // This method will create default contacts to the phonebook
	public static ArrayList<ListNode> firstContacts(ArrayList<ListNode> ContactList)
	{
    	    String [] firstNames = {"John", "Micheal", "Harry", "Mark"};
    	    String [] lastNames = {"Cena", "Jackson", "Potter", "Twain"};
            String [] emails = {"JCena@Gmail.com", "MJackson@Gmail.com",
            					"HPotter@Gmail.com", "MTwain@Gmail.com"};
            String[] phoneNumbers = {"360-592-3221", "360-592-3222",
            						 "360-592-3223", "360-592-3224"};
            String [] cities = {"Bellingham", "Bellingham", "Blaine", "Nooksack"};
                
    	    for(int i = 0; i <= 3; i++)
			{
				ListNode list = new ListNode();
                
                list.setFirstName(firstNames[i]);
				list.setLastName(lastNames[i]);
				list.setEmail(emails[i]);
                list.setPhoneNumber(phoneNumbers[i]);
                list.setCity(cities[i]);
                list.createList();

                ContactList.add(list);                
    	    }
		    return ContactList;
	}

	public static ArrayList<ListNode> addContact(Scanner input, ArrayList<ListNode> ContactList) 
	{
		Scanner input2 = new Scanner(System.in);
		
		System.out.println();
		ListNode list = new ListNode();
		
		System.out.println("Enter First Name: ");
		String firstName =  input2.next();
		list.setFirstName(firstName);
		
		System.out.println("Enter Last Name: ");
		String lastName = input2.next();
		list.setLastName(lastName);
		
		System.out.println("Enter Your Email: ");
		String email = input2.next();
		list.setEmail(email);
		
		System.out.println("Enter Phone Number: ");
		String phoneNumber = input2.next();
		list.setPhoneNumber(phoneNumber);
		
		System.out.println("Enter City: ");
		String city = input2.next();
		list.setCity(city);

		list.createList();
		ContactList.add(list);
		
		System.out.println(firstName + "" + lastName);
		System.out.println("Contact added");
		System.out.println();
		return ContactList;
	}

	// This method searches the phonebook for a contact
	public static void searchContact(ArrayList<ListNode> ContactList) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Type the name of the contact (case sensitive)");
		String getInfo = input.next();
		boolean check = false;

		for (ListNode element : ContactList) 
		{
			if (element.getFirstName().equals(getInfo) &&
				element.getLastName().equals(getInfo)) 
			{
				System.out.println(element);
				System.out.println();
				check = true;
				break;
			}// End of First Name and Last Name if statement
			else if (element.getFirstName().equals(getInfo)) 
			{
				System.out.println(element);
				System.out.println();
				check = true;
				break;
			}// End of First Name if statement
			else if (element.getLastName().equals(getInfo)) 
			{
				System.out.println(element);
				System.out.println();
				check = true;
				break;
			}// End of Last Name if statement
		}
		if (!check) 
		{
			System.out.println("Contact not found");
			System.out.println();
		}
	}

	public static void editContact(ArrayList<ListNode> ContactList) 
	{
		Scanner input = new Scanner(System.in);
		searchContact(ContactList);
		System.out.println("Type the information of the contact you would like to edit");
		System.out.println("(Ex: name (first or last), city):");
		String getInfo = input.nextLine();
		boolean check = false;

		if(getInfo.contains(" "))
		{
			System.out.println("Only one edit at a time!");
			System.out.println();
			editContact(ContactList);
		}

		selectInfo(check, input, getInfo, ContactList);
	}

	// This method allows the user to select what info they would like to change
	public static void selectInfo(boolean check, Scanner input, String getInfo, ArrayList<ListNode> ContactList)
	{
		for (ListNode element : ContactList) 
		{
			if (element.getFirstName().equals(getInfo)) 
			{
				check = true;
				int place = 1;
				takeCorrection(input, element, place);
			}
			if (element.getLastName().equals(getInfo)) 
			{
				check = true;
				int place = 2;
				takeCorrection(input, element, place);
			}
			if (element.getEmail().equals(getInfo)) 
			{
				check = true;
				int place = 3;
				takeCorrection(input, element, place);
			}
			if (element.getPhoneNumber().equals(getInfo)) 
			{
				check = true;
				int place = 4;
				takeCorrection(input, element, place);
			}
			if (element.getCity().equals(getInfo)) 
			{
				check = true;
				int place = 5;
				takeCorrection(input, element, place);
			}
		}
		if (!check) 
		{
			System.out.println("information not found");
			System.out.println();
		}
	}

	// This method corrects the contact from user input
	public static void takeCorrection(Scanner input, ListNode element, int place)
	{
		System.out.println("input correction:");
		String newInfo = input.next();
		changeInfo(element, input, newInfo, place);
	}

	// This method changes a certain piece of info in a contact
	public static void changeInfo(ListNode element, Scanner input, String newInfo, int place)
	{
		switch (place)
		{
			case 1:
				element.setFirstName(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 2:
				element.setLastName(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 3:
				element.setEmail(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 4:
				element.setPhoneNumber(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 5:
				element.setCity(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
		}
	}

	public static void printContacts(ArrayList<ListNode> ContactList)
	{
		int index = 0;
		ArrayList<String> printList = new ArrayList<String>();

		for (ListNode element : ContactList)
		{
			String contact = element.toString();
			printList.add(index, contact);
			index++;
		}
		Collections.sort(printList);// Sort contacts by name

		for(int counter = 0; counter < printList.size(); counter++)
		{
			System.out.println(printList.get(counter));
			System.out.println();
		}
	}

	// This method captures the user's input to the menu (userInterface)
	public static void userChoice(Scanner input)
	{
		ArrayList<ListNode> ContactList = new ArrayList<ListNode>();
		firstContacts(ContactList);
		int choice = 0;
		do {
			choice = userInterface(input);
			switch (choice) 
			{
				case 1: 
					ContactList = addContact(input, ContactList);
					break;
				case 2: 
					editContact(ContactList);
					break;
				case 3:
					searchContact(ContactList);
					break;
				case 4:
					printContacts(ContactList);
					break;
				case 5:
					System.out.println("Goodbye!"); 
					break;
				default: 
					System.out.println("Please enter a valid integer!");
					System.out.println();
					break;
			}
		} while(choice != 5);
	}
}