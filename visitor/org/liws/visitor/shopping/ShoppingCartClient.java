package org.liws.visitor.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartClient {

	private List<ItemElement> items = new ArrayList<>();
	
	public void add(ItemElement el) {
		items.add(el);
    }
	
	public int calculatePrice() {
		IShoppingCartVisitor visitor = new ShoppingCartVisitor1();
		int sum = 0;
		for(ItemElement item : items){
			sum += item.accept(visitor);
		}
		return sum;
	}

}