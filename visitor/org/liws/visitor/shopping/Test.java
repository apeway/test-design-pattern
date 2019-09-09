package org.liws.visitor.shopping;

public class Test {

	public static void main(String[] args) {
		ShoppingCartClient shoppingCartClient = new ShoppingCartClient();
		shoppingCartClient.add(new Book(20, "A001"));
		shoppingCartClient.add(new Book(100, "B005"));
		shoppingCartClient.add(new Fruit(10, 2, "Banana"));
		shoppingCartClient.add(new Fruit(5, 5, "Apple"));

		System.out.println("Total Cost = " + shoppingCartClient.calculatePrice());
	}
}
