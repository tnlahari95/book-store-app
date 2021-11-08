package com.ebook.model.order;

public interface IFacade {

//	public Order getOrder(String orderId);
//	
//	public void createOrder(Order order);
//	
//	public void updateOrderstatus(String orderId, String Status);
	
	public void update(Object id, Object object);
	
	public void create(Object object);
	
	public Object get(Object objectId);
	
	
}
