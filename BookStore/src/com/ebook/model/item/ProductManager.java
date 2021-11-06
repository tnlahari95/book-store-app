package com.ebook.model.item;

import java.util.List;

import com.ebook.dal.ProductDAO;
import com.ebook.model.item.Product;

public class ProductManager implements IProductManager{
	private ProductDAO productDAO = new ProductDAO();



    public void AddProduct(Product product){
        try{
            productDAO.AddProduct(product);
        }catch (Exception ex){
            System.out.println("Product service:Threw an error adding a product.");
        }
    }
    
    public void UpdateProduct(Product product){
        try{
            productDAO.UpdateProduct(product);
        }catch (Exception ex){
            System.out.println("Product service:Threw an error updating a product.");
        }
    }
    
    public void removeProduct(Product product){
        try{
            productDAO.removeProduct(product);
        }catch (Exception ex){
            System.out.println("Product service:Threw an error removing a product.");
        }
    }

    public void getAllProducts(){
        try{
           productDAO.getAllProducts();
        }catch(Exception ex){
            System.out.println("Product Service: Couldn't find a product");
        }
    }
    
    public Product getProductById(String productId){
        try{
            productDAO.getProductById(productId);
        }catch(Exception ex){
            System.out.println("Product Service: Couldn't find a product by Id");
        }
        return null;
    }

	@Override
	public void Add(Object object) {
		// TODO Auto-generated method stub
		productDAO.AddProduct((Product)object);
		
	}

	@Override
	public void Update(Object object) {
		// TODO Auto-generated method stub
		productDAO.UpdateProduct((Product)object);
		
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub
		productDAO.removeProduct((Product)object);
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		productDAO.getAllProducts();
	}
	
	@Override
	public void getById(Object objectid) {
		// TODO Auto-generated method stub
		productDAO.getProductById((String)objectid);
	}

}
    
    
