package hibernate1.service;


import java.util.List;
import hibernate1.Order;

public interface OrderService {

	void statusOfOrder(int id, String status);
	void addOrder(Order order);
	Order getOrder(int id);
	List<Order> getAll();
	void updateOrder(Order order);
	void deleteOrder(int id);
}
