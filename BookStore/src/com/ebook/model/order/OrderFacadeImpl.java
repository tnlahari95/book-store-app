package com.ebook.model.order;

import com.ebook.dal.OrderDAO;

public class OrderFacadeImpl implements IFacade{
	
	OrderDAO orderdao = new OrderDAO();
    
    
	public Order getOrder(String orderId) {
		return orderdao.getOrder(orderId);
	}
	
	public void createOrder(Order order) {
		orderdao.createOrder(order);
	}
	
	public void updateOrderstatus(String orderId, String Status) {
		orderdao.updateOrderstatus(orderId, Status);
	}

	@Override
	public void update(Object id, Object object) {
		// TODO Auto-generated method stub
		orderdao.updateOrderstatus((String)id, (String)object);
	}

	@Override
	public void create(Object object) {
		// TODO Auto-generated method stub
		orderdao.createOrder((Order)object);
	}

	@Override
	public Order get(Object objectId) {
		// TODO Auto-generated method stub
		return orderdao.getOrder((String)objectId);
		
	}
	
}
