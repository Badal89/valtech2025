package com.valtech.training.inventorymvc.services;

import java.util.List;

import com.valtech.training.inventorymvc.enums.OrderStatus;
import com.valtech.training.inventorymvc.repos.ItemRepo;
import com.valtech.training.inventorymvc.repos.OrderRepo;
import com.valtech.training.inventorymvc.vos.OrderVO;

public interface OrderService {
	 
	void placeOrder(OrderVO orderVO); 
	void updateOrderStatus(int orderId, OrderStatus status);	 
	OrderVO getOrderById(int orderId);	 
	List<OrderVO> getAllOrders();	 
	void setItemRepo(ItemRepo itemRepo);	 
	void setOrderRepo(OrderRepo orderRepo);
 
}
