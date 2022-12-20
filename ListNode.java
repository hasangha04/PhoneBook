package PhoneBookPackage;

class ListNode extends PhoneBookTest
{	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String city;
	private ListNode list;
	protected ListNode next;

	public ListNode() 
	{

	}

	public void createList()
	{
		list = new ListNode();
		list.next = new ListNode();
		list.next.next = new ListNode();
		list.next.next.next = new ListNode();
		list.next.next.next.next = new ListNode();
		list.next.next.next.next.next = null;
	}

	public String toString () 
	{
		return "Contact name = " + firstName + " "+  lastName + ", email = " + email + ", Phone Number = " + phoneNumber + ", City = " + city;
	}

	// Getters and setter for the Strings

	public String getLastName() 
	{
		return lastName;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getEmail() 
	{
		return email;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public String getCity() 
	{
		return city;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}
}
