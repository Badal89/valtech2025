package com.valtech.training.inventorymvc.services;

import java.util.List;

import com.valtech.training.inventorymvc.vos.CustomerVO;

public interface CustomerService {
	 
	CustomerVO saveCustomer(CustomerVO cvo);
	 
	CustomerVO updateCustomer(int id, CustomerVO cvo);
	 
	CustomerVO getCustomer(int id);
	 
	List<CustomerVO> getAllCustomer();
 
}
