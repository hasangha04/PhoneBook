package PhoneBookPackage;

import java.util.*;

class PhonebookManager extends PhoneBookTest {
    
    //this method 
	public static int userInterface(Scanner input) {//user interface started
		//The print statements for the UI
		int response = 0;
		String Answer;
		System.out.println("[1] Add Contact");
		System.out.println("[2] Edit Contact");
		System.out.println("[3] Search Contact");
		System.out.println("[4] Print Contacts List");
		System.out.println("[5] Close the program");
		System.out.print("What would you like to do: ");
		System.out.println();
		Answer = input.nextLine();
        try {  //this try catch statement for catch non-int values
            response = Integer.parseInt(Answer);
        }// end of try
        catch (Exception e) {
			System.out.println(); //this will be printed out for non-int inputs
		}// end of catch
		return response;						
	}//end of the user interface
    
    //this method will create default contacts to the phonebook
	public static ArrayList<ListNode> firstContacts(ArrayList<ListNode> ContactList){
    	    String [] firstNames = {"John", "Micheal", "Harry", "Mark"};
    	    String [] lastNames = {"Cena", "Jackson", "Potter", "Twain"};
            String [] emails = {"JCena@Gmail.com", "MJackson@Gmail.com",
            "HPotter@Gmail.com", "MTwain@Gmail.com"};
            String[] phoneNumbers = {"360-592-3221", "360-592-3222",
            "360-592-3223", "360-592-3224"};
            String [] cities = {"Bellingham", "Bellingham", "Blaine", "Nooksack"};
                
    	    for(int i = 0; i <= 3; i++){//adds each contact to contact list
				ListNode list = new ListNode();
                String firstName = firstNames[i];
                list.setFirstName(firstName);
                String lastName = lastNames[i];
                list.setLastName(lastName);
                String email = emails[i];
                list.setEmail(email);
                String phoneNumber = phoneNumbers[i];
                list.setPhoneNumber(phoneNumber);
                String city = cities[i];
                list.setCity(city);
                list.createList();
                ContactList.add(list);                
    	    }// end of for loop
		    return ContactList;
	}// end of firstContacts

	public static ArrayList<ListNode> addContact(Scanner input,
	ArrayList<ListNode> ContactList) {//addContact begins
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
	}//end of addContact

	//this method searches the phonebook for a contact
	public static void searchContact(ArrayList<ListNode> ContactList) {
		Scanner input = new Scanner(System.in);
		System.out.println("Type the name of the contact (case sensitive)");
		String getInfo = input.next();
		boolean check = false;

		for (ListNode element : ContactList) {
			if (element.getFirstName().equals(getInfo) &&
				element.getLastName().equals(getInfo)) {
				System.out.println(element);
				System.out.println();
				check = true;
				break;
			}// end of First Name and Last Name if statement
			else if (element.getFirstName().equals(getInfo)) {
				System.out.println(element);
				System.out.println();
				check = true;
				break;
			}// end of First Name if statement
			else if (element.getLastName().equals(getInfo)) {
				System.out.println(element);
				System.out.println();
				check = true;
				break;
			}// end of Last Name if statement
		}// end of for loop
		if (!check) {
			System.out.println("Contact not found");
			System.out.println();
		}// end of if statement
	}// end of searchContact

	//this method edits a contact in the phonebook
	public static void editContact(ArrayList<ListNode> ContactList) {
		Scanner input = new Scanner(System.in);
		searchContact(ContactList);
		System.out.println("Type the information of the contact you would like to edit");
		System.out.println("(Ex: name (first or last), city):");
		String getInfo = input.nextLine();
		boolean check = false;

		if(getInfo.contains(" ")){
			System.out.println("Only one edit at a time!");
			System.out.println();
			editContact(ContactList);
		}// end of if statement

		selectInfo(check, input, getInfo, ContactList);
	}// end of editContact

	// this method allows the user to select what info they would like to change
	public static void selectInfo(boolean check, Scanner input, String getInfo,
								  ArrayList<ListNode> ContactList){
		for (ListNode element : ContactList) {
			if (element.getFirstName().equals(getInfo)) {
				check = true;
				int place = 1;
				takeCorrection(input, element, place);
			}// end of First Name if statement
			if (element.getLastName().equals(getInfo)) {
				check = true;
				int place = 2;
				takeCorrection(input, element, place);
			}// end of Last Name if statement
			if (element.getEmail().equals(getInfo)) {
				check = true;
				int place = 3;
				takeCorrection(input, element, place);
			}// end of Email if statement
			if (element.getPhoneNumber().equals(getInfo)) {
				check = true;
				int place = 4;
				takeCorrection(input, element, place);
			}// end of Phone Number if statement
			if (element.getCity().equals(getInfo)) {
				check = true;
				int place = 5;
				takeCorrection(input, element, place);
			}// end of City if statement
		}// end of for loop
		if (!check) {
		System.out.println("information not found");
		System.out.println();
		}// end of if statement
	}// end of selectInfo

	//this method corrects the contact from user input
	public static void takeCorrection(Scanner input, ListNode element, int place){
		System.out.println("input correction:");
		String newInfo = input.next();
		changeInfo(element, input, newInfo, place);
	}// end of takeCorrection

	//this method changes a certain piece of info in a contact
	public static void changeInfo(ListNode element, Scanner input,
								  String newInfo, int place){
		switch (place){
			case 1:// sets new first name
				element.setFirstName(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 2:// sets new last name
				element.setLastName(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 3:// sets new email
				element.setEmail(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 4:// sets new phone number
				element.setPhoneNumber(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
			case 5:// sets new city
				element.setCity(newInfo);
				element.createList();
				System.out.println(element);
				System.out.println();
				break;
		}// end of switch/case
	}// end of changeInfo

	//this method prints the contact list
	public static void printContacts(ArrayList<ListNode> ContactList){
		int index = 0;//counts the place of the index
		ArrayList<String> printList = new ArrayList<String>();

		//adds each contact to the printList array
		for (ListNode element : ContactList) {
			String contact = element.toString();
			printList.add(index, contact);
			index++;
		}// end of for loop
		Collections.sort(printList);// sort contacts by name

		//prints out each contact
		for(int counter = 0; counter < printList.size(); counter++){
			System.out.println(printList.get(counter));
			System.out.println();
		}// end of for loop
	}// end of printContacts

	// this method captures the user's input to the menu (userInterface)
	public static void userChoice(Scanner input){//userChoice starts
		ArrayList<ListNode> ContactList = new ArrayList<ListNode>();
		firstContacts(ContactList);
		int choice = 0;
		do {//do while loop begins	
			//userInterface(response);//print the UI
			choice = userInterface(input);
			switch (choice) {
			case 1: //add a new contact to the phone book
				ContactList = addContact(input, ContactList);
				break;
			case 2: //edits a contact in the phone book
				editContact(ContactList);
				break;
			case 3:
				searchContact(ContactList);
				break;
			case 4://print out all the contacts
				printContacts(ContactList);
				break;
			case 5:
				System.out.println("Goodbye!"); 
				break;
			default://in case the user enter an invalid input 
				System.out.println("Please enter a valid integer!");
				System.out.println();
				break;
			}// end of switch/case
		} while(choice != 5);//end of the do while loop
	}//end of the userChoice
}// end of PhonebookManager class