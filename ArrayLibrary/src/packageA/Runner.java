package packageA;
import java.util.ArrayList;
import java.util.Scanner;


public class Runner {
	//Declaring ArrayList to be used across different methods
	private static ArrayList<Book> bookList = new ArrayList<>();
	private static ArrayList<Integer> yearCount = new ArrayList<>();
	
	//Main method
	public static void main(String[] args)
	{
		//Creates book objects and puts them in BookList
		setYears();
		for (int i = 0; i <= 20; i++) 
			bookList.add(new Book("Book " + i, "Math", 0, 0, 0));	
		
		//Assigns each book in bookList a random page number, review rating, subject and year of publication
		for (Book book: bookList) 
		{
			randomTotalPages(book);
			randomReviewRating(book);
			randomSubject();
			randomYear(book);
		}
		
		//Creates menu for user
		createMenu();
	}
	
	//Sets each book in bookList to a random number between 50 to 100
	public static void randomTotalPages(Book b)
	{
		int number = (int)(Math.random()*50) + 50;
		b.setTotalPages(number);
	}
	
	//Sets each book in bookList to a random rating between 0.1 to 10.0 
	public static void randomReviewRating(Book b)
	{
		double number = (Math.random()*9.9) + 0.1;
		b.setReviewRating(number);
	}
	
	//Sets each book in bookList to a random subject
	public static void randomSubject()
	{
		//Set of subjects each book can have
		ArrayList <String> subjectArray = new ArrayList<>();
		for (int i = 0; i < 5; i++)
		{
			subjectArray.add("Programming");
			subjectArray.add("Gaming");
			subjectArray.add("Algorithms");
			subjectArray.add("Operating Systems");
			subjectArray.add("Data Structures");
		}

		//For each book in bookList assign it a subject from subjectArray, and then remove it from subjectArray
		for (Book b: bookList)
	    {
	    	int number = (int)(Math.random()*subjectArray.size());
	    	b.setSubject(subjectArray.get(number));
	    	subjectArray.remove(number);
	    }
	}
	
	//Creates only one instance of each year and assigns it to yearCount
	public static void setYears()
	{
		for (int i = 1980; i < 2020; i++) 
		{
	        yearCount.add(i);
		}
	}
	
	//Adds a random year of publication to each book in bookList
	public static void randomYear(Book b)
	{
		//Chooses a random year from yearCount
		int yearRand = (int)(Math.random() * yearCount.size());
	    int year = yearCount.get(yearRand);
	    
	    //Sets year to the book
	    b.setYearOfPublication(year);
	    
	    //Removes the year from the list so no other occurrences of the same year exist
	    yearCount.remove(yearRand);
	}
	
	//Sorts bookList lowest to highest year of publication dates
	public static void sortYear()
	{
		// https://www.youtube.com/watch?v=3CJq3XV2PBU - modified it for lists
		/* Uses two for loops in order to compare one value of the list to the one after.
		 * If the year "i" is greater than the year "j" (the value after the index i), then it will set 
		 * the position of year "i" to the position of year "j" and set the value of year "j" to year "i".
		 * It essentially just pushes the values that are higher to the end of the list and pushes back 
		 * the values that are lower to the front of the list. 
		 */
		for (int i = 0; i < bookList.size(); i++)
		{
			for(int j = i +1; j < bookList.size(); j++)
			{
				if(bookList.get(i).getYearOfPublication() > bookList.get(j).getYearOfPublication())
				{
					Book change = bookList.get(i);
					bookList.set(i, bookList.get(j));
					bookList.set(j, change);
				}
			}
		}
		
		//Prints out newly sorted list
		for (Book book: bookList) 
		{
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
		}
		
		//Sends user back to the menu screen
		Scanner in = new Scanner(System.in);
		System.out.println("Press enter or any key to go back to menu");
		String ans = in.nextLine();
		if (ans.equals(""))
		{
			System.out.println("================================================");
			createMenu();
		}
		else 
		{
			System.out.println("================================================");
			createMenu();
		}
	}
	
	//Sorts bookList lowest to highest total pages
	public static void sortPages()
	{
		//Follows the same sorting method as sortYear() except with pages
		for (int i = 0; i < bookList.size(); i++)
		{
			for(int j = i +1; j < bookList.size(); j++)
			{
				if(bookList.get(i).getTotalPages() > bookList.get(j).getTotalPages())
				{
					Book change = bookList.get(i);
					bookList.set(i, bookList.get(j));
					bookList.set(j, change);
				}
			}
		}
		
		//Prints out newly sorted bookList
		for (Book book: bookList) 
		{
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
		}
		
		//Allows user to return the menu
		Scanner in = new Scanner(System.in);
		System.out.println("Press enter or any key to go back to menu");
		String ans = in.nextLine();
		if (ans.equals(""))
		{
			System.out.println("================================================");
			createMenu();
		}
		else 
		{
			System.out.println("================================================");
			createMenu();
		}
	}
	
	//Sorts bookList highest to lowest review rating
	public static void sortReview()
	{
		//Follows the same sorting method as sortYear() except it checks if rating "j" is greater than rating "i"
		for (int i = 0; i < bookList.size(); i++)
		{
			for(int j = i +1; j < bookList.size(); j++)
			{
				if(bookList.get(i).getReviewRating() < bookList.get(j).getReviewRating())
				{
					Book change = bookList.get(i);
					bookList.set(i, bookList.get(j));
					bookList.set(j, change);
				}
			}
		}
		
		//Prints out newly sorted list
		for (Book book: bookList) 
		{
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
		}
		
		//Allows user to return to menu
		Scanner in = new Scanner(System.in);
		System.out.println("Press enter or any key to go back to menu");
		String ans = in.nextLine();
		if (ans.equals(""))
		{
			System.out.println("================================================");
			createMenu();
		}
		else 
		{
			System.out.println("================================================");
			createMenu();
		}
	}
	
	//Prints out all books that pertains to one subject
	public static void sortSubject()
	{
		Scanner in = new Scanner (System.in);
		
		//A while loop to allow the user to check books of different subjects
		boolean check = true;
		while(check)
		{
			System.out.println("Which subject are you looking for? Press enter to go back to the menu");
			String ans = in.nextLine();
			
			//Returns the user to the menu if entered is pressed
			if (ans.equals(""))
			{
				System.out.println("================================================");
				createMenu();
				break;
			}
			
			//Else it will look for the subject the user typed
			else
			{
				//An ArrayList of all books found in the subject
				ArrayList<Book> bookSubjectList = new ArrayList<>();
				
				//Goes through each book in bookList to find and add the subject books to bookSubjectList
				for (Book b: bookList)
				{
					if(b.getSubject().equals(ans))
					{
						bookSubjectList.add(b);
					}
				}
				
				//If there are no books of the subject, then lets user know there are no books in the subject
				if (bookSubjectList.size() <= 0)
				{
					System.out.println("There are no books in your subject.");
				}
				
				//Else prints out all books with the same subject
				else 
				{
					for (Book book: bookSubjectList) 
					{
						System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
						System.out.println("");
					}
				}
			}
		}
	}
	
	//Displays all books in bookList
	public static void displayList()
	{
		//Prints out all books in bookList
		for (Book book: bookList) 
		{
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
		}
		
		//Allows user to return to the menu
		Scanner in = new Scanner(System.in);
		System.out.println("Press enter or any key to go back to menu");
		String ans = in.nextLine();
		if (ans.equals(""))
		{
			System.out.println("================================================");
			createMenu();
		}
		else 
		{
			System.out.println("================================================");
			createMenu();
		}
	}
	
	//Finds and provides detail of a book with a specific name
	public static void searchSpecificName()
	{
		Scanner in = new Scanner (System.in);
		
		//Used to check if there are any books in bookList with the same name
		int alt = 0;
		
		//While loop to allow users to look for multiple books
		boolean check = true;
		while(check)
		{
			alt = 0;
			System.out.println("What is the name of the book you are looking for? Press enter to go back to the menu");
			
			//Allows user to return to the menu
			String ans = in.nextLine();
			if (ans.equals(""))
			{
				System.out.println("================================================");
				createMenu();
				break;
			}
			
			//*Checks if each book in bookList match the name with the one provided. 
			//If not, then it will add 1 to alt
			else
			{
				for (Book book: bookList)
				{
					if(book.getTitle().equals(ans))
						System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
					else
						alt++;
				}
				
				//If the alt is greater than or equal to 21 (meaning that the entirebookList has been iterated through
				//then let the user that there are no books with the name provided
				if (alt >= 21)
					System.out.println("There are no books with the name");
			}
		}
	}
	
	//Allows user to add a book to bookList
	public static void addBook()
	{
		//A while loop to allow the user to add more than one book
		boolean check = true;
		while(check)
		{
			Scanner in = new Scanner (System.in);
			System.out.println("Do you want to add a book? Type yes to continue, Hit enter to go back to the menu");
			String ans = in.nextLine();
			
			//Sends the user to the menu if entered is hit
			if (ans.equals(""))
			{
				System.out.println("================================================");
				createMenu();
				break;
			}
			
			//If the user says yes, then ask for each of the details of the books 
			//and create a new book object with the given characteristics
			else if (ans.equals("yes")) {
				System.out.print("Title of Book: ");
				String title = in.nextLine();
				System.out.print("Subject of Book: ");
				String subject = in.nextLine();
				System.out.print("Year of Publication of Book: ");
				int yearOfPublication = Integer.parseInt(in.nextLine());
				System.out.print("Number of Pages of Book: ");
				int totalPages = Integer.parseInt(in.nextLine());
				System.out.print("Rating of Book: ");
				double reviewRating = Double.parseDouble(in.nextLine());
				Book newBook = new Book(title, subject, yearOfPublication,totalPages,reviewRating);
				bookList.add(newBook);
			}
			
			//If the user types in any other command, let them know it is invalid
			else
				System.out.println("Invalid Command!");
		}
	}
	
	//Creates menu for user to interact with
	public static void createMenu()
	{
		Scanner in = new Scanner(System.in);
		
		//Introduction and list of all possible commands
		System.out.println("Hello! Welcome to Ammaar University's Library Helper \nType a number to access the function \n");
		System.out.println("1. List of all the books");
		System.out.println("2. List of all the books sorted from oldest to newest year of publication");
		System.out.println("3. List of all the books sorted from shortest to longest page count");
		System.out.println("4. List of all the books sorted from highest to lowest rating");
		System.out.println("5. List of all the books based on Subject");
		System.out.println("6. Description of a book");
		System.out.println("7. Add a book");
		System.out.println("8. Exit");
		String ans = in.nextLine();
		
		//Checks the response of the user and executes its respective method
		if (ans.equals("1")) {
			System.out.println("================================================");
			displayList();
		}
		else if (ans.equals("2")) {
			System.out.println("================================================");
			sortYear();
		}
		else if (ans.equals("3")) {
			System.out.println("================================================");
			sortPages();
		}
		else if (ans.equals("4")) {
			System.out.println("================================================");
			sortReview();
		}
		else if (ans.equals("5")) {
			System.out.println("================================================");
			sortSubject();
		}
		else if (ans.equals("6")) {
			System.out.println("================================================");
			searchSpecificName();
		}
		else if (ans.equals("7")) {
			System.out.println("================================================");
			addBook();
		}
		else if (ans.equals("8")) {
			System.out.println("Thanks for using the program!");
			System.exit(0);
		}
		else 
			System.out.println("Invalid command!");
	}
}
