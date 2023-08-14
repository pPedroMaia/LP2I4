/*
* Pedro Henrique de Oliveira Maia dos Santos CB3013197  
*/

public class Book {
	private String name;
	private Author[] authors;
	private double price;
	private int qty;

	public Book(String name, Author[] authors, double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
	}

	public Book(String name, Author[] authors, double price, int qty) {
		this.name = name;
		this.authors = authors;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return this.name;
	}

	public Author[] getAuthors() {
		return this.authors;
	}

	public double getPrice() {
		return this.price;
	}

	public int getQty() {
		return this.qty;
	}

	public String getAuthorNames() {

		String names = "";

		for (Author author : this.authors) {
			names += author.getName() + ", ";
		}

		return String.format("[%s]", names);
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String toString() {

		String authorFormat = "";

		for (Author author : this.authors) {
			authorFormat += author.toString();
		}

		String bookFormat = String.format("Book[name=%s, authors={Author[%s]}, price=%s, qty=%s]", this.getName(),
				authorFormat,
				this.getPrice(), this.getQty());

		return bookFormat;
	}

}