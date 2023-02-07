package packageA;
import java.util.ArrayList;
import java.util.Scanner;


public class Runner {
	private static ArrayList<Book> bookList = new ArrayList<>();
	private static String[] subjectArray = new String[]{"Programming", "Data Structures", "Algorithms", "Operating Systems", "Gaming"};
	private static int[] subjectCount = new int[]{0,0,0,0,0};
	private static ArrayList<Integer> yearCount = new ArrayList<>();
	
	public static void main(String[] args)
	{
		setYears();
		for (int i = 0; i <= 20; i++) {
			bookList.add(new Book("Book " + i, "Math", 0, 0, 0));	
		}
		for (Book book: bookList) {
			randomTotalPages(book);
			randomReviewRating(book);
			randomSubject(book);
			randomYear(book);
		}
		createMenu();
	}
	public static void randomTotalPages(Book b)
	{
		int number = (int)(Math.random()*50) + 50;
		b.setTotalPages(number);
	}
	public static void randomReviewRating(Book b)
	{
		double number = (Math.random()*9.9) + 0.1;
		b.setReviewRating(number);
	}
	public static void randomSubject(Book b)
	{
		boolean check = true;
	    while(check == true)
	    {
	    	int counter = 0;
	        for(int i: subjectCount){
	            if(i > 5)
	              counter++;
	          }
	        int number = (int)(Math.random()*subjectArray.length);
	        if (counter == subjectCount.length)
	          break;
	        else{
	          if(subjectCount[number] < 5){
	           b.setSubject(subjectArray[number]);
	           subjectCount[number] += 1;
	           check = false;
	          }
	        }
	    }
	}
	public static void randomYear(Book b)
	{
		int yearRand = (int)(Math.random() * yearCount.size());
	    int year = yearCount.get(yearRand); 
	    b.setYearOfPublication(year);
	    yearCount.remove(yearRand);
	}
	public static void setYears()
	{
		for (int i = 1980; i < 2020; i++) {
	        yearCount.add(i);
		}
	}
	public static void sortYear()
	{
		boolean check = true;
		while (check)
		{
		// https://www.youtube.com/watch?v=3CJq3XV2PBU - modified for lists
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
		for (Book book: bookList) {
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
			}
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
	}
	public static void sortPages()
	{
		boolean check = true;
		while (check)
		{
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
		for (Book book: bookList) {
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");}
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
	}
	public static void sortReview()
	{
		boolean check = true;
		while (check)
		{
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
		for (Book book: bookList) {
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
			}
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
	}
	public static void sortSubject()
	{
		Scanner in = new Scanner (System.in);
		boolean check = true;
		while(check)
		{
			System.out.println("Which subject are you looking for? Press enter to go back to the menu");
			String ans = in.nextLine();
			if (ans.equals(""))
			{
				System.out.println("================================================");
				createMenu();
				break;
			}
			else
			{
			ArrayList<Book> bookSubjectList = new ArrayList<>();
			for (Book b: bookList)
			{
				if(b.getSubject().equals(ans))
				{
					bookSubjectList.add(b);
				}
			}
			if (bookSubjectList.size() <= 0)
			{
				System.out.println("There are no books in your subject.");
			}
			else {
				for (Book book: bookSubjectList) {
					System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
					System.out.println("");
				}
			}
			}
		}
	}
	public static void displayList()
	{
		boolean check = true;
		while (check)
		{
		for (Book book: bookList) {
			System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
			System.out.println("");
		}
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
	}
	public static void searchSpecificName()
	{
		Scanner in = new Scanner (System.in);
		boolean check = true;
		int alt = 0;
		while(check)
		{
			alt = 0;
			System.out.println("What is the name of the book you are looking for? Press enter to go back to the menu");
			String ans = in.nextLine();
			if (ans.equals(""))
			{
				System.out.println("================================================");
				createMenu();
				break;
			}
			else
			{
			//ArrayList<Book> bookSubjectList = new ArrayList<>();
			for (Book book: bookList)
			{
				if(book.getTitle().equals(ans))
				{
					System.out.println("Title: " + book.getTitle() + "\nSubject: " + book.getSubject()+ "\nYear of Publication: " + book.getYearOfPublication()+ "\nNumber of Pages: " + book.getTotalPages()+ "\nReview Rating: " + book.getReviewRating());
				}
				else
				{
					alt++;
				}
			}
			if (alt >= 21)
			{
				System.out.println("There are no books with the name");
			}
			}
		}
	}
	public static void addBook()
	{
		boolean check = true;
		while(check)
		{
			Scanner in = new Scanner (System.in);
			System.out.println("Do you want to add a book? Type yes to continue, Hit enter to go back to the menu");
			String ans = in.nextLine();
			if (ans.equals(""))
			{
				System.out.println("================================================");
				createMenu();
				break;
			}
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
			else
			{
				System.out.println("Invalid Command!");
			}
		}
	}
	public static void createMenu()
	{
		Scanner in = new Scanner(System.in);
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
		{
			System.out.println("Invalid command!");
		}
	}
}