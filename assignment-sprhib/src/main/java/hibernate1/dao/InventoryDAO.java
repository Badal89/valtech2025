package hibernate1.dao;

import java.util.List;
import hibernate1.Item;



public interface InventoryDAO {

	
	void addInventory(Item item);
	Item getInventory(int id);
	List<Item> getAll();
	void updateInventory(Item item);
	void deleteInventory(int id);
}