package hibernate1.dao;

import java.util.List;
import hibernate1.Order;


public interface OrderDAO {

	void addOrder(Order order);
	Order getOrder(int id);
	List<Order> getAll();
	void updateOrder(Order order);
	void deleteOrder(int id);
}