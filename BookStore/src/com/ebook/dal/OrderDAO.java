package com.ebook.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ebook.model.item.Product;
import com.ebook.model.order.Order;
import com.ebook.model.order.OrderDetail;
import com.ebook.model.order.Payment;

public class OrderDAO {
	
	private static HashMap <String, Order> orders = new HashMap <String, Order>();
	
	
	public OrderDAO() {
		
	}
	
	public Order getOrder(String orderId) {
		
		return orders.get(orderId);
		
	}
	
	public void createOrder(Order order) {
		
		Order newOrder = new Order();
		newOrder.setOrderId(order.getOrderId());
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		
//		orderDetails = order.getOrderDetails();
//		for(int i = 0; i < order.getOrderDetails().size(); i++)
		
			for(OrderDetail orderdetail : order.getOrderDetails()){
			Product newProduct = new Product();
			Product product = orderdetail.getProduct();
			
			newProduct.setproductId(product.getproductId());
			newProduct.setPrice(product.getPrice());
			newProduct.setTitle(product.getTitle());
			
			OrderDetail neworderDetail = new OrderDetail();
			neworderDetail.setProduct(newProduct);
			neworderDetail.setQuantity(orderdetail.getQuantity());
			orderDetails.add(neworderDetail);

			
		}
	
		
		newOrder.setOrderDetails(orderDetails);
		newOrder.setOrderState(order.getOrderState());
		newOrder.setPaymentReceived(order.isPaymentReceived());
		
		
		Payment newPayment = new Payment();
		newPayment.setPaymentId(order.getPayment().getPaymentId());
		newPayment.setPaymentStatus(order.getPayment().getPaymentStatus());
		newPayment.setPaymentType(order.getPayment().getPaymentType());
		
		
		newOrder.setPayment(newPayment);
		
		orders.put(newOrder.getOrderId(), newOrder);
		
	}
	
	
	
	public void updateOrderstatus(String orderId, String Status) {
		
		orders.get(orderId).setOrderState(Status);
	}

}
