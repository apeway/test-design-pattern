package org.liws.visitor.shopping;

interface ItemElement {
	int accept(IShoppingCartVisitor visitor);
}

class Book implements ItemElement {

	private int price;
	private String isbn; // 国际标准书号

	public int getPrice() {
		return price;
	}
	public String getIsbn() {
		return isbn;
	}

	public Book(int cost, String isbn) {
		this.price = cost;
		this.isbn = isbn;
	}

	@Override
	public int accept(IShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}

class Fruit implements ItemElement {

	private int pricePerKg;
	private int weight;
	private String name;
	
	public int getPricePerKg() {
		return pricePerKg;
	}
	public int getWeight() {
		return weight;
	}
	public String getName() {
		return this.name;
	}

	public Fruit(int priceKg, int wt, String nm) {
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}

	@Override
	public int accept(IShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}