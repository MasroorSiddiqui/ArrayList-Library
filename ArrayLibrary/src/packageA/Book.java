package packageA;

public class Book {
	private String title;
	private String subject;
	private int yearOfPublication;
	private int totalPages;
	private double reviewRating;
	
	public Book(String title, String subject, int yearOfPublication, int totalPages, double reviewRating) 
	{
		this.title = title;
		this.subject = subject;
		this.yearOfPublication = yearOfPublication;
		this.totalPages = totalPages;
		this.reviewRating = reviewRating;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public void setYearOfPublication(int yearOfPublication)
	{
		this.yearOfPublication = yearOfPublication;
	}
	
	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
	}
	
	public void setReviewRating(double reviewRating)
	{
		this.reviewRating = reviewRating;
	}
	
	public String getTitle()
	{
		return title;
	}

	public String getSubject()
	{
		return subject;
	}
	
	public int getYearOfPublication()
	{
		return yearOfPublication;
	}
	
	public int getTotalPages()
	{
		return totalPages;
	}
	
	public double getReviewRating()
	{
		return reviewRating;
	}
}
