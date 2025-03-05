package hibernate1.service;
import java.util.List;

import hibernate1.Item;

public interface InventoryService {
	
	void addInventory(Item item);
	Item getInventory(int id);
	List<Item> getAll();
	void updateInventory(Item item);
	void deleteInventory(int id);
	void reorderItem(int id);
	
}