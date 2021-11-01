package com.ebook.model.item;

public interface IProductManager {
	
	public void Add(Object object);
	
	public void Update(Object object);
	
	public void remove(Object object);
	
	public void getAll();
	
	public void getById(Object objectid);
}
