package com.valtech.training.inventorymvc.vos;

import com.valtech.training.inventorymvc.entities.Item;
import com.valtech.training.inventorymvc.entities.LineItem;
import com.valtech.training.inventorymvc.entities.Order;

public record LineItemVO(int id,int quantity, Order order, Item item) {
	public static LineItemVO from(LineItem li) {
		return new LineItemVO(li.getId(),li.getQuantity(),li.getOrder(),li.getItem());
	}
	public LineItem to() {
		return new LineItem(id,quantity,order,item);
	}
	public void updateTo(int id, LineItem lineItem) {
		lineItem.setItem(item);
		lineItem.setOrder(order);
		lineItem.setQuantity(quantity);
		}
}
