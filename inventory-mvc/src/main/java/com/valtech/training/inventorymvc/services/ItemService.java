package com.valtech.training.inventorymvc.services;

import java.util.List;

import com.valtech.training.inventorymvc.entities.Item;
import com.valtech.training.inventorymvc.vos.ItemVO;

public interface ItemService {
	 
	ItemVO saveItem(ItemVO ivo);	 
	ItemVO updateItem(int id, ItemVO ivo);	 
	ItemVO getItem(int id); 
	List<ItemVO> getAllItems(); 
	void updateInventory(int itemId, int newQuantity); 
	void resetInventory(Item item);
 
}
